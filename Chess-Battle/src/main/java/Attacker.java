/**
 * This interface represents any Piece that can attack.
 *
 * @author Aparna Roy
 * @version 1.0
 */

public interface Attacker {
    public abstract int getNumAttacks();
    public abstract void setNumAttacks(int numAttacks);
    public abstract boolean validAttackPath(int rowAttacker, int colAttacker, int rowAttacked, int colAttacked);
}
