package pl.wat.logic.pipeTypeTables;

import pl.wat.logic.objects.NominalPipeInfo;
import pl.wat.logic.variants.PipeType;

import java.util.ArrayList;
import java.util.List;

public class PolipropylenPipeInfo implements PipeTypeTableInterface {

    PipeType pipeType = PipeType.POLIPROPYLEN;

    public  List<NominalPipeInfo> infoList = new ArrayList<NominalPipeInfo>();

    public List<NominalPipeInfo> prepereTable() {
        infoList.clear();

        addCell(110,18.3);
            addCell(90,15.0);
            addCell(75,12.5);
            addCell(63,10.5);
            addCell(50,8.3);
            addCell(40,6.7);
            addCell(32,5.4);
            addCell(25,4.2);
            addCell(20,3.4);
            addCell(16,2.7);


        return infoList;
    }

    public void addCell(double outerDiameter, double pipeThicknes) {
        infoList.add(new NominalPipeInfo(outerDiameter,pipeThicknes,pipeType));
    }
}

