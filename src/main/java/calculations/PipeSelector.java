package calculations;

import objects.NominalPipeInfo;
import pipeTypeTables.PEXPipeInfo;
import pipeTypeTables.PipeTypeTableInterface;
import pipeTypeTables.PolipropylenPipeInfo;
import pipeTypeTables.SteelPipeTypeInfo;
import variants.PipeType;

import java.math.BigDecimal;

public class PipeSelector {

    public NominalPipeInfo selectOptimalPipe(PipeType pipeType , Double maxVelocity, double przeplywObliczniowyInM3PerS){

        PipeTypeTableInterface typeInterface ;
        NominalPipeInfo temp = null;
        PipeCalculations pipeCalculations = new PipeCalculations();
        UnitConverter unitConverter = new UnitConverter();

        switch (pipeType){
            case STEEL:{
                typeInterface = new SteelPipeTypeInfo();
            }
            break;
            case POLIPROPYLEN:{
                typeInterface = new PolipropylenPipeInfo();
            }
            break;
            case PEX:{
                typeInterface = new PEXPipeInfo();
            }
            break;
            default:
                throw new IllegalStateException("Unexpected value: " + pipeType);
        }

        for (int i = 0; i < typeInterface.prepereTable().size() ; i++) {

             temp = typeInterface.prepereTable().get(i);

             double innerDiameterInMM = pipeCalculations.calculateInnerDiameter(temp.getOuterDiameter(),temp.getPipeThicknes());
             double innerSectionInMM2 =pipeCalculations.calculateInnerSection(innerDiameterInMM);
             Double actualSpeed = VelocityCalculations.calculateVelociity(
                     przeplywObliczniowyInM3PerS,unitConverter.convertMM2ToM2(innerSectionInMM2));

            BigDecimal asDecimal = new BigDecimal(actualSpeed);
            BigDecimal maxDecimal = new BigDecimal(maxVelocity);



                   if (asDecimal.compareTo(maxDecimal) >0) {

                              temp = typeInterface.prepereTable().get(i-1);
                               double innerDiameterInMMForSecondTime = pipeCalculations.calculateInnerDiameter(temp.getOuterDiameter(),temp.getPipeThicknes());
                               double innerSectionInMM2ForSecondTime =pipeCalculations.calculateInnerSection(innerDiameterInMMForSecondTime);
                               Double actualSpeedForSecondTime = VelocityCalculations.calculateVelociity(
                               przeplywObliczniowyInM3PerS,unitConverter.convertMM2ToM2(innerSectionInMM2ForSecondTime));

                                temp.setSpeed(actualSpeedForSecondTime);
                              break;
                   }

        }

        return temp;
    }
}
