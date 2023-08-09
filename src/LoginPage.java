// SID: 2119372 ARU Cambridge 2023 Software principles MOD003484 TRI2 F01CAM live breif 2
import java.util.Scanner;

//  old GUI based Login Page
/*
public class LoginPage implements ActionListener {

    JFrame frame = new JFrame();
    JButton loginButton = new JButton("Login: ");
    JButton resetButton = new JButton("Reset: ");
    JButton signUpButton = new JButton("Sign up: ");
    JButton createAccountButton = new JButton("Create Account");
    JTextField userIDField = new JTextField();
    JPasswordField userPasswordField = new JPasswordField();
    JLabel userIDLabel = new JLabel("userID: ");
    JLabel userPasswordLabel = new JLabel("Password: ");
    JLabel messageLabel = new JLabel("");


    HashMap<String,String> logininfo = new HashMap<String,String>();

    LoginPage(HashMap<String,String> loginInfoOriginal){

        logininfo = loginInfoOriginal;

        userIDLabel.setBounds(50,100,75,15);
        userPasswordLabel.setBounds(50,150,75,15);

        messageLabel.setBounds(125,250,250,35);
        messageLabel.setFont(new Font(null,Font.ITALIC,25));

        userIDField.setBounds(125,100,200,25);
        userPasswordField.setBounds(125,150,200,25);

        loginButton.setBounds(125,200,100,25);
        loginButton.setFocusable(false);
        loginButton.addActionListener(this);

        signUpButton.setBounds(155,300,100,25);
        signUpButton.setFocusable(false);
        signUpButton.addActionListener(this);

        resetButton.setBounds(225,200,100,25);
        resetButton.setFocusable(false);
        resetButton.addActionListener(this);


        frame.add(userIDLabel);
        frame.add(userPasswordLabel);
        frame.add(messageLabel);
        frame.add(userIDField);
        frame.add(userPasswordField);
        frame.add(loginButton);
        frame.add(resetButton);
        frame.add(signUpButton);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(420,420);
        frame.setLayout(null);
        frame.setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {

         if(e.getSource()==resetButton){
             userIDField.setText("");
             userPasswordField.setText("");
         }

         if(e.getSource()==loginButton){

             String userID = userIDField.getText();
             String password = String.valueOf(userPasswordField.getPassword());

             if(logininfo.containsKey(userID)){
                 if(logininfo.get(userID).equals(password)){
                     messageLabel.setForeground(Color.green);
                     messageLabel.setText("Login Successful");
                     frame.dispose();
                     Welcome welcome = new Welcome(userID);

                 }
                 else{
                     messageLabel.setForeground(Color.red);
                     messageLabel.setText("password incorect");

                 }
             }

             else{
                 messageLabel.setForeground(Color.red);
                 messageLabel.setText("Username not found");
             }
         }

         if(e.getSource()==signUpButton){
             Files.addNewUserTOFile();
             JFrame signUpfFrame = new JFrame();

             signUpfFrame.setSize(420,420);
             signUpfFrame.setLayout(null);
             signUpfFrame.setVisible(true);
             signUpfFrame.add(userIDLabel);
             signUpfFrame.add(userPasswordLabel);
             signUpfFrame.add(userIDField);
             signUpfFrame.add(userPasswordField);
             signUpfFrame.add(userIDField);
             signUpfFrame.add(userPasswordField);
             signUpfFrame.add(createAccountButton);


             createAccountButton.setBounds(155,200,150,25);
             createAccountButton.setFocusable(false);
             createAccountButton.addActionListener(this);




         }

    }
}
*/

public class LoginPage{
    // a boolean to check if the login was successful
    private static boolean loginSuccessful = false;

    // a function to check if the login was successful
    public static boolean isLoginSuccessful(){
        return loginSuccessful;
    }


    private static String enteredUsername;
    // a function to get the username entered by the user
    public static String getEnteredUsername(){
        return enteredUsername;
    }

    // a function to display the login page
    public static void disiplay(){
        Scanner scanner = new Scanner(System.in);

        // asks user if they already have an account
        GameLogic.printSeparator(20);

        GameLogic.readInt("Do you have an account? \n (1) Yes\n (2) No" , 2);
        // System.out.println("Do you have an account? \n (1) Yes\n (2) No");
        GameLogic.printSeparator(20);
        GameLogic.printBlank(10);

        do{
            // if the user has an account it asks for their USERID and PASSWORD
            if (GameLogic.input == 1){
                System.out.println("UserID: ");
                // converts the input to lower case
                enteredUsername = scanner.next().toLowerCase();
                System.out.println("Password: ");
                String enteredPassword = scanner.next().toLowerCase();
                GameLogic.printHeading("loading...");

                // checks hashmap to see if the user exists and if the password is correct
                if (Files.usersAndPasswords.containsKey(enteredUsername)){
                    // if password is correct it sets loginSuccessful to true and exits the loop
                    if (Files.usersAndPasswords.get(enteredUsername).equals(enteredPassword)){
                        System.out.println("Login successful...");
                        GameLogic.pressToContinue();
                        loginSuccessful = true;
                        GameLogic.loginRunning = false;



                    }
                    else {
                        // if password is incorrect it asks the user if they want to try again
                        scanner.nextLine();
                        System.out.println("Incorrect password");
                        GameLogic.pressToContinue();
                        GameLogic.readInt("do you want to try again? \n (1) Yes \n (2) No", 2);
                        // System.out.println("do you want to try again? \n (1) Yes \n (2) No");
                        if (scanner.nextInt() != 1){
                            System.exit(0);
                        }


                    }
                }
                // if username and password are both incorrect it asks the user if they want to try again
                else {
                    scanner.next();
                    System.out.println("Incorrect login");
                    GameLogic.pressToContinue();System.out.println("do you want to try again? \n (1) Yes \n (2) No");
                    if (scanner.nextInt() != 1){
                        System.exit(0);
                    }
                }
            }
            // if the user does not have an account it asks them if they want to create one
            else if (GameLogic.input == 2){
                Files.addNewUserTOFile();
                disiplay();


            }
             else {
                 System.out.println("Invaild input");
            }


        }while(!loginSuccessful);









    }

    // old code
/*
    public static void loginPage(){
        Scanner scanner = new Scanner(System.in);

        String enteredUsername;

            GameLogic.printSeperator(20);
            System.out.println("Do you have an account? \n (1) Yes\n (2) No");
            GameLogic.printSeperator(20);
        boolean loginSuccessful = false;
        int userInput = scanner.nextInt();

            do{
                switch (userInput) {
                    case 1: {

                        Files.readFileUse("words.txt");

                        GameLogic.printSeperator(20);
                        System.out.println("UserID: ");
                        enteredUsername = Files.input.next();
                        System.out.println("Password: ");
                        GameLogic.printSeperator(20);
                        String enteredPassword = Files.input.next();

                        if (Files.usersAndPasswords.containsKey(enteredUsername)) {
                            if (((String)Files.usersAndPasswords.get(enteredUsername)).equals(enteredPassword)) {
                                GameLogic.printSeperator(20);
                                System.out.println("Login successful...");
                                loginSuccessful = true;


                            }


                        } else {
                            GameLogic.clearConsole();
                            System.out.println("Incorrect login");
                        }

                        break;

                    }

                    case 2: {

                        /*
                        GameLogic.clearConsole();
                        GameLogic.printSeperator(20);
                        System.out.println("Choose your UserID: ");
                        String userID = scanner.next();
                        userID.toLowerCase();
                        System.out.println("Choose your Password: ");
                        String password = scanner.next();
                        password.toLowerCase();
                        GameLogic.printSeperator(20);

                        Files.writeFile(userID, password);

                        GameLogic.clearConsole();
                        System.out.println("Your UserID: " + userID);
                        System.out.println("Your Password: " + password);

                        userInput = scanner.nextInt();
                        --
                        Files.addNewUserTOFile();
                        break;

                    }

                    default: {
                        System.out.println("Please press 1 or 2");
                        userInput = scanner.nextInt();

                        break;
                    }
                }

            }while(!loginSuccessful);



}
*/

}