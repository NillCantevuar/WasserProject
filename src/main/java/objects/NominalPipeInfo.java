package objects;

import variants.PipeType;

public class NominalPipeInfo {
    private double outerDiameter;
    private double pipeThicknes;
    private PipeType pipeType;
    private double speed;

    public double getSpeed() {
        return speed;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }

    public double getOuterDiameter() {
        return outerDiameter;
    }

    public void setOuterDiameter(double outerDiameter) {
        this.outerDiameter = outerDiameter;
    }

    public double getPipeThicknes() {
        return pipeThicknes;
    }

    public void setPipeThicknes(double pipeThicknes) {
        this.pipeThicknes = pipeThicknes;
    }

    public PipeType getPipeType() {
        return pipeType;
    }

    public void setPipeType(PipeType pipeType) {
        this.pipeType = pipeType;
    }

    public NominalPipeInfo(double outerDiameter, double pipeThicknes, PipeType pipeType) {
        this.outerDiameter = outerDiameter;
        this.pipeThicknes = pipeThicknes;
        this.pipeType = pipeType;
        this.speed = 0;
    }
}
