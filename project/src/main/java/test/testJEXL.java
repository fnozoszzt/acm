package test;

import org.apache.commons.jexl2.Expression;
import org.apache.commons.jexl2.JexlContext;
import org.apache.commons.jexl2.JexlEngine;
import org.apache.commons.jexl2.MapContext;
import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;


public class testJEXL {

    public static void main(String[]  aaaa) throws Exception {


//        JexlContext jc = new MapContext();
//        jc.set("x", 10);
//        jc.set("y", 20);
//        Expression e = new JexlEngine().createExpression("x - y");
//        Object result = e.evaluate(jc);
//        System.out.println(result.getClass());
//        System.out.println(result);

//        java.text.SimpleDateFormat a = java.text.SimpleDateFormat.getInstance();

        //java.lang.reflect.Proxy p;

        JexlContext jc = new MapContext();
        Expression e;
        Object result;

        /*e = new JexlEngine().createExpression("a = new('java.text.SimpleDateFormat')");
        result = e.evaluate(jc);
        System.out.println(result);

        e = new JexlEngine().createExpression("a.applyPatternImpl(\"YYYY\")");
        result = e.evaluate(jc);
        System.out.println(result);

        e = new JexlEngine().createExpression("$(a)");
        result = e.evaluate(jc);
        //System.out.println(result.getClass());
        System.out.println(result);*/





        DateTime dt = new DateTime();
        DateTimeFormatter fmt = DateTimeFormat.forPattern("d MMMM, yyyy");
        String str = dt.toString(fmt);


        System.out.println(str);

        System.out.println(dt.toString("YYYY-MM-dd SSS"));
    }
}
