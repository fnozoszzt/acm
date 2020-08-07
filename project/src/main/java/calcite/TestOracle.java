package calcite;

import org.apache.calcite.config.Lex;
import org.apache.calcite.sql.SqlDialect;
import org.apache.calcite.sql.SqlNode;
import org.apache.calcite.sql.dialect.MysqlSqlDialect;
import org.apache.calcite.sql.dialect.OracleSqlDialect;
import org.apache.calcite.sql.parser.SqlParser;
import org.apache.calcite.sql.pretty.SqlPrettyWriter;
import org.apache.calcite.sql.util.SqlBuilder;
import org.apache.calcite.sql.validate.SqlConformanceEnum;

public class TestOracle {
    public static void main(String[] args) throws Exception {
        //String sql = "select * from a";
        //String sql = "select id, cast(score as int), 'hello' from T where id < ?";
        String sql = "select \n" +
                "a, b, c as d \n" +
                "from t_1 \n" +
                "limit 10 \n";
        //String sql = "insert into table_1 (a, s, d) values (1, 3, 2)";
        //String sql = "select a from (insert into table_1 (a, s, d) values (1, 3, 2))";

        SqlParser.Config config = SqlParser.configBuilder()
                .setLex(Lex.ORACLE)
                .setConformance(SqlConformanceEnum.ORACLE_10)
                .build();

        SqlNode sqlNode = SqlParser.create(sql, config).parseQuery(sql);

        System.out.println(sqlNode);
        System.out.println(sqlNode.getClass());

        System.out.println(sqlNode.toString());

        SqlPrettyWriter writer = new SqlPrettyWriter(MysqlSqlDialect.DEFAULT);
        writer.setSelectListItemsOnSeparateLines(true);
        writer.setIndentation(0);
        writer.setQuoteAllIdentifiers(false);
        sqlNode.unparse(writer, 0, 0);
        System.out.println(writer.toString());



        System.out.println(sqlNode.toSqlString(SqlDialect.CALCITE, false).getSql());

    }
}
