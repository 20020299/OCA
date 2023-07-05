package ManagementProgram;

public class Info {
    private String id;
    private String assetID;
    private String employeeID;
    private int quantity;
    private String dateTime;

    public Info() {
    }

    public Info(String id, String assetID, String employeeID, int quantity, String dateTime) {
        this.id = id;
        this.assetID = assetID;
        this.employeeID = employeeID;
        this.quantity = quantity;
        this.dateTime = dateTime;
    }

    public String getID() {
        return id;
    }

    public void setID(String id) {
        this.id = id;
    }

    public String getAssetID() {
        return assetID;
    }

    public void setAssetID(String assetID) {
        this.assetID = assetID;
    }

    public String getEmployeeID() {
        return employeeID;
    }

    public void setEmployeeID(String employeeID) {
        this.employeeID = employeeID;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getDateTime() {
        return dateTime;
    }

    public void setDateTime(String dateTime) {
        this.dateTime = dateTime;
    }

    public void display() {
        System.out.println(this.id + "\t" + this.assetID + "\t" + this.employeeID + "\t" +
                this.quantity + "\t" + this.dateTime);
    }
}
