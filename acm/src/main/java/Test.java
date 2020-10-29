public class Test {
    public static void main(String[] args) throws Exception{
        CustomClassLoader loader = new CustomClassLoader("loader");
        loader.setPath("/Users/fnozoszzt/class/");

        Class<?> clazz = loader.loadClass("Sample1");

        Object object = clazz.newInstance();
    }
}