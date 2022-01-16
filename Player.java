package SnakeAndLadder;
import java.util.UUID;

public class Player{
    private String name;
    private String id;
    private int position;

    Player(String name,int position){
        this.name = name;
        id = UUID.randomUUID().toString();
        this.position = position;
    }

    String getName(){
        return name;
    }

    String getId(){
        return id;
    } 

    int getPosition(){
        return position;
    }

    void setPosition(int position){
        this.position = position;
    }


}