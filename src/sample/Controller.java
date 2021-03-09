package sample;

import com.sun.prism.Image;
import database.SQLiteDatabase;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import user.Account;
import user.vouchers;

import java.util.concurrent.ThreadLocalRandom;


public class Controller {

    @FXML
    private Label points;
    @FXML
    private Label points2;
    @FXML
    private Button updatePassword;
    @FXML
    private PasswordField ChangePasswordField;
    @FXML
    private Label points3;
    @FXML
    private Button showOffers;
    @FXML
    private Button homeButton;
    @FXML
    private Button accountButton;
    @FXML
    private Button rewardsButton;
    @FXML
    private AnchorPane rewardsPage;
    @FXML
    private AnchorPane homePage;
    @FXML
    private AnchorPane accountPage;
    @FXML
    private Label FNlabel;
    @FXML
    private Label SNLabel;
    @FXML
    private Label EMLabel;
    @FXML
    private Label UNLabel;
    @FXML
    private Label AccountTypeLabel;
    @FXML
    private Button loginMain;
    @FXML
    private Button FootLocker;
    @FXML
    private AnchorPane signInPage;
    @FXML
    private TextField userNameField;
    @FXML
    private PasswordField passwordField;
    @FXML
    private Label loginLabel;
    @FXML
    private Button login;
    @FXML
    private Button signUp;
    @FXML
    private Button Premium_Member;
    @FXML
    private AnchorPane registerPage;
    @FXML
    private TextField createUsername;
    @FXML
    private Button createAccount;
    @FXML
    private PasswordField createPassword;
    @FXML
    private TextField email;
    @FXML
    private TextField firstName;
    @FXML
    private TextField secondName;
    @FXML
    private Button closeRegister;
    @FXML
    private Button closeSignIn;
    @FXML
    private Label loginLabel1;
    @FXML
    private Button usernameButton;
    @FXML
    private AnchorPane usernameHider;
    @FXML
    private AnchorPane accountHider;
    @FXML
    private Button loginOffers;
    @FXML
    private Label subTitle;
    @FXML
    private Label loginTextPrompt;
    @FXML
    private Button logout ;
    @FXML
    private Label usernameLabel;
    @FXML
    private Label usernameLabel2;
    @FXML
    private Button DeleteAccount;
    @FXML
    private AnchorPane loginPopup;
    @FXML
    private TextField deleteUsername;
    @FXML
    private TextField deletePassword;
    @FXML
    private Button confirmDelete;
    @FXML
    private Label loginLabel2;
    @FXML
    private Button closeDelete;
    @FXML
    private Button randomPurchaseButton;
    @FXML
    private AnchorPane updatePassWindow;
    @FXML
    private Button closeUpdate;
    @FXML
    private PasswordField oldPassword;
    @FXML
    private Button confirmChange;
    @FXML
    private Label wrongPasswords;
    @FXML
    private Button AsosButton;

    @FXML
    private PasswordField NewPasswordField;
    @FXML
    private PasswordField CurrentPasswordField;
    @FXML
    private Button UpdatePasswordButton;
    @FXML
    private AnchorPane UpdatePasswordPage;
    @FXML
    private Button LookFantasicButton;
    @FXML
    private Button PizzaButton;
    @FXML
    private Button MSbutton;
    @FXML
    private Button UrbanDecay;

    @FXML
    void SimulatePurchase (ActionEvent event){
        //NEEDS TO SIMUATE THE USER PUTTING A CREDIT CARD/DEBIT CARD IN(MAYBE A NEW TABLE WITH SOME "VALID" CARDS
        //AND SOME CARDS WITH NOT ENOUGH TO BUY THE NEW MEMBERSHIP

        //new button to cancel membership(Are u sure?)
        //design to show the user is a higher member
        //deals require less points to purchase
        //get 1.5 more points than user per transation
    }

    public void purchaseVoucher(int cost, vouchers voucher){
        Account user = loginInfo(null);
        if(user.getPrivilegeLevel() == 0){
            if(user.getAccountBalance()>=voucher.getCost()){
                user.simPurchase(cost);
                String username = user.getAccountUsername();
                String balance = String.valueOf(user.getAccountBalance());
                SQLiteDatabase.updateBalance(username, balance);
                setpoints(balance);
            }
        }
        if(user.getPrivilegeLevel() == 1){
            if(user.getAccountBalance()>=(voucher.getCost()/2)){
                user.simPurchase(cost/2);
                String username = user.getAccountUsername();
                String balance = String.valueOf(user.getAccountBalance());
                SQLiteDatabase.updateBalance(username, balance);
                setpoints(balance);
            }
        }
    }

    @FXML
    void setUrbanDecaypoints(ActionEvent event){
        user.vouchers voucher = new vouchers(300);
        purchaseVoucher(-voucher.getCost()*100, voucher);
    }

    @FXML
    void setFootLockerpoints(ActionEvent event){
        user.vouchers voucher = new vouchers(750);
        purchaseVoucher(-voucher.getCost()*100, voucher);
    }
    @FXML
    void setpizzapoints(ActionEvent event){
        user.vouchers voucher = new vouchers(800);
        purchaseVoucher(-voucher.getCost()*100, voucher);
    }
    @FXML
    void setMandSPoints(ActionEvent event){
        user.vouchers voucher = new vouchers(150);
        purchaseVoucher(-voucher.getCost()*100, voucher);
    }
    @FXML
    void setAsospoints(ActionEvent event){
        user.vouchers voucher = new vouchers(1000);
        purchaseVoucher(-voucher.getCost()*100, voucher);
    }
    @FXML
    void setLOOKFANTASTICpoints(ActionEvent event){
        user.vouchers voucher = new vouchers(500);
        purchaseVoucher(-voucher.getCost()*100, voucher);
    }
    void setpoints(String accountBalance){
        points.setText(String.valueOf(accountBalance));
        points2.setText(String.valueOf(accountBalance));
        points3.setText(String.valueOf(accountBalance));
    }
    @FXML
    void changepassword(ActionEvent event){
        Account user = loginInfo(null);

        String username = user.getAccountUsername();
        String oldpassword = user.getPassword();
        String oldpasswordconfirm = oldPassword.getText();
        String newpassword = ChangePasswordField.getText();
        System.out.println(oldpassword);
        System.out.println(newpassword);
        if(oldpassword.equals(oldpasswordconfirm)){
            SQLiteDatabase.UpdatePassword(username, newpassword);
            wrongPasswords.setText("Password successfully changed.");
            wrongPasswords.setTextFill(Color.rgb(0 , 255, 33));
        }else {
            wrongPasswords.setText("Please enter correct password.");
            wrongPasswords.setTextFill(Color.rgb(255 , 0, 0));
        }
        oldPassword.clear();
        ChangePasswordField.clear();

    }
    @FXML
    void setLogout(ActionEvent event){
        logoutEvents();
    }

    @FXML
    void homeButtonAction(ActionEvent event) {
        homePage.toFront();
        homeButton.setStyle("-fx-background-color: #262626;" + "-fx-background-radius: 30;");
        rewardsButton.setStyle("-fx-background-color: #1C1316;");
        accountButton.setStyle("-fx-background-color: #1C1316;");

    }

    @FXML
    void rewardsButtonAction(ActionEvent event) {
        rewardsPage.toFront();
        rewardsButton.setStyle("-fx-background-color: #262626;" + "-fx-background-radius: 30;");
        homeButton.setStyle("-fx-background-color: #1C1316;");
        accountButton.setStyle("-fx-background-color: #1C1316;");

    }

    @FXML
    void accountButtonAction(ActionEvent event) {
        Account user = loginInfo(null);

        accountPage.toFront();
        accountButton.setStyle("-fx-background-color: #262626;" + "-fx-background-radius: 30;");
        homeButton.setStyle("-fx-background-color: #1C1316;");
        rewardsButton.setStyle("-fx-background-color: #1C1316;");
        String username = userNameField.getText();
        String firstName = user.getFirstName();
        String secondName = user.getSecondName();
        String email = user.getEmailAddress();


        FNlabel.setText(firstName);
        SNLabel.setText(secondName);
        EMLabel.setText(email);
        UNLabel.setText(username);
        if(user.getPrivilegeLevel()==0){
            AccountTypeLabel.setText("Standard Account");
            Premium_Member.setText("Become A Premium Member Today");
        }
        if(user.getPrivilegeLevel()==1){
            AccountTypeLabel.setText("Premium Account");
            Premium_Member.setText("Cancel Membership");
        }


    }

    @FXML
    void loginButtonAction(ActionEvent event) {
        loginMain.setStyle("-fx-background-color: #262626;" + "-fx-background-radius: 30;");
        System.out.println("test"); //takes us to login page
        signInPage.toFront();

    }

    @FXML
    void loginButtonOnAction(ActionEvent event){
        if (!userNameField.getText().isBlank() && !passwordField.getText().isBlank()){ //checks if username and password has been entered
            String accountUsername = userNameField.getText(); //gets text from the textbox
            String accountPassword = passwordField.getText(); //gets text from the textbox
            validateLogin(accountUsername, accountPassword); //validates the username and password entered to see if the values are correct
        }
        else{loginLabel.setText("Please enter your username and password");} //if the username or password hasn't been entered
    }


    @FXML
    void openDeleteAccount(ActionEvent event){
        loginPopup.toFront();
    }
    @FXML
    void DeleteAccountOnAction(ActionEvent event){
        String accountUsername = userNameField.getText();
        String accountPassword = passwordField.getText(); // original password
        String reEnteredPassword = deletePassword.getText(); // add a second password field
        String reEnteredUsername = deleteUsername.getText();
        //add a are u sure screen which requires the username to enter their password again and compare to password
        if (accountPassword.equals(reEnteredPassword) && accountUsername.equals(reEnteredUsername)){
            SQLiteDatabase.deleteRecord(accountUsername);
            logoutEvents();
        }
        else{
            loginLabel2.setText("Username or Password Incorrect");
            System.out.println(accountPassword);
            System.out.println(reEnteredPassword);

        }



    }

    public Account loginInfo(Account user) {
        String accountUsername = userNameField.getText();
        String accountFirstName = SQLiteDatabase.accountFirstName(accountUsername);
        String accountSecondName = SQLiteDatabase.accountSecondName(accountUsername);
        String accountEmailAddress = SQLiteDatabase.accountEmailAddress(accountUsername);
        int accountBalance = SQLiteDatabase.accountBalance(accountUsername);
        int accountPrivilegeLevel = SQLiteDatabase.privilegeLevel(accountUsername);
        String password = passwordField.getText();

        user = new Account(accountUsername, accountFirstName, accountSecondName, accountEmailAddress, accountBalance, accountPrivilegeLevel, password);
        return user;
    }

    public void validateLogin(String accountUsername, String accountPassword){
        boolean validate = SQLiteDatabase.verifyLogin(accountUsername, accountPassword); //calls function which checks if username and password are correct
        if (validate){
            Account user = loginInfo(null);
            int accountBalance = user.getAccountBalance();
            String accountFirstName = user.getFirstName();
            loginLabel.setText("");
            System.out.println("Welcome "+ accountUsername);
            signInPage.toBack();
            usernameButton.setText(String.valueOf(accountUsername));
            usernameHider.toFront();
            usernameButton.toFront();
            accountHider.toBack();
            points.setTextFill(Color.rgb(255, 174, 203));
            showOffers.toFront();
            loginTextPrompt.setText("Welcome back " + accountFirstName + ", check your rewards to see your specialised offers!");
            subTitle.setText("We are proud that you are one of 4+ pastel users.");
            logout.setOpacity(100);
            randomPurchaseButton.setOpacity(100);
            System.out.println(accountBalance);
            points.setText(String.valueOf(accountBalance));
            points2.setText(String.valueOf(accountBalance));
            points3.setText(String.valueOf(accountBalance));
            usernameLabel.setText(accountUsername);
            usernameLabel2.setText(accountUsername);

            homeButton.setStyle("-fx-background-color: #262626;" + "-fx-background-radius: 30;");
            rewardsButton.setStyle("-fx-background-color: #1C1316;");
            accountButton.setStyle("-fx-background-color: #1C1316;");




        }
        if(!validate){
            loginLabel.setText("You entered the wrong username or password!");
        }
    }

    public void validateSignUp(String firstName, String secondName, String emailAddress, String accountPassword, String accountUsername){
        boolean checkUsername = SQLiteDatabase.CheckUserName(accountUsername);
        if (checkUsername) {
            if (accountPassword.length() < 8) {
                loginLabel1.setText("password is too short");
            }
            else{
                SQLiteDatabase.insertRecords(accountUsername, accountPassword, emailAddress, firstName, secondName);
                loginLabel1.setText("Successfully created, welcome " + accountUsername);
            }
        }
        else{
            loginLabel1.setText("Username already in use");

        }

    }
    @FXML
    void CreateAccountButton(ActionEvent event){
        if (!firstName.getText().isBlank() && !email.getText().isBlank()&& !createPassword.getText().isBlank()&& !createUsername.getText().isBlank()&& !secondName.getText().isBlank()){ //checks if username and password has been entered
            String firstName = this.firstName.getText(); String secondName = this.secondName.getText(); String emailAddress = email.getText();String accountPassword = createPassword.getText(); String accountUsername = createUsername.getText();
            validateSignUp(firstName,secondName,emailAddress,accountPassword,accountUsername);
        }
        else{loginLabel1.setText("Please fill all the fields");} //if the username or password hasn't been entered
    }

    @FXML
    void signUpPage(ActionEvent event){
        signInPage.toBack();
        registerPage.toFront();
    }


    @FXML
    void closeRegisterAction(ActionEvent event){
        loginMain.setStyle("-fx-background-color: #1C1316;");
        registerPage.toBack();
    }

    @FXML
    void closeSignInAction(ActionEvent event){
        loginMain.setStyle("-fx-background-color: #1C1316;");
        signInPage.toBack();
    }

    @FXML
    void closePopup(ActionEvent event){
        loginMain.setStyle("-fx-background-color: #1C1316;");
        loginPopup.toBack();
        updatePassWindow.toBack();
    }

    @FXML
    void randomPurchase(ActionEvent event){
        int randomNum = ThreadLocalRandom.current().nextInt(1, 100 + 1);
        System.out.println(randomNum);
        randomPurchaseButton.setText("Spent £"+randomNum);
        int purchaseValue = randomNum*100;
        Account user = loginInfo(null);
        user.simPurchase(purchaseValue);

        String username = userNameField.getText();
        String balance = String.valueOf(user.getAccountBalance());
        SQLiteDatabase.updateBalance(username, balance);

        points.setText(String.valueOf(user.getAccountBalance()));
        points2.setText(String.valueOf(user.getAccountBalance()));
        points3.setText(String.valueOf(user.getAccountBalance()));

    }

    public void logoutEvents(){
        loginLabel.setText("");
        userNameField.clear(); //gets text from the textbox
        passwordField.clear(); //gets text from the textbox
        ChangePasswordField.clear();
        homePage.toFront();
        usernameButton.setText("");
        usernameHider.toBack();
        usernameButton.toBack();
        accountHider.toFront();
        showOffers.toBack();
        loginTextPrompt.setText("Login now to view rewards and access your account information.");
        subTitle.setText("Join Over 4 Pastel Users.");
        logout.setOpacity(0);
        randomPurchaseButton.setOpacity(0);
        points.setText("N/A");
        loginMain.setStyle("-fx-background-color: #1C1316;");
        homeButton.setStyle("-fx-background-color: #262626;" + "-fx-background-radius: 30;");
        randomPurchaseButton.setText("Random Purchase");
    }

    public void openPassWindow(){
        updatePassWindow.toFront();
        wrongPasswords.setTextFill(Color.rgb(255 , 0, 0));
        wrongPasswords.setText("");
    }

    @FXML
    public void premiumStatus(ActionEvent event){
        String privilege = null;
        Account user = loginInfo(null);
        String username = user.getAccountUsername();
        if(user.getPrivilegeLevel()==0){
            privilege = String.valueOf(1);
            AccountTypeLabel.setText("Premium Account");
            Premium_Member.setText("Cancel Membership");
        }
        if(user.getPrivilegeLevel()==1){
            privilege = String.valueOf(0);
            AccountTypeLabel.setText("Standard Account");
            Premium_Member.setText("Become A Premium Member Today");
        }
        SQLiteDatabase.updatePremium(username, privilege);

    }


}

