// New Piece Modification
/**
 * This class represents a Powerpuff Girl Piece with her different abilities.
 * @author Benita Abraham
 * @version 05/11/22
 */

public class PiecePowerpuff extends Piece implements Attacker, Recruiter {
    private int numTimesSpawned;
    private int numAttacks;
    private int numRecruits;
    private final static int MAX_NUM_SPAWNS = 3;

    public PiecePowerpuff(char symbol, String teamColor, boolean hidden, boolean original, int numTimesSpawned,
                          int numAttacks, int numRecruits){
        super(symbol, teamColor, hidden, original);
        this.numTimesSpawned = numTimesSpawned;
    }

    public PiecePowerpuff(){
        this('P', "NON", false, true, 0, 0, 0);
    }

    public int getNumTimesSpawned(){
        return numTimesSpawned;
    }

    public void setNumTimesSpawned(int numTimesSpawned){
        this.numTimesSpawned = numTimesSpawned;
    }

    public int getNumAttacks(){
        return numAttacks;
    }

    public void setNumAttacks(int numAttacks){
        this.numAttacks = numAttacks;
    }

    public int getNumRecruits(){
        return numRecruits;
    }

    public void setNumRecruits(int numRecruits){
        this.numRecruits = numRecruits;
    }

    @Override
    public boolean validMovePath(int fromRow, int fromCol, int toRow, int toCol) {
        return toCol == fromCol && Math.abs(fromRow - toRow) == 1;
    }

    @Override
    public boolean validAttackPath(int fromRow, int fromCol, int toRow, int toCol) {
        return toRow == fromRow - 2 && Math.abs(toCol - fromCol) == 1;
    }

    @Override
    public boolean validRecruitPath(int fromRow, int fromCol, int toRow, int toCol) {
        return toRow == fromRow && Math.abs(fromCol - toCol) == 1;
    }

    @Override
    public boolean validSpawnPath(int fromRow, int fromCol, int toRow, int toCol) {
        return Math.abs(toCol - fromCol) == 1 && Math.abs(toRow - fromRow) == 1;
    }

    // New Action Modification
    @Override
    public boolean validMoonwalkPath(int fromRow, int fromCol, int toRow, int toCol){
        return false;
    }

    @Override
    public void speak(){
        System.out.println("\nGirls rule!\n");
    }

    @Override
    public boolean canSpawn(){
        return numTimesSpawned < MAX_NUM_SPAWNS;
    }

    @Override
    public PiecePowerpuff spawn(){
        this.numTimesSpawned++;
        return new PiecePowerpuff(Character.toLowerCase(this.symbol), this.teamColor,
                false, false, this.numTimesSpawned, 0, 0);
    }
}