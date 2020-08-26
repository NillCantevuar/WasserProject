package pl.wat.view;

import javafx.collections.ObservableListBase;
import javafx.event.ActionEvent;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import pl.wat.logic.calculations.*;
import pl.wat.logic.objects.NominalPipeInfo;
import pl.wat.logic.variants.BuildingType;
import pl.wat.logic.variants.PipeType;

public class WindowController {

    WplywNormatywnyCalculations wplywNormatywnyCalculations = new WplywNormatywnyCalculations();
    PrzeplywOblicznieowyCalculations przeplywOblicznieowyCalculations = new PrzeplywOblicznieowyCalculations();
    UnitConverter unitConverter = new UnitConverter();
    PipeCalculations pipeCalculations = new PipeCalculations();
    PipeSelector pipeSelector = new PipeSelector();

    public TextField umywalkaQuantity = null;
    public TextField zlewozmywakQuantity;
    public TextField wannaQuantity;
    public TextField natryskQuantity;
    public TextField pralkaQuantity;
    public TextField zmywarkaQuantity;
    public TextField pisuarQuantity;
    public TextField pluczkaZbiornikowaQuantity;
    public TextField maxSpeed;
    public ChoiceBox<String> buildingType;
    public ChoiceBox<String>  pipeType;
    public TextField wyplywNormatywnyResult;
    public TextField QoblInDmResult;
    public TextField QoblInMResult;
    public TextField pipeResult;
    public TextField actualSpeedResult;


    public void calculate(ActionEvent actionEvent) {


        double wyplywNormatywny = calculateWyplywNormatywny();

        //to sa dm3 na s
        double przeplywObliczeniowy = calculatePrzeplywObliczeniowy();



        wyplywNormatywnyResult.setText(String.valueOf(wyplywNormatywny));
        QoblInDmResult.setText(String.valueOf(przeplywObliczeniowy));
        QoblInMResult.setText(String.valueOf(unitConverter.convertDM3PerSToM3PerH(przeplywObliczeniowy)));


        NominalPipeInfo nominalPipeInfo = pipeSelector.selectOptimalPipe(
                getPipeType(),Double.valueOf(maxSpeed.getText()),unitConverter.convertDM3PerSToM3PerS(przeplywObliczeniowy));



        actualSpeedResult.setText(String.valueOf( nominalPipeInfo.getSpeed()));
        pipeResult.setText(String.valueOf(nominalPipeInfo.getOuterDiameter())+"x"+String.valueOf(nominalPipeInfo.getPipeThicknes()));


    }

    private double calculateWyplywNormatywny() {
        return wplywNormatywnyCalculations.calculateWholeWplywNormatywny(
                Integer.parseInt(umywalkaQuantity.getText()),
                Integer.parseInt(zlewozmywakQuantity.getText()),
                Integer.parseInt(wannaQuantity.getText()),
                Integer.parseInt(natryskQuantity.getText()),
                Integer.parseInt(pralkaQuantity.getText()),
                Integer.parseInt(zmywarkaQuantity.getText()),
                Integer.parseInt(pisuarQuantity.getText()),
                Integer.parseInt(pluczkaZbiornikowaQuantity.getText()));

    }

    private double calculatePrzeplywObliczeniowy(){
        BuildingType buildingType = getBuildingType();
        assert buildingType != null;
       return przeplywOblicznieowyCalculations.calculatePrzeplywObliczniowy(buildingType,calculateWyplywNormatywny());

    }

    private BuildingType getBuildingType(){
        String text = buildingType.getValue();
        switch (text) {
            case "Budynki Mieszkalne":
                return BuildingType.BUDYNKI_MIESZKANLE;
            case "Budynki Biurowe i Administacyjne":
                return BuildingType.BUDYNKI_BIUROWE_I_ADMINISTRACYJNE;
            case "Hotele":
                return BuildingType.HOTELE;
            case "Domy Towarowe":
                return BuildingType.DOMY_TOWAROWE;
            case "Szpitale":
                return BuildingType.SZPITALE;
            case "Szkoły":
                return BuildingType.SZKOLY;
        }
        return null;
    }

    private PipeType getPipeType(){
        String text = pipeType.getValue();
        switch (text){
            case "Stal":
                return PipeType.STEEL;
            case "PEX" :
                return PipeType.PEX;
            case "Polipropylen" :
                return PipeType.POLIPROPYLEN;
        }
        return null;
    }

}
