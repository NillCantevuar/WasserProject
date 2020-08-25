package pipeTypeTables;

import objects.NominalPipeInfo;
import variants.PipeType;

import java.util.List;

public interface PipeTypeTableInterface {

    public List<NominalPipeInfo> prepereTable();

    public void addCell( double outerDiameter,double pipeThicknes);
}
