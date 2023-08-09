import java.io.File;
import java.util.Scanner;
// SID: 2119372 ARU Cambridge 2023 Software principles MOD003484 TRI2 F01CAM live breif 2
public class Main {
    public static void main(String[] args) {
        // old code (hard coded login info
        //IDPasswords idPasswords = new IDPasswords();
        // LoginPage loginPage = new LoginPage(idPasswords.getLoginInfo());
        // create a new login file at launch
        Files.createLoginFile();
        // read the login file into a hashmap
        Files.readFileUse();
        // displays login page
        LoginPage.disiplay();
        // starts the game
        GameLogic.startGame();

    }
}