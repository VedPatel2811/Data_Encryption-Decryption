package encryption.ciphers;

import encryption.EncryptionType;

public class VigenereCipher extends EncryptionType{
    private String key;
    private int keyLength;

    /**
     * @param password
     */
    public VigenereCipher(String password){
        this.key = password;
        this.keyLength = password.length();
    }

    /**
     * This method will take an input of string to encrypt it and it also uses sfiftChar to encrypt the text 
     * @param input it will take an input of string that user wants to encrypt 
     * @return it returns encrypted string 
     */
    public String encrypt(String input){
        StringBuilder result = new StringBuilder(); // StringBuilder to store the encrypted result
        
        for (int i=0; i<input.length(); i++){
            char userInput = (char) input.charAt(i); // Get the character at position i from the input
            char newPass = key.charAt(i % keyLength); //to ensure that the position i wraparound to fit the keyLength
            //int numString = (int) userInput; // Convert the user input character to its corresponding ASCII value
            int numPass = (int) newPass; // Convert the key character to its corresponding ASCII value

            
            char newChar = shiftChar(userInput, numPass); // Using the shiftChar to add user text's character and the password character 
            int added = (int) newChar; //to calculate according to Ascii table 
            int encNum = ((added - (2*START_CHAR)) % RANGE);
            if (encNum<0){ //if the final number of the calculation is less then zero then it will add 91 to put the number into range 
                encNum = encNum + RANGE;
            }
            encNum = encNum + START_CHAR; //to convert the number into our range, our range start from 32 
            char encryptedChar = (char) encNum; // Convert the ASCII value back to character
            result.append(encryptedChar);
        }
        return result.toString();
        }

    /**
     * This method is use to decrypt the text which is already encrypted by using certain password wihich is provided by user 
     * It also used shiftChar method to decrypt 
     * @param input it takes the string input 
     * @return it will return the decrypted string 
     */
    public String decrypt(String input) {
        StringBuilder result = new StringBuilder(); 
        for (int i=0; i<input.length(); i++){
            char newInput = (char) input.charAt(i); // Get the character at position i from the input
            char newPass = key.charAt(i % keyLength);  // Get the character from the key based on the key length
            //int numString = (int) newInput;
            int numPass = (int) newPass; // Convert the key character to its corresponding ASCII value

            char newChar = shiftChar(newInput, -numPass);
            int added = (int) newChar;
            int decryptNum = ((added) % RANGE);  // Decrypt the ASCII values
            if (decryptNum<0){  // If the result is negative, add RANGE to bring it within the range
                decryptNum = decryptNum + RANGE;
            }
            decryptNum = decryptNum + START_CHAR;
            char decryptChar = (char) decryptNum; // Convert the ASCII value back to character
            result.append(decryptChar); // Append the decrypted character to the result
        }
        return result.toString();
    }

}

