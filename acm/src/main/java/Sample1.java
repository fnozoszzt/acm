public class Sample1 {
    public Sample1(){
        System.out.println("Sample1 is loaderd by: " + this.getClass().getClassLoader());

        new Sample2();
    }
}