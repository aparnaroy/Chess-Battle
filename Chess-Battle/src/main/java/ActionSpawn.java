/**
 * This class represents an action the player can take where they create a copy of their own piece on the
 * From Square and put it on the To Square.
 * @author Benita Abraham
 * @version 05/02/22
 */

public class ActionSpawn extends Action {
    /**
     * This method is a constructor for the ActionSpawn class
     * @param game game currently playing
     * @param fromRow row index of Piece making Action (From Square)
     * @param fromCol column index of Piece making Action (From Square)
     * @param toRow row index of second board square chosen by player (To Square)
     * @param toCol column index of second board square chosen by player (To Square)
     */
    public ActionSpawn(GameS22 game, int fromRow, int fromCol, int toRow, int toCol){
        super(game, fromRow, fromCol, toRow, toCol);
    }

    /**
     * Implementation for abstract performAction
     */
    @Override
    public void performAction() {
        game.getGameBoard().getSquares()[fromRow][fromCol].getPiece().speak();
        Piece spawned = game.getGameBoard().getSquares()[fromRow][fromCol].getPiece().spawn();
        game.getCurrentTeam().addPieceToTeam(spawned);
        game.getGameBoard().getSquares()[toRow][toCol].setPiece(spawned);
        game.changeTurn();
    }
}

