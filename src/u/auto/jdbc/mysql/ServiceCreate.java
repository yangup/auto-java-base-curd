package u.auto.jdbc.mysql;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

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
public class ServiceCreate {
	/**
	 * 加载模板
	 * 
	 * @param modelName
	 */
	public ServiceCreate(Table table) {
		try {
			String modelName = CharUtil.UnderlineToUppercaseTitle(table.getTableName());
			String fileName = null;
			if (Constant.isTable) {
				fileName = Constant.path + modelName + File.separator + modelName + "Ser.java";
			} else {
				fileName = Constant.path + Constant.package_ser + File.separator + modelName + "Ser.java";
			}
			File file = new File(fileName);
			if (!file.getParentFile().exists()) {
				file.getParentFile().mkdir();
			}
			if (!file.exists()) {
				file.createNewFile();
			}
			BufferedWriter writer = new BufferedWriter(new FileWriter(file));
			BufferedReader reader = new BufferedReader(new FileReader(Constant.ser));
			reader = ReaderWriter.readWrite(reader, table);
			String line = null;
			while ((line = reader.readLine()) != null) {
				writer.write(line + "\n");
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

}
