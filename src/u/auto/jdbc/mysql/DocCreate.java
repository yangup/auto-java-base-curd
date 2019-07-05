package u.auto.jdbc.mysql;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;

import com.alibaba.fastjson.JSON;

import u.auto.jdbc.mysql.model.ColumnInfo;
import u.auto.jdbc.mysql.model.Table;
import u.auto.util.CharUtil;
import u.auto.util.ReaderWriter;

/**
 * <p>
 * yangpu.jdbc.mysql.DocCreate.java
 * </p>
 * <p>
 * description：
 * </p>
 * 
 * @author YangPu
 * @createTime 2016年7月21日 下午3:50:33
 */
public class DocCreate {

	private BufferedWriter writer;

	private List<ColumnInfo> list;

	/**
	 * 加载模板
	 * 
	 * @param modelName
	 */
	public DocCreate(Table table) {
		try {
			this.list = table.getColumnInfos();
			String modelName = CharUtil.UnderlineToUppercaseTitle(table.getTableName());
			String fileName = null;
			if (Constant.isTable) {
				fileName = Constant.path + modelName + File.separator + modelName + "doc.txt";
			} else {
				fileName = Constant.path + Constant.package_doc + File.separator + modelName + "doc.txt";
			}
			File file = new File(fileName);
			if (!file.getParentFile().exists()) {
				file.getParentFile().mkdir();
			}
			if (!file.exists()) {
				file.createNewFile();
			}
			writer = new BufferedWriter(new FileWriter(file));
			// 读取模板数据
			BufferedReader reader = new BufferedReader(new FileReader(Constant.doc));
			reader = ReaderWriter.readWrite(reader, table);
			String line = null;
			while ((line = reader.readLine()) != null) {
				if (line.contains("-modelJson-")) {
					createJson();
				} else if (line.contains("-columnNote-")) {
					createColumnNote();
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
	 * 创建json数据
	 **/
	private void createJson() {
		try {
			Map<String, String> map = new HashMap<>();
			String str = null;
			for (int i = 0; i < list.size(); i++) {
				ColumnInfo columninfo = list.get(i);
				map.put(CharUtil.UnderlineToUppercase(columninfo.getColumnName()), columninfo.getColumnComment());
				str = JSON.toJSONString(map);
			}
			writer.write(CharUtil.formatJson(str));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * 创建列的说明数据
	 **/
	private void createColumnNote() {
		try {
			StringBuilder sb = null;
			// 每一行，都不变的
			String h = CharUtil.h;
			String a = CharUtil.getWhitespace(2);
			String ah = a + h;
			// 要变的
			String isNull = "否";
			String max = "";
			for (int i = 0; i < list.size(); i++) {
				isNull = "否";
				max = "";
				ColumnInfo c = list.get(i);
				sb = new StringBuilder();
				// |参数名 |参数描述 |是否必填 |类型 |最大长度(整数,小数) |说明
				// |id |权限id |是 |Integer | |1 | | |权限id
				if ("NO".equals(c.getIsNullable())) {
					isNull = "是";
					max = "";
				}
				sb.append(h);
				sb.append(c.getColumnNameJava());// 参数名
				sb.append(ah);
				sb.append(c.getColumnComment());// 参数描述
				sb.append(ah);
				sb.append(isNull);// 是否必选
				sb.append(ah);
				sb.append(c.getDataTypeJava());// 类型
				// 最大长度(整数.小数)
				// String
				if (c.getDataTypeIndex() == 5 || c.getDataTypeIndex() == 10) {
					max = c.getCharacterMaximumLength();
				}
				// Integer
				if (c.getDataTypeIndex() == 1) {
					max = c.getNumericPrecision() + CharUtil.d + "0";
				}
				// Double
				if (c.getDataTypeIndex() == 4) {
					// 小数部分为空
					if (StringUtils.isEmpty(c.getNumericScale())) {
						max = c.getNumericPrecision();
					} else {
						// 有小数部分
						max = c.getNumericPrecision() + CharUtil.d + c.getNumericScale();
					}
				}
				// 其他情况
				if (StringUtils.isEmpty(max)) {
					if (StringUtils.isNotEmpty(c.getCharacterMaximumLength())) {
						max = c.getCharacterMaximumLength();
					} else if (StringUtils.isEmpty(c.getNumericScale())) {
						max = c.getNumericPrecision();
					} else {
						// 有小数部分
						max = CharUtil.c(c.getNumericPrecision()) + CharUtil.d + c.getNumericScale();
					}
				}
				sb.append(ah);
				sb.append(CharUtil.c(max));
				sb.append(ah);
				sb.append(CharUtil.getWhitespace(2) + h);// 说明
				if (i == (list.size() - 1)) {
					sb.append(CharUtil.getWhitespace(2) + h);
				}
				sb.append(CharUtil.n);
				writer.write(sb.toString());
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
