package com.neves.status.utils;

public abstract class TestUtils {
	public static final String TEST_USER_ID = "testUser123";
	public static final String FORMAT_USER_ID = "{\"%s\":\"%s\"}";
	public static final String DEFAULT_PAYLOAD = java.util.Base64.getEncoder().encodeToString(String.format(FORMAT_USER_ID, JwtUtils.USER_KEY, TEST_USER_ID).getBytes());
	public static final String DEFAULT_JWT= "Bearer header." + DEFAULT_PAYLOAD + ".signature";
	public static final String DEFAULT_UUID = "123e4567-e89b-12d3-a456-426614174000";

	public static String encodeUserId(String userId) {
		return java.util.Base64.getEncoder().encodeToString(String.format(FORMAT_USER_ID, JwtUtils.JWT_HEADER, userId).getBytes());
	}
}
