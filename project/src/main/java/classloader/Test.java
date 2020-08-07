package classloader;

import org.codehaus.plexus.classworlds.ClassWorld;
import org.codehaus.plexus.classworlds.realm.ClassRealm;

import java.net.URL;

public class Test {
    public static void main(String[] args) throws Exception {


        ClassWorld world = new ClassWorld();
        ClassRealm containerRealm    = world.newRealm( "container" );
        containerRealm    = world.newRealm( "container" );
        ClassRealm logComponentRealm = world.newRealm( "logComponent" );

        System.out.println(Test.class.getClassLoader().getResource(""));


        containerRealm.addURL( new URL("containerJarUrl") );
        logComponentRealm.addURL( new URL("logComponentJarUrl") );



        logComponentRealm.importFrom( "container",
                "com.werken.projectz.component" );


        Class containerClass = containerRealm.loadClass( "CONTAINER_CLASSNAME" );
        //MyContainer container = (MyContainer) containerClass.newInstance();
        //Thread.currentThread().setContextClassLoader( containerRealm.getClassLoader() );
        //container.run();


    }
}
