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
    void showOffersAction(ActionEvent event) { //temp debug button

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
            String username = userNameField.getText();
            String password = passwordField.getText();
            validateLogin(username, password); //validates the username and password entered to see if the values are correct
        }
        else{loginLabel.setText("Please enter username and password");} //if the username or password hasn't been entered
    }

    public void validateLogin(String username, String password){
        // SELECT count(1) FROM LoginInfo WHERE Username = ? AND Password = ?
        boolean validate = SQLiteDatabase.verifyLogin(username, password);
        if (validate){
            loginLabel.setText("");
            System.out.println("Welcome "+ username);
            signInPage.toBack();
            usernameButton.setText(String.valueOf(username));
            usernameHider.toFront();
            usernameButton.toFront();
            accountHider.toBack();
            points.setTextFill(Color.rgb(255, 174, 203));
            showOffers.toFront();
            loginTextPrompt.setText("Welcome back " + username + ", check your rewards to see your specialised offers!");
            subTitle.setText("We are proud that you are one of 4+ pastel users.");

            int accountBalance = SQLiteDatabase.accountBalance(username);
            points.setText(String.valueOf(accountBalance));
            points2.setText(String.valueOf(accountBalance));
        }
        if(!validate){
            loginLabel.setText("You entered the wrong username or password!");
        }
    }

    public void validateSignUp(String firstName, String secondName, String emailAddress, String password, String username){
        SQLiteDatabase.insertRecords(username, password, emailAddress, firstName, secondName);
    }
    @FXML
    void CreateAccountButton(ActionEvent event){
        if (!firstName.getText().isBlank() && !email.getText().isBlank()&& !createPassword.getText().isBlank()&& !createUsername.getText().isBlank()&& !secondName.getText().isBlank()){ //checks if username and password has been entered
            String Fn = firstName.getText(); String Sn = secondName.getText(); String Email = email.getText();String password = createPassword.getText(); String Username = createUsername.getText();
            validateSignUp(Fn,Sn,Email,password,Username);
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



}

