import kafka.javaapi.producer.Producer;
import kafka.producer.KeyedMessage;
import kafka.producer.ProducerConfig;

import java.io.Closeable;
import java.io.IOException;
import java.util.*;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.function.Function;
import java.util.function.ObjIntConsumer;
import java.util.function.Supplier;
import java.util.stream.Collectors;

import com.google.common.collect.Lists;


public class a {
    synchronized void f1() throws Exception {
        System.out.println("f1");
        Thread.sleep(10000);
        System.out.println("f1");
    }

    synchronized void f2() throws Exception {
        System.out.println("f2");
        Thread.sleep(10000);
        System.out.println("f2");
    }

    public static void main(String[] aaaa) throws Exception {
        /*Properties tempProperties = new Properties();
        Producer<String, String> producer;



        tempProperties.put("metadata.broker.list", "datastream36.lt.163.org:9092");
        tempProperties.put("key.serializer.class", "kafka.serializer.StringEncoder");
        tempProperties.put("value.serializer.class", "kafka.serializer.StringEncoder");
        tempProperties.put("serializer.class", "kafka.serializer.StringEncoder");
        tempProperties.put("request.required.acks", "-1");
        tempProperties.put("request.timeout.ms", "5000");
        tempProperties.put("message.send.max.retries", "3");
        tempProperties.put("producer.type", "sync");
        tempProperties.put("topic.metadata.refresh.interval.ms", "60000");


        ProducerConfig producerConfig = new ProducerConfig(tempProperties);
        producer = new Producer<>(producerConfig);




        //List<KeyedMessage<String, Object>> keyedMessageList = Lists.newArrayListWithCapacity(pairs.size());
        //for (Pair<String, Object> pair : pairs) {
        List<KeyedMessage<String, String>> keyedMessageList = Lists.newArrayListWithCapacity(100);


        for (int i = 0; i < 100; i++) {
            KeyedMessage<String, String> keyedMessage = new KeyedMessage<>("test_08_kafka", null, String.valueOf(i));
            keyedMessageList.add(keyedMessage);
        }
        producer.send(keyedMessageList);


        Thread.sleep(100000);


        for (int i = 0; i < 100; i++) {
            KeyedMessage<String, String> keyedMessage = new KeyedMessage<>("test_08_kafka", null, String.valueOf(i));
            keyedMessageList.add(keyedMessage);
        }
        producer.send(keyedMessageList);*/


        /*ArrayList<Object> a1 = new ArrayList<>();
        ArrayList<Object> a2 = new ArrayList<>();
        a1.add(a2);
        a2.add(a1);

        System.out.println(a1);*/

        /*a aa = new a();
        new Thread(() -> {
            try {
                aa.f1();
            } catch (Exception e) {

            }
        }).start();


        new Thread(() -> {
            try {
                aa.f2();
            } catch (Exception e) {

            }
        }).start();*/


        //Object o = new Object();
        /*WeakHashMap<Object, Object> weakHashMap = new WeakHashMap<>();

        for (int i = 0; i < 1000; i++) {
            weakHashMap.put(new Integer(i), new Object());
        }

        while (true) {

            Thread.sleep(1000);
            System.out.println(weakHashMap);
            System.out.println(weakHashMap.get(0));
            System.out.println(weakHashMap.get(100));

            int[] a = new int[10000000];

            System.out.println(Runtime.getRuntime().freeMemory());
        }*/


        /*a aa = new a();
        synchronized (aa) {
            synchronized (aa) {
                aa.wait(1);
            }
        }*/
        Class<?> c = "a".getClass();
        System.out.println(c);




        Base base = new a().new Sub();
        base.print("hello");

//        // 不转型
//        Sub sub = new a().new Sub();
//        sub.print("hello");


        Spiciness a = Spiciness.FLAMING;
        System.out.println(a.toString());
        Spiciness.values();

        //new a().new Test2();

        System.out.println(new a().hashCode());

        //new Spiciness().toString();

        testFinal t = new a().new testFinal();

        Vector vector;


        System.out.println(test1.b);
        System.out.println(test2.b);

        new a().new Base().work();


        new Random(47)
                .ints(5, 20)
                .distinct()
                .limit(7)
                .sorted()
                .forEach(System.out::println);
        //Optionals o;

        ClassLoader.getSystemClassLoader().
                setDefaultAssertionStatus(true);


        Class<Boolean> TYPE = Boolean.TYPE;

        finalclass f = new finalclass();

    }


    class Test implements AutoCloseable {
        public void close() throws IOException {
            System.out.println("close");
            throw new IOException();
        }
    }



    // 基类
    class Base {
        void print(String... args) {
            System.out.println("Base......test");
        }

        private void test() {
            System.out.println("test");
        }

        void work() {
            Base sub = new Sub();
            sub.test();
        }
    }

    // 子类，覆写父类方法
    class Sub extends Base {
        @Override
        void print(String[] args) {
            System.out.println("Sub......test");
        }

        private void test() {
            System.out.println("test2");
        }
    }

    class Test2 {
        //Test2 t = new Test2();
        Test2() {

        }
    }


    enum Spiciness {
        NOT, MILD, MEDIUM, HOT, FLAMING
    }

    class aa {
        void work() {

        }
    }

    class bb extends aa {
        @Override
        public void work() {

        }
    }

    class testFinal {
        final int a;

        void print() {
            System.out.println(a);
        }
        testFinal() {
            print();
            a = 1;
        }

    }

    final class finalClass {
        void a() {

        }
    }

    static class test1 {
        static int a = 1;
        static int b = test2.a;
    }

    static class test2 {
        static int a = 2;
        static int b = test1.a;
    }


    static class FunctionComposition {
        static Function<String, String>
                f1 = s -> {
            System.out.println(s);
            return s.replace('A', '_');
        },
                f2 = s -> s.substring(3),
                f3 = String::toLowerCase,
                f4 = f1.compose(f2).andThen(f3);
        public static void main(String[] args) {
            System.out.println(
                    f4.apply("GO AFTER ALL AMBULANCES"));


            Function<String, Function<String, String>> sum = a -> b -> a + b;
            sum = new Function<String, Function<String, String>>() {
                @Override
                public Function<String, String> apply(String a) {

                    return b -> a + b;
                }
            };



            //Function<Function<String, String>, String> test = a -> b -> a + b;


        }
    }



    class generic<A extends Object> {
        A[] a;

        generic() {
            //a = new A[1];

        }

    }

    static final class finalclass {

    }

    //class finalClass2 extends finalClass {}

}
