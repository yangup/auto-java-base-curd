package u.auto.sys.order;

import java.util.Date;
import java.util.Properties;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.DateFormatUtils;

import u.auto.util.CharUtil;

public enum Order {

	// house_side_info -> HouseSideInfo
	// 表名称-> 将下划线+小写转化为大写,首字母大写
	modelName,
	// house_side_info -> houseSideInfo
	// 将下划线+小写转化为大写
	modelNameParam,
	// id的类型
	// 例如：String
	modelNameIdType,
	// id..house_side_info -> houseSideInfo
	// 将下划线+小写转化为大写
	modelNameId,
	// id..house_side_info -> HouseSideInfo
	// 将下划线+小写转化为大写,首字母大写
	modelNameIdTitle,
	// 表的注释
	modelComment,
	// house_side_info -> housesideinfo
	// 表名称->全部小写
	modelLower,
	// model产生的时候生成的field
	startField,
	// model产生的时候生成的构造方法
	createConstructor,
	// model产生的时候生成的geter,setter方法
	startMethod,
	// 当前用户
	user,
	// 当前日期
	date,
	// 当前日期
	// yyyy-mm-dd HH:mi
	dateYMDHM,
	//
	;

	/**
	 * 获得命令
	 **/
	public static String getOrder(Order o) {
		if (o == null) {
			return null;
		}
		return CharUtil.y + o.toString() + CharUtil.y;
	}

	/**
	 * 判断str中,是否含有命令
	 **/
	public static boolean check(String str, Order o) {
		if (StringUtils.isEmpty(str)) {
			return false;
		}
		if (str.contains(getOrder(o))) {
			return true;
		}
		return false;
	}

	/**
	 * 判断str中,o命令转化成os,并返回str
	 **/
	public static String change(String str, Order o, String os) {
		if (StringUtils.isEmpty(str)) {
			return str;
		}
		if (check(str, o)) {
			str = str.replaceAll(getOrder(o), os);
		}
		return str;
	}

	/**
	 * 将str中的user换成系统的user
	 **/
	public static String user(String str) {
		return change(str, Order.user, System.getProperty("user.name"));
	}

	/**
	 * 将str中的date换成系统的系统时间
	 **/
	public static String date(String str) {
		return change(str, Order.date, DateFormatUtils.format(new Date(), "yyyy-MM-dd HH:mm:ss"));
	}

	/**
	 * 将str中的date换成系统的系统时间
	 **/
	public static String dateYMDHM(String str) {
		return change(str, Order.dateYMDHM, DateFormatUtils.format(new Date(), "yyyy-MM-dd HH:mm"));
	}

}
