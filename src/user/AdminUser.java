package user;

public class AdminUser extends Account{
    AdminUser(String accountUsername, String firstName,String lastName, String emailAddress, int accountBalance, int privilegeLevel){
        super(accountUsername,firstName,lastName,emailAddress,accountBalance,privilegeLevel);
    }
}
