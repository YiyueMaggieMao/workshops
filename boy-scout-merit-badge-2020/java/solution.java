import java.util.Random; // Can generate random numbers
import java.util.Scanner;
class Main {
  public static void main(String[] args) {
    java.util.Random rand = new Random();
    Scanner keyboard = new Scanner(System.in);
    
    // Both your HP and the monster's HP start at 100
    int monsterHP = 100;
    int yourHP = 100;

    // Game messages uwu
    System.out.println("You have encountered a big, hairy monster! OwO");

    // Print out the remaining HP
    System.out.println("Your HP: " + yourHP);
    System.out.println("Monster's HP: " + 
      monsterHP);

    // The game goes on as long as both you and 
    // the monster have HP > 0
    while( monsterHP > 0 && yourHP > 0 ){

      // Instruction for the player
      System.out.println("Enter 'a' to attack the monster, 'f' to flee the battle");

      // Get the response of the player
      String response = keyboard.nextLine();
      
      // If the user enters f, the game ends
      if(response.equals("f")){
        System.out.println("You ran away from the monster! :(");
        break;
      }

      // If the user enters a, they choose to attack
      else if(response.equals("a")){

        // We get to attack first, but we are not as strong as the monster! :0

        // Randomly pick our damage from lower than 40
        int yourDamage = rand.nextInt(40);

        // Let the player know of the outcome 
        System.out.println("You inflicted " + yourDamage + " points of damage on the monster!");
        
        // Update monster's HP and print it
        monsterHP = monsterHP - yourDamage;
        System.out.println("Monster's HP: " + 
        monsterHP);

        System.out.println(""); // Just prints out a new line

        // If monster has negative HP, monster will not attack us anymore
        if( monsterHP <= 0 ){
          break;
        }

        // Ask the user to enter anything to continue
        System.out.println("Press [Enter] to continue");
        keyboard.nextLine();
        System.out.println("");
        

        // Randomly pick monster damage from lower than 50
        int monsterDamage = rand.nextInt(50);
        
        // Let the player know of the outcome
        System.out.println("The monster inflicted " + monsterDamage + " points of damage on you!");
        
        // Update player's HP and print it
        yourHP = yourHP - monsterDamage;
        System.out.println("Your HP: " + yourHP);
        System.out.println("");
      }
    }

    // We win if monster has non-positive HP
    if(monsterHP <= 0){
      System.out.println("You defeated the monster! xD");
      System.out.println("Winner winner chicken dinner uwu");
    }

    if(yourHP <= 0){
      System.out.println("The monster made a nice dinner out of you :'(");
      System.out.println("Press F to pay respects...");
    }
    
  }
}