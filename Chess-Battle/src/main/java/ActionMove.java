/**
 * This class extends the Action class and represents an action the user can take where they move their
 * own piece from the first square on the board to the second square on the board.
 *
 * @author Benita Abraham
 * @version 1.0
 */

public class ActionMove extends Action {
    /**
     * This method is a constructor for the ActionMove class
     * @param game game currently playing
     * @param fromRow row index of Piece making Action (From Square)
     * @param fromCol column index of Piece making Action (From Square)
     * @param toRow row index of second board square chosen by player (To Square)
     * @param toCol column index of second board square chosen by player (To Square)
     */
    public ActionMove(GameS22 game, int fromRow, int fromCol, int toRow, int toCol){
        super(game, fromRow, fromCol, toRow, toCol);
    }

    /**
     * Implementation for the abstract performAction method
     */
    @Override
    public void performAction() {
        game.getGameBoard().getSquares()[fromRow][fromCol].getPiece().speak();

        // Board Square Modification
        if (game.getGameBoard().getSquares()[toRow][toCol].isHidden()){
            System.out.println("Uh oh! Trap door! Piece now removed.\n");
            Piece fallen = game.getGameBoard().getSquares()[fromRow][fromCol].removePiece();
            game.getCurrentTeam().removePieceFromTeam(fallen);
        }
        else{
            Piece removed = game.getGameBoard().getSquares()[fromRow][fromCol].removePiece();
            game.getGameBoard().getSquares()[toRow][toCol].setPiece(removed);
        }
        game.changeTurn();
    }
}

