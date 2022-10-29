/**
 * This class represents a Buzz Lightyear Piece.
 *
 * @author Aparna Roy, Benita Abraham, Samantha Glover
 * @version 1.0
 */

public class PieceBuzz extends Piece implements Attacker {
    protected int numAttacks;
    protected int numTimesBeenAttacked;
    protected boolean workingLaser;

    public PieceBuzz(char symbol, String teamColor, int numAttacks, int numTimesBeenAttacked, boolean workingLaser,
                     boolean hidden, boolean original) {
        super(symbol, teamColor, hidden, original);
        this.numAttacks = numAttacks;
        this.numTimesBeenAttacked = numTimesBeenAttacked;
        this.workingLaser = workingLaser;
    }

    public PieceBuzz(){
        this('B',"- -", 0,0, true, false, true);
    }

    public int getNumAttacks() {
        return numAttacks;
    }
    public int getNumTimesBeenAttacked() {
        return numTimesBeenAttacked;
    }
    public boolean canAttack(){
        return workingLaser;
    }

    public void setWorkingLaser(boolean workingLaser) {
        this.workingLaser = workingLaser;
    }

    public void setNumAttacks(int numAttacks)  {
        this.numAttacks = numAttacks;
    }

    @Override
    public boolean validMovePath(int fromRow, int fromCol, int toRow, int toCol) {
        return true;
    }

    @Override
    public boolean validAttackPath(int fromRow, int fromCol, int toRow, int toCol) {
        if (fromCol == toCol){
            if(Math.abs(fromRow - toRow) != 2){
                return false;
            }
        } else{
            if(fromRow != toRow){
                return false;
            }
        }
        return true;
    }

    @Override
    public boolean validRecruitPath(int fromRow, int fromCol, int toRow, int toCol) {
        return false;
    }

    @Override
    public boolean validSpawnPath(int fromRow, int fromCol, int toRow, int toCol) {
        return false;
    }

    // New Action Modification
    @Override
    public boolean validMoonwalkPath(int fromRow, int fromCol, int toRow, int toCol){
        return false;
    }

    public void updateNumTimesBeenAttacked(){
        this.numTimesBeenAttacked += 1;
        this.workingLaser = false;
    }

    @Override
    public void speak(){
        System.out.println("\nTo Infinity and Beyond!\n");
    }

    @Override
    public Piece spawn(){
        return null;
    }

    @Override
    public boolean canSpawn(){
        return false;
    }
}