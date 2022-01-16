package SnakeAndLadder;
import java.util.List;
import java.util.Queue;


public class SnakeAndLadderService{

    
    private static final int DEFAULT_BOARD_SIZE = 100;
    private static boolean gameCompleted = false;

   

    static boolean newPositionEqualToSnakeOrLadderStart(Player player,List<Snake> snakes,List<Ladder> ladders,int location){
        
        
        
        for(int i=0;i<snakes.size();i++){
            if(snakes.get(i).getStart() == location)
            {
                System.out.println(player.getName()+" got hit by a snake at "+location);
                return true;
             }
         }

        for(int i=0;i<ladders.size();i++){
            if(ladders.get(i).getStart() == location)
                {
                    System.out.println(player.getName()+" got a ladder to climb at "+location);    
                    return true;
                }
        }

        return false;
    }

    static void checkWinSituation(int position){
        if(position == DEFAULT_BOARD_SIZE)
            gameCompleted = true;
    }

    static void makeMove(Player player){
        String playerId = player.getId();
        int oldPosition = player.getPosition();
        int diceRoll = DiceRollService.rollDice();
        System.out.println(player.getName()+" got a "+diceRoll);
        int newPosition = diceRoll + oldPosition;
        
        if(newPosition > DEFAULT_BOARD_SIZE){
            System.out.println("Exceeded DEFAULT_BOARD_SIZE");
            return;
        }



        List<Snake> snakes = SnakeAndLadderBoard.getSnakes();
        List<Ladder> ladders = SnakeAndLadderBoard.getLadders();

        do{
            for(int i = 0;i<snakes.size();i++){
                if(snakes.get(i).getStart() == newPosition){
                    System.out.println(player.getName()+" got hit by a snake at "+newPosition);
                    newPosition = snakes.get(i).getEnd();
                }
            }

            for(int i = 0;i<ladders.size();i++){
                if(ladders.get(i).getStart() == newPosition){
                    System.out.println(player.getName()+" got a ladder to climb at "+newPosition);    
                    newPosition = ladders.get(i).getEnd();
                }
            }

        
        }while(newPositionEqualToSnakeOrLadderStart(player,snakes,ladders,newPosition));

        player.setPosition(newPosition);
        checkWinSituation(newPosition);

        return;
    }

   

    static void startGame(){
       
       Player currentPlayer;
       Queue<Player> players = SnakeAndLadderBoard.getPlayers();

       while(players.size()>0){
           currentPlayer = players.poll();
           System.out.println("Its turn of "+currentPlayer.getName());
           int oldPosition = currentPlayer.getPosition();
           makeMove(currentPlayer);
           if(gameCompleted)
                {
                   System.out.println(currentPlayer.getName()+" moves to "+currentPlayer.getPosition()+" and wins the game");
                   return;     
                }
            else{
                    int newPosition = currentPlayer.getPosition();
                    System.out.println(currentPlayer.getName()+" moved from "+oldPosition+" to "+newPosition);
                    players.add(currentPlayer);
                }
        }
       
        

    }
}