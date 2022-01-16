package SnakeAndLadder;
import java.util.Scanner;
import java.util.List;
import java.util.Queue;
import java.util.ArrayList;
import java.util.LinkedList;

public class Driver{
    public static void main(String args[]){
        
        Scanner s = new Scanner(System.in);

        System.out.println("Please enter number of Snakes");
        int numberOfSnakes = s.nextInt();
        List<Snake> snakes = new ArrayList<>();

        for(int i=0;i<numberOfSnakes;i++){
            System.out.println("Please enter start and end of snake "+(i+1));
      
            int start = s.nextInt();
            int end = s.nextInt();

            Snake snakeObject = new Snake(start,end);
            snakes.add(snakeObject);
        }

        System.out.println("Please enter number of Ladders");
        int numberOfLadders = s.nextInt();
        List<Ladder> ladders = new ArrayList<>();

        for(int i=0;i<numberOfLadders;i++){
            System.out.println("Please enter start and end of ladder "+(i+1));
            int start = s.nextInt();
            int end = s.nextInt();

            Ladder ladderObject = new Ladder(start,end);
            ladders.add(ladderObject);
        }

        System.out.println("Please enter number of players");
        int numberOfPlayers = s.nextInt();
        Queue<Player> players = new LinkedList<>();

        for(int i=0;i<numberOfPlayers;i++){
            System.out.println("Please enter the name of Player "+(i+1));
            String name = s.next();
            Player playerObject = new Player(name,1);
            players.add(playerObject);

        }
        SnakeAndLadderBoard snakeAndLadderBoard = new SnakeAndLadderBoard(snakes, ladders, players);
        SnakeAndLadderService.startGame();


    }
}
