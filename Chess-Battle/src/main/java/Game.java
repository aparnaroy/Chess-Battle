/**
 * This class represents the game.
 *
 * @author Aparna Roy
 * @version 1.0
 */

import java.util.Collections;

public abstract class Game {
    // Attributes
    private GameBoard board;
    private Team one;
    private Team two;
    private String turn;

    public abstract boolean isAWinner();
    public abstract Team getWinner();
    public abstract boolean isGameEnded();

    /**
     * Creates a new board for the game and sets it with the inputted number
     * of rows and columns.
     * @param rows Number of rows on game board
     * @param columns Number of columns on game board
     */
    private void initializeGameBoard(int rows, int columns) {
        this.board = new GameBoard(rows, columns);

        BoardSquare emptyBoardSquare;
        for (Piece aPiece : this.one.getTeamPieces()) {
            emptyBoardSquare = this.board.findRandomEmptySpace();
            emptyBoardSquare.setPiece(aPiece);
        }

        for (Piece aPiece : this.two.getTeamPieces()) {
            emptyBoardSquare = this.board.findRandomEmptySpace();
            emptyBoardSquare.setPiece(aPiece);
        }
    }

    // Constructor
    /**
     * This is the constructor for Game.
     * @param rows  an integer representation of the number of rows on the GameBoard
     * @param columns  an integer representation of the number of columns on the GameBoard
     * @param one  a representation of the first Team in the game
     * @param two  a representation of the second Team in the game
     */
    public Game(int rows, int columns, Team one, Team two) {
        this.one = one;
        this.two = two;
        this.turn = one.getTeamColor();
        initializeGameBoard(rows, columns);
    }

    // Accessor Methods
    /**
     * Gets the GameBoard of the Game.
     * @return  a GameBoard that represents the board of the Game
     */
    public GameBoard getGameBoard() {
        return this.board;
    }

    /**
     * Gets the Team whose turn it currently is in the Game.
     * @return  the Team whose turn it is
     */
    public Team getCurrentTeam() {
        if (this.turn.equals(one.getTeamColor())) {
            return one;
        }
        else {
            return two;
        }
    }

    /**
     * Gets the Team whose turn it currently isn't in the Game.
     * @return  the Team whose turn it isn't
     */
    public Team getOpponentTeam() {
        if (this.turn.equals(one.getTeamColor())) {
            return two;
        }
        else {
            return one;
        }
    }

    /**
     * Gets if it is currently the turn of a given Team in the Game.
     * @param aTeam  a given Team
     * @return  a boolean representing if it is the turn of the given Team
     */
    public boolean isTurn(Team aTeam) {
        return this.turn.equals(aTeam.getTeamColor());
    }

    /**
     * Gets the 2D array of all the BoardSquares on the GameBoard for this Game.
     * @return  a 2D array of BoardSquares
     */
    public BoardSquare[][] getBoardSquares() {
        return this.getGameBoard().getSquares();
    }

    // Mutator Method
    /**
     * Sets the turn to the other Team.
     */
    public void changeTurn() {
        if (this.turn.equals(one.getTeamColor())) {
            this.turn = two.getTeamColor();
        }
        else {
            this.turn = one.getTeamColor();
        }
    }

    // Overriding the toString() method
    /**
     * Overrides the toString() method of the Object class.
     * @return  a String that describes the Game
     */
    @Override
    public String toString(){
        StringBuilder retString = new StringBuilder();
        retString.append("Game Board:\n")
                .append(String.join("", Collections.nCopies(10 + board.getNumColumns()*8, "*")))
                .append("\n" + getGameBoard().toString())
                .append(String.join("", Collections.nCopies(10 + board.getNumColumns()*8, "*")))
                .append("\n" + getCurrentTeam().toString() + "\n")
                .append(String.join("", Collections.nCopies(10 + board.getNumColumns()*8, "*")))
                .append("\n" + getOpponentTeam().toString() + "\n")
                .append(String.join("", Collections.nCopies(10 + board.getNumColumns()*8, "*")))
                .append("\nIt is Team " + getCurrentTeam().getTeamColor() + "'s turn\n");
        return retString.toString();
    }
}
