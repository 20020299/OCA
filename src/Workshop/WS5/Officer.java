package Workshop.WS5;

import java.security.PublicKey;

public class Officer extends Person {
    private double bSalary;

    public Officer() {
    }

    public Officer(String name, double bSalary) {
        super(name);
        this.bSalary = bSalary;
    }

    @Override
    public void display() {
        System.out.println(super.getName() + "\t" + getSalary());
    }

    @Override
    public double getSalary() {
        return this.bSalary;
    }
}
