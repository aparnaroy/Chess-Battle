/**
 * This class extends the PieceMinion class. It represents an evil minion which has the ability to bite (attack) and convert
 * a PieceMinion into a PieceEvilMinion.
 * @author Benita Abraham
 * @version 04/06/22
 */

public class PieceEvilMinion extends PieceMinion implements Attacker, Recruiter {
    private boolean hungry;
    private int numAttacks;
    private final static int MAX_NUM_ATTACKS = 4;

    /**
     * This is the constructor class for a PieceEvilMinion with seven parameters
     * @param symbol a character representing the piece
     * @param teamColor the team's color
     * @param numRecruits number of other minions recruited
     * @param numAttacks number of other pieces attacked
     * @param numTimesSpawned number of times minion has spawned
     * @param hidden whether the piece is hidden or not
     * @param original whether the piece is original
     */
    public PieceEvilMinion(char symbol, String teamColor, int numRecruits, int numAttacks,
                           int numTimesSpawned, boolean hidden, boolean original){
        super(symbol, teamColor, numRecruits, numTimesSpawned, hidden, original);
        this.numAttacks = numAttacks;
        updateHungry();
    }

    /**
     * This is the constructor class for PieceEvilMinion with no parameters where the properties are set to default
     * values
     */
    public PieceEvilMinion(){
        this('E', "NON", 0, 0, 0, false, true);
        updateHungry();
    }

    /**
     * This method is a getter for numAttacks
     * @return numAttacks property
     */
    public int getNumAttacks(){
        return this.numAttacks;
    }

    /**
     * This method is a getter for the hungry property. Evil minions that are hungry can attack
     * @return hungry property
     */
    public boolean canAttack(){
        return this.hungry;
    }

    /**
     * This method is a mutator for the numAttacks property
     * @param numAttacks number of other pieces attacked
     */
    public void setNumAttacks(int numAttacks){
        this.numAttacks = numAttacks;
    }

    @Override
    public boolean validMovePath(int fromRow, int fromCol, int toRow, int toCol) {
        return super.validMovePath(fromRow, fromCol, toRow, toCol);
    }

    @Override
    public boolean validAttackPath(int fromRow, int fromCol, int toRow, int toCol) {
        return super.validMovePath(fromRow, fromCol, toRow, toCol);
    }

    @Override
    public boolean validRecruitPath(int fromRow, int fromCol, int toRow, int toCol) {
        return super.validMovePath(fromRow, fromCol, toRow, toCol);
    }

    @Override
    public boolean validSpawnPath(int fromRow, int fromCol, int toRow, int toCol) {
        return super.validMovePath(fromRow, fromCol, toRow, toCol);
    }

    // New Action Modification
    @Override
    public boolean validMoonwalkPath(int fromRow, int fromCol, int toRow, int toCol){
        return false;
    }

    /**
     * This method is a mutator for the numTimesSpawned property
     * @param numTimesSpawned number of times minion has spawned
     */
    public void setNumTimesSpawned(int numTimesSpawned){
        super.numTimesSpawned = numTimesSpawned;
    }

    /**
     * This method sets the value of the hungry property by making sure numAttacks is less than the max attacks
     */
    public void updateHungry(){
        this.hungry = numAttacks < MAX_NUM_ATTACKS;
    }

    /**
     * This method prints a phrase to the console
     */
    @Override
    public void speak(){
        System.out.println("\nRoar!\n");
    }

    @Override
    public boolean canSpawn(){
        return numTimesSpawned < MAX_NUM_SPAWNED;
    }

    /**
     * This method creates a new PieceEvilMinion with certain properties
     * @return new PieceEvilMinion
     */
    @Override
    public PieceEvilMinion spawn(){
        PieceEvilMinion baby = new PieceEvilMinion(Character.toLowerCase(symbol), this.teamColor, 1, 0, 0, false, false);
        baby.hungry = true;
        this.numTimesSpawned++;
        return baby;
    }
}