package Catalog;

public class Class {
    private String NrClass;

    public Class()
    {
        this.NrClass = "";
    }

    public Class(String nrClass)
    {
        NrClass = nrClass;
    }

    public String getNrClass() {
        return NrClass;
    }

    public void setNrClass(String nrClass) {
        NrClass = nrClass;
    }
    @Override
    public  String toString()
    {
        return getNrClass();
    }
}
