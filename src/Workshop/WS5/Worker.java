package Workshop.WS5;

public class Worker extends Person {
    private double hrs;
    private final double RATE = 5.5;

    public Worker() {
    }

    public Worker(String name, double hrs) {
        super(name);
        this.hrs = hrs;
    }

    public double getHrs() {
        return hrs;
    }

    public void setHrs(double hrs) {
        this.hrs = hrs;
    }

    @Override
    public void display() {
        System.out.println(super.getName() + "\t" + getSalary());
    }

    @Override
    public double getSalary() {
        return this.hrs * this.RATE;
    }
}
