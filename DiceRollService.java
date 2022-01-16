package SnakeAndLadder;
import java.util.Random;

public class DiceRollService{

    public static int rollDice(){
        return new Random().nextInt(6) + 1;
    }
}