/*
Name: Diego Garcia, Erwin Pan
Date: 9/2/2021
Description: Postal Bar Code Printer
*/
import java.util.Scanner;
class Main {
  public static void main(String[] args) {
    String zip = getZip(); // calls getZip and stores zip code within zip
    printBarCode(zip); // prints the bar code of inputted zip code
  }
  /**
  Takes input of the zip code and check if it's within the range[10000-99999].
  @return zip returns zip code in string format.
  */
  public static String getZip(){ 
    Scanner in = new Scanner(System.in); //creates scanner
    System.out.print("Enter a zip code: "); // prompt
    int zip = CheckInput.getIntRange(10000,99999); // checks for input in valid range
    return String.valueOf(zip); // returns the zip in string format
  }
  /**
  Calculates Check Digit.
  @param zip zip code to be used to create the check digit.
  @return checked returns character that corresponds to the integer of the check digit.
  */
  public static char getCheckDigit(String zip){
    int sum = 0; // prime accumulator 
    for (int i = 0; i < zip.length(); i++){
      char charNum = zip.charAt(i); // obtain char at i
      int num = Character.getNumericValue(charNum); // convert char to int and store in num
      sum = sum + num; // add to accumulator
    }
    int rounded = (int)(Math.ceil((double)sum/10.0))*10; // converts sum to double, then back to int after rounding up to nearest 10
    //int rounded = ((int)Math.ceil((double)sum/10))*10;
    int checkInt = rounded - sum; // sub rounded from sum
    char checkChar = (char)(48+checkInt); // convert checkInt to char with respect to ASCII
    return checkChar; // return char to be used for bar code
  }
  /**
  Prints out barcode given by the zip code.
  @param zip zip code given by the user.
  */
  public static void printBarCode(String zip){
    System.out.print("|"); //prints the start of the frame bar.
    for (int i = 0; i < zip.length(); i++){
      char d = zip.charAt(i); //store char at i position of zip. 
      printDigit(d); // send char to printdigit to be printed
    }
    char checkDigit = getCheckDigit(zip); // generate check digit and store in char
    printDigit(checkDigit); // print check digit
    System.out.print("|"); //prints the end of the frame bar.
  }
    /**
     * Prints the barcode corresponding to the given char.
     * @param d the character that will be used to print the barcode.
     */
    public static void printDigit(char d){
      if (d == '1'){
        System.out.print("...||");
      } else if (d == '2'){
        System.out.print("..|.|");
      } else if (d == '3'){
        System.out.print("..||.");
      } else if (d == '4'){
        System.out.print(".|..|");
      } else if (d == '5'){
        System.out.print(".|.|.");
      } else if (d == '6'){
        System.out.print(".||..");
      } else if (d == '7'){
        System.out.print("|...|");
      } else if (d == '8'){
        System.out.print("|..|.");
      } else if(d == '9'){
        System.out.print("|.|..");
      } else if (d == '0'){
        System.out.print("||...");
      }
  }

}