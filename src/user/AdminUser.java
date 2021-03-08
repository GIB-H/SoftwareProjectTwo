package user;

public class AdminUser extends Account{
    AdminUser(String accountUsername, String firstName,String secondName, String emailAddress, int accountBalance, int privilegeLevel){
        super(accountUsername,firstName,secondName,emailAddress,accountBalance,privilegeLevel);
    }
}
