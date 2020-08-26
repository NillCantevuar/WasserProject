package pl.wat.logic.pipeTypeTables;

import pl.wat.logic.objects.NominalPipeInfo;

import java.util.List;

public interface PipeTypeTableInterface {

    public List<NominalPipeInfo> prepereTable();

    public void addCell( double outerDiameter,double pipeThicknes);
}
