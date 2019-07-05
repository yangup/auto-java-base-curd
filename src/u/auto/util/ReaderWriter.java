package u.auto.util;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

import u.auto.jdbc.mysql.Constant;
import u.auto.jdbc.mysql.model.ColumnInfo;
import u.auto.jdbc.mysql.model.Table;
import u.auto.sys.order.Order;

public class ReaderWriter {

	/**
	 * <p>
	 * description： 将模板文件读入temp文件<br>
	 * 返回读取temp文件的reader<br>
	 * </p>
	 *
	 * @param reader
	 * @param list
	 * @param tableName<br>
	 * @author YangPu
	 * @createTime 2016年7月27日 上午9:50:18
	 */
	public static BufferedReader readWrite(BufferedReader reader, Table table) {
		BufferedReader result = null;
		try {
			File file = new File(Constant.temp);
			if (!file.getParentFile().exists()) {
				file.getParentFile().mkdir();
			}
			if (!file.exists()) {
				file.createNewFile();
			}
			BufferedWriter writer = new BufferedWriter(new FileWriter(file));
			// 表名称--将下划线+小写转化为大写,首字母大写
			String modelName = CharUtil.UnderlineToUppercaseTitle(table.getTableName());
			// 表名称--将下划线+小写转化为大写
			String modelNameParam = CharUtil.UnderlineToUppercase(table.getTableName());
			// 表的注释
			String modelComment = table.getTableComment();
			String line = null;
			ColumnInfo id = table.getId();
			while ((line = reader.readLine()) != null) {
				// 表的注释
				line = Order.change(line, Order.modelComment, modelComment);
				// house_side_info -> housesideinfo
				// 表名称->全部小写
				line = Order.change(line, Order.modelLower, modelNameParam.toLowerCase());
				// house_side_info -> HouseSideInfo
				// 表名称-> 将下划线+小写转化为大写,首字母大写
				line = Order.change(line, Order.modelName, modelName);
				// house_side_info -> houseSideInfo
				// 将下划线+小写转化为大写
				line = Order.change(line, Order.modelNameParam, modelNameParam);
				line = Order.user(line);
				line = Order.date(line);
				line = Order.dateYMDHM(line);
				// 处理id相关的
				if (id != null) {
					// 有id
					// id的类型
					// 例如：String
					line = Order.change(line, Order.modelNameIdType, id.getDataTypeJava());
					// id..house_side_info -> houseSideInfo
					// 将下划线+小写转化为大写
					line = Order.change(line, Order.modelNameId, CharUtil.UnderlineToUppercase(id.getColumnName()));
					// id..house_side_info -> HouseSideInfo
					// 将下划线+小写转化为大写,首字母大写
					line = Order.change(line, Order.modelNameIdTitle, CharUtil.UnderlineToUppercaseTitle(id.getColumnName()));
				}
				writer.write(line + "\n");
			}
			writer.close();
			reader.close();
			result = new BufferedReader(new FileReader(file));

		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

}
