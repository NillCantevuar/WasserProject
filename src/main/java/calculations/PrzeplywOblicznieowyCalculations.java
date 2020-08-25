package calculations;

import variants.BuildingType;

public class PrzeplywOblicznieowyCalculations {

    //co dostaje
    //wplyw normatywny i rodzaj budynku

    public double calculatePrzeplywObliczniowy (BuildingType buildingType, double wplywNormatywny) {

        switch (buildingType){
            case BUDYNKI_MIESZKANLE:{
                if (wplywNormatywny<= 20){
                        return (0.682 * Math.pow(wplywNormatywny,0.45)) -0.14;
                }else {
                        return (1.7 * Math.pow(wplywNormatywny,0.21)) -0.7;
                }

            }
            case BUDYNKI_BIUROWE_I_ADMINISTRACYJNE:{
                if (wplywNormatywny<= 20){
                        return (0.682 * Math.pow(wplywNormatywny,0.45)) -0.14;
                }else {
                        return (0.4 * Math.pow(wplywNormatywny,0.54)) +0.48;
                }

            }
            case HOTELE:{
                if (wplywNormatywny<= 20){
                        return (0.698 * Math.pow(wplywNormatywny,0.5)) -0.12;
                }else {
                        return (1.08 * Math.pow(wplywNormatywny,0.5)) -1.83;
                }

            }
            case DOMY_TOWAROWE:{
                if (wplywNormatywny<= 20){
                        return (0.698 * Math.pow(wplywNormatywny,0.5)) -0.12;
                }else {
                        return (4.3 * Math.pow(wplywNormatywny,0.27)) -6.65;
                }

            }
            case SZPITALE:{
                if (wplywNormatywny<= 20){
                        return (0.698 * Math.pow(wplywNormatywny,0.5)) -12;
                }else {
                        return (0.25 * Math.pow(wplywNormatywny,0.65)) -1.25;
                }

            }
            case SZKOLY:{
                if (wplywNormatywny<= 1.5){
                        return wplywNormatywny;
                }else if(wplywNormatywny>1.5 && wplywNormatywny<=20) {
                        return (4.4 * Math.pow(wplywNormatywny,0.27)) -3.41;
                }else {
                        return (-22.5 * Math.pow(wplywNormatywny,-0.5)) +11.5;
                }

            }
        }
        return 0;
    }

}
