/**
 * This class extends the Action class and it represents an action
 * the player can take where they recruit an opponent's piece on the
 * To square with their own piece on the From square.
 *
 * @author Samantha Glover
 * @version 1.0
 */

public class ActionRecruit extends Action{
    /**
     * Constructor for the ActionRecruit class
     * @param game Game played
     * @param fromRow Index of row of From piece
     * @param fromCol Index of column of From piece
     * @param toRow Index of row of To piece
     * @param toCol Index of column of To piece
     */
    public ActionRecruit(GameS22 game, int fromRow, int fromCol, int toRow, int toCol) {
        super(game, fromRow, fromCol, toRow, toCol);
    }

    /**
     * Implementation for the abstract performAction method
     */
    @Override
    public void performAction() {
        game.getGameBoard().getSquares()[fromRow][fromCol].getPiece().speak();
        Piece add = game.getGameBoard().getSquares()[toRow][toCol].getPiece();
        game.getOpponentTeam().removePieceFromTeam(add);
        game.getCurrentTeam().addPieceToTeam(add);
        game.changeTurn();
    }
}


