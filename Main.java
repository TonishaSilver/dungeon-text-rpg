import java.util.Random;
import java.util.Scanner;


class Main {
   public static void main(String[] args) {
       // System objects
       Scanner in = new Scanner(System.in);
       Random rand = new Random();
       //Game variables
       String[] enemies = {"Skeleton", "Zombie", "Warrior", "Monster"};
       int maxEnemyHealth = 75;
       int enemyAttackDamage = 25;
       //Player variables
       int health = 100;
       int attackDamage = 50;
       int numHealthPotions = 3;
       int healthPotionHealAmount = 30;
       int healthPotionDropChance = 50; // Percentage of chance that enemy will drop potion
       boolean running = true;
       System.out.println("Welcome to the Dungeon!");

       GAME:
       while (running) {
           System.out.println("------------------------------------------");
           int enemyHealth = rand.nextInt(maxEnemyHealth);
           String enemy = enemies[rand.nextInt(enemies.length)];
           System.out.println("\t# " + enemy + " appeared! #\n");
               // Health Overview + Options
           while(enemyHealth>0) {
               System.out.println("\tYour HP: " + health);
               System.out.println("\t" + enemy + "'s HP: " + enemyHealth);
               System.out.println("\n\tWhat would you like to do?");
               System.out.println("\t1.Attack");
               System.out.println("\t2.Drink health potion");
               System.out.println("\t3.Run!");
               //  User input
               String input = in.nextLine();
               //  Attack
               if(input.equals("1")) {
                 int damageDealt = rand.nextInt(attackDamage) + 1; //Avoids 0 damage
                 int damageTaken = rand.nextInt(enemyAttackDamage) + 1; //Avoids 0 damage
                 enemyHealth -= damageDealt;
                 health -= damageTaken;
                 System.out.println("\t> You strike the " + enemy + " and they lose " + damageDealt + " HP.");
                 System.out.println("\t> The " + enemy + " strikes back in retaliation and you lose " + damageTaken + " HP." );
                 System.out.println("------------------------------------------");
                 if(health < 1) {
                     System.out.println("\t> You have taken too much damage, you are too weak to go on!");
                     break;
                 }
               }
               // Drink Health Potion
               else if(input.equals("2")) {
                   if(numHealthPotions > 0) {
                       health += healthPotionHealAmount;
                       numHealthPotions--;
                       System.out.println("\t> You drink a health potion and regain " + healthPotionHealAmount + " HP." +
                       "\n\t> You now have " + health + "HP." +
                       "\n\t> You now have " + numHealthPotions + " health potions remaining.");
                       System.out.println("------------------------------------------");

                   }
                   else {
                       System.out.println("\t>You do not have any health potions remaining. Defeat an enemy for a chance to gain one!");
                   }
               }
               // Run
               else if(input.equals("3")) {
                   System.out.println("\tYou run away from the " + enemy + "!");
                   System.out.println("------------------------------------------");
                   continue GAME;
               }
               else {
                  System.out.println("\tInvalid command, try again!");
               }
           }
           // Break out the loop:
           if (health < 1) {
               System.out.println("You limp out of the dungeon, weak from battle.");
               break;
           }
           System.out.println("------------------------------------------");
           System.out.println(" # " + enemy + " was defeated! #");
           System.out.println(" # You have " + health + " HP left! #");
           //Health Potion Drop
           if(rand.nextInt(100) < healthPotionDropChance) {
               numHealthPotions++;
               System.out.println(" # The " + enemy + " dropped a health potion! #");
               System.out.println(" # You now have " + numHealthPotions + "health potion(s)! #");
           }
           System.out.println("------------------------------------------");
           System.out.println("What would you like to do now?");
           System.out.println("1. Continue fighting");
           System.out.println("2. Exit dungeon");
           String input = in.nextLine();
           while(!input.equals("1") && !input.equals("2")) {
               System.out.println("Invalid command!");
               input = in.nextLine();
           }
             if(input.equals("1")) {
                 System.out.println("You continue on your adventure!");
                System.out.println("------------------------------------------");
             }  
             else if(input.equals("2")) {
                 System.out.println("You exit the dungeon, successful from your adventure");
                 System.out.println("------------------------------------------");
                 break;
             }
           }
       }

}