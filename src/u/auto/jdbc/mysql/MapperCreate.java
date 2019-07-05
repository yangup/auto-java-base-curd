package u.auto.jdbc.mysql;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

import u.auto.jdbc.mysql.model.ColumnInfo;
import u.auto.jdbc.mysql.model.Table;
import u.auto.util.CharUtil;
import u.auto.util.ReaderWriter;

/**
 * <p>
 * yangpu.jdbc.mysql.ModelCreate.java
 * </p>
 * <p>
 * description：
 * </p>
 * 
 * @author YangPu
 * @createTime 2016年7月21日 下午3:50:33
 */
public class MapperCreate {

	private BufferedWriter writer;
	private List<ColumnInfo> list;
	private Table table;
	private int MaxLength = 0;
	private ColumnInfo pris;

	/**
	 * 加载模板
	 * 
	 * @param modelName
	 */
	public MapperCreate(Table table) {
		init(table);
	}

	private void init(Table table) {
		try {
			this.table = table;
			this.pris = table.getId();
			this.list = table.getColumnInfos();
			String modelName = CharUtil.UnderlineToUppercaseTitle(table.getTableName());
			String fileName = null;
			if (Constant.isTable) {
				fileName = Constant.path + modelName + File.separator + modelName + "Mapper.xml";
			} else {
				fileName = Constant.path + Constant.package_mapper + File.separator + modelName + "Mapper.xml";
			}
			File file = new File(fileName);
			if (!file.getParentFile().exists()) {
				file.getParentFile().mkdir();
			}
			if (!file.exists()) {
				file.createNewFile();
			}
			writer = new BufferedWriter(new FileWriter(file));
			BufferedReader reader = new BufferedReader(new FileReader(Constant.mapper));
			reader = ReaderWriter.readWrite(reader, table);
			calcMaxLength();
			String line = null;
			while ((line = reader.readLine()) != null) {
				if (line.contains("-columns-")) {
					columnsCreate();
				} else if (line.contains("-where-")) {
					whereCreate();
				} else if (line.contains("-insert-")) {
					insertCreate();
				} else if (line.contains("-update-")) {
					updateCreate();
				} else if (line.contains("-updateByParam-")) {
					updateByParamCreate();
				} else if (line.contains("-deleteById-")) {
					deleteByIdCreate();
				} else if (line.contains("-deleteByEntity-")) {
					deleteByEntityCreate();
				} else if (line.contains("-getById-")) {
					getByIdCreate();
				} else if (line.contains("-getList-")) {
					getListCreate();
				} else if (line.contains("-getList_count-")) {
					getListCountCreate();
				} else {
					writer.write(line + "\n");
				}
			}
			writer.close();
			reader.close();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * 计算<br>
	 * 所有字段中,长度最长的一个字段的长度<br>
	 */
	private void calcMaxLength() {
		try {
			for (int index = 0; index < list.size(); index++) {
				ColumnInfo columninfo = list.get(index);
				String cloumn = columninfo.getColumnName();
				if (MaxLength < cloumn.length()) {
					MaxLength = cloumn.length();
				}
			}
			MaxLength++;
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	private void columnsCreate() {
		try {
			String temp = null;
			boolean isTwo = false;
			if (list.size() > Constant.limit) {
				isTwo = true;
			}
			String fieldFront = null;
			for (int index = 0; index < list.size(); index++) {
				ColumnInfo columninfo = list.get(index);
				String cloumn = columninfo.getColumnName();
				String field = CharUtil.UnderlineToUppercase(cloumn);
				if (index == 0) {
					temp = new String(" " + cloumn);
				} else {
					temp = new String("," + cloumn);
				}
				if (isTwo) {
					if (index % 2 == 0) {
						writer.write(CharUtil.getTab(2) + temp + CharUtil.getWhitespace(MaxLength - temp.length()));
						writer.write(" AS ");
						writer.write(field);
						fieldFront = field;
					} else {
						writer.write(CharUtil.getWhitespace(MaxLength - fieldFront.length()) + CharUtil.getTab(1) + temp
								+ CharUtil.getWhitespace(MaxLength - temp.length()));
						writer.write(" AS ");
						writer.write(field);
						writer.write("\n");
					}
				} else {
					writer.write(CharUtil.getTab(2) + temp + CharUtil.getWhitespace(MaxLength - temp.length()));
					writer.write(" AS ");
					writer.write(field);
					writer.write("\n");
				}
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private void whereCreate() {
		try {
			for (int index = 0; index < list.size(); index++) {
				ColumnInfo columninfo = list.get(index);
				String cloumn = columninfo.getColumnName();
				String field = CharUtil.UnderlineToUppercase(cloumn);
				writer.write(CharUtil.getTab(3) + "<if test=\"@Ognl@isNotEmpty(" + field + ")\">" + "\n");
				writer.write(CharUtil.getTab(4) + "AND " + cloumn.toLowerCase() + CharUtil.getWhitespace(MaxLength - cloumn.length()));
				writer.write(" = ");
				writer.write("#{" + field + "}" + "\n");
				writer.write(CharUtil.getTab(3) + "</if>" + "\n");
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private void insertCreate() {
		String line = null;
		try {
			line = new String(CharUtil.getTab(2) + "INSERT INTO " + table.getTableName().toLowerCase() + " (");
			writer.write(line + "\n");
			for (int index = 0; index < list.size(); index++) {
				ColumnInfo columninfo = list.get(index);
				String cloumn = columninfo.getColumnName();
				if (index == 0) {
					line = new String(CharUtil.getTab(3) + " " + cloumn.toLowerCase());
				} else {
					line = new String(CharUtil.getTab(3) + "," + cloumn.toLowerCase());
				}
				writer.write(line + "\n");
			}
			writer.write(CharUtil.getTab(2) + ") VALUES (\n");
			for (int index = 0; index < list.size(); index++) {
				ColumnInfo columninfo = list.get(index);
				String cloumn = columninfo.getColumnName();
				String field = CharUtil.UnderlineToUppercase(cloumn);
				if (index == 0) {
					line = new String(CharUtil.getTab(3) + " #{" + field + "}");
				} else {
					line = new String(CharUtil.getTab(3) + ",#{" + field + "}");
				}
				writer.write(line + "\n");
			}
			writer.write(CharUtil.getTab(2) + ")\n");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private void updateCreate() {
		try {
			writer.write(CharUtil.getTab(2) + "UPDATE\n");
			writer.write(CharUtil.getTab(3) + table.getTableName().toLowerCase() + "\n");
			writer.write(CharUtil.getTab(2) + "SET\n");
			String temp = null;
			boolean isFirst = true;
			for (int index = 0; index < list.size(); index++) {
				ColumnInfo columninfo = list.get(index);
				String cloumn = columninfo.getColumnName();
				String field = CharUtil.UnderlineToUppercase(cloumn);
				if (isFirst) {
					temp = new String(" " + cloumn);
					isFirst = false;
				} else {
					temp = new String("," + cloumn);
				}
				writer.write(CharUtil.getTab(3) + temp.toLowerCase() + CharUtil.getWhitespace(MaxLength - temp.length()));
				writer.write(" = ");
				writer.write("#{" + field + "}" + "\n");
			}
			isFirst = true;
			if (pris != null) {
				writer.write(CharUtil.getTab(2) + "WHERE\n");
				String cloumn = pris.getColumnName();
				String field = CharUtil.UnderlineToUppercase(cloumn);
				if (isFirst) {
					temp = new String(" ");
					isFirst = false;
				} else {
					temp = new String("AND ");
				}
				writer.write(CharUtil.getTab(3) + temp + cloumn.toLowerCase() + CharUtil.getWhitespace(MaxLength - cloumn.length()) + "= #{" + field
						+ "}\n");
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private void updateByParamCreate() {
		try {
			writer.write(CharUtil.getTab(2) + "UPDATE\n");
			writer.write(CharUtil.getTab(3) + table.getTableName().toLowerCase() + "\n");
			writer.write(CharUtil.getTab(2) + "<set>\n");
			for (int index = 0; index < list.size(); index++) {
				ColumnInfo columninfo = list.get(index);
				boolean isContinue = true;
				if (pris != null) {
					if (pris.getColumnName().equals(columninfo.getColumnName())) {
						isContinue = false;
					}
				}
				if (!isContinue) {
					continue;
				}
				String cloumn = columninfo.getColumnName();
				String field = CharUtil.UnderlineToUppercase(cloumn);
				writer.write(CharUtil.getTab(3) + "<if test=\"@Ognl@isNotEmpty(" + field + ")\">\n");
				writer.write(CharUtil.getTab(4) + cloumn.toLowerCase() + CharUtil.getWhitespace(MaxLength - cloumn.length()));
				writer.write(" = ");
				writer.write("#{" + field + "}" + ",\n");
				writer.write(CharUtil.getTab(3) + "</if>\n");
			}
			writer.write(CharUtil.getTab(2) + "</set>\n");
			if (pris != null) {
				writer.write(CharUtil.getTab(2) + "<where>\n");
				String cloumn = pris.getColumnName();
				String field = CharUtil.UnderlineToUppercase(cloumn);
				writer.write(CharUtil.getTab(3) + "<if test=\"@Ognl@isNotEmpty(" + field + ")\">\n");
				writer.write(CharUtil.getTab(4) + "AND " + cloumn.toLowerCase() + " = #{" + field + "}\n");
				writer.write(CharUtil.getTab(3) + "</if>\n");
				writer.write(CharUtil.getTab(2) + "</where>\n");
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private void deleteByIdCreate() {
		try {
			writer.write(CharUtil.getTab(2) + "DELETE\n");
			writer.write(CharUtil.getTab(2) + "FROM\n");
			writer.write(CharUtil.getTab(3) + table.getTableName().toLowerCase() + "\n");
			if (pris != null) {
				writer.write(CharUtil.getTab(2) + "WHERE\n");
				String cloumn = pris.getColumnName();
				String field = CharUtil.UnderlineToUppercase(cloumn);
				writer.write(CharUtil.getTab(3) + cloumn.toLowerCase() + " = #{" + field + "}" + "\n");
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private void deleteByEntityCreate() {
		try {
			writer.write(CharUtil.getTab(2) + "DELETE\n");
			writer.write(CharUtil.getTab(2) + "FROM\n");
			writer.write(CharUtil.getTab(3) + table.getTableName().toLowerCase() + "\n");
			writer.write(CharUtil.getTab(2) + "<include refid=\"where\"/>\n");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private void getByIdCreate() {
		try {
			writer.write(CharUtil.getTab(2) + "SELECT\n");
			writer.write(CharUtil.getTab(3) + "<include refid=\"columns\" />\n");
			writer.write(CharUtil.getTab(2) + "FROM\n");
			writer.write(CharUtil.getTab(3) + table.getTableName().toLowerCase() + "\n");
			if (pris != null) {
				writer.write(CharUtil.getTab(2) + "WHERE\n");
				String cloumn = pris.getColumnName();
				String field = CharUtil.UnderlineToUppercase(cloumn);
				writer.write(CharUtil.getTab(3) + cloumn.toLowerCase() + " = #{" + field + "}\n");
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private void getListCreate() {
		try {
			writer.write(CharUtil.getTab(2) + "SELECT\n");
			writer.write(CharUtil.getTab(3) + "<include refid=\"columns\" />\n");
			writer.write(CharUtil.getTab(2) + "FROM\n");
			writer.write(CharUtil.getTab(3) + table.getTableName().toLowerCase() + "\n");
			writer.write(CharUtil.getTab(2) + "<include refid=\"where\"/>\n");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private void getListCountCreate() {
		try {
			StringBuilder prisSb = new StringBuilder();
			boolean isFirst = true;
			if (pris != null) {
				String cloumn = pris.getColumnName();
				if (!isFirst) {
					prisSb.append(",");
				} else {
					isFirst = false;
				}
				prisSb.append(cloumn);
			} else {
				prisSb.append("*");
			}
			writer.write(CharUtil.getTab(2) + "SELECT\n");
			writer.write(CharUtil.getTab(3) + "count(" + prisSb.toString() + ")\n");
			writer.write(CharUtil.getTab(2) + "FROM" + "\n");
			writer.write(CharUtil.getTab(3) + table.getTableName().toLowerCase() + "\n");
			writer.write(CharUtil.getTab(2) + "<include refid=\"where\"/>\n");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
