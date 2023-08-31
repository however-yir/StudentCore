package com.system.utils;

import org.mindrot.jbcrypt.BCrypt;

public final class PasswordUtil {

	private static final int WORK_FACTOR = 12;

	private PasswordUtil() {
	}

	public static String hash(String rawPassword) {
		if (isBlank(rawPassword)) {
			throw new IllegalArgumentException("Password cannot be blank");
		}
		return BCrypt.hashpw(rawPassword, BCrypt.gensalt(WORK_FACTOR));
	}

	public static boolean verify(String rawPassword, String encodedPassword) {
		if (isBlank(rawPassword) || isBlank(encodedPassword)) {
			return false;
		}
		if (looksLikeBCrypt(encodedPassword)) {
			return BCrypt.checkpw(rawPassword, encodedPassword);
		}
		// 向后兼容：首次迁移前数据库中可能仍存在明文
		return rawPassword.equals(encodedPassword);
	}

	public static boolean looksLikeBCrypt(String value) {
		if (value == null) {
			return false;
		}
		return value.matches("^\\$2[aby]\\$\\d{2}\\$[./A-Za-z0-9]{53}$");
	}

	private static boolean isBlank(String value) {
		return value == null || value.trim().isEmpty();
	}
}
