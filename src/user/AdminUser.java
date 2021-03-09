package user;

public class AdminUser extends Account{
    AdminUser(String accountUsername, String firstName,String secondName, String emailAddress, int accountBalance, int privilegeLevel, String password){
        super(accountUsername,firstName,secondName,emailAddress,accountBalance,privilegeLevel, password);
    }
}
