package encryption.ciphers;

import encryption.EncryptionType;

public class CaesarCipher extends EncryptionType{
    private int key;

   
    /**
     * this method will take a shift for encryption 
     * @param shift is an integer 
     */
    public CaesarCipher (int shift){
        this.key = shift;
    }


    /**
     * This method will encrypt the text by using shiftchar method  
     * @param input will take the string to encrypt 
     * @return it returns an encrypted string 
     */
    public String encrypt(String input){
        StringBuilder result = new StringBuilder(); // StringBuilder to store the encrypted result

        for (int c = 0; c < input.length(); c++){
            char character = input.charAt(c); // Get the character at position c from the input
            
            char newChar = shiftChar(character, key); //ths will use the shiftChar method from here 
            result.append(newChar); //returns the final char 
        }
        return result.toString(); //to string to collect all the chars and return the string 
    }


    /**
     * This method is use to decrypt the text by taking input of string that is encrypted
     * @param input takes string input 
     * @return return decrypted string 
     */
    public String decrypt(String input){
        StringBuilder result = new StringBuilder(); 

        for (int c = 0; c < input.length(); c++){ //taking the characters of string one by one 
            char character = input.charAt(c); //converting string to character 
            
            char newChar = shiftChar(character, -key); //Using the ShiftChar method to add char and key 
            result.append(newChar); 
        }
        return result.toString();
    }
}
