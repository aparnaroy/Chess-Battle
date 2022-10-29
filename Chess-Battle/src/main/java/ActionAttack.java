/**
 * This class extends the Action class. It represents an action the
 * player can take where they attack another piece on the To square
 * with their own piece on the From square.
 *
 * @author Samantha Glover
 * @version 1.0
 */

public class ActionAttack extends Action {
    /**
     * Constructor for ActionAttack
     * @param game Game played
     * @param fromRow Index of row of From piece
     * @param fromCol Index of column of From piece
     * @param toRow Index of row of To piece
     * @param toCol Index of column of To piece
     */
    public ActionAttack(GameS22 game, int fromRow, int fromCol, int toRow, int toCol) {
        super(game, fromRow, fromCol, toRow, toCol);
    }

    /**
     * Implementation for the abstract performAction method
     */
    @Override
    public void performAction(){
        // New Rule Modification
        int numAttacks = 0;

        if (game.getBoardSquares()[fromRow][fromCol].getPiece().getSymbol() == 'B') {
            PieceBuzz buzz = (PieceBuzz)game.getBoardSquares()[fromRow][fromCol].getPiece();
            buzz.setNumAttacks(buzz.getNumAttacks() + 1);
            numAttacks = buzz.getNumAttacks();
        }
        else if (game.getBoardSquares()[fromRow][fromCol].getPiece().getSymbol() == 'E') {
            PieceEvilMinion evilMinion = (PieceEvilMinion)game.getBoardSquares()[fromRow][fromCol].getPiece();
            evilMinion.setNumAttacks(evilMinion.getNumAttacks() + 1);
            numAttacks = evilMinion.getNumAttacks();
        }
        else if (game.getBoardSquares()[fromRow][fromCol].getPiece().getSymbol() == 'H') {
            PieceBlueHen hen = (PieceBlueHen)game.getBoardSquares()[fromRow][fromCol].getPiece();
            hen.setNumAttacks(hen.getNumAttacks() + 1);
            numAttacks = hen.getNumAttacks();
        }
        else if (game.getBoardSquares()[fromRow][fromCol].getPiece().getSymbol() == 'P') {
            PiecePowerpuff powerpuff = (PiecePowerpuff)game.getBoardSquares()[fromRow][fromCol].getPiece();
            powerpuff.setNumAttacks(powerpuff.getNumAttacks() + 1);
            numAttacks = powerpuff.getNumAttacks();
        }
        else if (game.getBoardSquares()[fromRow][fromCol].getPiece().getSymbol() == 'S') {
            PieceSpanishBuzz spanishBuzz = (PieceSpanishBuzz)game.getBoardSquares()[fromRow][fromCol].getPiece();
            spanishBuzz.setNumAttacks(spanishBuzz.getNumAttacks() + 1);
            numAttacks = spanishBuzz.getNumAttacks();
        }

        // New Objective Modification
        game.getCurrentTeam().setTotalNumAttacks(game.getCurrentTeam().getTotalNumAttacks() + 1);

        if (game.getBoardSquares()[fromRow][fromCol].getPiece().getSymbol() == 'E'){
            if ((game.getBoardSquares()[toRow][toCol].getPiece().getTeamColor() == game.getCurrentTeam().getTeamColor()) &&
                    (game.getBoardSquares()[toRow][toCol].getPiece().getSymbol() == 'M')){
                game.getBoardSquares()[fromRow][fromRow].getPiece().speak();
                Piece attacked = game.getBoardSquares()[toRow][toCol].removePiece();
                game.getCurrentTeam().removePieceFromTeam(attacked);
                PieceEvilMinion newEvil = new PieceEvilMinion();
                game.getCurrentTeam().addPieceToTeam(newEvil);
                game.getBoardSquares()[toRow][toCol].setPiece(newEvil);
                // New Rule Modification
                if (numAttacks != 5) {
                    game.changeTurn();
                }
                else {
                    System.out.println("\nThe attacking piece has attacked 5 times, so this team gets another turn!\n");
                }
            }
            else {
                game.getBoardSquares()[fromRow][fromCol].getPiece().speak();
                Piece attacked = game.getBoardSquares()[toRow][toCol].removePiece();
                game.getOpponentTeam().removePieceFromTeam(attacked);
                Piece from = game.getBoardSquares()[fromRow][fromCol].removePiece();
                game.getGameBoard().getSquares()[toRow][toCol].setPiece(from);
                // New Rule Modification
                if (numAttacks != 5) {
                    game.changeTurn();
                }
                else {
                    System.out.println("\nThe attacking piece has attacked 5 times, so this team gets another turn!\n");
                }
            }
        }
        else {
            game.getBoardSquares()[fromRow][fromCol].getPiece().speak();
            Piece attacked = game.getBoardSquares()[toRow][toCol].removePiece();
            game.getOpponentTeam().removePieceFromTeam(attacked);
            Piece from = game.getBoardSquares()[fromRow][fromCol].removePiece();
            game.getGameBoard().getSquares()[toRow][toCol].setPiece(from);
            // New Rule Modification
            if (numAttacks != 5) {
                game.changeTurn();
            }
            else {
                System.out.println("\nThe attacking piece has attacked 5 times, so this team gets another turn!\n");
            }
        }
    }
}