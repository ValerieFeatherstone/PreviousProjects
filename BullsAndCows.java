import java.util.Random;
import java.util.Scanner;

public class BullsAndCows{
  public static void main(String[] args){
    //Intializes the game
    playBullsAndCows(42);



  }


  public static boolean contains(int[] a, int b){
      //Check if an array contains a particular integer
      for (int i = 0; i < a.length; i++){
        if(a[i] == b){
          return true;
        }
      }
      return false;
  }

  public static int[] generateSecretdigits(int a){
    //Generates an array of 4 random single digit integers
    int o = 0;
    int n;
    int[] b = {-1, -1, -1, -1};
    Random rand = new Random(a);
    for (int i = 0; i < 4; i++){
      n = rand.nextInt(9);
      int check = 0;
      //Checks to make sure an int is not being repeated. If repeating is not taking place, the method inputs the integer to the array
      if (n == b[0] || n == b[1] || n == b[2] || n == b[3]){
        check = 1;
      }
      if(check == 1){
        i--;
      }
      else if (check == 0){
        b[i] = n;
      }

    }
    return b;
  }

  public static int getNumOfBulls(int[] a, int[] b){
    //Gets the number of bulls
    int[] result = {0, 0, 0, 0};
    int bulls = 0;
    if (a.length != b.length){
      throw new ArithmeticException("All inputs must be 4 digits");
    }
    for (int i = 0; i < a.length; i++){
      for (int j = 0; j < a.length; j++){
        if (a[i] == a[j] || b[i] == b[j]){
          result[i]++;
        }
        if (result[i] > 1){
          throw new ArithmeticException("digits must not repeat");
        }
      }
    }
    for (int i = 0; i < 4; i++){
      if (a[i] == b[i]){
        bulls++;
      }
    }
    return bulls;
  }

  public static int getNumOfCows(int[] a, int[] b){
    //Get number of cows
    int[] result = {0, 0, 0, 0};
    int cows = 0;
    if (a.length != b.length){
      throw new ArithmeticException("All inputs must be 4 digits");
    }
    for (int i = 0; i < a.length; i++){
      for (int j = 0; j < a.length; j++){
        if (a[i] == a[j] || b[i] == b[j]){
          result[i]++;
        }
        if (result[i] > 1){
          throw new ArithmeticException("digits must not repeat");
        }
      }
    }

    for (int i = 0; i < 4; i++){
      for (int j = 0; j < 4; j++){
        if (a[i] == b[j] && i != j){
          cows++;
        }
      }
    }
    return cows;

}

public static void playBullsAndCows(int a){
  //Initializing variables and generating secret number
  int check = 0;
  int attempts = 0;
  int bulls = 0;
  int cows = 0;
  int digits = 0;
  int divide = 0;
  int[] secret = generateSecretdigits(a);

  //Opens the game with a welcome message and begins the primary loop of inputting guesses
  System.out.println("Welcome to Bulls And Cows! You've been assigned a random 4 digit number and your job is to guess it. Each attempt you will be given cows (the number of digits that are corret but not in the correct place) and bulls (the number of digits you have that are correct and that are in the correct place). Guesses must be 4 digit numbers and digits must not repeat. Please type in your first guess!");
  Scanner guessIn = new Scanner(System.in);
  Scanner quitIn = new Scanner(System.in);

  while (bulls <= 3 && check == 0){
    digits = 0;
    System.out.println("Guess " + attempts + ", please make a 4 digit guess!");
    int guess = guessIn.nextInt();
    divide = guess;
    while (divide > 0){
      divide /= 10;
      digits++;
    }
      //If more than 4 digits are inputted or the guess is a negative integer, an attempt is wasted
    if(guess < 0 || digits > 4 || digits < 4){
      System.out.println("You have wasted an attempt, please input a positive 4 digit integer");
      attempts++;
      System.out.println("Guess " + attempts + ", please make a 4 digit guess!");
      guess = guessIn.nextInt();
    }
    System.out.println("Your guess is: " + guess);
    String temp = Integer.toString(guess);
    int[] guessArr = {0, 0, 0, 0};
    for (int i = 0; i < temp.length(); i++){
      guessArr[i] = temp.charAt(i) - '0';
    }
    //Calls methods to check bulls and cows
    bulls = getNumOfBulls(secret, guessArr);
    System.out.println("Bulls: " + bulls);
    cows = getNumOfCows(secret, guessArr);
    System.out.println("Cows: " + cows);
    attempts++;
    //Checks if over 5 attempts have been made and asks if the player would like to quit
    if (attempts > 5 && bulls != 4){
      System.out.println("You have made 5 attempts, would you like to quit? Input y(Yes) or n(No)");
      String quit = quitIn.nextLine();
      if (quit.equals("y")){
        System.out.println("We hope you have enjoyed the game! You made " + attempts + " attempts!");
        throw new ArithmeticException("Quit");
      }

    }
  }
  //If all digits in guess are in the correct place, the player wins and is congratulated
  if (bulls == 4){
    System.out.println("Congratulations! You win the game! You took " + attempts + " attempts!");
  }

}


}
