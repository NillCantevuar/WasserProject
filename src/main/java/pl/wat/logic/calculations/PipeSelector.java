package pl.wat.logic.calculations;

import pl.wat.logic.objects.NominalPipeInfo;
import pl.wat.logic.pipeTypeTables.PEXPipeInfo;
import pl.wat.logic.pipeTypeTables.PipeTypeTableInterface;
import pl.wat.logic.pipeTypeTables.PolipropylenPipeInfo;
import pl.wat.logic.pipeTypeTables.SteelPipeTypeInfo;
import pl.wat.logic.variants.PipeType;

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

                   if (actualSpeed > maxVelocity) {

                       if (i>0) {
                           temp = typeInterface.prepereTable().get(i - 1);
                           double innerDiameterInMMForSecondTime = pipeCalculations.calculateInnerDiameter(temp.getOuterDiameter(), temp.getPipeThicknes());
                           double innerSectionInMM2ForSecondTime = pipeCalculations.calculateInnerSection(innerDiameterInMMForSecondTime);
                           Double actualSpeedForSecondTime = VelocityCalculations.calculateVelociity(
                                   przeplywObliczniowyInM3PerS, unitConverter.convertMM2ToM2(innerSectionInMM2ForSecondTime));
                           temp.setSpeed(actualSpeedForSecondTime);
                           break;
                       }else {
                           temp = typeInterface.prepereTable().get(i);
                           double innerDiameterInMMForSecondTime = pipeCalculations.calculateInnerDiameter(temp.getOuterDiameter(), temp.getPipeThicknes());
                           double innerSectionInMM2ForSecondTime = pipeCalculations.calculateInnerSection(innerDiameterInMMForSecondTime);
                           Double actualSpeedForSecondTime = VelocityCalculations.calculateVelociity(
                                   przeplywObliczniowyInM3PerS, unitConverter.convertMM2ToM2(innerSectionInMM2ForSecondTime));
                           temp.setSpeed(actualSpeedForSecondTime);
                       }
                   }

        }

        return temp;
    }
}
