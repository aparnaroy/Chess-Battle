/**
 * This class represents each space on a game board.
 *
 * @author Samantha Glover
 * @version 1.0
 */

public class BoardSquare {
    // Attributes
    private boolean isEmpty;
    private Piece squarePiece;
    private String squareColor;

    // Board Square Modification
    private boolean isHidden;

    /**
     * Getter for isHidden property
     * @return isHidden
     */
    public boolean isHidden() {
        return this.isHidden;
    }

    /**
     * Setter for isHidden
     * @param isHidden If the square is "hidden"
     */
    public void setHidden(boolean isHidden){
        this.isHidden = isHidden;
    }

    /**
     * Constructor that accepts the color and sets the property
     * @param squareColor Color of the square
     */
    public BoardSquare(String squareColor){
        this.squareColor = squareColor;
        this.isEmpty = true;
    }

    /**
     * Getter for the squarePiece property
     * @return Piece on the square
     */
    public Piece getPiece(){
        return this.squarePiece;
    }

    /**
     * Getter for the isEmpty property
     * @return Whether the space is empty or not
     */
    public boolean isEmpty(){
        return this.isEmpty;
    }

    /**
     * Getter for the squareColor property
     * @return Color of the square
     */
    public String getSquareColor(){
        return this.squareColor;
    }

    /**
     * Mutator for the squarePiece property. Sets a piece on
     * a square.
     * @param squarePiece Piece that is located on the square
     */
    public void setPiece(Piece squarePiece){
        this.squarePiece = squarePiece;
        this.isEmpty = false;
    }

    /**
     * Removes a Piece and updates the Piece
     * to null and empty member fields.
     * @return Piece that is on the square
     */
    public Piece removePiece(){
        Piece temp = squarePiece;
        squarePiece = null;
        this.isEmpty = true;
        return temp;
    }

    /**
     * Overrides the toString method
     * @return Updated string
     */
    @Override
    public String toString(){
        if (isEmpty){
            return "-------";
        }
        else{
            return "-" + squarePiece.toString() + "-";
        }
    }
}