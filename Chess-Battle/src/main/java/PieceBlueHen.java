/**
 * This class represents a Blue Hen Piece.
 *
 * @author Aparna Roy, Benita Abraham, Samantha Glover
 * @version 1.0
 */

public class PieceBlueHen extends Piece implements Attacker, Recruiter {
    private int numAttacks;
    private int numRecruits;
    private boolean flies;

    final public int MAX_NUM_ATTACKS = 3;

    public PieceBlueHen (char symbol, String teamColor, int numAttacks, int numRecruits,
                         boolean hidden, boolean original){
        super(symbol, teamColor, hidden, original);
        this.numAttacks = numAttacks;
        this.numRecruits = numRecruits;
        updateFly();
    }

    public PieceBlueHen ()  {
        this('H',"NON", 0,0, false,true);
    }

    public int getNumAttacks()    {
        return this.numAttacks;
    }

    public int getNumRecruits(){
        return this.numRecruits;
    }

    public boolean canFly()    {
        return this.flies;
    }

    public void setNumAttacks(int numAttacks)    {
        this.numAttacks = numAttacks;
        updateFly();
    }
    public void setNumRecruits(int numRecruits)    {
        this.numRecruits = numRecruits;
    }

    private void updateFly()    {
        this.flies = this.numAttacks < MAX_NUM_ATTACKS;
    }
    @Override
    public void speak(){
        System.out.println("\nGo UD!\n");
    }

    @Override
    public boolean validMovePath(int fromRow, int fromCol, int toRow, int toCol) {
        if(canFly()){
            return true;
        } else {
            return Math.abs(fromRow - toRow) == 1 || Math.abs(fromCol - toCol) == 1;
        }
    }

    @Override
    public boolean validAttackPath(int fromRow, int fromCol, int toRow, int toCol) {
        if(canFly()){
            return true;
        } else {
            return Math.abs(fromCol - toCol) == 1 && fromRow == toRow;
        }
    }

    @Override
    public boolean validRecruitPath(int fromRow, int fromCol, int toRow, int toCol) {
        if(canFly()){
            return true;
        } else {
            return Math.abs(fromRow - toRow) == 1 && fromCol == toCol;
        }
    }

    @Override
    public boolean validSpawnPath(int fromRow, int fromCol, int toRow, int toCol) {
        if(canFly()){
            return true;
        } else {
            return Math.abs(fromRow - toRow) == 1 && Math.abs(fromCol - toCol) == 1;
        }
    }

    // New Action Modification
    @Override
    public boolean validMoonwalkPath(int fromRow, int fromCol, int toRow, int toCol){
        return false;
    }

    @Override
    public PieceBlueHen spawn()    {
        return  new PieceBlueHen(Character.toLowerCase(this.symbol), this.teamColor,
                this.numAttacks,this.numRecruits, false,false);
    }

    @Override
    public boolean canSpawn(){
        return true;
    }
}