// New Action Modification
/**
 * This class extends the Action class. It represents an action the
 *  player can take where the PieceSpanishBuzz moonwalks backwards
 *  and displaces other pieces in its way.
 *
 * @author Samantha Glover
 * @version 1.0
 */

public class ActionMoonwalk extends Action {
    /**
     * Constructor for ActionMoonwalk
     * @param game Game played
     * @param fromRow Index of row of From piece
     * @param fromCol Index of column of From piece
     * @param toRow Index of row of To piece
     * @param toCol Index of column of To piece
     */
    public ActionMoonwalk(GameS22 game, int fromRow, int fromCol, int toRow, int toCol){
        super(game, fromRow, fromCol, toRow, toCol);
    }

    /**
     * Implementation for performAction
     */
    @Override
    public void performAction() {
        game.getGameBoard().getSquares()[fromRow][fromCol].getPiece().speak();

        Piece removed = game.getGameBoard().getSquares()[fromRow][fromCol].removePiece();
        game.getGameBoard().getSquares()[toRow][toCol].setPiece(removed);

        for (int i = 1; i < 3; i++){
            if (!game.getGameBoard().getSquares()[fromRow + i][fromCol].isEmpty()) {
                Piece movePiece = game.getGameBoard().getSquares()[fromRow + i][fromCol].removePiece();
                BoardSquare emptySquare = game.getGameBoard().findRandomEmptySpace();
                emptySquare.setPiece(movePiece);
            }
        }
        game.changeTurn();
    }
}