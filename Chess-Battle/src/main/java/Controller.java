/**
 * This class interacts with View and the Game Model to allow
 * players to play the game.
 *
 * @author Samantha Glover
 * @version 1.0
 */

import java.util.ArrayList;

public class Controller {
    public GameS22 gameplay;
    public TextView view;

    /**
     * Sets up game model
     * @return Game
     */
    public GameS22 setUpGameModel(){
        // Create 4 pieces for team A

        // Load the pieces in an ArrayList
        ArrayList<Piece> piecesTeamA = new ArrayList<>();
        piecesTeamA.add(new PieceMinion('M',"Blu",
                0,0,false,true));
        piecesTeamA.add(new PieceBuzz('B',"Blu",2,1,
                true,false,true));
        piecesTeamA.add(new PieceBlueHen('H',"Blu",3,
                9,false,true));
        piecesTeamA.add(new PieceEvilMinion('E',"Blu",1,
                1,4,false, true));
        piecesTeamA.add(new PiecePowerpuff('P', "Blu",false,true,
                0,0, 0));
        piecesTeamA.add(new PieceSpanishBuzz('S', "Blu", 0,
                0, true,false,true,true,0));
        // Create a team object
        Team teamA = new Team("Blu",piecesTeamA);

        // Create 4 pieces for team B
        // Load the pieces in an ArrayList
        ArrayList<Piece> piecesTeamB = new ArrayList<>();
        piecesTeamB.add(new PieceMinion('M',"Red",
                0,0,false,true));
        piecesTeamB.add(new PieceBlueHen('H',"Red",3,
                9,false,true));
        piecesTeamB.add(new PieceBuzz('B',"Red",2,1,
                true,false,true));
        piecesTeamB.add(new PieceEvilMinion('E',"Red",1,
                1,4,false, true));
        piecesTeamB.add(new PiecePowerpuff('P', "Red",false,true,
                0,0, 0));
        piecesTeamB.add(new PieceSpanishBuzz('S', "Red", 0,
                0, true,false,true,true,0));
        // Create a team object
        Team teamB = new Team("Red",piecesTeamB);

        // Create an instance of the game
        return new GameS22(8, 8,teamA, teamB);
    }

    /**
     * Constructor for controller
     */
    public Controller(){
        this.gameplay = setUpGameModel();
        TextView newView = new TextView();
        this.view = newView;
        newView.updateView(gameplay);
    }

    /**
     * Carries out the action picked by player
     * @param fromRow
     * @param fromCol
     * @param toRow
     * @param toCol
     * @param actionType
     */
    public void carryOutAction(int fromRow, int fromCol, int toRow, int toCol, char actionType){
        if (actionType == 'A'){
            ActionAttack attack = new ActionAttack(gameplay, fromRow, fromCol, toRow, toCol);
            attack.performAction();
        }
        else if (actionType == 'M'){
            ActionMove move = new ActionMove(gameplay, fromRow, fromCol, toRow, toCol);
            move.performAction();
        }
        else if (actionType == 'R'){
            ActionRecruit recruit = new ActionRecruit(gameplay, fromRow, fromCol, toRow, toCol);
            recruit.performAction();
        }
        else if (actionType == 'S'){
            ActionSpawn spawn = new ActionSpawn(gameplay, fromRow, fromCol, toRow, toCol);
            spawn.performAction();
        }
        // New Action Modification
        else if (actionType == 'W'){
            ActionMoonwalk walk = new ActionMoonwalk(gameplay, fromRow, fromCol, toRow, toCol);
            walk.performAction();

        }
    }

    /**
     * Plays the game
     */
    public void playGame(){
        // Board Square Modification
        gameplay.getGameBoard().hiddenSpace();

        boolean gameDone = false;
        while (!gameDone){
            boolean isValid;
            view.getNextPlayersAction(gameplay);
            isValid = Rules.checkValidAction(gameplay, view.fromRow, view.fromCol, view.toRow, view.toCol, view.actionType);
            while(!isValid){
                System.out.println("Action not valid. Try again: ");
                view.getNextPlayersAction(gameplay);
                isValid = Rules.checkValidAction(gameplay, view.fromRow, view.fromCol, view.toRow, view.toCol, view.actionType);
            }
            carryOutAction(view.fromRow, view.fromCol, view.toRow, view.toCol, view.actionType);
            view.updateView(gameplay);
            if (gameplay.isGameEnded()){
                gameDone = true;
            }
        }
        view.printEndOfGameMessage(gameplay);
    }

    /**
     * Main method
     * @param args
     */
    public static void main (String[] args){
        Controller control = new Controller();
        control.playGame();
    }
}
