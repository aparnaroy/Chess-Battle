/**
 * This class provides a text-based interface to the players so that
 * they can view and play the game.
 *
 * @author Samantha Glover
 * @version 1.0
 */

import java.util.Scanner;

public class TextView {
    public int fromRow;
    public int fromCol;
    public int toRow;
    public int toCol;
    public char actionType;

    /**
     * Getter for row of From square
     * @return index
     */
    public int getFromRow() {
        return fromRow;
    }

    /**
     * Getter for column of From square
     * @return Index
     */
    public int getFromCol() {
        return fromCol;
    }

    /**
     * Getter for row of To square
     * @return Index
     */
    public int getToRow() {
        return toRow;
    }

    /**
     * Getter for row of To square
     * @return Index
     */
    public int getToCol(){
        return toCol;
    }

    /**
     * Getter for action type
     * @return Action type
     */
    public char getActionType() {
        return actionType;
    }

    /**
     * Continually asks user to enter one of the following character values:
     * A (representing attack)
     * M (representing move)
     * R (representing recruit)
     * S (representing spawn)
     * W (representing moonwalk)
     * @param scr User input
     * @return First character from the list entered by the user. If a user
     * enters text that begins with one of the valid characters, the method
     * returns that character.
     */
    public char getUsersNextActionType(Scanner scr){
        scr = new Scanner(System.in);
        boolean validValue = false;
        String userInput;
        char characterMove = 0;

        // New Action Modification
        while (!validValue){
            System.out.println("Enter A for attack, M for move, R for recruit, " +
                    "S for spawn, or W for moonwalk (SpanishBuzz only): ");
            if (scr.hasNext()){
                userInput = scr.next();
                characterMove = userInput.charAt(0);
                if (characterMove == 'A'){
                    validValue = true;
                }
                else if (characterMove == 'M'){
                    validValue = true;
                }
                else if (characterMove == 'R'){
                    validValue = true;
                }
                else if (characterMove == 'S'){
                    validValue = true;
                }
                else if (characterMove == 'W'){
                    validValue = true;
                }
                else{
                    System.out.println("Did not enter a valid move. Enter A, M, " +
                            "R, S, or W: ");
                }
            }
            else{
                System.out.println("Input too long. Enter only a single character: ");
            }
        }
        return characterMove;
    }

    /**
     * Continues to ask the user to enter an integer in the range
     * until the user enters an integer in that range. The first entry
     * that is in range is returned.
     * @param minimumInt Minimum integer value allowed to be entered by user
     * @param maximumInt Maximum integer value allowed to be entered by user
     * @param scr User input
     * @return First integer in range entered by the user
     */
    public int getValidInt(int minimumInt, int maximumInt, Scanner scr) {
        scr = new Scanner(System.in);
        boolean validValue = false;
        int userInput = 0;

        while (!validValue){
            System.out.print("(an integer between " + minimumInt +
                    " to " + maximumInt + "): ");
            if (scr.hasNextInt()){
                userInput = scr.nextInt();
                if (userInput >= minimumInt && userInput <= maximumInt){
                    validValue = true;
                }
                else{
                    System.out.println("Integer not in valid range. Try again: ");
                }
            }
            else{
                scr.next();
                System.out.println("Did not enter an integer. Try again: " );
            }
        }
        return userInput;
    }

    /**
     * Gets the player's next actions
     * @param game Game played
     */
    public void getNextPlayersAction(GameS22 game){
        Scanner scr = new Scanner(System.in);
        actionType = getUsersNextActionType(scr);
        System.out.print("Enter the Row index of the From square ");
        fromRow = getValidInt(0, game.getGameBoard().getNumRows() - 1, scr);
        System.out.print("Enter the Column index of the From square ");
        fromCol = getValidInt(0, game.getGameBoard().getNumColumns() - 1, scr);
        System.out.print("Enter the Row index of the To square ");
        toRow = getValidInt(0, game.getGameBoard().getNumRows() - 1, scr);
        System.out.print("Enter the Column index of the To square ");
        toCol = getValidInt(0, game.getGameBoard().getNumRows() - 1, scr);
    }

    /**
     * Prints the game object
     * @param game
     */
    public void updateView(Game game) {
        System.out.println(game);
    }

    // New Objective Modification
    /**
     * Displays a message stating the game ended and which team won
     * @param game
     */
    public void printEndOfGameMessage (Game game){
        if (game.getWinner() == null) {
            System.out.println("The game has ended and no one has won.");
        }
        else {
            System.out.println("The game has ended and Team " + game.getWinner().getTeamColor() + " has won!");
        }
    }
}