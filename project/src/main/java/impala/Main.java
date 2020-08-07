package impala;

import java.sql.*;

public class Main {
    private static String JDBC_DRIVER = "com.cloudera.impala.jdbc41.Driver";
    private static String CONNECTION_URL ="jdbc:hive2://hadoop334.photo.163.org:2181,hadoop335.photo.163.org:2181,hadoop336.photo.163.org:2181/;serviceDiscoveryMode=zooKeeper;zooKeeperNamespace=impala-ha/hiveserver2;principal=impala/_HOST@TEST.HZ.NETEASE.COM";

    static {
        try {
            Class.forName(JDBC_DRIVER);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws Exception {
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
