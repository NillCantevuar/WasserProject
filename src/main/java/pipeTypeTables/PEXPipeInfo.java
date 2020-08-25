package pipeTypeTables;

import objects.NominalPipeInfo;
import variants.PipeType;

import java.util.ArrayList;
import java.util.List;

public class PEXPipeInfo implements  PipeTypeTableInterface {

    public  List<NominalPipeInfo> infoList = new ArrayList<NominalPipeInfo>();
    PipeType pipeType = PipeType.PEX;

    public List<NominalPipeInfo> prepereTable() {
        addCell(63.0,4.5);
        addCell(50.0,4.0);
        addCell(40.0,3.5);
        addCell(32.0,3.0);
        addCell(25.0,2.5);
        addCell(20.0,2.0);
        addCell(16.0,2.0);

        return infoList;
    }

    public void addCell(double outerDiameter, double pipeThicknes) {
        infoList.add(new NominalPipeInfo(outerDiameter,pipeThicknes,pipeType));
    }
}
