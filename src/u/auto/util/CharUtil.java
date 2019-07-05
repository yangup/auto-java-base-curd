package u.auto.util;

import org.apache.commons.lang3.StringUtils;

/**
 * <p>
 * yangpu.util.CharUtil.java
 * </p>
 * <p>
 * description：charUtil
 * </p>
 * 
 * @author YangPu
 * @createTime 2016年7月21日 上午10:29:53
 */
public class CharUtil {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// System.out.println(CharUtil.UppercaseToUnderline("characterMaximumLength"));
		System.out.println(CharUtil.UnderlineToUppercase("CHARACTER_MAXIMUM_LENGTH"));
		System.out.println(CharUtil.UnderlineToUppercaseTitle("character_maximum_length"));
		System.out.println(s);

	}

	public static String y = "-";
	public static String s = "\"";
	public static String m = ":";
	public static String d = ",";
	public static String a = ".";
	public static String n = "\n";
	public static String h = "|";

	/**
	 * <p>
	 * description： 将大写转化为下划线
	 * </p>
	 *
	 * @param str
	 * @return<br>
	 * @author YangPu
	 * @createTime 2016年7月21日 上午10:48:58
	 */
	public static String UppercaseToUnderline(String str) {
		StringBuilder result = new StringBuilder();
		if (StringUtils.isBlank(str)) {
			return result.toString();
		}
		int strLen = str.length();
		for (int i = 0; i < strLen; ++i) {
			char c = str.charAt(i);
			if (Character.isUpperCase(c)) {
				result.append("_" + Character.toLowerCase(c));
			} else {
				result.append(c);
			}
		}
		return result.toString();

	}

	/**
	 * <p>
	 * description： 将下划线+小写转化为大写
	 * </p>
	 *
	 * @param str
	 * @return<br>
	 * @author YangPu
	 * @createTime 2016年7月21日 上午10:50:19
	 */
	public static String UnderlineToUppercase(String str) {
		StringBuilder result = new StringBuilder();
		if (StringUtils.isBlank(str)) {
			return result.toString();
		}
		str = str.toLowerCase();
		int strLen = str.length();
		for (int i = 0; i < strLen; ++i) {
			char c = str.charAt(i);
			if (c == '_') {
				i++;
				if (i < strLen) {
					c = str.charAt(i);
					c = Character.toTitleCase(c);
				}
			}
			result.append(c);
		}
		return result.toString();
	}

	/**
	 * <p>
	 * description： 将下划线+小写转化为大写,首字母大写
	 * </p>
	 *
	 * @param str
	 * @return<br>
	 * @author YangPu
	 * @createTime 2016年7月21日 下午5:34:29
	 */
	public static String UnderlineToUppercaseTitle(String str) {
		StringBuilder result = new StringBuilder();
		if (StringUtils.isBlank(str)) {
			return result.toString();
		}
		str = str.toLowerCase();
		int strLen = str.length();
		for (int i = 0; i < strLen; ++i) {
			char c = str.charAt(i);
			if (i == 0 && Character.isLetter(c)) {
				c = Character.toTitleCase(c);
			}
			if (c == '_') {
				i++;
				if (i < strLen) {
					c = str.charAt(i);
					c = Character.toTitleCase(c);
				}
			}
			result.append(c);
		}
		return result.toString();
	}

	public static String getWhitespace(int length) {
		StringBuilder result = new StringBuilder();
		if (length < 1) {
			return result.toString();
		}
		for (int i = 0; i < length; i++) {
			result.append(" ");
		}
		return result.toString();
	}

	public static String getTab(int length) {
		StringBuilder result = new StringBuilder();
		if (length < 1) {
			return result.toString();
		}
		for (int i = 0; i < length; i++) {
			result.append("\t");
		}
		return result.toString();
	}

	/**
	 * str数据的转化<br>
	 * null -> ""<br>
	 **/
	public static String c(String str) {
		if (StringUtils.isEmpty(str)) {
			return "";
		}
		return str;
	}

	/**
	 * json数据的格式化
	 **/
	public static String formatJson(String json) {
		if (StringUtils.isEmpty(json)) {
			return json;
		}
		return json.replace("{", "{\n\t").replace("}", "\n}\n").replace(",", ",\n\t");
	}
}
