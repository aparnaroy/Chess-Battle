/**
 * This class represents a Team in the game.
 *
 * @author Aparna Roy
 * @version 1.0
 */

import java.util.ArrayList;
import java.util.Collections;

public class Team {
    // Attributes
    private String color;
    private ArrayList<Piece> pieces;
    // New Objective Modification
    private int totalNumAttacks = 0;

    // Constructor
    /**
     * This is the constructor for Team.
     * @param color  the color of the Team
     * @param pieces  the Pieces in the Team
     */
    public Team(String color, ArrayList<Piece> pieces) {
        this.color = color;
        this.pieces = pieces;
    }

    // Accessor Methods
    /**
     * Gets the color of the Team.
     * @return  a String representing the color of the Team
     */
    public String getTeamColor() {
        return this.color;
    }

    /**
     * Gets the Pieces in the Team.
     * @return  an ArrayList representing the Pieces in the Team
     */
    public ArrayList<Piece> getTeamPieces() {
        return this.pieces;
    }

    // New Objective Modification
    /**
     * Gets the total number of attacks done by all the Pieces in this Team.
     * @return  an int representing the total attacks done by the Team
     */
    public int getTotalNumAttacks() {
        return this.totalNumAttacks;
    }

    // Mutator Methods
    // New Objective Modification
    public void setTotalNumAttacks(int totalNumAttacks) {
        this.totalNumAttacks = totalNumAttacks;
    }

    /**
     * Removes a Piece from the Team.
     * @param pieceToRemove  the Piece to remove from the Team
     */
    public void removePieceFromTeam(Piece pieceToRemove) {
        this.pieces.remove(pieceToRemove);
    }

    /**
     * Adds a Piece to the Team.
     * @param pieceToAdd  the Piece to add to the Team
     */
    public void addPieceToTeam(Piece pieceToAdd) {
        this.pieces.add(pieceToAdd);
        pieceToAdd.setTeamColor(this.color);
    }

    // Overriding the toString() method
    /**
     * Overrides the toString() method of the Object class.
     * @return  a String that describes the Team
     */
    @Override
    public String toString() {
        ArrayList<Piece> thePieces = pieces;
        String description = "Team " + this.color + " Pieces : \n";
        // Sort the ArrayList of Pieces by symbol
        Collections.sort(thePieces);
        for (Piece aPiece : thePieces) {
            description += aPiece.toString() + "   ";
        }
        return description;
    }
}