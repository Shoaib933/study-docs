import java.util.Properties;

class Test {

    public static void printSystemProperties() {
        System.out.println("Print System Properties Using JAVA......");
        Properties props = System.getProperties();
        System.out.println(props);
    }

    public static void main(String[] args) {
        System.out.println("Java Program Started .........");
        printSystemProperties();
    }
}