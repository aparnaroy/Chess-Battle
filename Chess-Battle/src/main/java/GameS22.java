/**
 * This class handles finding if a game has ended and which team has won.
 *
 * @author Aparna Roy
 * @version 1.0
 */

public class GameS22 extends Game {
    /**
     * This is the constructor for GameS22.
     * @param rows  an integer representation of the number of rows on the GameBoard
     * @param columns  an integer representation of the number of columns on the GameBoard
     * @param one  a representation of the first Team in the game
     * @param two  a representation of the second Team in the game
     */
    public GameS22(int rows, int columns, Team one, Team two) {
        super(rows, columns, one, two);
    }

    /**
     * Indicates if there is a winner of the game.
     * @return  a boolean representing if there is a winner
     */
    public boolean isAWinner() {
        if (getWinner() != null) {
            return true;
        }
        else {
            return false;
        }
    }

    // New Objective Modification
    /**
     * Indicates which Team is the winner, which is the Team that attacks 15 times first.
     * @return  a Team representing which team is the winner of the game
     */
    public Team getWinner() {
        if (getCurrentTeam().getTotalNumAttacks() == 15) {
            return getCurrentTeam();
        }
        else if (getOpponentTeam().getTotalNumAttacks() == 15) {
            return getOpponentTeam();
        }
        else {
            return null;
        }
    }

    // New Objective Modification
    /**
     * Indicates if the game has ended or not, which happens when one of the Teams has
     * attacked 15 times, or if both Teams have no more Pieces left on the Board.
     * @return  a boolean representing if the game has ended
     */
    public boolean isGameEnded() {
        if (isAWinner() || getCurrentTeam().getTeamPieces().isEmpty() || getOpponentTeam().getTeamPieces().isEmpty()) {
            return true;
        }
        else {
            return false;
        }
    }
}
