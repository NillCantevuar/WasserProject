package pl.wat.logic.calculations;

public class PipeCalculations {

    public double calculateInnerDiameter(double outerDiameter,double pipeThickness){
        return outerDiameter - 2 * pipeThickness;
    }
    public double calculateInnerSection(double innerDiameter){
        return  (Math.PI * Math.pow(innerDiameter,2)/4);
    }


}
