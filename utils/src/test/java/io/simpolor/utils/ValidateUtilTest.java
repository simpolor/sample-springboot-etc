package io.simpolor.utils;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

class ValidateUtilTest {

	@Test
	void testIsSpace() {
		assertTrue(ValidateUtil.isSpace("공백 검증"));
		//fail("Not yet implemented");
	}

	@Test
	void testIsLowerCase() {
		assertTrue(ValidateUtil.isLowerCase("abcd"));
	}

	@Test
	void testIsUpperCase() {
		assertTrue(ValidateUtil.isUpperCase("ABCD"));
	}

	@Test
	void testIsNumber() {
		assertTrue(ValidateUtil.isNumber("1234"));
	}

	@Test
	void testIsHangeul() {
		assertTrue(ValidateUtil.isHangeul("가나다라"));
	}

	@Test
	void testIsIdentity() {
		assertTrue(ValidateUtil.isIdentity("abcd1234", 6, 20));
	}

	@Test
	void testIsPassword() {
		assertTrue(ValidateUtil.isPassword("234abcd!@#$", 6, 16));
	}

	@Test
	void testIsEmail() {
		assertTrue(ValidateUtil.isEmail("abcd@simpolor.com"));
	}

	@Test
	void testIsName() {
		assertTrue(ValidateUtil.isName("단순색", 2, 25));
	}

	@Test
	void testIsNickname() {
		assertTrue(ValidateUtil.isNickname("simpolor-단순색", 2, 25));
	}

	@Test
	void testIsTel() {
		assertTrue(ValidateUtil.isTel("02-888-8888"));
	}

	@Test
	void testIsMobile() {
		assertTrue(ValidateUtil.isMobile("010-8888-8888"));
	}

	@Test
	void testIsUrl() {
		assertTrue(ValidateUtil.isUrl("http://www.simpolor.com"));
	}

}
