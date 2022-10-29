/**
 * This class represents the Game Board which
 * our pieces will be placed upon.
 *
 * @auuthor Samantha Glover
 * @version 1.0
 */

public class GameBoard {
    // Attributes
    private int rows;
    private int columns;
    private BoardSquare[][] squares;

    /**
     * Constructor that accepts the rows and columns and
     * sets those properties. Also creates a new 2D array
     * using rows and columns.
     * @param rows Number of rows
     * @param columns Number of columns
     */
    public GameBoard(int rows, int columns){
        this.rows = rows;
        this.columns = columns;
        this.squares = new BoardSquare[rows][columns];
        setUpEmptyBoard();
    }

    /**
     * Getter for rows property
     * @return Number of rows
     */
    public int getNumRows(){
        return this.rows;
    }

    /**
     * Getter for columns property
     * @return Number of columns
     */
    public int getNumColumns(){
        return this.columns;
    }

    /**
     * Getter for squares property
     * @return Board square
     */
    public BoardSquare[][] getSquares() {
        return this.squares;
    }

    /**
     * Represents whether the location of the space is within the
     * bounds of the board
     * @param rowIndex Index of the row
     * @param colIndex Index of the column
     * @return Whether or not the location is in bound
     */
    public boolean inBounds(int rowIndex, int colIndex){
        boolean isInBound = true;
        if (rowIndex < 0 || colIndex < 0){
            isInBound = false;
        }
        else if (rowIndex >= getNumRows()){
            isInBound = false;
        }
        else if (colIndex >= getNumColumns()){
            isInBound = false;
        }
        return isInBound;
    }

    /**
     * Sets up an empty board with alternating colored squares
     */
    private void setUpEmptyBoard(){
        for (int i = 0; i < getNumRows(); i++){
            for (int j = 0; j < getNumColumns(); j++){
                if ((getNumRows() + getNumColumns()) % 2 == 0){
                    squares[i][j] = new BoardSquare("black");
                }
                else {
                    squares[i][j] = new BoardSquare("red");
                }
            }
        }
    }

    /**
     * Generates random row and column indexes and sees whether
     * the location on the Board is empty
     * @return BoardSquare if the spot is empty
     */
    public BoardSquare findRandomEmptySpace(){
        boolean isSpaceEmpty = false;
        int rowIndex = (int)(Math.random() * (getNumRows()-1));
        int colIndex = (int)(Math.random() * (getNumColumns()-1));
        while (!isSpaceEmpty){
            if (squares[rowIndex][colIndex].isEmpty()){
                isSpaceEmpty = true;
            }
            else {
                rowIndex = (int)(Math.random() * (getNumRows()-1));
                colIndex = (int)(Math.random() * (getNumColumns()-1));
            }
        }
        return squares[rowIndex][colIndex];
    }

    // Board Square Modification
    /**
     * Creates a random trap door on the board
     */
    public void hiddenSpace(){
        int rowIndex = (int)(Math.random() * (getNumRows()-1));
        int colIndex = (int)(Math.random() * (getNumColumns()-1));
        //squares[rowIndex][colIndex].setHidden(true);
        squares[0][0].setHidden(true);
    }

    /**
     * Overrides toString method
     * @return Updated string
     */
    @Override
    public String toString(){
        StringBuilder boardString = new StringBuilder();
        boardString.append("Col :       ");

        for(int col = 0; col < squares[0].length; col++){
            boardString.append(col + "        ");
        }
        boardString.append("\n");
        for(int row = 0; row < squares.length; row++){
            boardString.append("Row : " + row + "   ");
            for(int col = 0; col < squares[row].length; col++){
                boardString.append(squares[row][col].toString() + "  ");
            }
            boardString.append("\n");
        }
        return boardString.toString();
    }
}
