package u.auto.jdbc.mysql;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import u.auto.jdbc.mysql.model.ColumnInfo;
import u.auto.jdbc.mysql.model.Table;
import u.auto.sys.annotation.Booelan;
import u.auto.sys.annotation.Length;
import u.auto.sys.annotation.Null;
import u.auto.util.CharUtil;
import u.auto.util.ReaderWriter;

/**
 * yangpu.jdbc.mysql.ModelAnnotationCreate.java<br>
 * Description：<br>
 * 
 * @author YangPu
 * @createTime 2016年7月21日 下午3:50:33
 */
public class VoCreate {

	private BufferedWriter writer;
	private List<ColumnInfo> list;

	/**
	 * 加载模板
	 * 
	 * @param modelName
	 */
	public VoCreate(Table table) {
		try {
			this.list = table.getColumnInfos();
			// model的名称
			String modelName = CharUtil.UnderlineToUppercaseTitle(table.getTableName());
			// 文件路径
			String fileName = null;
			if (Constant.isTable) {
				fileName = Constant.path + modelName + File.separator + modelName + "Vo.java";
			} else {
				fileName = Constant.path + Constant.package_vo + File.separator + modelName + "Vo.java";
			}
			File file = new File(fileName);
			// 创建父文件
			if (!file.getParentFile().exists()) {
				file.getParentFile().mkdir();
			}
			// 创建文件
			if (!file.exists()) {
				file.createNewFile();
			}
			// 获得写入字符流
			writer = new BufferedWriter(new FileWriter(file));
			// 获得模板读出流
			BufferedReader reader = new BufferedReader(new FileReader(Constant.vo));
			// 将模板和表信息写入到temp文件中,并返回temp文件的读出流
			reader = ReaderWriter.readWrite(reader, table);
			String line = reader.readLine();
			while (line != null) {
				if (line.contains("-startField-")) {
					createField();
				} else {
					writer.write(line + "\n");
				}
				line = reader.readLine();
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

	private void createField() {
		try {
			for (int i = 0; i < list.size(); i++) {
				ColumnInfo columninfo = list.get(i);
				// 注释部分
				writer.write("\t/* " + columninfo.getColumnComment() + " */\n");
				// 注解部分
				switch (columninfo.getDataTypeIndex()) {
					case 0 :
						// Boolean
						writer.write("\t" + Booelan.TRUE.ch(columninfo.getColumnComment()) + "\n");
						break;
					case 1 :
						// Integer
						break;
					case 5 :
						// String
						writer.write("\t" + Null.NOTEMPTY.ch(columninfo.getColumnComment()) + "\n");
						writer.write("\t" + Length.LENGTH.ch(0, columninfo.getCharacterMaximumLength(), columninfo.getColumnComment()) + "\n");
						break;
					case 6 :
						// Timestamp
						break;

					default :
						break;
				}
				// 代码部分
				writer.write("\t" + "private " + columninfo.getDataTypeJava() + " " + columninfo.getColumnNameJava() + ";" + "\n");
			}
			writer.write("\n");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
