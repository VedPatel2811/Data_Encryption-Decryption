package encryption;

import java.util.Scanner;

public class ScannerUtils {
  private static Scanner input = new Scanner(System.in);

  /**
   * This method will take number of options in the form of string to make the interface with respected to their uniqually numbers assigned to it 
   * @param options this is a object that takes number of string input 
   * @return it retuens the user choice 
   */
  public static int getMenuItem(String... options) { // Method to display a menu and get user's choice
    int choice = -1;
    boolean validChoice = false;
    
    while (!validChoice) {
      for (int i = 0; i < options.length; i++) {
        System.out.println("\t"+ (i + 1) + " - " + options[i]); // Display the menu options
      }
      System.out.print("Select action: ");
      String inputStr = input.nextLine(); // Read the user's input
      try{
        choice = Integer.parseInt(inputStr); // Parse the input as an integer
        if (choice >= 1 && choice <= options.length) {
          validChoice = true; // Validate the user's choice
        } else {
          System.out.println("\nPlease select a number in the range");// Display error message for non-integer input
        }
      } catch(NumberFormatException e) {
        System.out.println("\nPlease enter an integer");
      }
    }
    return choice; // Return the user's choice
  }    

  /**
   * This method will take a string which need to output to complete the interface of the output 
  * @param prompt this is a variable that takes string 
  * @return it will return the input from the user 
  */
  public static String getString(String prompt){ // Method to get a string input from the user
    System.out.print(prompt);
    return input.nextLine(); // Read a line of input from the user

  }

  /**
   * This method will output a instruction to ask the user for the integer input in a certain range 
   * If the user input is not valid then it will print an error respectedly 
  * @param prompt This will ask the user for the input 
  * @param min it is the starting range for the integer input 
  * @param max it is the ending range 
  * @return it returns the integer that user had given 
  * @author Ved Patel
  */
  public static int getInt(String prompt, int min, int max) {// Method to get an integer input within a specific range from the user
    int value = -1;
    boolean validInput = false;
        
    while (!validInput) {
      System.out.print(prompt);
      String inputStr = input.nextLine();
        
      try {
        value = Integer.parseInt(inputStr); // Parse the input as an integer
        if (value >= min && value <= max) {
          validInput = true; // Validate the user's input
        } else {
            System.out.println("\nPlease select a number in the range.");
          }
      } catch (NumberFormatException e) {
          System.out.println("\nPlease enter an integer");// Display error message for non-integer input
        }
    }
    return value;

  }

}
