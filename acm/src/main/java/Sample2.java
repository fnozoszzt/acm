public class Sample2 {
    public Sample2(){
        System.out.println("Sample2 is loaderd by: " + this.getClass().getClassLoader());
        System.out.println("Sample2 output Sample1.class:");
        System.out.println(Sample1.class);
    }
}