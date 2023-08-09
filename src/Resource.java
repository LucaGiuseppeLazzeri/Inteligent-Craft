// SID: 2119372 ARU Cambridge 2023 Software principles MOD003484 TRI2 F01CAM live breif 2
public class Resource {
    private String name; // name of the resource
    private int quantity; // quantity of the resource
    private String properties; // any unique properties of the resource

    // Constructor to create a new Resource object
    public Resource(String name, int quantity, String properties) {
        this.name = name;
        this.quantity = quantity;
        this.properties = properties;
    }

    // Getter method for the name field
    public String getName() {
        return name;
    }

    // Setter method for the name field
    public void setName(String name) {
        this.name = name;
    }

    // Getter method for the quantity field
    public int getQuantity() {
        return quantity;
    }

    // Setter method for the quantity field
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    // Getter method for the properties field
    public String getProperties() {
        return properties;
    }

    // Setter method for the properties field
    public void setProperties(String properties) {
        this.properties = properties;
    }
}
