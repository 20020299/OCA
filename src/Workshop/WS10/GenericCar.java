package Workshop.WS10;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class GenericCar<T> {
    private List<T> a = new ArrayList<>();

    public GenericCar(List<T> a) {
        this.a = a;
    }

    public List<T> getA() {
        return a;
    }

    public void setA(List<T> a) {
        this.a = a;
    }

    public void add(T car) {
        this.a.add(car);
    }

    public void display() {
        for (T car : a) {
            System.out.println(car.toString());
        }
    }

    public int getSize() {
        return a.size();
    }

    public boolean checkEmpty() {
        return a.isEmpty();
    }

    public void delete(int pos) {
        a.remove(pos);
    }
}
