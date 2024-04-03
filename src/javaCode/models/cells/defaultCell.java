package javaCode.models.cells;

import javaCode.factories.Cell;

public class defaultCell implements Cell {
    /**
     * 0->nothing,
     * 1->mine,
     * 2->coveredMine
     * 3->flag
     * 4->wrongFlag
     * */
    private int status;
    private boolean mine =false;
    private boolean flag = false;
    private final int position;
    private int mineCount;
    private boolean revealed;

    public defaultCell(int status, int mineCount, boolean isRevealed, int position) {
        this.status = status;
        this.mineCount = mineCount;
        this.revealed = isRevealed;
        this.position=position;
    }

    @Override
    public int getStatus() {
        return status;
    }

    @Override
    public int getPosition() {
        return position;
    }


    public void setStatus(int status) {
        this.status = status;
    }

    public void setMineCount(int count) {
        this.mineCount = this.mineCount + count;
    }


    public int getMineCount() {
        return this.mineCount;
    }

    @Override
    public boolean getIsRevealed() {
        return revealed;
    }

    @Override
    public boolean getFlag() {
        return this.flag;
    }

    @Override
    public boolean getMine() {
        return mine;
    }

    @Override
    public void setMine(boolean mine) {
this.mine=mine;    }

    @Override
    public void setFlag(boolean setFlag) {
this.flag=setFlag;
    }

    public void setRevealed(boolean reveal) {
        this.revealed = reveal;
    }
    // Implement status cell


}