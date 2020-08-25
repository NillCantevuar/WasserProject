package pipeTypeTables;

import objects.NominalPipeInfo;
import variants.PipeType;

import java.util.ArrayList;
import java.util.List;

public class SteelPipeTypeInfo implements PipeTypeTableInterface{

    PipeType pipeType = PipeType.STEEL;

    public  List<NominalPipeInfo> infoList = new ArrayList<NominalPipeInfo>();

    public List<NominalPipeInfo> prepereTable() {
        addCell(168.3,4.5);
        addCell(139.7,4.0);
        addCell(114.3,3.6);
        addCell(88.9,3.2);
        addCell(76.1,2.9);
        addCell(60.3,2.9);
        addCell(48.3,2.6);
        addCell(42.4,2.6);
        addCell(33.7,2.6);
        addCell(26.9,2.3);
        addCell(21.3,2.0);
        return infoList;
    }

    public void addCell(double outerDiameter, double pipeThicknes) {

            infoList.add(new NominalPipeInfo(outerDiameter,pipeThicknes,pipeType));
    }
}
