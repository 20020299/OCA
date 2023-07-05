package Workshop.WS5;

public class IntPhoneNumber extends PhoneNumber{
    private String countryCode;

    public IntPhoneNumber() {
    }

    public IntPhoneNumber(String countryCode, int are, String number) {
        super(are, number);
        this.countryCode = countryCode;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    @Override
    public void display() {
        System.out.println(this.countryCode + " - " + super.getAre() + " - " + super.getNumber());
    }
}
