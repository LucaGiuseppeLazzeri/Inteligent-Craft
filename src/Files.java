// SID: 2119372 ARU Cambridge 2023 Software principles MOD003484 TRI2 F01CAM live breif 2
import java.io.*;
import java.util.HashMap;
import java.util.Scanner;

public class Files {
    static Scanner input = new Scanner(System.in);
    static HashMap<String, String> usersAndPasswords;
    // file path for the login file. This will need to be changed to the correct path on your computer
    public static final String filePath = "./ExternalFiles";


    // a new read file function that uses a hashmap to store the data
    public static void readFileUse() {
        try {
            BufferedReader readData = new BufferedReader(new FileReader(filePath+"Login.txt"));

            String line;
            String[] divider;
            String date;
            // separate the data into a hashmap with the username as the key and the password as the value
            while((line = readData.readLine()) != null) {
                divider = line.split(",", 2);
                if (divider.length >= 2) {
                    date = divider[0];
                    String password = divider[1];
                    usersAndPasswords.put(date, password);

                } else {
                    System.out.println("Invalid entry" + line);
                }
            }

            readData.close();

        } catch (FileNotFoundException var8) {
            System.out.println("File does not exist");
        } catch (IOException var9) {
            System.out.println("Could not read line ");
        }

    }

    // a read file function to read char by char
    public static void readFiles2(){
        try {
            FileReader fileReader = new FileReader("/Users/lucalazzeri/Desktop/ARU/Year Two/MOD003484 - Software Principles /InteligentCraft/InteligentCraft2/src/ExternalFiles");

            System.out.println("Reading char by char : \n");
            int i;
            while ((i = fileReader.read()) != -1) {

                // exchanges , for a space
                if(i == ','){
                    System.out.print(" ");
                }
                else{
                    System.out.print((char)i);
                }
            }


            fileReader.close();
            System.out.println("FileReader closed!");
        }
        catch (Exception e) {
            System.out.println(e + "<---- Exception error ");
        }
    }

    // an old write file function
    public static void writeFile(String fileName, String userID, String item){


        try {
            FileWriter writer = new FileWriter(filePath + fileName, true);
            writer.append(userID);
            writer.append(",");
            writer.append(item);
            writer.close();

            System.out.println("Account creation complete");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // function to create a new login file

    public static void createLoginFile() {
        try {
            File loginInfo = new File(filePath + "Login.txt");


            if (loginInfo.createNewFile()) {
                // if the file is created successfully then print a message
                GameLogic.printSeparator(20);
                System.out.println("New Login file has been made.");
                GameLogic.printSeparator(20);

            } else {
                // if the file already exists then print a message
                GameLogic.printSeparator(20);
                System.out.println("\nFile already exits\n");
                GameLogic.printSeparator(20);
            }
        } catch (IOException e) {
            GameLogic.printSeparator(20);
            // if the file cannot be created then print a message
            System.out.println("File creation unsuccessful");
            GameLogic.printSeparator(20);
            e.printStackTrace();
        }
    }

    static {
        input = new Scanner(System.in);
        usersAndPasswords = new HashMap();
    }

    // a function to add a new user to the login file
    public static void addNewUserTOFile() {
        BufferedWriter entry = null;

        try {

          //  entry = new BufferedWriter(new FileWriter("Login.txt"));
            FileWriter writer = new FileWriter(filePath + "login.txt", true);
            Scanner input = new Scanner(System.in);

            // ask the user for their username and password and store them in a hashmap with the username as the key and the password as the value
            System.out.println("Please enter your name");
            String name = input.next().toLowerCase();
            System.out.println("Please enter your password");
            String password = input.next().toLowerCase();

            System.out.println(name + password);

            usersAndPasswords.put(name, password);

            writer.append(name);
            writer.append(",");
            writer.append(password);
            writer.append("\n");

           // writer.flush();
            writer.close();

        } catch (IOException trace) {
            trace.printStackTrace();
        }finally {
            try {


            } catch (Exception fileError) {
                // although the file is has shown an error it is still created and information is still stored in it
                System.out.println("Account creation 'successful'...");
                GameLogic.printHeading("Please restart the game to login");

            }
        }

    }


}
// A whole lotta old code
// just ignore this. Failed experiment i might come back to


            /*                                                                     // Original line 128
            while(var5.hasNext()) {
                Map.Entry<String, String> line = (Map.Entry)var5.next();
                String var10001 = (String)line.getKey();
                entry.write(var10001 + "," + (String)line.getValue());
                entry.newLine();
            System.out.println("Your login email is: "+email+"\nplease go log in with the chosen password");



            for (Map.Entry<String, String> line : usersAndPasswords.entrySet())
            {
                entry.write(line.getKey() + "," + line.getValue());

                entry.newLine();

            }


            entry.flush();                                                              //Original line: 147
        }catch (IOException trace){
            trace.printStackTrace();
        }finally {
            try{
                entry.close();

            }catch (Exception fileError){
                System.out.println("Error Closing file");
            }
        }

    }

    static {
        input = new Scanner(System.in);
        usersAndPasswords = new HashMap();
    }

}
*/
// old read file function
    /*
    public static void readFiles(){
        try{
            BufferedReader readData = new BufferedReader(new FileReader(filePath + "login.txt"));
            String line;
            String[] div;
            String userID;

            while ((line = readData.readLine()) != null) {
                div = line.split(",", 2);
                if (div.length >= 2) {
                    userID = div[0];
                    String password = div[1];
                    usersAndPasswords.put(userID,password);
                } else {
                    System.out.println("pattern up you gave an incorrect combination" + line);
                }
            }

            readData.close();
        } catch (FileNotFoundException var8) {
            System.out.println("File does not exit");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

     */
    /*
  THE FOLLOWING CODE HAS BEEN MOVED TO GAMELOGIC AS ACCESSING CORRECT VALUES FROM PLAYER CLASS NOT WORKING
    public static void saveGame(){
        try{
            GameLogic.characterInfo();

            FileWriter writer = new FileWriter(filePath + "save_"+ LoginPage.enteredUsername +"_.txt",true);
            writer.write(LoginPage.enteredUsername+",");
            writer.write(Player.playerHP());
            writer.write(",");
            writer.write(Player.playerXP());
            writer.close();
            GameLogic.printHeading("Character Info Saved");
            GameLogic.pressToContinue();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
*/


