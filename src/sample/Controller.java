package sample;

import database.SQLiteDatabase;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;


public class Controller {

    int counter = 0;
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
    void showOffersAction(ActionEvent event) {
        counter++;
        points.setText(String.valueOf(counter));
        points2.setText(String.valueOf(counter));
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
        counter++;
        points.setText(String.valueOf(counter));
        points2.setText(String.valueOf(counter));
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
        SQLiteDatabase.verifyLogin(username, password);

    }
    public void validateSignUp(String Firstname, String Secondname, String Email, String Password, String Username){
        SQLiteDatabase.insertRecords(Username,Password,Email,Firstname,Secondname);
    }
    @FXML
    void CreateAccountButton(ActionEvent event){
        if (!firstName.getText().isBlank() && !email.getText().isBlank()&& !createPassword.getText().isBlank()&& !createUsername.getText().isBlank()&& !secondName.getText().isBlank()){ //checks if username and password has been entered
            String Fn = firstName.getText(); String Sn = secondName.getText(); String Email = email.getText();String password = createPassword.getText(); String Username = createUsername.getText();
            validateSignUp(Fn,Sn,Email,password,Username);
        }
        else{loginLabel.setText("Please Fill All The Fields");} //if the username or password hasn't been entered
    }

    @FXML
    void signUpPage(ActionEvent event){
        points.setText(String.valueOf(counter)); //takes us to signup page
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

