package javaCode.factories;

public interface Cell {
    /**
     * 0->nothing,
     * 1->mine,
     * 2->coveredMine
     * 3->flag
     * 4->wrongFlag
     * */
    int getStatus();  // Method to check if the cell contains a mine
    /**
     * 0->nothing,
     * 1->mine,
     * 2->coveredMine
     * 3->flag
     * 4->wrongFlag
     * */
    void setStatus(int status);
    boolean getIsRevealed();  // Method to check if the cell is revealed
    boolean getFlag();
    boolean getMine();
    void setMine(boolean mine);
    void setFlag(boolean setFlag);
    void setRevealed(boolean reveal);
 int getPosition();
    int getMineCount();
    void setMineCount(int count);
}