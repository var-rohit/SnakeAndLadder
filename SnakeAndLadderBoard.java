package SnakeAndLadder;
import java.util.List;
import java.util.Queue;

public class SnakeAndLadderBoard{

    private static List<Snake> snakes;
    private static List<Ladder> ladders;
    private static Queue<Player> players;

    SnakeAndLadderBoard(List<Snake> snakes,List<Ladder> ladders,Queue<Player> players){
        this.snakes = snakes;
        this.ladders = ladders;
        this.players = players;
    }

    static List<Snake> getSnakes(){
        return snakes;
    }

    static List<Ladder> getLadders(){
        return ladders;
    }

    static Queue<Player> getPlayers(){
        return players;
    }

    void setSnakes(List<Snake> snakes){
        this.snakes = snakes;
    }

    void setLadders(List<Ladder> ladders){
        this.ladders = ladders;
    }

    void setPlayers(Queue<Player>  players){
        this.players = players;
    }


}