
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Main {
    private static String JDBC_DRIVER = "com.cloudera.impala.jdbc41.Driver";
    private static String CONNECTION_URL ="jdbc:hive2://hadoop334.photo.163.org:2181,hadoop335.photo.163.org:2181,hadoop336.photo.163.org:2181/;serviceDiscoveryMode=zooKeeper;zooKeeperNamespace=impala-ha/hiveserver2;principal=impala/_HOST@TEST.HZ.NETEASE.COM";


    public static void main(String[] args) throws Exception {
        Class.forName(JDBC_DRIVER);



        Connection connection = null;
        ResultSet rs = null;
        PreparedStatement ps = null;
        connection = DriverManager.getConnection(CONNECTION_URL);
        ps = connection.prepareStatement("select * from xuxuerui_test_table");
        rs = ps.executeQuery();
        while (rs.next()) {
            System.out.println(rs.getInt(1) + "-------" + rs.getString(2));
        }

    }
}
