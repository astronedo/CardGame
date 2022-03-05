package cardgame;

import static java.lang.Double.NaN;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner input=new Scanner(System.in);
        System.out.println("Find-A-Match (must be 18 or older)");
        Player player=new Player();
        //------------------------------------NAME
        String name;
        do{
        System.out.println("Enter Name: ");
        name=input.nextLine();
        }while("".equals(name));
        player.setName(name);
        //------------------------------------AGE
        int age;
           try{
           System.out.println("Enter Age: ");
           age=input.nextInt();
           player.setAge(age);
           }catch(Exception e){
               System.out.println("Incorrect Input");
           }
        //------------------------------------GAME
        String[] SUITS = {
            "Clubs", "Diamonds", "Hearts", "Spades"
        };

        String[] RANKS = {
            "2", "3", "4", "5", "6", "7", "8", "9", "10",
            "Jack", "Queen", "King", "Ace"
        };

        // initialize deck
        int n = SUITS.length * RANKS.length;
        String[] deck = new String[n];
        for (int i = 0; i < RANKS.length; i++) {
            for (int j = 0; j < SUITS.length; j++) {
                deck[SUITS.length*i + j] = RANKS[i] + " of " + SUITS[j];
            }
        }

        // shuffle
        for (int i = 0; i < n; i++) {
            int r = i + (int) (Math.random() * (n-i));
            String temp = deck[r];
            deck[r] = deck[i];
            deck[i] = temp;
        }

        // print shuffled deck
        for (int i = 0; i < n; i++) {
            System.out.println(deck[i]);
        }
        
    }
    
}
