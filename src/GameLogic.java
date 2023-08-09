// SID: 2119372 ARU Cambridge 2023 Software principles MOD003484 TRI2 F01CAM live breif 2
import java.io.*;
import java.util.Arrays;
import java.util.Scanner;



public class GameLogic {
    // variables used to check if the game is running
    public static boolean loginRunning;
    public static boolean isRunning;
   // public static boolean quitGame;
    static Scanner scanner = new Scanner(System.in);

    // variables used to check if the game is saved
    public static boolean saveGameCheck = false;
    public static int place = 0, act = 1;

    // array of acts and locations a player can go to
    public static String[] acts = {"Act 1", "Act 2", "Act 3", "Act 4"};
    public static String[] places = {"MouseMountains", "Minecraft", "The White House", "Space X"};

    public static Player player;

   //public static Player player = new Player("");

    // array of encounters and enemies

    public static String[] encounters = {"Battle,", "Battle,", "Rest,","Rest"};
    public static String[] enemies = {"Horses, ", "Herobrine, ", "Joe Biden, ","Elon Musk, "};
    // public static String[] parts = {"Wood, ", "Iron, ", "Gold, "," Fuel"};

   // public static String[] enemies = new String[4];
   // public static String[] encounters = new String[4];

    // read int from user input
    public static int input;
    // function used to read input from user
    public static int readInt (String prompt, int userChoices){
        do {
            System.out.println(prompt);
            try {
                input = Integer.parseInt(scanner.next());
            }
            catch (Exception e){
                input = -1;
                System.out.println("Please enter an Integer");
            }
        }while (input < 1|| input > userChoices);
        return input;
    }

    // function to clear console
    public static void clearConsole(){
        for(int i = 0; i < 100; i++){
            System.out.println();
        }
    }
    // function to print separator
    public static void printSeparator(int n){
        for(int i = 0; i < n; i++){
            System.out.print("-");
        }
        System.out.println();
    }
    // function to print blank lines (like clear console but not the same)
    public static void printBlank(int n) {
        for (int i = 0; i < n; i++){
            System.out.println();
        }
    }
    // function to print heading
    public static void printHeading(String title){
        printSeparator(30);
        System.out.println(title);
        printSeparator(30);
    }

    // function to pause game
    public static void pressToContinue(){
        System.out.println("press key + enter to continue");
        scanner.next();
    }

    // function to start game
    public static void startGame(){

        String name;

        clearConsole();
        printSeparator(40);
        printSeparator(30);
        System.out.println("Intelligent craft");
        printSeparator(30);
        printSeparator(40);
        pressToContinue();

        boolean nameSet = false;
        // boolean loadSave = false;

        do{
            clearConsole();
            printHeading("Is this your name " + LoginPage.getEnteredUsername() + "?");
            name = LoginPage.getEnteredUsername();
            System.out.println("Is this your name? \n (1) Yes \n (2) No");
            if (readInt("->", 2) == 1){
                nameSet = true;
            } else if (readInt("->", 2) == 2) {
                System.out.println("Please enter your name");
                name = scanner.next();
                nameSet = true;

            } else{
                System.out.println("Please enter a valid option");
                break;
            }
        }while(!nameSet);



        player = new Player(name);
        Story.printFirstActIntro();
        gameLoop();

/*
        if(LoginPage.loginSuccessful == true) {
            Story.printIntro();
            gameLoop();
        }
*/
    }

    // a function to print out information about the character
    public static void characterInfo(){
        clearConsole();
        printHeading("CHARACTER INFO");
        System.out.println(player.name + "\nHP: " + player.hp + "/" + player.maxHP);
        printSeparator(20);
        System.out.println("XP: "+ player.xp + "\tGold: " + player.gold);
        printSeparator(20);
        System.out.println("# of pots" + player.pots);
        System.out.println("place: "+ places[place]+ acts[act]);
        System.out.println("Parts: "+ player.parts + "You need more parts to win");

        if(player.numAtkUpgrades > 0 ){
            System.out.println("Offensive trait: "+ player.atkUpgrade[player.numAtkUpgrades]);
            printSeparator(20);
        }
        if(player.numDefUpgrades > 0){
            System.out.println("Defensive trait: "+ player.defUpgrades[player.numDefUpgrades]);
        }
        pressToContinue();

        if (!saveGameCheck){
            gameLoop();
        }
    }

    // function to check the act the okayer is currently playing
    public static void checkAct(){
        if(player.xp >= 10 && act == 1) {
            act = 2;
            place++;

            Story.printFirstActOutro();
            player.chooseTrait();
            Story.printSecondActIntro();
            enemies[0] = "Horses";
            enemies[1] = "Herobrine";
            enemies[2] = "Joe Biden";
            enemies[3] = "Elon Musk";

            encounters[0] = "Battle";
            encounters[1] = "Battle";
            encounters[2] = "Rest";
            encounters[3] = "Rest";

            player.hp = player.maxHP;
        }
        else if(player.xp >= 50 && act == 2){
            act = 3;
            place++ ;

            Story.printSecondActOutro();
            player.chooseTrait();

            enemies[0] = "Horses";
            enemies[1] = "Herobrine";
            enemies[2] = "Joe Biden";
            enemies[3] = "Elon Musk";

            encounters[0] = "Battle";
            encounters[1] = "Battle";
            encounters[2] = "Rest";
            encounters[3] = "Rest";

            player.hp = player.maxHP;

            Story.printThirdActIntro();
        } else if (player.xp >= 100 && act == 3) {
            act = 4;
            place++;
            Story.printThirdActOutro();
            player.chooseTrait();
            Story.printFourthActIntro();
            place++;
            finalBattle();
        }

    }

    public static void randomEncounter(){
        int random = (int)(Math.random()*encounters.length);
        if(encounters[random].equals("Battle")){
            randomBattle();
        }
        else if(encounters[random].equals("Rest")){
            takeRest();
        }
        else {
            shop();
        }
    }
    // function to continue the journey
    public static void continueJourney(){
        checkAct();
        if(act!=4){
            randomBattle();
            gameLoop();
        }
        else{
            finalBattle();
        }

    }

    // function to print out the menu for the shop
    public static void shop(){
    clearConsole();
    printHeading("SHOP");
    // maths to set out the price of the parts
    int price = (int) (Math.random()*(10+player.pots*3)+10 + player.pots);
    System.out.println("You have " + player.gold + " gold");
    System.out.println("parts costs " + price + " gold");
    System.out.println("Do you want to buy a part? \n (1) Yes \n (2) No");
    if(readInt("->", 2) == 1){
        if(player.gold >= price){
            player.gold -= price;
            player.parts++;
            System.out.println("You bought a part");
            pressToContinue();
        }
        else{
            System.out.println("You don't have enough gold");
            pressToContinue();
        }
    }
    else{
        System.out.println("You didn't buy a potion");
        pressToContinue();
    }
    gameLoop();
    }

    // function to allow the player to restore their HP
    public static void takeRest(){
        clearConsole();
        printHeading("REST");
        System.out.println("You take a rest");
        System.out.println("You are full of health");
        player.hp = player.maxHP;

        pressToContinue();
    }
    // function to create a battle with an enemy
    public static void randomBattle(){
        clearConsole();
        printHeading("Random Encounter");
        pressToContinue();
        battle(new Enemy(enemies[(int)(Math.random()*enemies.length)], player.xp));
    }
    public static void battle(Enemy enemy){
        while(true){
            clearConsole();
            printHeading(enemy.name + " HP: " + enemy.hp + "/" + enemy.maxHP);
            printHeading(player.name + " HP: " + player.hp + "/" + player.maxHP);
            System.out.println("Choose action: ");
            printSeparator(20);
            System.out.println("(1) Attack\n (2) Use potion\n (3) Run");
            input = readInt("->", 3);

            if (input == 1) {
                int dmg = player.attack() - enemy.defend();
                int dmgTook = enemy.attack() - player.defend();
                if (dmgTook < 0) {
                    dmg -= dmgTook/2;
                    dmgTook = 0;
                }
                if (dmg < 0) {
                    dmg = 0;

                }
                player.hp -= dmgTook;
                enemy.hp -= dmg;
                System.out.println("You did " + dmg + " damage to " + enemy.name);
                printSeparator(15);
                System.out.println(enemy.name + " did " + dmgTook + " damage to you");
                pressToContinue();
                if (player.hp <= 0) {
                    playerDied();
                    break;
                }
                else if (enemy.hp <= 0) {
                    clearConsole();
                    player.xp += enemy.xp;
                    System.out.println("You defeated " + enemy.name + " and gained " + enemy.xp + " xp");

                    boolean addRest = (Math.random()*5 + 1 <= 2.25);
                    int goldEarned = (int)(Math.random()*enemy.xp + 1);

                    if(addRest){
                        System.out.println("You found a rest spot and gained 10 hp");
                        player.hp += 10;
                        if(player.hp > player.maxHP){
                            player.hp = player.maxHP;
                        }
                    }

                    if(goldEarned > 0){
                        System.out.println("You found " + goldEarned + " gold");
                        player.gold += goldEarned;
                    }

                    pressToContinue();
                    break;
                }

            }else if (input == 2) {
                clearConsole();
                System.out.println("Do you want to use a potion? (1) Yes /(2) No");
                int input = readInt("->", 2);
                if (input == 1) {
                    if (player.pots > 0 && player.hp < player.maxHP) {
                        player.hp += 10;
                        if (player.hp > player.maxHP) {
                            player.hp = player.maxHP;
                        }
                        player.pots--;
                        System.out.println("You used a potion and healed 10 hp");
                        pressToContinue();

                    } else if (player.pots > 0 && player.hp == player.maxHP) {
                        System.out.println("You are already at full health");
                        pressToContinue();
                    }
                }
                /*
                if(player.numPotions > 0){
                    player.hp += 10;
                    if(player.hp > player.maxHP){
                        player.hp = player.maxHP;
                    }
                    player.numPotions--;
                    System.out.println("You used a potion and healed 10 hp");
                    pressToContinue();
                }


                else {
                    System.out.println("You don't have any potions");
                    pressToContinue();
                }
            }
             */

            }else{
                    clearConsole();

                    if (act != 4){
                        if (Math.random() * 10 + 1 <= 3.5) {
                            printHeading("You ran away");
                        }else{
                            printHeading("You failed to run away");
                            int dmgTook = enemy.attack();
                            if (dmgTook < 0) {
                                dmgTook = 0;
                            }
                            player.hp -= dmgTook;
                            System.out.println(enemy.name + " did " + dmgTook + " damage to you");
                            pressToContinue();
                            if (player.hp <= 0) {
                                playerDied();
                                break;
                            }
                    }
                    }else {
                        System.out.println("You can't run away from the final battle");
                        pressToContinue();
                    }


            }
        }
    }

    // a list of action that a user can preform
    public static void printMenu(){
        clearConsole();
        System.out.println(places[place] + places[place] + player.xp);
        System.out.println("Choose action: ");
        printSeparator(20);
        System.out.println("(1) continue on your journey");
        System.out.println("(2) Character Info");
        System.out.println("(3) Shop");
        System.out.println("(4) Load Game");
        System.out.println("(5) Save Game");
        System.out.println("(6) Exit Game");
    }

    public static void finalBattle(){
        clearConsole();
        printHeading("Final Battle");
        System.out.println("You have reached the final boss");
        randomBattle();
        if(player.parts > 5){
            System.out.println("You have all the parts needed to defeat the final boss and exit the the world");
            randomBattle();
            gameLoop();

        }
        Story.printEnd(player);
        isRunning = false;


    }

    public static void playerDied(){
        clearConsole();
        printHeading("You died");
        System.out.println("You earned " + player.xp + " with " + player.xp + " xp");
        System.out.println("Thanks for playing, noob");
        isRunning = false;
    }

    public static void gameLoop(){
        printMenu();

        int input = readInt("->",6);
        if (input == 1){
            continueJourney();
        } else if (input == 2) {
            characterInfo();
        }else if(input == 3){
            shop();
        } else if (input == 4 ){
            loadGame3();
        } else if(input == 5){
             int input3 = readInt(" Are you sure you want to save?\n This will overwrite the exsiting save (1) Yes / (2) No", 2);
            if (input3 == 1){
                saveGame();

            } else if(input3 == 2){
                gameLoop();
            } else{
                System.out.println("Invalid input");
            }


            saveGame();
            gameLoop();
        } else if (input == 6) {
            int input2 = readInt("Are you sure you want to exit? (1) Yes / (2) No", 2);
            if (input2 == 1) {
                System.out.println("Thank you for playing");
                System.out.println("Exiting game...");
                System.exit(0);
            }
            else if(input2 == 2){
                gameLoop();
            }else{
                System.out.println("Invalid input");
            }
        }
    }

    public static void saveGame(){
        try{
            saveGameCheck = true;

            System.out.println("Saving game...");
            FileWriter writer = new FileWriter(Files.filePath + "save_"+ LoginPage.getEnteredUsername() +"_.txt",false);
            System.out.println("File Exisits");
            writer.write("\n" + player.name + ",");

            System.out.println("Name saved");
            for (int i : new int[]{player.hp, player.xp, player.gold,player.pots,place,act,player.parts}) {
                writer.write(i + ",");
            }


            writer.close();
            printHeading("Character Info Saved");
            GameLogic.pressToContinue();
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Error saving file");
        }

    }
    // first attempt at loading a save

    public static void loadGame(){
        try{
            System.out.println("Loading game...");
            File file = new File(Files.filePath + "save_"+ LoginPage.getEnteredUsername() +"_.txt");
            Scanner scanner = new Scanner(file);
            String[] data = scanner.nextLine().split(",");

          //  Player player = new Player("");
          //  player.name = data[0];
            player.hp = Integer.parseInt(data[0]);
            player.xp = Integer.parseInt(data[1]);
            player.gold = Integer.parseInt(data[2]);
            player.pots = Integer.parseInt(data[3]);
        //    place = Integer.parseInt(data[4]);
          //  act = Integer.parseInt(data[5]);

            System.out.println("Game loaded");
            printHeading("Game Loaded");
            GameLogic.pressToContinue();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.out.println("Error loading file");
        }
    }
    // second attempt at loading a save
    public static void loadGame2(){
        String[] data = scanner.next().split(",");
        if(data.length <= 5){ // make sure there are at least 7 elements in the array
            //Player player = new player("");
           // player.name = data[0];
            int a = Integer.parseInt(data[0]);
            int b = Integer.parseInt(data[1]);
            int c = Integer.parseInt(data[2]);
            int d = Integer.parseInt(data[3]);
            int e = Integer.parseInt(data[4]);
            int f = Integer.parseInt(data[5]);
            System.out.println(a + b+ c + d + e + f);
            System.out.println("Game loaded");
            printHeading("Game Loaded");
            pressToContinue();
            gameLoop();
        } else {
            System.out.println("Error loading file: data array length is less than 7");
            pressToContinue();
        }

    }

    // third attempt at loading a save (this one works)

    public static void loadGame3(){


        try{
            // creating a buffered reader to read infomation from the file
            new BufferedReader(new FileReader(Files.filePath + "save_" + LoginPage.getEnteredUsername() + "_.txt"));
            System.out.println("Loading game...");
            File file = new File(Files.filePath + "save_"+ LoginPage.getEnteredUsername() +"_.txt");
            Scanner scanner = new Scanner(file);
            // splitting the data into an array
            String[] data = scanner.next().split(",");

            // storing the data into variables
            String tempString = data[0];
            player.name = tempString;
            // parsing the data into integers stored in temp variable
            int tempInt = Integer.parseInt(data[1]);
            // assigning the temp variable to the corresponding player variable
            player.hp = tempInt;
            tempInt = Integer.parseInt(data[2]);
            player.xp = tempInt;
            tempInt = Integer.parseInt(data[3]);
            player.gold = tempInt;
            tempInt = Integer.parseInt(data[4]);
            player.pots = tempInt;
            tempInt = Integer.parseInt(data[5]);
            place = tempInt;
            tempInt = Integer.parseInt(data[6]);
            act = tempInt;

            System.out.println("Data loaded");


            printHeading("Game Loaded");


            pressToContinue();
            gameLoop();

        }catch (IOException e){
            e.printStackTrace();
            System.out.println("No save data found");
            pressToContinue();
            gameLoop();
        }
    }


}



