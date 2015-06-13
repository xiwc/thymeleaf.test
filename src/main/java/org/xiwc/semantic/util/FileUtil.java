package org.xiwc.semantic.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import org.apache.log4j.Logger;

public class FileUtil {

	private static final Logger logger = Logger.getLogger(FileUtil.class);
	private static final String EMPTY = "";

	/**
	 * 获取文件名.
	 * 
	 * @author xiweicheng
	 * @creation 2014年4月26日 下午6:43:41
	 * @modification 2014年4月26日 下午6:43:41
	 * @param filePath
	 * @return
	 */
	public static String getName(String filePath) {
		if (filePath == null || filePath.length() == 0) {
			return EMPTY;
		}

		int i = filePath.lastIndexOf("/");
		int j = filePath.lastIndexOf(".");

		if (i != -1) {
			if (j > i) {
				return filePath.substring(i + 1, j);
			} else if (i != filePath.length() - 1) {
				return filePath.substring(i + 1);
			}
		} else {
			if (j > 0) {
				return filePath.substring(0, j);
			} else if (j == 0) {
				return EMPTY;
			}
		}

		return filePath;
	}

	public static byte[] getBytesFromFile(File file) throws IOException {

		InputStream is = new FileInputStream(file);

		long length = file.length();

		if (length > Integer.MAX_VALUE) {
			is.close();
			throw new IOException("File is to large " + file.getName());
		}

		byte[] bytes = new byte[(int) length];

		int offset = 0;
		int numRead = 0;

		while (offset < bytes.length
				&& (numRead = is.read(bytes, offset, bytes.length - offset)) >= 0) {
			offset += numRead;
		}

		if (offset < bytes.length) {
			is.close();
			throw new IOException("Could not completely read file "
					+ file.getName());
		}

		is.close();

		return bytes;
	}

}
