package cardgame;

import static java.lang.Double.NaN;
import java.util.Scanner;

public class Main {
    public static String [] userDeck=new String[26];
    public static String [] comDeck=new String[26];//COMPUTER DECK

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
        //------------------------------------Deck of Card Generator
        String[] SUITS = {
            "Clubs", "Diamonds", "Hearts", "Spades"
        };

        String[] VALUES = {
            "2", "3", "4", "5", "6", "7", "8", "9", "10",
            "Jack", "Queen", "King", "Ace"
        };

        // initialize deck
        int n = SUITS.length * VALUES.length;
        String[] deck = new String[n];
        for (int i = 0; i < VALUES.length; i++) {
            for (int j = 0; j < SUITS.length; j++) {
                deck[SUITS.length*i + j] = VALUES[i] + " of " + SUITS[j];
            }
        }

        // shuffle
        for (int i = 0; i < n; i++) {
            int r = i + (int) (Math.random() * (n-i));
            String temp = deck[r];
            deck[r] = deck[i];
            deck[i] = temp;
        }
        
        //The shuffled cards will be on a new array[]
        //after creating the card identities, the card is shuffled, then I stored the shuffled cards into an array to make it its own identity
        
        String [] shufDeck=new String[n];
        for(int i=0;i<n;i++){
            shufDeck[i]=deck[i];
        }
        
        
        //-------------------------------------Deck splitter
        
        for(int i=0;i<26;i++){
            userDeck[i]=shufDeck[i];
            System.out.println(userDeck[i]);
        }
        
        System.out.println("-------------------Split---------------");
        for(int i=0;i<26;i++){
            comDeck[i]=shufDeck[i+26];
            System.out.println(comDeck[i]);
        }
        
       
        
        
        
        
        
        
        
        
    }
    
}
