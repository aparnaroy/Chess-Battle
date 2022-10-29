/**
 * This class represents a Minion Piece.
 *
 * @author Aparna Roy, Benita Abraham, Samantha Glover
 * @version 1.0
 */

public class PieceMinion extends Piece implements Recruiter {
    protected int numRecruits;
    protected int numTimesSpawned;

    public static int MAX_NUM_SPAWNED = 3;

    public PieceMinion(char symbol, String teamColor, int numRecruits,
                       int numTimesSpawned, boolean hidden, boolean original) {
        super(symbol, teamColor, hidden, original);
        this.numRecruits = numRecruits;
        this.numTimesSpawned = numTimesSpawned;

    }

    public PieceMinion(){
        this('M',"- -", 0,0, false,true);
    }

    public int getNumRecruits() {
        return numRecruits;
    }
    public int getNumTimesSpawned() {
        return numTimesSpawned;
    }

    public void setNumRecruits(int numRecruits) {
        this.numRecruits = numRecruits;
    }

    public void speak(){
        System.out.println("\nBello!\n");
    }

    @Override
    public boolean validMovePath(int fromRow, int fromCol, int toRow, int toCol) {
        if (fromCol != toCol){
            return Math.abs(fromCol - toCol) == 2 && fromRow >= toRow;
        } else{
            return fromRow != toRow;
        }
    }

    @Override
    public boolean validAttackPath(int fromRow, int fromCol, int toRow, int toCol) {
        return false;
    }

    @Override
    public boolean validRecruitPath(int fromRow, int fromCol, int toRow, int toCol) {
        if (fromCol != toCol){
            return Math.abs(fromCol - toCol) == 2 && fromRow >= toRow;
        } else{
            return fromRow != toRow;
        }
    }

    @Override
    public boolean validSpawnPath(int fromRow, int fromCol, int toRow, int toCol) {
        // Implement in Rules
        return true;
    }

    // New Action Modification
    @Override
    public boolean validMoonwalkPath(int fromRow, int fromCol, int toRow, int toCol){
        return false;
    }

    @Override
    public PieceMinion spawn(){
        this.numTimesSpawned++;
        return new PieceMinion(Character.toLowerCase(this.symbol),
                this.teamColor,1,
                0,
                false,
                false);
    }

    @Override
    public boolean canSpawn(){
        return original && numTimesSpawned < MAX_NUM_SPAWNED;
    }
}