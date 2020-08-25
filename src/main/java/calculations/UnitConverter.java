package calculations;

public class UnitConverter {

    public double convertDM3PerSToM3PerH(double dM3PerS){
        return dM3PerS *3.6;
    }

    public double convertM3PerHToM3PerS(double m3PerH){
        return m3PerH * 0.277778;
    }

    public double convertDM3PerSToM3PerS( double dM3PerS){
        return dM3PerS * 0.001;
    }

    public double convertMM2ToM2(double MM2){
        return MM2/1000000;
    }
}
