package ManagementProgram;

public class Asset {
    private String name;
    private String assetId;
    private String color;
    private double price;
    private double weight;
    private int quantity;

    public Asset(String assetId, String name, String color, double price, double weight, int quantity) {
        this.name = name;
        this.assetId = assetId;
        this.color = color;
        this.price = price;
        this.weight = weight;
        this.quantity = quantity;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAssetId() {
        return assetId;
    }

    public void setAssetId(String assetId) {
        this.assetId = assetId;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void display() {
        System.out.println(this.assetId + "\t" + this.name + "\t" + this.color + "\t" +
                this.price + "\t" + this.weight + "\t" + this.quantity);
    }
}
