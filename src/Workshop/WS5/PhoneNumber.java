package Workshop.WS5;

public class PhoneNumber {
    private int area;
    private String number;

    public PhoneNumber() {
    }

    public PhoneNumber(int area, String number) {
        this.area = area;
        this.number = number;
    }

    public int getAre() {
        return area;
    }

    public void setAre(int area) {
        this.area = area;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public void display() {
        System.out.println(this.area + " - " + this.number);
    }
}
