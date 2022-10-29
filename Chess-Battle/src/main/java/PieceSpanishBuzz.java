// New Extended Piece Modification
/**
 * This class represents a Spanish Buzz Lightyear Piece that extends the PieceBuzz and has extra features.
 * @author Benita Abraham
 * @version 05/11/22
 */

public class PieceSpanishBuzz extends PieceBuzz implements Attacker {
    private boolean moonwalk;

    // New Action Modification
    private int numMoonwalks;

    public PieceSpanishBuzz(char symbol, String teamColor, int numAttacks, int numTimesBeenAttacked,
                            boolean workingLaser, boolean hidden, boolean original, boolean moonwalk, int numMoonwalks){
        super(symbol,teamColor,numAttacks, numTimesBeenAttacked, workingLaser, hidden, original);
        this.moonwalk = moonwalk;
        // New Action Modification
        this.numMoonwalks = numMoonwalks;
    }

    public PieceSpanishBuzz(){
        this('S', "NON", 0, 0,
                true, false, true, true, 0);
    }

    public boolean canMoonwalk(){
        return numMoonwalks <= 1;
    }

    public void setMoonwalk(boolean moonwalk){
        this.moonwalk = moonwalk;
    }

    // New Action Modification
    public int getNumMoonwalks(){
        return this.numMoonwalks;
    }

    public void setNumMoonwalks(int numMoonwalks) {
        this.numMoonwalks = numMoonwalks;
    }

    @Override
    public boolean validMovePath(int fromRow, int fromCol, int toRow, int toCol) {
        return (Math.abs(fromRow - toRow) == 3 && Math.abs(fromCol - toCol) == 3);
    }

    @Override
    public boolean validAttackPath(int fromRow, int fromCol, int toRow, int toCol) {
        return fromCol == toCol && toRow == fromRow - 3;
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
        if (fromCol == toCol && fromRow == toRow - 3 && fromRow <= 4){
            this.numMoonwalks++;
            return true;
        }
        else{
            return false;
        }
    }

    @Override
    public void speak(){
        System.out.println("\nAl infinito y mas alla!\n");
    }

    @Override
    public boolean canSpawn(){
        return false;
    }

    @Override
    public Piece spawn(){
        return null;
    }
}