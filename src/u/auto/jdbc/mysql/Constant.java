package u.auto.jdbc.mysql;

public class Constant {

	// 位置不能随意变更
	public static final String[][] fieldType = { //
			{"bool", "boolean"} // Boolean--0
			, {"bit", "tinyint", "smallint", "int", "integer", "mediummint"} // Integer--1
			, {"bigint"} // Long--2
			, {"float", "real"} // Float--3
			, {"dec", "decimal", "double", "dec", "decimal", "double"} // Double--4
			, {"enum", "binary", "blob", "char", "enum", "fixed", "longblob", "tinyblob", "tinytext", "varbinary", "varchar", "longtext", "mediumblob", "set", "text"} // String--5
			, {"timestamp", "year", "datetime"}// Timestamp--6
			, {"year"}// Year--7
			, {"date"}// Date--8
			, {"time"}// Time--9
			, {"byte"}// byte--10
	};

	// 位置不能随意变更
	// 修改的时候注意修改modelCreate中的值
	public static final String[] fieldTyepName = { //
			"Boolean"// Boolean--0
			, "Integer"// Integer--1
			, "Long"// Long--2
			, "Float"// Float--3
			, "BigDecimal"// BigDecimal--4
			, "String"// String--5
			, "Timestamp" // Timestamp--6
			// , "Timestamp" // Timestamp--6
			, "Year" // Year--7
			, "Date" // Date--8
			, "time"// Time--9
			, "Byte"// Byte--10
			, "String" // default--10
	};

	private static String pre;

	static {
		pre = Class.class.getClass().getResource("/").getPath().substring(1, Class.class.getClass().getResource("/").getPath().length());
	}

	private static final String template = pre + "u/auto/resources/";
	public static final String model = template + "templateModel.up";
	public static final String do1 = template + "templateDo.up";
	public static final String dto = template + "templateDto.up";
	public static final String vo = template + "templateVo.up";
	public static final String modelAnnotation = template + "templateModelAnnotation.up";
	public static final String mapper = template + "templateMapper.up";
	public static final String dao = template + "templateDao.up";
	public static final String ser = template + "templateSer.up";
	public static final String ctr = template + "templateCtr.up";
	public static final String doc = template + "templateDoc.up";
	public static final String ctrRestful = template + "templateCtrRestful.up";
	public static final String temp = template + "temp.up";
	public static final String package_model = "model";
	public static final String package_do = "do";
	public static final String package_dto = "dto";
	public static final String package_vo = "vo";
	public static final String package_model_annotation = "modelAnnotation";
	public static final String package_mapper = "mapper";
	public static final String package_dao = "dao";
	public static final String package_ser = "service";
	public static final String package_ctr = "controller";
	public static final String package_ctr_restful = "controllerRestful";
	public static final String package_doc = "doc";
	public static int limit = 15;
	public static String path = "E:/study/auto/";
	public static Boolean isTable = Boolean.FALSE;
	public static Boolean isConstructor = Boolean.FALSE;

}
