package user;

public class User extends Account{
    User(String accountUsername, String firstName,String secondName, String emailAddress, int accountBalance, int privilegeLevel, String password){
        super(accountUsername,firstName,secondName,emailAddress,accountBalance,privilegeLevel, password);
    }
}
