// SID: 2119372 ARU Cambridge 2023 Software principles MOD003484 TRI2 F01CAM live breif 2
public abstract class Character {

    // setting up the variables for the character class
    public String name;
    public int maxHP;

    public int hp;
    public int xp;

    // setting up the constructor for the character class
    public Character(String name, int maxHP, int xp){
        this.name = name;
        this.maxHP = maxHP;
        this.xp = xp;
        this.hp = maxHP;
    }
    private String resourceName; // name of the resource
    private int quantity; // quantity of the resource
    private String properties; // any unique properties of the resource
    public void resoruces(String name, int quantity, String properties) {
        this.resourceName = name;
        this.quantity = quantity;
        this.properties = properties;
    }
    public abstract int attack();




    public abstract int defend();
}
