
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.security.UserGroupInformation;

import java.security.PrivilegedAction;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Main {
    private static String JDBC_DRIVER = "com.cloudera.impala.jdbc41.Driver";
    private static String CONNECTION_URL ="jdbc:hive2://hadoop334.photo.163.org:2181,hadoop335.photo.163.org:2181,hadoop336.photo.163.org:2181/;" +
            "serviceDiscoveryMode=zooKeeper;zooKeeperNamespace=impala-ha/hiveserver2;principal=impala/_HOST@TEST.HZ.NETEASE.COM"
    +             ";hive.server2.proxy.user=intern";

    public static void main(String[] args) throws Exception {
        Class.forName(JDBC_DRIVER);
        Class.forName("org.apache.hive.jdbc.HiveDriver");


        System.setProperty("java.security.krb5.conf", "/etc/krb5.conf");
        Configuration configuration = new Configuration();
        configuration.set("hadoop.security.authentication" , "Kerberos");
        UserGroupInformation. setConfiguration(configuration);
        UserGroupInformation.loginUserFromKeytab("mammut/dev@TEST.HZ.NETEASE.COM", "/Users/fnozoszzt/code/acm/impala/mammut.keytab");



        UserGroupInformation loginUser = UserGroupInformation.getLoginUser();


        Connection[] connection = new Connection[1];
        ResultSet rs;
        PreparedStatement ps;



        for (int i = 0; i < 10; i++) {
            long start = System.currentTimeMillis();
            loginUser.doAs((PrivilegedAction<Object>) () -> {

                try {

                    connection[0] = DriverManager.getConnection(CONNECTION_URL);

                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    // JDBCUtils.disconnect(connection, rs, ps);
                }
                return null;
            });


            ps = connection[0].prepareStatement("select * from intern_new.xuxuerui_test_table");
            rs = ps.executeQuery();
            while (rs.next()) {
                System.out.println(rs.getInt(1) + "-------" + rs.getString(2));
            }
            long end = System.currentTimeMillis();
            System.out.println(end - start);

        }






//        Connection connection = null;
//        ResultSet rs = null;
//        PreparedStatement ps = null;
//        connection = DriverManager.getConnection(CONNECTION_URL);
//        ps = connection.prepareStatement("select * from xuxuerui_test_table");
//        rs = ps.executeQuery();
//        while (rs.next()) {
//            System.out.println(rs.getInt(1) + "-------" + rs.getString(2));
//        }

    }
}
