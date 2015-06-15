package org.xiwc.semantic;

import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.Date;
import java.util.Locale;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeUtility;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.InputStreamSource;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;
import org.thymeleaf.templateresolver.ClassLoaderTemplateResolver;
import org.thymeleaf.templateresolver.TemplateResolver;

@SpringApplicationConfiguration(classes = Application.class)
public class MailSenderTest extends AbstractTestNGSpringContextTests {

	@Autowired
	MailSender mailSender;

	TemplateEngine templateEngine;

	@BeforeClass
	public void beforeClass() {
		templateEngine = new TemplateEngine();

		TemplateResolver resolver = new ClassLoaderTemplateResolver();
		resolver.setTemplateMode("LEGACYHTML5");
		resolver.setCharacterEncoding("UTF-8");
		resolver.setSuffix(".html");
		resolver.setCacheable(false);

		templateEngine.setTemplateResolver(resolver);
	}

	@Test
	public void sendText() {
		SimpleMailMessage message = new SimpleMailMessage();
		message.setFrom("lihengjizhu@163.com");
		message.setTo("xiwc87@yeah.net");
		message.setSubject("Mail Sender测试 " + new Date().getTime());
		message.setText("Mail Sender Test.... 邮件正文内容...");
		message.setCc("xiweicheng@yeah.net");
		message.setBcc("xiweicheng@yeah.net");

		mailSender.send(message);
	}

	@Test
	public void sendHtml() throws MessagingException {

		JavaMailSenderImpl sender = (JavaMailSenderImpl) mailSender;
		MimeMessage mimeMessage = sender.createMimeMessage();
		MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, false);

		helper.setFrom(sender.getUsername());
		helper.setTo("xiwc87@yeah.net");
		helper.setSubject("Mail Sender - Send HTML测试 " + new Date().getTime());
		helper.setText("<body><p>Hello Html Email</p></body>", true);

		sender.send(mimeMessage);
	}

	@Test
	public void sendHtmlWithAttachmentAndInlineImg() throws MessagingException,
			IOException {

		JavaMailSenderImpl sender = (JavaMailSenderImpl) mailSender;
		MimeMessage mimeMessage = sender.createMimeMessage();
		MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true,
				"UTF-8");

		helper.setFrom(sender.getUsername());
		helper.setTo("xiwc87@yeah.net");
		helper.setSubject("Mail Sender - Send HTML测试 " + new Date().getTime());
		helper.setText(
				"<!DOCTYPE html> <html><body><p>Hello Html Email</p><img src='cid:imageResourceName'/></body> </html>",
				true);

		InputStream is = MailSenderTest.class
				.getResourceAsStream("/static/img/img01.jpg");

		byte[] bs = new byte[is.available()];
		is.read(bs);

		is.close();

		final InputStreamSource imageSource = new ByteArrayResource(bs);

		helper.addInline("imageResourceName", imageSource, "image/jpg");

		helper.addAttachment(
				MimeUtility.encodeText("网站开发成本.jpeg", "UTF-8", "B"),
				new FileSystemResource("C:\\Users\\xi\\Desktop\\网站开发成本.jpeg"));

		sender.send(mimeMessage);
	}

	@Test
	public void sendHtmlByTmpl() throws MessagingException, IOException {

		JavaMailSenderImpl sender = (JavaMailSenderImpl) mailSender;

		// Prepare the evaluation context
		final Context ctx = new Context(Locale.CHINA);
		ctx.setVariable("name", "recipientName");
		ctx.setVariable("subscriptionDate", new Date());
		ctx.setVariable("hobbies", Arrays.asList("Cinema", "Sports", "Music"));
		ctx.setVariable("imageResourceName", "imageResourceName");

		// Prepare message using a Spring helper
		final MimeMessage mimeMessage = sender.createMimeMessage();
		final MimeMessageHelper helper = new MimeMessageHelper(mimeMessage,
				true, "UTF-8");
		helper.setSubject("HTML Mail with template测试 " + new Date().getTime());
		helper.setFrom(sender.getUsername());
		helper.setTo("xiwc87@yeah.net");

		// Create the HTML body using Thymeleaf
		final String htmlContent = templateEngine
				.process("templates/mail", ctx);
		helper.setText(htmlContent, true);

		// final InputStreamSource imageSource = new ByteArrayResource(
		// FileUtil.getBytesFromFile(new File(
		// "C:\\Users\\xi\\Desktop\\网站开发成本.jpeg")));

		InputStream is = MailSenderTest.class
				.getResourceAsStream("/static/img/img01.jpg");

		byte[] bs = new byte[is.available()];
		is.read(bs);

		is.close();

		final InputStreamSource imageSource = new ByteArrayResource(bs);
		helper.addInline("imageResourceName", imageSource, "image/jpg");

		sender.send(mimeMessage);
	}

	@Test
	public void test() {
		StringUtils.capitalize("aBccCdd");
		Assert.assertNotNull(mailSender);
	}
}
