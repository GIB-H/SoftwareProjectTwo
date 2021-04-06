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
import user.Account;
import user.Vouchers;



import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class Controller {

    private static Scanner x;

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
    private Label v1;
    @FXML
    private Label v2;
    @FXML
    private Label v3;
    @FXML
    private Label v4;
    @FXML
    private Label v5;
    @FXML
    private Label v6;
    @FXML
    private Label v7;
    @FXML
    private Label v8;

    @FXML
    private Label c1;
    @FXML
    private Label c2;
    @FXML
    private Label c3;
    @FXML
    private Label c4;
    @FXML
    private Label c5;
    @FXML
    private Label c6;
    @FXML
    private Label c7;
    @FXML
    private Label c8;
    @FXML
    private Button BlueFilterButton;
    @FXML
    private Label LittleEffort;
    @FXML
    private AnchorPane BigAnchor;
    @FXML
    private AnchorPane BottomPane;
    @FXML
    private AnchorPane RightPane;
    @FXML
    private AnchorPane InsidePane;
    @FXML
    private Label myBalance;
    @FXML
    private Label voucherHeader;
    @FXML
    private Label pointCostHeader;
    @FXML
    private Label firstNameHeader;
    @FXML
    private Label secondNameHeader;
    @FXML
    private Label emailAddressHeader;
    @FXML
    private Label userNameHeader;
    @FXML
    private Label accountTypeHeader;
    @FXML
    private Label purchaseHistoryHeader;
    @FXML
    private Label accountDetailsHeader;
    @FXML
    private Label myBalance2;

    @FXML
    void BlueCoulorBlindnessFilter(ActionEvent event){
        //homepage
        homePage.setStyle("-fx-background-color: #142142;");
        BigAnchor.setStyle("-fx-background-color: #262626;" + "-fx-background-radius: 30;");
        BottomPane.setStyle("-fx-background-color: #262626;" + "-fx-background-radius: 30;");
        RightPane.setStyle("-fx-background-color:  #262626;" + "-fx-background-radius: 30;");
        InsidePane.setStyle("-fx-background-color: #A3E4D7;" + "-fx-background-radius: 30;");
        showOffers.setStyle("-fx-text-fill: #154360;" + "-fx-background-radius: 30;" + "-fx-background-color: #da3fd2;");
        randomPurchaseButton.setStyle("-fx-text-fill: #154360;" + "-fx-background-radius: 30;" + "-fx-background-color: #da3fd2;");
        loginOffers.setStyle("-fx-text-fill: #154360;" + "-fx-background-radius: 30;" + "-fx-background-color: #da3fd2;");
        BlueFilterButton.setStyle("-fx-text-fill: #154360;" + "-fx-background-radius: 30;" + "-fx-background-color: #da3fd2;");
        loginTextPrompt.setStyle("-fx-text-fill: #da3fd2;");
        subTitle.setStyle("-fx-text-fill: #da3fd2;");
        LittleEffort.setStyle("-fx-text-fill: #da3fd2;");

        //accountpage
        accountPage.setStyle("-fx-background-color: #142142;");
        updatePassword.setStyle("-fx-text-fill: #154360;" + "-fx-background-radius: 30;" + "-fx-background-color: #da3fd2;");
        DeleteAccount.setStyle("-fx-text-fill: #154360;" + "-fx-background-radius: 30;" + "-fx-background-color: #da3fd2;");
        Premium_Member.setStyle("-fx-text-fill: #154360;" + "-fx-background-radius: 30;" + "-fx-background-color: #da3fd2;");
        logout.setStyle("-fx-text-fill: #154360;" + "-fx-background-radius: 30;" + "-fx-background-color: #da3fd2;");
        myBalance.setStyle("-fx-text-fill: #A3E4D7;");
        voucherHeader.setStyle("-fx-text-fill: #A3E4D7;");
        pointCostHeader.setStyle("-fx-text-fill: #A3E4D7;");
        firstNameHeader.setStyle("-fx-text-fill: #A3E4D7;");
        secondNameHeader.setStyle("-fx-text-fill: #A3E4D7;");
        emailAddressHeader.setStyle("-fx-text-fill: #A3E4D7;");
        userNameHeader.setStyle("-fx-text-fill: #A3E4D7;");
        accountTypeHeader.setStyle("-fx-text-fill: #A3E4D7;");
        usernameLabel2.setStyle("-fx-text-fill: #da3fd2;");
        points3.setStyle("-fx-text-fill: #da3fd2;");
        purchaseHistoryHeader.setStyle("-fx-text-fill: #da3fd2;");
        accountDetailsHeader.setStyle("-fx-text-fill: #da3fd2;");
        FNlabel.setStyle("-fx-text-fill: #da3fd2;");
        SNLabel.setStyle("-fx-text-fill: #da3fd2;");
        EMLabel.setStyle("-fx-text-fill: #da3fd2;");
        UNLabel.setStyle("-fx-text-fill: #da3fd2;");
        AccountTypeLabel.setStyle("-fx-text-fill: #da3fd2;");

        Label[] vlabels = {v1, v2, v3, v4, v5, v6, v7, v8};
        Label[] clabels = {c1, c2, c3, c4, c5, c6, c7, c8};

        for(int i = 0; i < vlabels.length; i++){
            try{
                vlabels[i].setStyle("-fx-text-fill: #da3fd2;");
                clabels[i].setStyle("-fx-text-fill: #da3fd2;");
            } catch (ArrayIndexOutOfBoundsException e) {
            }
        }


        //rewardspage
        rewardsPage.setStyle("-fx-text-fill: #da3fd2;");
        points2.setStyle("-fx-text-fill: #da3fd2;");
        usernameLabel.setStyle("-fx-text-fill: #da3fd2;");
        myBalance2.setStyle("-fx-text-fill: #A3E4D7;");








    }

    public void purchaseVoucher(int cost, Vouchers voucher){
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
        ArrayList<String> voucherDetails = new ArrayList();
        voucherDetails.add(user.getAccountUsername());
        voucherDetails.add(voucher.getName());
        if(user.getPrivilegeLevel()==0){
            voucherDetails.add(String.valueOf(voucher.getCost()));
        }
        if(user.getPrivilegeLevel()==1){
            voucherDetails.add(String.valueOf(voucher.getCost()/2));
        }
        String voucherDetailsString = String.join(",", voucherDetails);

        BufferedWriter writer;
        try {
            writer = new BufferedWriter(new FileWriter("userVouchers.csv", true));
            writer.write(voucherDetailsString);
            writer.newLine();
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @FXML
    void setUrbanDecaypoints(ActionEvent event){
        Vouchers voucher = new Vouchers(300, "Urban Decay");
        purchaseVoucher(-voucher.getCost()*100, voucher);
    }

    @FXML
    void setFootLockerpoints(ActionEvent event){
        Vouchers voucher = new Vouchers(750, "Foot Locker");
        purchaseVoucher(-voucher.getCost()*100, voucher);
    }
    @FXML
    void setpizzapoints(ActionEvent event){
        Vouchers voucher = new Vouchers(800, "Pizza");
        purchaseVoucher(-voucher.getCost()*100, voucher);
    }
    @FXML
    void setMandSPoints(ActionEvent event){
        Vouchers voucher = new Vouchers(150, "Marks & Spencer");
        purchaseVoucher(-voucher.getCost()*100, voucher);
    }
    @FXML
    void setAsospoints(ActionEvent event){
        Vouchers voucher = new Vouchers(1000, "ASOS");
        purchaseVoucher(-voucher.getCost()*100, voucher);
    }
    @FXML
    void setLOOKFANTASTICpoints(ActionEvent event){
        Vouchers voucher = new Vouchers(500, "LOOK FANTASTIC");
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
        homePage.toBack();
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

        String filePath = "userVouchers.csv";
        String searchTerm = user.getAccountUsername();

        String[] nameData;
        String[] costData;

        nameData = (fetchVoucherName(searchTerm, filePath));

        for (int i = 0; i < nameData.length / 2; i++) {
            Object temp = nameData[i];
            nameData[i] = nameData[nameData.length - 1 - i];
            nameData[nameData.length - 1 - i] = (String) temp;
        }

        costData = (fetchVoucherCost(searchTerm, filePath));

        for (int i = 0; i < costData.length / 2; i++) {
            Object temp = costData[i];
            costData[i] = costData[costData.length - 1 - i];
            costData[costData.length - 1 - i] = (String) temp;
        }

        Label[] vlabels = {v1, v2, v3, v4, v5, v6, v7, v8};
        Label[] clabels = {c1, c2, c3, c4, c5, c6, c7, c8};

        for(int i = 0; i < vlabels.length; i++){
            try{
                vlabels[i].setText(nameData[i]);
                clabels[i].setText(costData[i]);
            } catch (ArrayIndexOutOfBoundsException e) {
            }
        }

    }

    public static String[] fetchVoucherName(String searchTerm, String filePath){
        ArrayList<String> records = new ArrayList<String>();

        boolean found = false;
        String name = ""; String voucherName = ""; String voucherCost;

        try {
            Scanner x;
            x = new Scanner(new File(filePath));
            x.useDelimiter("[,\n]");

            while (x.hasNext()){
                name = x.next();
                if(name.equals(searchTerm)){
                    voucherName = x.next();
                    voucherCost = x.next();
                    String record = voucherName;
                    records.add(record);
                    found = true;
                }
                else{
                    x.next();
                    x.next();
                }
            }
            if(!found){
                System.out.println("No Vouchers Found");

            }
            x.close();
        }
        catch (Exception e){
            System.out.println("Error");
        }

        String[] recordsArray = new String[records.size()];
        records.toArray(recordsArray);
        return recordsArray;
    }

    public static String[] fetchVoucherCost(String searchTerm, String filePath){
        ArrayList<String> records = new ArrayList<String>();

        boolean found = false;
        String name = ""; String voucherName = ""; String voucherCost;

        try {
            Scanner x;
            x = new Scanner(new File(filePath));
            x.useDelimiter("[,\n]");

            while (x.hasNext()){
                name = x.next();
                if(name.equals(searchTerm)){
                    voucherName = x.next();
                    voucherCost = x.next();
                    String record = voucherCost;
                    records.add(record);
                    found = true;
                }
                else{
                    x.next();
                    x.next();
                }
            }
            if(!found){
                System.out.println("No Vouchers Found");
            }
            x.close();
        }
        catch (Exception e){
            System.out.println("Error");
        }

        String[] recordsArray = new String[records.size()];
        records.toArray(recordsArray);
        return recordsArray;
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
        Account user = loginInfo(null);
        String accountUsername = user.getAccountUsername();
        String accountPassword = user.getPassword(); // original password
        String reEnteredPassword = deletePassword.getText(); // add a second password field
        String reEnteredUsername = deleteUsername.getText();
        //add a are u sure screen which requires the username to enter their password again and compare to password
        if (accountPassword.equals(reEnteredPassword) && accountUsername.equals(reEnteredUsername)){
            SQLiteDatabase.deleteRecord(accountUsername);
            removeRecord("userVouchers.csv", accountUsername, 1);
            logoutEvents();
        }
        else{
            loginLabel2.setText("Username or Password Incorrect");
            System.out.println(accountPassword);
            System.out.println(reEnteredPassword);

        }



    }

    public void removeRecord(String filepath, String removeTerm, int positionOfTerm) {
        int position = positionOfTerm - 1;
        String tempFile = "temp.csv";
        File oldFile = new File(filepath);
        File newFile = new File(tempFile);

        try {
            FileWriter fw = new FileWriter(tempFile, true);
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter pw = new PrintWriter(bw);
            FileReader fr = new FileReader(filepath);
            BufferedReader br = new BufferedReader(fr);

            String currentLine;
            while((currentLine = br.readLine()) != null) {
                String[] data = currentLine.split(",");
                if (!data[position].equalsIgnoreCase(removeTerm)) {
                    pw.println(currentLine);
                }
            }

            pw.flush();
            pw.close();
            fr.close();
            br.close();
            bw.close();
            fw.close();
            oldFile.delete();
            File dump = new File(filepath);
            newFile.renameTo(dump);
        } catch (Exception var15) {
            var15.printStackTrace();
        }

    }

    public Account loginInfo(Account user) {
        String accountUsername = userNameField.getText();
        String accountFirstName = SQLiteDatabase.accountFirstName(accountUsername);
        String accountSecondName = SQLiteDatabase.accountSecondName(accountUsername);
        String accountEmailAddress = SQLiteDatabase.accountEmailAddress(accountUsername);
        int accountBalance = SQLiteDatabase.accountBalance(accountUsername);
        int accountPrivilegeLevel = SQLiteDatabase.privilegeLevel(accountUsername);
        String password = SQLiteDatabase.accountPassword(accountUsername);

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
        boolean checkUsername = SQLiteDatabase.checkUsername(accountUsername);
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
        oldPassword.clear();
        ChangePasswordField.clear();
    }

    @FXML
    void randomPurchase(ActionEvent event){
        Account user = loginInfo(null);
        int randomNum = ThreadLocalRandom.current().nextInt(1, 100 + 1);
        System.out.println(randomNum);

        int purchaseValue = 0;
        if(user.getPrivilegeLevel()==0){
            purchaseValue = randomNum*100;
        }
        if(user.getPrivilegeLevel()==1){
            purchaseValue = randomNum*150;
        }
        randomPurchaseButton.setText("Spent £"+randomNum+ " +" + purchaseValue/100+ "p");

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
        oldPassword.clear();
        ChangePasswordField.clear();
        deleteUsername.clear();
        deletePassword.clear();

        v1.setText("NA");
        v2.setText("NA");
        v3.setText("NA");
        v4.setText("NA");
        v5.setText("NA");
        v6.setText("NA");
        v7.setText("NA");
        v8.setText("NA");

        c1.setText("NA");
        c2.setText("NA");
        c3.setText("NA");
        c4.setText("NA");
        c5.setText("NA");
        c6.setText("NA");
        c7.setText("NA");
        c8.setText("NA");
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

