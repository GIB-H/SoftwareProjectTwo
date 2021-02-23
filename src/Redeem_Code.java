import java.util.Random;

public class Redeem_Code {
    public static void main(String[] args) {
        String Code = getcode();
        int Value = getValue();
    }
    public static String getcode(){
        // create a string of all characters
        String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ123456789";

        // create random string builder
        StringBuilder sb = new StringBuilder();

        // create an object of Random class
        Random random = new Random();

        // specify length of random string
        int length = 10;

        for(int i = 0; i < length; i++) {

            // generate random index number
            int index = random.nextInt(alphabet.length());

            // get character specified by index
            // from the string
            char randomChar = alphabet.charAt(index);

            // append the character to string builder
            sb.append(randomChar);
        }

        String randomString = sb.toString();
        System.out.println("Random String is: " + randomString);
        return randomString;
    }
    public static int getValue(){
        int randomNum = (int)(Math.random() * 101);  // 0 to 100
        System.out.println(randomNum);
        return randomNum;
    }


}
