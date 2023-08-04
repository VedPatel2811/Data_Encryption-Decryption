package encryption;

import encryption.ciphers.CaesarCipher;
import encryption.ciphers.VigenereCipher;

public abstract class EncryptionType {
    protected final static int START_CHAR = 32; //range start from this in Ascii table 
    protected final static int END_CHAR = 122; //Ending character 
    protected final static int RANGE = END_CHAR - START_CHAR +1; //range for the Ascii table 

    /**
     * This method will take an char and integer as an input and then char is converted into integer and at last both interger add ups 
     * @param character this is a characted 
     * @param offset this is an integer 
     * @return this method returns character which further used in ceaser cipher and vigenere cipher 
     */
    
    public abstract String encrypt(String input);
    public abstract String decrypt(String input);
    
     
    /**
     * This method will take an char and int input and then it will add them after converting char to int  
     * After that if the value if not in range then it will make the value in range 
     * @param character it will take an character 
     * @param offset it will take an integer 
     * @return it will return the added character 
     */
    protected char shiftChar(char character, int offset) {
        int charToInt = (int) character;
        int add = charToInt + offset;
        
        while (add < START_CHAR) {
            add += RANGE;
        }
        while (add > END_CHAR) {
            add -= RANGE;
        }
        char newChar = (char) add;
        
        return newChar;
    }

    
    /**
     * This method is use to print the two options of encryption type.
     * Further it also take shift if user choose Caeaser Cipher encryption.
     * OR if user choose Vigenere cipher the it will ask password to encrypt.
     * @return it return null values 
     */
    public static EncryptionType getMethod(){ // Method to get the encryption method chosen by the user
        System.out.println("Encryption method: ");
        int userChoice = ScannerUtils.getMenuItem("Caesar","Vigenere"); //To display encrpytion method options 

        switch (userChoice) {
            case 1:
                int shift = ScannerUtils.getInt("Shift value: ", Integer.MIN_VALUE, Integer.MAX_VALUE); //Take shift and also define the range of the shift 
                return new CaesarCipher(shift); // Create a new CaesarCipher instance
            case 2:
                String password = ScannerUtils.getString("Password: "); // Get the password from the user
                return new VigenereCipher(password); // Create a new VigenereCipher instance
            default:
            return null;
        }
    }
}
