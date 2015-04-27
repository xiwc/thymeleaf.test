package org.xiwc.semantic.web;

import java.io.File;
import java.util.Locale;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.xiwc.semantic.entity.Test;
import org.xiwc.semantic.entity.TestRepository;
import org.xiwc.semantic.model.RespBody;
import org.xiwc.semantic.util.ImageUtil;
import org.xiwc.semantic.util.StringUtil;
import org.xiwc.semantic.util.WebUtil;

@Controller
@RequestMapping("page")
public class PageController {

	static Logger logger = LoggerFactory.getLogger(PageController.class);

	@Autowired
	Environment env;

	@Autowired
	TestRepository testRepository;

	@RequestMapping("test")
	String test(ModelMap modelMap) {

		logger.debug("test page.");

		testRepository.findAll().forEach(System.out::println);

		modelMap.addAttribute("test", testRepository.findOne(1L));
		modelMap.addAttribute("tests", testRepository.findAll());

		return "test";
	}

	@RequestMapping("submit")
	String submit(Test test, ModelMap modelMap) {

		modelMap.addAttribute("test", testRepository.save(test));
		modelMap.addAttribute("tests", testRepository.findAll());

		return "test";
	}

	@RequestMapping(value = "upload", method = RequestMethod.POST)
	@ResponseBody
	public RespBody upload(HttpServletRequest request, HttpServletResponse response, Model model, Locale locale,
			@RequestParam("multiple") MultipartFile file) {

		logger.debug("upload file start...");

		String realPath = WebUtil.getRealPath(request);

		if (file == null || file.isEmpty()) {
			return RespBody.failed("上传文件为空！");
		}

		String originalFilename = file.getOriginalFilename();

		if (!ImageUtil.isImage(originalFilename)) {
			return RespBody.failed("上传文件不是图片！");
		}

		String type = originalFilename.substring(originalFilename.lastIndexOf("."));

		String fileName = StringUtil.replace("{?1}{?2}", UUID.randomUUID(), type);

		String storePath = env.getProperty("test.upload.img.store.path");
		int sizeOriginal = env.getProperty("test.upload.img.scale.size.original", Integer.class);
		int sizeLarge = env.getProperty("test.upload.img.scale.size.large", Integer.class);
		int sizeHuge = env.getProperty("test.upload.img.scale.size.huge", Integer.class);

		// relative file path
		String path = storePath + sizeOriginal + "/" + fileName;// 原始图片存放
		String pathLarge = storePath + sizeLarge + "/" + fileName;// 缩放图片存放
		String pathHuge = storePath + sizeHuge + "/" + fileName;// 缩放图片存放

		// absolute file path
		String filePath = realPath + path;

		try {

			// make upload dir if not exists
			FileUtils.forceMkdir(new File(realPath + storePath + sizeOriginal));
			FileUtils.forceMkdir(new File(realPath + storePath + sizeLarge));
			FileUtils.forceMkdir(new File(realPath + storePath + sizeHuge));

			// store into webapp dir
			file.transferTo(new File(filePath));

			// scale image size as thumbnail
			// 图片缩放处理.120*120
			ImageUtil.scale2(filePath, realPath + pathLarge, sizeLarge, sizeLarge, true);
			// 图片缩放处理.640*640
			ImageUtil.scale2(filePath, realPath + pathHuge, sizeHuge, sizeHuge, true);

			// 保存记录到数据库
			// TODO

		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e.getMessage(), e);
			return RespBody.failed(e.getMessage());
		}

		// back relative file path
		return RespBody.succeed(storePath + sizeOriginal + "/" + fileName);
	}
}
