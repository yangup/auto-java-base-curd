package u.auto.jdbc.mysql;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

import org.apache.commons.lang3.StringUtils;

import u.auto.jdbc.mysql.model.ColumnInfo;
import u.auto.jdbc.mysql.model.Table;
import u.auto.util.CharUtil;
import u.auto.util.Log;

/**
 * <p>
 * jdbc.mysql.Connection.java
 * </p>
 * <p>
 * description：
 * </p>
 * 
 * @author YangPu
 * @createTime 2016年7月19日 上午11:44:13
 */
public class ConnectionSingle {

	private static ConnectionSingle connectionSingle = null;
	Log log = new Log(ConnectionSingle.class.getName());

	private static String url;
	private static String username;
	private static String password;
	private static String database;

	public static ConnectionSingle getSingle() {

		if (connectionSingle == null) {
			synchronized (ConnectionSingle.class) {
				if (connectionSingle == null) {
					connectionSingle = new ConnectionSingle();
				}
			}
		}

		return connectionSingle;
	}

	public void prepare(String... param) {
		this.url = param[0];
		this.username = param[1];
		this.password = param[2];
		this.database = param[3];
	}

	public void start(String... tableName) {

		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection(url + database, username, password);

			Statement st = conn.createStatement();

			StringBuilder tableNames = new StringBuilder(tableName.length * 16);
			for (String s : tableName) {
				tableNames.append("'" + s + "',");
			}

			String tableSql = new String();
			if (tableNames.length() != 0) {
				tableSql = new String(" and c.table_name in (" + tableNames.substring(0, tableNames.length() - 1) + ")");
			}

			String sql = "SELECT c.table_catalog, c.table_schema, c.table_name, c.column_name, c.ordinal_position , c.column_default, "//
					+ "c.is_nullable, c.data_type, c.character_maximum_length, c.character_octet_length , c.numeric_precision, c.numeric_scale, "//
					+ "c.character_set_name, c.collation_name, c.column_type , c.column_key, c.extra, c.PRIVILEGES, c.column_comment, "//
					// + "c.datetime_precision, c.generation_expression,"//
					+ "if(INSTR(t.TABLE_COMMENT, ';') = 0, '', substring_index(t.TABLE_COMMENT, ';', 1)) as TABLE_COMMENT"//
					+ " FROM information_schema.COLUMNS c INNER JOIN information_schema.TABLES t ON c.TABLE_NAME = t.TABLE_NAME"//
					+ " WHERE c.table_schema = '" + database + "'" + "and t.TABLE_SCHEMA = '" + database + "'" + tableSql//
					+ " order by c.table_schema asc, c.table_name asc, c.column_key desc";// 必须按照table_name排序,否则,后面就可能出错了

			log.out("get table infomation from database -start");
			log.out(sql);
			ResultSet rs = st.executeQuery(sql);
			log.out("get table infomation from database -end");
			Set<String> keys = ColumnInfo.FieldSet();
			List<Table> tables = new ArrayList<>();
			Table table = null;
			List<ColumnInfo> list = new ArrayList<>();
			log.out("analyze table data -start");
			// 将查出的数据解析到list中
			while (rs.next()) {
				// 某一列的有关信息
				ColumnInfo columninfo = new ColumnInfo();
				for (String key : keys) {
					String tkey = CharUtil.UppercaseToUnderline(key);
					String value = rs.getString(tkey);
					Field field = columninfo.getClass().getDeclaredField(key);
					field.setAccessible(true);
					field.set((Object) columninfo, value);
				}
				if (list.size() != 0) {
					String tableNameTemp = list.get(list.size() - 1).getTableName();
					// 如果这一列的表名称和上一列的表名称,相同,就意味着是同一个表
					if (!tableNameTemp.equals(columninfo.getTableName())) {
						// 将上一个表的信息整理到table类中
						table = new Table();
						table.setTableName(tableNameTemp);
						table.setColumnInfos(list);
						table.setTableComment(list.get(list.size() - 1).getTableComment());
						prepareTable(table);
						tables.add(table);
						list = new ArrayList<>();
					}
				}
				list.add(columninfo);
			}
			// 处理最后一个list
			if (list.size() != 0) {
				table = new Table();
				table.setTableName(list.get(list.size() - 1).getTableName());
				table.setColumnInfos(list);
				table.setTableComment(list.get(list.size() - 1).getTableComment());
				prepareTable(table);
				tables.add(table);
			}
			log.out("analyze table data -end");
			int length = tables.size();
			for (int i = 0; i < length; i++) {
				table = tables.get(i);
				String nameShow = CharUtil.UnderlineToUppercaseTitle(table.getTableName());
				log.out("generate(" + length + ")" + (i + 1) + " model ..." + nameShow);
				new ModelCreate(table);
				// dao使用的对象
				log.out("generate(" + length + ")" + (i + 1) + " Do ..." + nameShow);
				new DoCreate(table);
				// service使用的对象
				log.out("generate(" + length + ")" + (i + 1) + " Dto ..." + nameShow);
				new DtoCreate(table);
				// controller使用的对象
				log.out("generate(" + length + ")" + (i + 1) + " Vo ..." + nameShow);
				new VoCreate(table);
				log.out("generate(" + length + ")" + (i + 1) + " mapper ..." + nameShow);
				new MapperCreate(table);
				log.out("generate(" + length + ")" + (i + 1) + " dao ..." + nameShow);
				new DaoCreate(table);
				log.out("generate(" + length + ")" + (i + 1) + " service ..." + nameShow);
				new ServiceCreate(table);
				log.out("generate(" + length + ")" + (i + 1) + " controller ..." + nameShow);
				new ControllerCreate(table);
				log.out("generate(" + length + ")" + (i + 1) + " controllerRestful ..." + nameShow);
				new ControllerRestfulCreate(table);
				log.out("generate(" + length + ")" + (i + 1) + " doc ..." + nameShow);
				new DocCreate(table);
				log.out("generate(" + length + ")" + (i + 1) + " modelAnnotation ..." + nameShow);
				new ModelAnnotationCreate(table);
			}
			rs.close();
			st.close();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 整理表数据
	 **/
	public void prepareTable(Table table) {
		if (table == null) {
			return;
		}
		List<ColumnInfo> list = table.getColumnInfos();
		if (list == null) {
			return;
		}
		// 确定每列的数据类型
		for (ColumnInfo columninfo : list) {
			String type = columninfo.getDataType();
			columninfo.setColumnNameJava(CharUtil.UnderlineToUppercase(columninfo.getColumnName()));
			for (int i = 0; i < Constant.fieldType.length; i++) {
				String[] str = Constant.fieldType[i];
				if (Arrays.asList(str).contains(type)) {
					type = Constant.fieldTyepName[i];
					columninfo.setDataTypeJava(type);
					columninfo.setDataTypeIndex(i);
					break;
					// 如果最后没有找到就用默认值
				} else if ((i + 1) == Constant.fieldType.length) {
					type = Constant.fieldTyepName[Constant.fieldTyepName.length - 1];
					columninfo.setDataTypeJava(type);
					columninfo.setDataTypeIndex(i);
					break;
				}
			}
		}
		// 确定主键
		for (ColumnInfo columninfo : list) {
			if (StringUtils.isNotBlank(columninfo.getColumnKey()) && "PRI".equals(columninfo.getColumnKey().toUpperCase())) {
				table.setId(columninfo);
				break;
			}
		}
	}

}
