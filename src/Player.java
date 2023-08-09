// SID: 2119372 ARU Cambridge 2023 Software principles MOD003484 TRI2 F01CAM live breif 2
public class Player extends Character {

    // player stats
    public int numAtkUpgrades, numDefUpgrades;

    int gold;
    int restsLeft;
    int pots;
    int parts;

    public String[] atkUpgrade = {"Strength", "power", "Might", "Godlike Strength"};
    public String[] defUpgrades = {"Heavy bonus", "Stone Skin", "Scale armor", "Holy aurora"};

    // constructor to set default values
    public Player(String name) {
        super(name, 100, 0);
        this.numAtkUpgrades = 0;
        this.numDefUpgrades = 0;

        this.gold = 5;
        this.restsLeft = 1;
        this.pots = 0;

        chooseTrait();
    }

    // getters and setters for attack and defense


    public int attack() {

        return (int)(Math.random()*(xp/4 + numAtkUpgrades*3 +3) + xp/10 + numAtkUpgrades*2 + numDefUpgrades + 1);
    }

    public int defend(){

        return (int)(Math.random()*(xp/4 + numDefUpgrades*3 +3) + xp/10 + numDefUpgrades*2 + numAtkUpgrades + 1);
    }

    // choose a trait
    public void chooseTrait(){
        GameLogic.clearConsole();
        GameLogic.printHeading("Choose a trait");
        System.out.println("(1)" + atkUpgrade[numAtkUpgrades]);
        System.out.println("(2) " + defUpgrades[numDefUpgrades]);

        int input = GameLogic.readInt("--> ",2);

        boolean running = true;
        do {
            switch(input){
                case 1:{
                    // print the trait chosen
                    GameLogic.printHeading("You chose " + atkUpgrade[numAtkUpgrades]);
                    numAtkUpgrades++;
                    running = false;
                }
                case 2:{
                    // print the trait chosen
                    GameLogic.printHeading("You chose " + defUpgrades[numDefUpgrades]);
                    numDefUpgrades++;
                    running = false;
                }
                default:{
                    System.out.println("choose either 1 or 2");
                }


            }

        } while(running);

    }
}
