package exercicio3.carro;

public class Car {
    private boolean on;
    private int speed;
    private int gear;
    private String steeringWheel;

    public Car() {
        this.on = false;
        this.speed = 0;
        this.gear = 0;
        this.steeringWheel = "Frente";
    }

    // Getters
    public boolean isOn() {
        return on;
    }

    public int getSpeed() {
        return speed;
    }

    public int getGear() {
        return gear;
    }

    public String getSteeringWheel() {
        return steeringWheel;
    }

    protected void setOn(boolean on) {
        this.on = on;
    }

    protected void setSpeed(int speed) {
        this.speed = speed;
    }

    protected void setGear(int gear) {
        this.gear = gear;
    }

    protected void setSteeringWheel(String steeringWheel) {
        this.steeringWheel = steeringWheel;
    }
}