/**
 * This interface represents any Piece that can recruit.
 *
 * @author Aparna Roy
 * @version 1.0
 */

public interface Recruiter {
    public abstract int getNumRecruits();
    public abstract void setNumRecruits(int numRecruits);
    public abstract boolean validRecruitPath(int rowRecruiter, int colRecruiter, int rowRecruited, int colRecruited);
}
