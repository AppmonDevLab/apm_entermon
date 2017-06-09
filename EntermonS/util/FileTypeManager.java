package util;

import java.io.File;

public class FileTypeManager {
	private FileTypeManager() {
	}
	/**
	 * ȷ�������ļ�������
	 */
	public static String getType(File file) {
		String name = file.getName();
		if (name.endsWith("htm") || name.endsWith("html"))
			return "text/html";
		else if (name.endsWith("jpg"))
			return "image/jpg";
		else if (name.endsWith("gif"))
			return "image/gif";
		else
			return "error";
	}
}
