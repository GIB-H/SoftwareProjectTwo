package user;

public class User extends Account{
    User(String accountUsername, String firstName,String secondName, String emailAddress, int accountBalance, int privilegeLevel){
        super(accountUsername,firstName,secondName,emailAddress,accountBalance,privilegeLevel);
    }
}
