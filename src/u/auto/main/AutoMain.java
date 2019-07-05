package u.auto.main;

import u.auto.jdbc.mysql.ConnectionSingle;
import u.auto.jdbc.mysql.Constant;

public class AutoMain {

    public static void main(String[] args) {
        // C:\Users\wantw\Desktop\auto
        Constant.path = "C:\\Users\\wantw\\Desktop\\auto\\";
        Constant.isTable = Boolean.FALSE;
        // Constant.isTable = Boolean.TRUE;
        // Constant.isConstructor = Boolean.FALSE;
        ConnectionSingle connection = ConnectionSingle.getSingle();
        connection.prepare(new String[]{"jdbc:mysql://192.168.1.214:3306/", "root", "root", "ogmsdb"});
        // connection.start("sys_authorities");
        // connection.start("house_release");
        // project_info
        connection.start("newer_yield");
//		AutoMain.class.getAnnotations();
        // connection.start("member_info");
        // connection.start();
    }

}
