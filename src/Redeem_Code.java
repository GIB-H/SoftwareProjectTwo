import java.util.Scanner;

public class Redeem_Code {
/* MUST TAKE A VALID CODE
* IF CODE/OR VALUE IS INVALID (NOT IN CSV) PRESENT ERROR
* IF CODE IS VALID AND VALUE IS VALID WITH CODE, THEN POINTS MAY BE EARNT, DELETE THE CODE AFTER*/

    public static void main(String[] args) {

    }

    public void getCodeAndValue() {
        Scanner sc = new Scanner(System.in);
        System.out.println("please enter your code");
        String code = sc.nextLine();
        System.out.println("please enter the amount you spent");
        int value = sc.nextInt();
        search(code,value);
    }

    public static void search(String code, int value) {

    }





}
