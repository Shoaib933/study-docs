package java8;

public class Main {
    void main() {
        System.out.println("Hello");
        Eatable food = () -> {
            System.out.println("Eating Food");
            System.out.println("Eating Food 2");
            return 50;
        };
        Eatable drink = () -> {
            System.out.println("Eating Drink");
            return 100;
        };

        food.eat();
        drink.eat();

        Foody foody = new Foody();
        foody.foodyEat(
                () -> {
                    System.out.println("eating foody...");
                    return 500;
                }

        )
        ;


    }
}
