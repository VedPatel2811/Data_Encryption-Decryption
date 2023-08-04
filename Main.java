import java.util.ArrayList;

import encryption.EncryptionType;
import encryption.ScannerUtils;

public class Main {
    
    /**
     * This is the main method which prints the first interface contain four options for the user 
     * After the user choose the option it calls the certain method from various classes to encrypt, decypt, display encripted texts and to exit the code 
     * @param args it takes number of arguments 
     */
    public static void main(String[] args)  {
        System.out.println("Encryption tester");
        ArrayList<String> encryptedText = new ArrayList<>(); // Create an ArrayList to store encrypted text
        boolean exit = false;
        while (!exit) {
            int userChoice = ScannerUtils.getMenuItem("Encrypt text", "Decrypt text", "Display encrypted list", "Exit"); //Display this four option 
            
            switch (userChoice){
                case 1:
                String stringToEncrypt = ScannerUtils.getString("Please enter text to be encrypted: "); // Get the text to be encrypted
                EncryptionType encMethod = EncryptionType.getMethod(); //Get the encription method

                String EncString = encMethod.encrypt(stringToEncrypt); // Encrypt the text
                encryptedText.add(EncString); // Add the encrypted text to the ArrayList
                System.out.println("Encrypted value #" + encryptedText.size() + " is: " + EncString +"\n"); // Display the encrypted text
                break;
                
                case 2: 
                if(encryptedText.isEmpty()){
                    System.out.println("\nNothing to decrypt"); //Display error message for non integer values input by the user 
                    break;
                }
                int txtToDec= ScannerUtils.getInt("Message number you want to decrypt: ", 1 , encryptedText.size());
                EncryptionType decMethod = EncryptionType.getMethod();
                String decString = (decMethod).decrypt(encryptedText.get(txtToDec-1)); // Decrypt the text
                System.out.println("Decrypted value #" + txtToDec+ " is: "+ decString +"\n"); // Display the decrypted text
                break;

                case 3: 
                
                if (encryptedText.isEmpty()){
                    System.out.println("\nNothing to display"); // Display error message if there is no encrypted text to display
                    break;
                }
                System.out.println("------------");
                for (int i = 0; i <encryptedText.size(); i++){
                    System.out.println("#" + (i+1)+ ": " +encryptedText.get(i)); // Display each encrypted text in the ArrayList
                }
                System.out.println("------------\n");
                break;

                case 4:
                System.out.println("Good bye");
                exit = true; // Exit the program
                break;
            }

        }
    }
}
