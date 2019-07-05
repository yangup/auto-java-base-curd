package u.auto.util;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Log {

	private String pre;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Log log = new Log(Log.class.getName());
		log.out("122");
	}

	public Log(String pre) {
		this.pre = pre;

	}

	public void out(String str) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Timestamp time = new Timestamp(new Date().getTime());
		System.out.println(sdf.format(time) + " " + pre + ": " + str);
	}

}
