package io.simpolor.utils;

import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

class DateUtilTest {

	@Test
	void testGetDateTimeMillis() {
		System.out.println("DateUtil.getDateTimeMillis() : "+DateUtil.getDateTimeMillis(new Date()));
		assertNotNull(DateUtil.getDateTimeMillis(new Date()));
	}

	@Test
	void testGetDateTime() {
		System.out.println("DateUtil.getDateTime() : "+DateUtil.getDateTime(new Date()));
		assertNotNull(DateUtil.getDateTime(new Date()));
	}

	@Test
	void testGetDate() {
		System.out.println("DateUtil.getDate() : "+DateUtil.getDate(new Date()));
		assertNotNull(DateUtil.getDate(new Date()));
	}

	@Test
	void testGetTime() {
		System.out.println("DateUtil.getTime() : "+DateUtil.getTime(new Date()));
		assertNotNull(DateUtil.getTime(new Date()));
	}

	@Test
	void testGetDateFormat() {
		String format = "yyyy-MM-dd HH:mm:ss";
		System.out.println("DateUtil.getDateFormat() : "+DateUtil.getDateFormat(new Date(), format));
		assertNotNull(DateUtil.getDateFormat(new Date(), format));
	}

	@Test
	void testGetDateToLong() {
		System.out.println("DateUtil.getDateToLong() : "+DateUtil.getDateToLong(new Date()));
		assertNotNull(DateUtil.getDateToLong(new Date()));
	}

	@Test
	void testGetLongToDate() {
		long longTime = 1521002333581L;
		System.out.println("DateUtil.getLongToDate() : "+DateUtil.getLongToDate(longTime));
		assertNotNull(DateUtil.getLongToDate(longTime));
	}

	@Test
	void testToDateTimeMillis() {
		String dateTimeMillis = "2018-03-14 13:41:19:234";
		System.out.println("DateUtil.toDateTimeMillis() : "+DateUtil.toDateTimeMillis(dateTimeMillis));
		assertNotNull(DateUtil.toDateTimeMillis(dateTimeMillis));
	}

	@Test
	void testToDateTime() {
		String dateTime = "2018-03-14 13:41:19";
		System.out.println("DateUtil.toDateTime() : "+DateUtil.toDateTime(dateTime));
		assertNotNull(DateUtil.toDateTime(dateTime));
	}

	@Test
	void testToDate() {
		String date = "2018-03-14";
		System.out.println("DateUtil.toDate() : "+DateUtil.toDate(date));
		assertNotNull(DateUtil.toDate(date));
	}

	@Test
	void testIsValid() {
		String dateTime = "2018-03-14 13:41:19";
		String format = "yyyy-MM-dd HH:mm:ss";
		System.out.println("DateUtil.isValid() : "+DateUtil.isValid(dateTime, format));
		assertTrue(DateUtil.isValid(dateTime, format));
	}

}
