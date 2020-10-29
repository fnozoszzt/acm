package calcite;

import org.apache.calcite.config.Lex;
import org.apache.calcite.sql.SqlNode;
import org.apache.calcite.sql.parser.SqlParser;
import org.apache.calcite.sql.validate.SqlConformanceEnum;

public class Test {
    public static void main(String[] args) throws Exception {
        //String sql = "select * from a";
        //String sql = "select id, cast(score as int), 'hello' from T where id < ?";
        //String sql = "select a, b, c from t_1 join t_2";
        //String sql = "insert into table_1 (a, s, d) values (1, 3, 2)";
        String sql = "select a from (insert into table_1 (a, s, d) values (1, 3, 2))";

        SqlParser.Config config = SqlParser.configBuilder()
                .setLex(Lex.valueOf("MYSQL"))
                .setConformance(SqlConformanceEnum.valueOf("MYSQL_5"))
                .build();

        SqlNode sqlNode = SqlParser.create(sql, config).parseStmt();

        System.out.println(sqlNode);




        System.out.println();
    }
}
