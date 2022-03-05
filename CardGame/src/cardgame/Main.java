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
        
        
        
    }
    
}
