// SID: 2119372 ARU Cambridge 2023 Software principles MOD003484 TRI2 F01CAM live breif 2
import java.io.*;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;

public class FilesORG {
    static Scanner input = new Scanner(System.in);
    static HashMap<String, String> usersAndPasswords;
    public static final String filePath = "/Users/lucalazzeri/Desktop/ARU/Year Two/MOD003484 - Software Principles /InteligentCraft/InteligentCraft2/src/ExternalFiles/";


    public static void readFile() {

        try {
            BufferedReader readData = new BufferedReader(new FileReader(filePath + "login.txt"));

            FileWriter writer = new FileWriter(filePath + "login.tx");

            String line;
            String[] div;
            String date;

            while ((line = readData.readLine()) != null) {
                div = line.split(",", 2);
                if (div.length >= 2) {
                    date = div[0];
                    String password = div[1];
                    writer.append(usersAndPasswords.put(date,password));

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






        // BroCode read + output file


        try {

            FileReader reader = new FileReader(filePath + "login.txt");
            int data = reader.read();


            while (data != -1) {
                System.out.print((char) data);
                data = reader.read();

            }

            reader.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();

        } catch (IOException e) {
            e.printStackTrace();

        }


    }

    public static void writeFile(String userID, String password) {


        try {
            FileWriter writer = new FileWriter(filePath + "words.txt");
            writer.append(userID);
            writer.append(",");
            writer.append(password + "\n");

            writer.close();

            System.out.println("Account creation complete");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void createLoginFile() {
        try {
            File loginInfo = new File(filePath + "Login.txt");


            if (loginInfo.createNewFile()) {
                GameLogic.printSeparator(20);
                System.out.println("New Login file has been made.");
                GameLogic.printSeparator(20);

            } else {
                GameLogic.printSeparator(20);
                System.out.println("\nFile already exits\n");
                GameLogic.printSeparator(20);
            }
        } catch (IOException e) {
            GameLogic.printSeparator(20);
            System.out.println("File creation unsuccessful");
            GameLogic.printSeparator(20);
            e.printStackTrace();
        }
    }

    public static void addNewUserTOFile() {
        BufferedWriter entry = null;

        try {
            entry = new BufferedWriter(new FileWriter("Login.txt"));

            Scanner input = new Scanner(System.in);
            System.out.println("Please enter your name");
            String name = input.next().toLowerCase();
            System.out.println("Please enter your password");
            String password = input.next();
            String email = (name + "@LazzeriMail.co.uk");
            Iterator var5 = usersAndPasswords.entrySet().iterator();


            usersAndPasswords.put(email, password);

            entry.flush();                                                              //Original line: 147
        } catch (IOException trace) {
            trace.printStackTrace();
        } finally {
            try {
                entry.close();

            } catch (Exception fileError) {
                System.out.println("Error Closing file");
            }
        }
    }

    static {
        input = new Scanner(System.in);
        usersAndPasswords = new HashMap();
    }
}

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

