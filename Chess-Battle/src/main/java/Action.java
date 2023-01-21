/**
 * This class represents actions that the players can make during their turn.
 * @author Benita Abraham
 * @version 05/02/22
 */

public abstract class Action {
    protected GameS22 game;
    protected int fromRow;
    protected int fromCol;
    protected int toRow;
    protected int toCol;

    /**
     * This method is a constructor for the Action class
     * @param game game currently playing
     * @param fromRow row index of Piece making Action (From Square)
     * @param fromCol column index of Piece making Action (From Square)
     * @param toRow row index of second board square chosen by player (To Square)
     * @param toCol column index of second board square chosen by player (To Square)
     */
    public Action(GameS22 game, int fromRow, int fromCol, int toRow, int toCol){
        this.game = game;
        this.fromRow = fromRow;
        this.fromCol = fromCol;
        this.toRow = toRow;
        this.toCol = toCol;
    }

    /**
     * Abstract method that performs the action specified
     */
    public abstract void performAction();
}
