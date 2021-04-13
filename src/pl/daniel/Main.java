package pl.daniel;

import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        String[] enemies = {"Skeleton", "Zombie", "Assassin", "Warrior"};
        int maxEnemyHealth = 75;
        int enemiesAttackDamage = 25;

        int health = 100;
        int attackDamage = 50;
        int numHealthPotion = 3;
        int healthPotionHealAmount = 30;
        int healthPotionDropChanse = 50;

        boolean running = true;

        System.out.println("Welcome to the Dungeon");

        GAME:
        while (running) {
            System.out.println("-----------------------------------------------");

            int enemyHealth = random.nextInt(maxEnemyHealth);
            String enemy = enemies[random.nextInt(enemies.length)];
            System.out.println("\t# " + enemy + " has appeared!" + "\t#");

            while (enemyHealth > 0) {
                System.out.println("\tYour HP: " + health);
                System.out.println("\t" + enemy + "s HP: " + enemyHealth);
                System.out.println("\n\tWhat would you like to do?");
                System.out.println("\t1. Attack");
                System.out.println("\t2. Drink health potion");
                System.out.println("\t3. Run!");

                String input = scanner.nextLine();

                if (input.equals("1")) {
                    System.out.println("\t^^^^^^^^^^^^^^^^^");
                    int damageDealt = random.nextInt(attackDamage);
                    int damageTaken = random.nextInt(enemiesAttackDamage);

                    enemyHealth -= damageDealt;
                    health -= damageTaken;

                    System.out.println("\t>You hit for " + enemy + " for " + damageDealt + " damage.");
                    System.out.println("\t>You racieve " + damageTaken + " in retaliation.");

                    if (health < 1) {
                        System.out.println("\t>You take too much damage, you are too weak to go on!");
                        break;
                    }

                } else if (input.equals("2")) {
                    System.out.println("\t^^^^^^^^^^^^^^^^^");
                    if (numHealthPotion > 0) {
                        health += healthPotionHealAmount;
                        numHealthPotion--;
                        System.out.println("\t> You drink heal potion and healing yourself for: " + healthPotionHealAmount + "."
                                + "\n\t> You have now " + health + "HP."
                                + "\n\t> You have " + numHealthPotion + " health potion(s) left.");
                    } else {
                        System.out.println("You have no health potions left. Defeat enemies for a chance to get one.");
                    }

                } else if (input.equals("3")) {
                    System.out.println("You run away for the " + enemy + ".");
                    continue GAME;

                } else {
                    System.out.println("\tInvalid command.");

                }
            }
            if (health < 1) {
                System.out.println("\t>You limp out of the dungeon, weak from battle.");
                break;
            }
            System.out.println("-----------------------------------------------");
            System.out.println(" # " + enemy + " was defeated! #");
            System.out.println(" # You have " + health + " HP left #");
            if (random.nextInt(100) > healthPotionDropChanse) {
                numHealthPotion++;
                System.out.println(" # The " + enemy + " dropped a health potion! #");
                System.out.println(" # You now have " + numHealthPotion + " potion(s). #");
            }
            System.out.println("-----------------------------------------------");
            System.out.println("What would you like to do now?");
            System.out.println("1. Continue fighting.");
            System.out.println("2. Exit form dungeon.");

            String input = scanner.nextLine();
            while (!input.equals("1") && !input.equals("2")) {
                System.out.println("Invalid command!");
                input = scanner.nextLine();
            }
            if (input.equals("1")) {
                System.out.println("You continue your adventure.");
            } else if (input.equals("2")) {
                System.out.println("You exit the dungeon.");
                break;
            }
        }
        System.out.println("##########################");
        System.out.println("# THANK YOU FOR PLAYING! #");
        System.out.println("##########################");
    }
}
