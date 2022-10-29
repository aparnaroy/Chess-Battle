/**
 * This class is an abstract class for all the game pieces. It contains properties that are similar among
 * PieceBlueHen, PieceMinion, and PieceBuzz.
 * @author Benita Abraham
 * @version 04/06/2022
 */

public abstract class Piece implements Comparable<Piece> {
    protected char symbol;
    protected String teamColor;
    protected boolean hidden;
    protected boolean original;

    /**
     * This method is a constructor for Piece
     * @param symbol a character representing the piece
     * @param teamColor the team's color
     * @param hidden whether the piece is hidden or not
     * @param original whether the piece is original
     */
    public Piece(char symbol, String teamColor, boolean hidden, boolean original){
        this.symbol = symbol;
        this.teamColor = teamColor;
        this.hidden = hidden;
        this.original = original;
    }

    /**
     * This method is a getter for the symbol property
     * @return the piece's symbol
     */
    public char getSymbol() {
        return symbol;
    }

    /**
     * This method is a getter for the teamColor property
     * @return the team color for the piece
     */
    public String getTeamColor() {
        return teamColor;
    }

    /**
     * This method is a getter for the hidden property
     * @return whether the piece is hidden or not
     */
    public boolean isHidden() {
        return hidden;
    }

    /**
     * This method is a getter for the original property
     * @return whether the piece is original or not
     */
    public boolean isOriginal() {
        return original;
    }

    /**
     * This method is a setter for the symbol property
     * @param symbol a character representing the piece
     */
    public void setSymbol(char symbol) {
        this.symbol = symbol;
    }

    /**
     * This method is a setter for the teamColor property
     * @param teamColor the team's color
     */
    public void setTeamColor(String teamColor) {
        this.teamColor = teamColor;
    }

    /**
     * This method is a setter for the hidden property
     * @param hidden whether the piece is hidden or not
     */
    public void setHidden(boolean hidden) {
        this.hidden = hidden;
    }

    /**
     * This method is a setter for the original property
     * @param original whether the piece is original
     */
    public void setOriginal(boolean original) {
        this.original = original;
    }

    /**
     * This method is an abstract method that prints a phrase for that game piece
     */
    public abstract void speak();

    /**
     * This method is an abstract method that returns whether that piece can spawn
     * @return boolean of whether the piece can spawn or not
     */
    public abstract boolean canSpawn();

    /**
     * This method is an abstract method checking if the move path is valid
     * @param fromRow row index of from square
     * @param fromCol column index of from square
     * @param toRow row index of to square
     * @param toCol column index of to square
     * @return boolean whether or not path is valid
     */
    public abstract boolean validMovePath(int fromRow, int fromCol, int toRow, int toCol);

    /**
     * This method is an abstract method checking if the recruit path is valid
     * @param fromRow row index of from square
     * @param fromCol column index of from square
     * @param toRow row index of to square
     * @param toCol column index of to square
     * @return boolean whether or not path is valid
     */
    public abstract boolean validRecruitPath(int fromRow, int fromCol, int toRow, int toCol);

    /**
     * This method is an abstract method checking if the spawn path is valid
     * @param fromRow row index of from square
     * @param fromCol column index of from square
     * @param toRow row index of to square
     * @param toCol column index of to square
     * @return boolean whether or not path is valid
     */
    public abstract boolean validSpawnPath(int fromRow, int fromCol, int toRow, int toCol);

    /**
     * This method is an abstract method checking if the attack path is valid
     * @param fromRow row index of from square
     * @param fromCol column index of from square
     * @param toRow row index of to square
     * @param toCol column index of to square
     * @return boolean whether or not path is valid
     */
    public abstract boolean validAttackPath(int fromRow, int fromCol, int toRow, int toCol);

    // New Action Modification
    /**
     * This method is an abstract method checking if the moonwalk path is valid
     * @param fromRow row index of from square
     * @param fromCol column index of from square
     * @param toRow row index of to square
     * @param toCol column index of to square
     * @return boolean whether or not path is valid
     */
    public abstract boolean validMoonwalkPath(int fromRow, int fromCol, int toRow, int toCol);

    /**
     * This method is an abstract method that creates a new game piece if allowed for that piece
     * @return Piece
     */
    public abstract Piece spawn();

    /**
     * This method returns a string with the teamColor and symbol properties
     * @return String representing the piece
     */
    @Override
    public String toString(){
        return teamColor + " " + symbol;
    }

    /**
     * This method ensures that when an ArrayList of Pieces is sorted, it is
     * sorted by symbol.
     * @param other  another Piece
     * @return  an int representing how the Pieces compare with each other
     */
    @Override
    public int compareTo(Piece other) {
        return Character.valueOf(symbol).compareTo(other.symbol);
    }
}