package com.system.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class DB {

	private static final String DEFAULT_CONFIG_PATH = "./config/db.properties";
	private static final String DEFAULT_DRIVER = "com.mysql.cj.jdbc.Driver";

	// 数据库地址
	private String driverName = DEFAULT_DRIVER;
	// 数据库用户名
	private String user;
	// 数据库密码
	private String pass;
	// 数据库 URL
	private String url;
	// 数据库连接
	public static Connection con;

	// 构造方法
	public DB() {
		try {
			Properties properties = loadProperties();
			driverName = firstNonBlank(System.getenv("STUDENTCORE_DB_DRIVER"), properties.getProperty("db.driver"), DEFAULT_DRIVER);
			url = firstNonBlank(System.getenv("STUDENTCORE_DB_URL"), properties.getProperty("db.url"));
			user = firstNonBlank(System.getenv("STUDENTCORE_DB_USERNAME"), properties.getProperty("db.username"));
			pass = firstNonBlank(System.getenv("STUDENTCORE_DB_PASSWORD"), properties.getProperty("db.password"));
			validateConfig();

			// 加载驱动
			Class.forName(driverName); // 这个驱动是mysql8版本的
			// 获取连接
			con = DriverManager.getConnection(url, user, pass);
		} catch (Exception e) {
			throw new IllegalStateException("Database initialization failed. Please check STUDENTCORE_DB_* env vars or config/db.properties", e);
		}
	}

	private Properties loadProperties() {
		Properties properties = new Properties();
		try {
			InputStream classpathInput = DB.class.getClassLoader().getResourceAsStream("db.properties");
			if (classpathInput != null) {
				properties.load(classpathInput);
				classpathInput.close();
			}

			String configPath = firstNonBlank(System.getenv("STUDENTCORE_DB_CONFIG"), DEFAULT_CONFIG_PATH);
			File file = new File(configPath);
			if (file.isFile()) {
				FileInputStream fileInput = new FileInputStream(file);
				properties.load(fileInput);
				fileInput.close();
			}
		} catch (Exception e) {
			throw new IllegalStateException("Failed to load database config file", e);
		}
		return properties;
	}

	private void validateConfig() {
		if (isBlank(url) || isBlank(user) || isBlank(pass)) {
			throw new IllegalStateException("Missing db.url / db.username / db.password configuration");
		}
	}

	private String firstNonBlank(String... values) {
		if (values == null) {
			return null;
		}
		for (String value : values) {
			if (!isBlank(value)) {
				return value.trim();
			}
		}
		return null;
	}

	private boolean isBlank(String value) {
		return value == null || value.trim().isEmpty();
	}

	// 获取连接
	public static Connection getConnection() {
		if (con == null) {
			new DB();
		}
		return con;
	}

	// 释放连接
	public static void close(ResultSet resultSet, Statement statement, Connection connection) {

		if (resultSet != null) {
			try {
				resultSet.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		if (statement != null) {
			try {
				statement.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		if (connection != null) {
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	// 释放连接
	public static void close(Statement statement, Connection connection) {

		if (statement != null) {
			try {
				statement.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		if (connection != null) {
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	// 释放连接
	public static void close(Connection connection) {

		if (connection != null) {
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

}
