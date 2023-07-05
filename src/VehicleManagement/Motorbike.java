package VehicleManagement;

public class Motorbike extends Vehicle {
    private double speed;
    private boolean license;

    public Motorbike(String id, String name, String color, double price, String brand, double speed, boolean license) {
        super(id, name, color, price, brand);
        this.speed = speed;
        this.license = license;
    }

    public double getSpeed() {
        return speed;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }

    public boolean isLicense() {
        return license;
    }

    public void setLicense(boolean license) {
        this.license = license;
    }

    @Override
    public void display() {
        super.display();
        System.out.println("Speed: " + this.speed);
        System.out.println("Require license: " + this.license);
    }

    public void makeSound() {
        System.out.println("Tin tin tin");
    }
}
