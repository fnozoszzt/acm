package classloader;

public class TestClassLoader {
    public static void main(String[] args) throws Exception {


        ClassLoader loader = TestClassLoader.class.getClassLoader();

        System.out.println(loader.toString());

        System.out.println(loader.getParent().toString());

        System.out.println(loader.getParent().getParent());


        new ClassLoader(){

        };

        Class.forName("");

        //
        // Thread.currentThread().getContextClassLoader().loadClass("");


        ClassLoader.getSystemClassLoader();


        System.out.println("0");

        Class<?> c = Test.class;

        System.out.println("1");
        System.out.println(c.getClassLoader());

        System.out.println("2");

        //CustomClassLoader c;

    }


    static class Test {

        static {

            System.out.println("Test class init");
        }

    }
}
