public class Car {

    private String name;
    private int speed;
    private int gear;
    private int rpm;


    public void setName(String name) {
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("name cannot be empty");
        }
        this.name = name;
    }

    public String getName() {
        //logic:
        return name;
    }


    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public int getGear() {
        return gear;
    }

    public void setGear(int gear) {
        this.gear = gear;
    }

    public int getRpm() {
        return rpm;
    }

    public void setRpm(int rpm) {
        this.rpm = rpm;
    }

    //
    public void accelerate() {
        speed += 10;
        System.out.println(name + " is accelerating");
    }
}
