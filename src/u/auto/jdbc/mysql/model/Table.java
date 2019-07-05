package u.auto.jdbc.mysql.model;

import java.util.List;

/**
 * @description: <br/>
 * @version: 1<br/>
 * @package u.auto.jdbc.mysql.model.Table.java
 * @author YangPu
 * @date 2017年1月16日 上午11:51:43
 */
public class Table {

	// 表的名称
	// house_side_info
	private String tableName;
	// 表的注释
	private String tableComment;
	// 表中的每一列的信息
	private List<ColumnInfo> columnInfos;
	// 主键列,有或无--没有联合主键的情况--多个主键,现在不支持
	private ColumnInfo id;

	public ColumnInfo getId() {
		return id;
	}

	public void setId(ColumnInfo id) {
		this.id = id;
	}

	public String getTableComment() {
		return tableComment;
	}

	public void setTableComment(String tableComment) {
		this.tableComment = tableComment;
	}

	public String getTableName() {
		return tableName;
	}

	public void setTableName(String tableName) {
		this.tableName = tableName;
	}

	public List<ColumnInfo> getColumnInfos() {
		return columnInfos;
	}

	public void setColumnInfos(List<ColumnInfo> columnInfos) {
		this.columnInfos = columnInfos;
	}

}
