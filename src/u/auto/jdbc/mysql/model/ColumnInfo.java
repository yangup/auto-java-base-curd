package u.auto.jdbc.mysql.model;

import java.lang.reflect.Field;
import java.util.HashSet;
import java.util.Set;

/**
 * @description: <br/>
 * @version: 1<br/>
 * @package u.auto.jdbc.mysql.model.ColumnInfo.java
 * @author YangPu
 * @date 2017年1月16日 上午11:51:52
 */
public class ColumnInfo {

	private String tableCatalog;
	private String tableSchema;
	private String tableName;
	private String columnName;
	private String columnNameJava;// java中的驼峰命名
	private String ordinalPosition;
	private String columnDefault;
	private String isNullable;
	private String dataType;// 数据库中的数据类型
	private String dataTypeJava;// java中的数据类型
	private int dataTypeIndex;// 在Constant.fieldTyepName中的下标值
	private String characterMaximumLength;
	private String characterOctetLength;
	private String numericPrecision;
	private String numericScale;
	// private String datetimePrecision;
	private String characterSetName;
	private String collationName;
	private String columnType;
	private String columnKey;
	private String extra;
	private String privileges;
	private String columnComment;
	// private String generationExpression;
	private String tableComment;

	public int getDataTypeIndex() {
		return dataTypeIndex;
	}

	public void setDataTypeIndex(int dataTypeIndex) {
		this.dataTypeIndex = dataTypeIndex;
	}

	public String getColumnNameJava() {
		return columnNameJava;
	}

	public void setColumnNameJava(String columnNameJava) {
		this.columnNameJava = columnNameJava;
	}

	public String getDataTypeJava() {
		return dataTypeJava;
	}

	public void setDataTypeJava(String dataTypeJava) {
		this.dataTypeJava = dataTypeJava;
	}

	public String getTableComment() {
		return tableComment;
	}

	public void setTableComment(String tableComment) {
		this.tableComment = tableComment;
	}

	public String getTableCatalog() {
		return tableCatalog;
	}

	public void setTableCatalog(String tableCatalog) {
		this.tableCatalog = tableCatalog;
	}

	public String getTableSchema() {
		return tableSchema;
	}

	public void setTableSchema(String tableSchema) {
		this.tableSchema = tableSchema;
	}

	public String getTableName() {
		return tableName;
	}

	public void setTableName(String tableName) {
		this.tableName = tableName;
	}

	public String getColumnName() {
		return columnName;
	}

	public void setColumnName(String columnName) {
		this.columnName = columnName;
	}

	public String getOrdinalPosition() {
		return ordinalPosition;
	}

	public void setOrdinalPosition(String ordinalPosition) {
		this.ordinalPosition = ordinalPosition;
	}

	public String getColumnDefault() {
		return columnDefault;
	}

	public void setColumnDefault(String columnDefault) {
		this.columnDefault = columnDefault;
	}

	public String getIsNullable() {
		return isNullable;
	}

	public void setIsNullable(String isNullable) {
		this.isNullable = isNullable;
	}

	public String getDataType() {
		return dataType;
	}

	public void setDataType(String dataType) {
		this.dataType = dataType;
	}

	public String getCharacterMaximumLength() {
		return characterMaximumLength;
	}

	public void setCharacterMaximumLength(String characterMaximumLength) {
		this.characterMaximumLength = characterMaximumLength;
	}

	public String getCharacterOctetLength() {
		return characterOctetLength;
	}

	public void setCharacterOctetLength(String characterOctetLength) {
		this.characterOctetLength = characterOctetLength;
	}

	public String getNumericPrecision() {
		return numericPrecision;
	}

	public void setNumericPrecision(String numericPrecision) {
		this.numericPrecision = numericPrecision;
	}

	public String getNumericScale() {
		return numericScale;
	}

	public void setNumericScale(String numericScale) {
		this.numericScale = numericScale;
	}

	// public String getDatetimePrecision() {
	// return datetimePrecision;
	// }
	//
	// public void setDatetimePrecision(String datetimePrecision) {
	// this.datetimePrecision = datetimePrecision;
	// }

	public String getCharacterSetName() {
		return characterSetName;
	}

	public void setCharacterSetName(String characterSetName) {
		this.characterSetName = characterSetName;
	}

	public String getCollationName() {
		return collationName;
	}

	public void setCollationName(String collationName) {
		this.collationName = collationName;
	}

	public String getColumnType() {
		return columnType;
	}

	public void setColumnType(String columnType) {
		this.columnType = columnType;
	}

	public String getColumnKey() {
		return columnKey;
	}

	public void setColumnKey(String columnKey) {
		this.columnKey = columnKey;
	}

	public String getExtra() {
		return extra;
	}

	public void setExtra(String extra) {
		this.extra = extra;
	}

	public String getPrivileges() {
		return privileges;
	}

	public void setPrivileges(String privileges) {
		this.privileges = privileges;
	}

	public String getColumnComment() {
		return columnComment;
	}

	public void setColumnComment(String columnComment) {
		this.columnComment = columnComment;
	}

	// public String getGenerationExpression() {
	// return generationExpression;
	// }
	//
	// public void setGenerationExpression(String generationExpression) {
	// this.generationExpression = generationExpression;
	// }

	public static Set<String> FieldSet() {
		Set<String> keys = new HashSet<>();
		Field[] fields = ColumnInfo.class.getDeclaredFields();
		for (Field field : fields) {
			if (!"datatypejava".equals(field.getName().toLowerCase()) && !"columnnamejava".equals(field.getName().toLowerCase())
					&& !"datatypeindex".equals(field.getName().toLowerCase())) {
				keys.add(field.getName());
			}
		}
		return keys;
	}

}
