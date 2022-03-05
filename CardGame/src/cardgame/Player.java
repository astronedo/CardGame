package cardgame;

public class Player {
    private String username;
    private int age;
    
    public void setName(String name){
        this.username=name;
    }
    public String getName(){
        return this.username;
    }
    public void setAge(int age){
        this.age=age;
    }
    public int getAge(){
        return this.age;
    }
}
