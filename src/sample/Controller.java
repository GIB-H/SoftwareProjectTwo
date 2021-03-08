package sample;

import database.SQLiteDatabase;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;


public class Controller {

    @FXML
    private Label points;
    @FXML
    private Label points2;
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
    private Button loginMain;
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
    void showOffersAction(ActionEvent event) { //temp debug button

    }
    @FXML
    void setLogout(ActionEvent event){
        loginLabel.setText("");
        System.out.println("Goodbye, " + userNameField.getText() + ", have a nice day!");
        userNameField.clear(); //gets text from the textbox
        passwordField.clear(); //gets text from the textbox
        homePage.toFront();
        usernameButton.setText("");
        usernameHider.toBack();
        usernameButton.toBack();
        accountHider.toFront();
        showOffers.toBack();
        loginTextPrompt.setText("Login now to view rewards and access your account information.");
        subTitle.setText("Join Over 4 Pastel Users.");
        logout.setOpacity(0);
        points.setText("N/A");
        loginMain.setStyle("-fx-background-color: #1C1316;");
        homeButton.setStyle("-fx-background-color: #262626;" + "-fx-background-radius: 30;");
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
        accountPage.toFront();
        accountButton.setStyle("-fx-background-color: #262626;" + "-fx-background-radius: 30;");
        homeButton.setStyle("-fx-background-color: #1C1316;");
        rewardsButton.setStyle("-fx-background-color: #1C1316;");

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
        String accountPassword = passwordField.getText();//orginal password
        String reEnteredPassword = deletePassword.getText(); // add a second password field
        String reEnteredUsername = deleteUsername.getText();
        //add a are u sure screen which requires the username to enter their password again and compare to password
        if (accountPassword.equals(reEnteredPassword) && accountUsername.equals(reEnteredUsername)){
            SQLiteDatabase.deleteRecord(accountUsername);
            userNameField.clear();
            passwordField.clear();
            homePage.toFront();
            usernameButton.setText("");
            usernameHider.toBack();
            usernameButton.toBack();
            accountHider.toFront();
            showOffers.toBack();
            loginTextPrompt.setText("Login now to view rewards and access your account information.");
            subTitle.setText("Join Over 4 Pastel Users!");
            logout.setOpacity(0);
            points.setText("N/A");
            loginMain.setStyle("-fx-background-color: #1C1316;");
            homeButton.setStyle("-fx-background-color: #262626;" + "-fx-background-radius: 30;");
            loginPopup.toBack();
        }
        else{
            loginLabel2.setText("Username or Password Incorrect");
            System.out.println(accountPassword);
            System.out.println(reEnteredPassword);

        }



    }

    public void validateLogin(String accountUsername, String accountPassword){
        boolean validate = SQLiteDatabase.verifyLogin(accountUsername, accountPassword); //calls function which checks if username and password are correct
        if (validate){
            loginLabel.setText("");
            System.out.println("Welcome "+ accountUsername);
            signInPage.toBack();
            usernameButton.setText(String.valueOf(accountUsername));
            usernameHider.toFront();
            usernameButton.toFront();
            accountHider.toBack();
            points.setTextFill(Color.rgb(255, 174, 203));
            showOffers.toFront();
            loginTextPrompt.setText("Welcome back " + accountUsername + ", check your rewards to see your specialised offers!");
            subTitle.setText("We are proud that you are one of 4+ pastel users.");
            logout.setOpacity(100);
            int accountBalance = SQLiteDatabase.accountBalance(accountUsername);
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
    }


}

