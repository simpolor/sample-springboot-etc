package io.simpolor.utils;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class StringUtilTest {

	@Test
	void testGetIntObject() {
		assertEquals(5, StringUtil.getInt("5"));
	}

	@Test
	void testGetIntObjectInt() {
		//assertEquals(4, StringUtil.getInt("test", 4));
		assertEquals(5, StringUtil.getInt("5", 4));
	}

	@Test
	void testGetLongObject() {
		//assertEquals(5L, StringUtil.getLong("5"));
		assertEquals(-1L, StringUtil.getLong("test"));
	}

	@Test
	void testGetLongObjectLong() {
		assertEquals(4L, StringUtil.getInt("test", 4));
		//assertEquals(5L, StringUtil.getInt("5", 4));
	}

	@Test
	void testGetFloatObject() {
		//assertEquals(-1.0f, StringUtil.getFloat("test"));
		assertEquals(1.0f, StringUtil.getFloat("1"));
	}

	@Test
	void testGetFloatObjectFloat() {
		assertEquals(4.0f, StringUtil.getFloat("test", 4.0f));
	}

	@Test
	void testGetDoubleObject() {
		//assertEquals(-1.0d, StringUtil.getDouble("test"));
		assertEquals(1.0d, StringUtil.getDouble("1"));
	}

	@Test
	void testGetDoubleObjectDouble() {
		//assertEquals(4.0d, StringUtil.getDouble("test", 4.0d));
		assertEquals(3.0d, StringUtil.getDouble("3", 4.0d));
	}

	@Test
	void testGetStringObject() {
		assertEquals("가", StringUtil.getString("가"));
	}

	@Test
	void testGetStringObjectString() {
		assertEquals("가", StringUtil.getString("가", "나"));
		//assertEquals("나", StringUtil.getString(null, "나"));
	}

	@Test
	void testGetStrArrStringArray() {
		assertEquals("가, 나", StringUtil.getStrArr(new String[]{"가","나"}));
	}

	@Test
	void testGetStrArrStringArrayString() {
		assertEquals("가|나", StringUtil.getStrArr(new String[]{"가","나"}, "|"));
	}

	@Test
	void testIsEmpty() {
		assertTrue(StringUtil.isEmpty(""));
		//assertTrue(StringUtil.isEmpty("가"));
	}

	@Test
	void testGetLength() {
		assertTrue(StringUtil.isEmpty(""));
	}

	@Test
	void testIsEquals() {
		//assertTrue(StringUtil.isEquals("A", "a"));
		assertTrue(StringUtil.isEquals("가", "가"));
	}

	@Test
	void testIsIgnoreEquals() {
		assertTrue(StringUtil.isIgnoreEquals("A", "a"));
	}

	@Test
	void testSubstring() {
		assertEquals("나다", StringUtil.substring("가나다라마바사", 1, 3));
	}

	@Test
	void testLastSubString() {
		assertEquals("사", StringUtil.lastSubString("가나다라마바사", 1));
	}

	@Test
	void testLastRemove() {
		assertEquals("가나다라마", StringUtil.lastRemove("가나다라마바사", 2));
	}

}
