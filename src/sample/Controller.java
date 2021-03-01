package sample;

import database.SQLiteDatabase;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {

    @FXML
    private PasswordField PasswordField;

    @FXML
    private TextField UserNameField;

    @FXML
    private Button Login;

    @FXML
    private Label lab;

    @FXML
    private Label LoginLabel;
    @FXML
    private ImageView LoginImageView;

    @FXML
    void loginButtonOnAction(ActionEvent event){
        if (!UserNameField.getText().isBlank() && !PasswordField.getText().isBlank()){ //checks if username and password has been entered
            validatelogin(); //validates the username and password entered to see if the values are correct

        }
        else{LoginLabel.setText("Please enter username and password");} //if the username or password hasnt be entered
    }
    public void validatelogin(){
        //SQLiteDatabase connectionNow = new ();
        SQLiteDatabase.connect();
        System.out.println("Database connection successful!");
        SQLiteDatabase.verifyLogin();
      //  String verifyLogin = "SELECT count(1) FROM user WHERE username = "" AND WHERE password = """;


    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        File ImageFile = new File("/Photo/LoginPhoto.png");//loads in the photos from the address
        Image LoginImage = new Image(ImageFile.toURI().toString());
        LoginImageView.setImage(LoginImage);//should set imagine up
    }
}