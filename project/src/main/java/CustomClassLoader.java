import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

public class CustomClassLoader extends ClassLoader{

    private String classLoaderName;

    //类的扩展名
    private final String fileExtension = ".class";

    private  String path;

    public void setPath(String path){
        this.path = path;
    }

    public CustomClassLoader(String classLoaderName){
        //使用方法getSystemClassLoader（）返回的ClassLoader作为父类加载器创建新的类加载器
        super();
        this.classLoaderName = classLoaderName;
    }

    public CustomClassLoader(String classLoaderName, ClassLoader parent){
        //使用指定的父类加载器创建新的类加载器以进行委派
        super(parent);
        this.classLoaderName = classLoaderName;
    }


    @Override
    protected Class<?> findClass(String className) throws ClassNotFoundException{
        System.out.println("findClass invoked: " + className);
        System.out.println("class loader name: " + this.classLoaderName);
        byte[] data = this.loadClassDate(className);
        return this.defineClass(className, data, 0, data.length);
    }

    private byte[] loadClassDate(String name){
        InputStream is = null;
        byte[] data = null;
        ByteArrayOutputStream baos = null;

        try{
            //转换为磁盘对应的地址
            name = name.replace(".", "/");
            is = new FileInputStream(new File(this.path+ name + this.fileExtension));
            baos = new ByteArrayOutputStream();

            int ch = 0;
            while((ch = is.read()) != -1){
                baos.write(ch);
            }
            data = baos.toByteArray();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            try{
                is.close();
                baos.close();
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        return data;
    }

    public static void main(String[] args) throws Exception {
        CustomClassLoader loader1 = new CustomClassLoader("loader1");
        loader1.setPath("/home/cc/test/");
        Class<?> clazz = loader1.loadClass("indi.greenhat.jvm.Test");
        Object object = clazz.newInstance();
    }
}