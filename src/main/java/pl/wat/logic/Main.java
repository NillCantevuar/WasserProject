package pl.wat.logic;

import pl.wat.logic.calculations.*;
import pl.wat.logic.objects.NominalPipeInfo;
import pl.wat.logic.variants.BuildingType;
import pl.wat.logic.variants.PipeType;

public class Main {
    public static void main(String[] args) {

        PipeSelector pipeSelector = new PipeSelector();
        PrzeplywOblicznieowyCalculations przeplywOblicznieowyCalculations = new PrzeplywOblicznieowyCalculations();
        WplywNormatywnyCalculations wplywNormatywnyCalculations = new WplywNormatywnyCalculations();
        UnitConverter unitConverter = new UnitConverter();

        double przeplywNormatywnyInDm3PerS = wplywNormatywnyCalculations
                .calculateWholeWplywNormatywny(
                        2,
                        0,
                        1,
                        0,
                        1,
                        0,
                        0,
                        1);



        double przeplywObliczeniowyInDM3PerS = przeplywOblicznieowyCalculations.calculatePrzeplywObliczniowy(
                BuildingType.DOMY_TOWAROWE , przeplywNormatywnyInDm3PerS );



        NominalPipeInfo pipeInfo = pipeSelector.selectOptimalPipe(
                PipeType.STEEL,
                1.5 ,
                unitConverter.convertDM3PerSToM3PerS(przeplywObliczeniowyInDM3PerS));


        System.out.println("Przeplyw Normatywny");
        System.out.println(przeplywNormatywnyInDm3PerS);
        System.out.println("Przeplyw Oblicznieowy");
        System.out.println(unitConverter.convertDM3PerSToM3PerH(przeplywObliczeniowyInDM3PerS));
        System.out.println("srednica Nominalna");
        System.out.println( pipeInfo.getPipeType()+" "+pipeInfo.getOuterDiameter()+"x"+pipeInfo.getPipeThicknes());
        System.out.println("predkosc aktualna");
        System.out.println(pipeInfo.getSpeed());


    }
}
