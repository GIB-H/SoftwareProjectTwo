package encryption;

public class Encrypt {

    // Creates Encryption Instance Variables
    int encryptionKey = 12;

    public String encryptData(String plaintextString){
        String container = "";

        char[] chars = plaintextString.toCharArray();

        for(char character : chars) {
            character += encryptionKey;
            container += character;
        }
        return container;
    }

    public String decryptData(String encryptedString){
        String container = "";

        char[] chars = encryptedString.toCharArray();

        for(char character : chars){
            character -= encryptionKey;
            container += character;
        }
        return container;
    }
}
