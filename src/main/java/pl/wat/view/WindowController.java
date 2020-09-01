package pl.wat.view;

import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.scene.input.InputMethodEvent;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
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




    public void calculate(KeyEvent actionEvent) {

            double wyplywNormatywny = calculateWyplywNormatywny();
            double przeplywObliczeniowy = calculatePrzeplywObliczeniowy();
            wyplywNormatywnyResult.setText(String.valueOf(wyplywNormatywny));
            QoblInDmResult.setText(String.valueOf(przeplywObliczeniowy));
            QoblInMResult.setText(String.valueOf(unitConverter.convertDM3PerSToM3PerH(przeplywObliczeniowy)));
            NominalPipeInfo nominalPipeInfo = pipeSelector.selectOptimalPipe(
                    getPipeType(), getVMax(), unitConverter.convertDM3PerSToM3PerS(przeplywObliczeniowy));
            actualSpeedResult.setText(String.valueOf(nominalPipeInfo.getSpeed()));
            setPipeResult(nominalPipeInfo);

    }

    public void calculateBox(MouseEvent actionEvent) {

            double wyplywNormatywny = calculateWyplywNormatywny();
            double przeplywObliczeniowy = calculatePrzeplywObliczeniowy();
            wyplywNormatywnyResult.setText(String.valueOf(wyplywNormatywny));
            QoblInDmResult.setText(String.valueOf(przeplywObliczeniowy));
            QoblInMResult.setText(String.valueOf(unitConverter.convertDM3PerSToM3PerH(przeplywObliczeniowy)));
            NominalPipeInfo nominalPipeInfo = pipeSelector.selectOptimalPipe(
                    getPipeType(), getVMax(), unitConverter.convertDM3PerSToM3PerS(przeplywObliczeniowy));
            actualSpeedResult.setText(String.valueOf(nominalPipeInfo.getSpeed()));
            setPipeResult(nominalPipeInfo);


    }
    private double getVMax(){
        return verifyDouble(maxSpeed.getText());
    }

    private void setPipeResult(NominalPipeInfo nominalPipeInfo) {

            String demetntions = String.valueOf(Integer.valueOf((int) nominalPipeInfo.getOuterDiameter())) + "x" + String.valueOf(nominalPipeInfo.getPipeThicknes());
            if (nominalPipeInfo.getPipeType() != PipeType.STEEL) {
                pipeResult.setText(demetntions);
            } else {
                String stealText = null;
                switch (demetntions) {
                    case "168x4.5":
                        stealText = "DN150";
                        break;
                    case "139x4.0":
                        stealText = "DN125";
                        break;
                    case "114x3.6":
                        stealText = "DN100";
                        break;
                    case "88x3.2":
                        stealText = "DN80";
                        break;
                    case "76x2.9":
                        stealText = "DN65";
                        break;
                    case "60x2.9":
                        stealText = "DN50";
                        break;
                    case "48x2.6":
                        stealText = "DN40";
                        break;
                    case "42x2.6":
                        stealText = "DN32";
                        break;
                    case "33x2.6":
                        stealText = "DN25";
                        break;
                    case "26x2.3":
                        stealText = "DN20";
                        break;
                    case "21x2.0":
                        stealText = "DN15";
                        break;

                }
                pipeResult.setText(stealText);

            }


    }

    private double calculateWyplywNormatywny() {

            return wplywNormatywnyCalculations.calculateWholeWplywNormatywny(
                    verifyInt(umywalkaQuantity.getText()),
                    verifyInt(zlewozmywakQuantity.getText()),
                    verifyInt(wannaQuantity.getText()),
                    verifyInt(natryskQuantity.getText()),
                    verifyInt(pralkaQuantity.getText()),
                    verifyInt(zmywarkaQuantity.getText()),
                    verifyInt(pisuarQuantity.getText()),
                    verifyInt(pluczkaZbiornikowaQuantity.getText()));
    }

    private double calculatePrzeplywObliczeniowy(){

            BuildingType buildingType = getBuildingType();
            assert buildingType != null;
            return przeplywOblicznieowyCalculations.calculatePrzeplywObliczniowy(buildingType, calculateWyplywNormatywny());


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

    private int verifyInt(String input){
        try {
            int parsedInt = Integer.parseInt(input);
            return parsedInt;

        }catch ( NumberFormatException e){
            return 0;
        }
    }
    private double verifyDouble(String input){
        try {
            double parsedDouble = Double.parseDouble(input);
            return parsedDouble;
        }catch ( NumberFormatException e){
            return 0;
        }

    }
}
