import static java.lang.IO.*;

public class Start {

    void test() {

    }

//    void main() {
//        println("Hello");
//        println("Wow its working");
//        System.out.println("hello");
//    }

//    public static void main(String[] args) {
//        System.out.println("hi");
//    }

    void main() {

        // new car

        Car car1 = new Car();
        Car car2 = new Car();

//        car1.name = "BMW123";
//        car2.name = "TATA123"
//        ;

        car1.setName("BMW123");
        car2.setName("TATA123");


        println(car1.getName());
        println(car2.getName());

        car1.accelerate();
        car1.accelerate();
//        println(car1.speed);
//        println(car2.speed);
        car2.accelerate();
        println(car1.getSpeed());
        println(car2.getSpeed());

    }
}
