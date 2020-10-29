package oracle;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Main {
    public static void main(String[] args) throws Exception {
        Connection connect = null;
        Statement statement = null;
        ResultSet resultSet = null;



        Class.forName("oracle.jdbc.OracleDriver");

        connect = DriverManager.getConnection("jdbc:oracle:thin:@10.196.96.66:1521:orcl", "scott", "1");


        statement = connect.createStatement();



        resultSet = statement.executeQuery("select  * from TABLE_NAME");

        while (resultSet.next())
        {
            int id = resultSet.getInt("id");
            System.out.println(id);
        }

    }
}
