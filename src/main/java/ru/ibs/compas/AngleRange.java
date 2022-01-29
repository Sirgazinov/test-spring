package ru.ibs.compas;

public class AngleRange {

    private int angleStart;
    private int angleEnd;

    public void setAngleStart(int angleStart) {
        this.angleStart = angleStart;
    }

    public void setAngleEnd(int angleEnd) {
        this.angleEnd = angleEnd;
    }

    public boolean inRange(int value) {
        if (value >= angleStart && value <= angleEnd) {
            return true;
        } else {
            return false;
        }
    }
}
