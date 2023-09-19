public class CoinMachine {
  public static void main (String[] args) {
    // Initializing variables to keep track of coins
    int quarters = 0;
    int toonies = 0;
    int loonies = 0;
    int dimes = 0;
    int nickels = 0;
    int pennies = 0;

    
    // Converting args to ints and storing them in variables
    int cash = Integer.parseInt(args[0]);
    int price =Integer.parseInt(args[1]);
    
    System.out.println("Amount received: " + cash);
    System.out.println("Cost of the item " + price);

    // Calculating difference of cash and price
    int need = cash - price;
    System.out.println("Required change: " + need);


    // adding toonies to change
    while(need >= 200){
      need -= 200;
      toonies += 1;
    }
    System.out.println("\nToonies x " + toonies);

    // adding loonies to change
    while(need >= 100){
      need -= 100;
      loonies += 1;
    }
    System.out.println("Loonies x " + loonies);

    // adding quarters to change
    while(need >= 25){
      need -= 25;
      quarters += 1;
    }
    System.out.println("Quarters x " + quarters);

    // adding dimes to change
    while(need >= 10){
      need -= 10;
      dimes += 1;
    }
    System.out.println("Dimes x " + dimes);


    // adding nickels to change
    while(need >= 5){
      need -= 5;
      nickels += 1;
    }
    System.out.println("Nickels x " + nickels);

    while(need >= 1){
      need -= 1;
      pennies += 1;
    }
    System.out.println("Pennies x " + pennies);

  }
}