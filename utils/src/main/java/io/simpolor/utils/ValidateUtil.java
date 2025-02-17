package io.simpolor.utils;

import java.util.regex.Pattern;

public class ValidateUtil {

	public final static String PATTERN_SPACE = ".*\\s.*";
	public final static String PATTERN_LOWER_CASE = "^[a-z]*$";
	public final static String PATTERN_UPPER_CASE = "^[A-Z]*$";
	public final static String PATTERN_NUMBER = "[0-9]*";
	public final static String PATTERN_HANGEUL = "^[ㄱ-힣]*$";
	public final static String PATTERN_ENGLISH = "^[a-zA-Z]*$";
	
	public final static String PATTERN_IDENTITY = "^[a-zA-Z]+[a-zA-Z0-9]*$";
	public final static String PATTERN_PASSWORD = "^[a-zA-Z0-9!@#$%^&*()]*$";
	public final static String PATTERN_EMAIL = "^[a-zA-Z0-9-_.]+@+[a-zA-Z0-9-_]+\\.+[a-zA-Z]+$";
	public final static String PATTERN_NICKNAME = "^[a-zA-Z0-9ㄱ-힣-_]*$";
	public final static String PATTERN_TEL = "\\d{2,3}-\\d{3,4}-\\d{4}";
	public final static String PATTERN_MOBILE = "01([0-9])-\\d{3,4}-\\d{4}";
	public final static String PATTERN_URL = "^((https?+://www.)|(https?+://))+[a-zA-Z0-9-_.]+((:[0-9]+)|(\\.[a-zA-Z]+))+([a-zA-Z0-9ㄱ-힣?!@#$%^&-=_./()\\[\\]{}'\"]*)?$";
	
	/***
	 * 입력된 String형의 문자가 null 또는 공백("")인지 여부를 확인 
	 * @param str
	 * @return boolean
	 */
	public static boolean isEmpty(String str){
		if(str == null || str.trim().length() <= 0){
			return true;
		}
		
		return false;
	}
	
	/***
	 * 입력된 String형의 문자가 공백이 있는지 여부를 확인
	 * @param str
	 * @return boolean
	 */
	public static boolean isSpace(String str) {
		if (isEmpty(str)){
			return false;
		}
		return Pattern.matches(PATTERN_SPACE, str);
	}
	
	/***
	 * 입력된 String형의 문자가 소문자인지 여부를 확인
	 * @param str
	 * @return boolean
	 */
	public static boolean isLowerCase(String str) {
		if (isEmpty(str)){
			return false;
		}
		return Pattern.matches(PATTERN_LOWER_CASE, str);
	}
	
	/***
	 * 입력된 String형의 문자가 대문자인지 여부를 확인
	 * @param str
	 * @return boolean
	 */
	public static boolean isUpperCase(String str) {
		if (isEmpty(str)){
			return false;
		}
		return Pattern.matches(PATTERN_UPPER_CASE, str);
	}
	
	/***
	 * 입력된 String형의 문자가 숫자인지 여부를 확인
	 * @param str
	 * @return boolean
	 */
	public static boolean isNumber(String str) {
		if (isEmpty(str)){
			return false;
		}
		return Pattern.matches(PATTERN_NUMBER, str);
	}
	
	/***
	 * 입력된 String형의 문자가 한글인지 여부를 확인
	 * @param str
	 * @return boolean
	 */
	public static boolean isHangeul(String str) {
		if (isEmpty(str)){
			return false;
		}
		return Pattern.matches(PATTERN_HANGEUL, str);
	}
	
	/***
	 * 입력된 String형의 문자가 id형식이 맞는지 여부를 확인
	 * ( 첫글자는 영문소문자로 시작해야하며, 두번째부터는 숫자가 들어갈 수 있음
	 *   특수문자 및 영문대문자, 한글은 올 수가 없음 )
	 * @param str
	 * @return boolean
	 */
	public static boolean isIdentity(String str, int minLength, int maxLength) {
		if (isEmpty(str)){
			return false;
		}
		if(str.length() < minLength || str.length() > maxLength) {
			return false;
		}
		return Pattern.matches(PATTERN_IDENTITY, str);
	}
	
	/***
	 * 입력된 String형의 문자가 password형식이 맞는지 여부를 확인
	 * ( 영문, 숫자, 특수문자[숫자]를 혼용하여 사용 )
	 * @param str
	 * @return boolean
	 */
	public static boolean isPassword(String str, int minLength, int maxLength) {
		if (isEmpty(str)){
			return false;
		}
		if(str.length() < minLength || str.length() > maxLength) {
			return false;
		}
		return Pattern.matches(PATTERN_PASSWORD, str);
	}
	
	/***
	 * 입력된 String형의 문자가 email 형식이 맞는지 여부를 확인
	 * ex) simpolor@gmail.com (@와 .의 여부) 
	 * @param str
	 * @return boolean
	 */
	public static boolean isEmail(String str) {
		if (isEmpty(str)){
			return false;
		}
		return Pattern.matches(PATTERN_EMAIL, str);
	}
	
	/***
	 * 입력된 String형의 문자가 이름 형식이 맞는지 여부를 확인
	 * ( 한글만 사용 )
	 * @param str
	 * @return boolean
	 */
	public static boolean isName(String str, int minLength, int maxLength) {
		if (isEmpty(str)){
			return false;
		}
		if(str.length() < minLength || str.length() > maxLength) {
			return false;
		}
		return Pattern.matches(PATTERN_HANGEUL, str);
	}
	
	/***
	 * 입력된 String형의 문자가 닉네임 형식이 맞는지 여부를 확인
	 * ex) IAM-최고_01 (영문/한글/숫자/특수문자[_,-]) 
	 * @param str
	 * @return boolean
	 */
	public static boolean isNickname(String str, int minLength, int maxLength) {
		if (isEmpty(str)){
			return false;
		}
		if(str.length() < minLength || str.length() > maxLength) {
			return false;
		}
		return Pattern.matches(PATTERN_NICKNAME, str);
	}
	
	/***
	 * 입력된 String형의 문자가 전화번호 형식이 맞는지 여부를 확인
	 * ex) 02-452-2123 
	 * @param str
	 * @return boolean
	 */
	public static boolean isTel(String str) {
		if (isEmpty(str)){
			return false;
		}
		return Pattern.matches(PATTERN_TEL, str);
	}
	
	/***
	 * 입력된 String형의 문자가 핸드폰번호 형식이 맞는지 여부를 확인
	 * ex) 010-4952-2123
	 * @param str
	 * @return boolean
	 */
	public static boolean isMobile(String str) {
		if (isEmpty(str)){
			return false;
		}
		return Pattern.matches(PATTERN_MOBILE, str);
	}
	
	/***
	 * 입력된 String형의 문자가 URL 형식이 맞는지 여부를 확인
	 * ex) http://www.simpolor.com
	 * @param str
	 * @return boolean
	 */
	public static boolean isUrl(String str) {
		if (isEmpty(str)){
			return false;
		}
		return Pattern.matches(PATTERN_URL, str);
	}
	
	
}
