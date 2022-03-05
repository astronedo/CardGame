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
        System.out.println("Enter chosen value: ");
        int chosenValue=input.nextInt();
        String converted=Integer.toString(chosenValue);
        
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
        
        
        //-------------------------------------User Deck
        System.out.println("=================================User Deck");
        
        for(int i=0;i<26;i++){
            userDeck[i]=shufDeck[i];
            System.out.println(userDeck[i]);
            
        }
        System.out.println("====================================Pairs");
        int userScore=0;
        for(int i=0;i<26;i++){//we need a for loop inside for loop for each item inside array to be compared to all items inside array
            char w=userDeck[i].charAt(0);
            String x=String.valueOf(w);
            
            for(int j=0;j<26;j++){
                char y=userDeck[j].charAt(0);
                String z=String.valueOf(y);
                if((x.equals(z))&&(!z.equals(userDeck[j]))){
                    System.out.println("paired from "+ userDeck[i]);
                    if(z.equals(converted)){
                        userScore+=1;
                    }
                }else{}
            }
        }
        System.out.println("The number of total pair of the given value from your deck is "+userScore);
        
        
        
        System.out.println("-------------------Game Board--------------------");
        
        System.out.println("====================================Computer Deck");
        for(int i=0;i<26;i++){
            comDeck[i]=shufDeck[i+26];
            System.out.println(comDeck[i]);
        }
        System.out.println("====================================Pairs");
        String [] result=new String[100];
        int comScore=0;
        for(int i=0;i<26;i++){//we need a for loop inside for loop for each item inside array to be compared to all items inside array
            char w=comDeck[i].charAt(0);
            String x=String.valueOf(w);
            
            for(int j=0;j<26;j++){
                char y=comDeck[j].charAt(0);
                String z=String.valueOf(y);
                if((x.equals(z))&&(!z.equals(comDeck[i]))){
                    
                    System.out.println("paired from "+ comDeck[i]);
                    if(z.equals(converted)){
                        comScore+=1;
                    }
                    
                    
                }else{}
            }
            
        }
        System.out.println("The number of total pair of the given value from your deck is "+comScore);
        

        
    }
    
}
