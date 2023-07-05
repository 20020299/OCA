package VehicleManagement;

public class Car extends Vehicle {
    private String type;
    private int year;

    public Car(String id, String name, String color, double price, String brand, String type, int year) {
        super(id, name, color, price, brand);
        this.type = type;
        this.year = year;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    @Override
    public void display() {
        super.display();
        System.out.println("Type: " + this.type);
        System.out.println("Year of manufacture: " + this.year);
    }


}
