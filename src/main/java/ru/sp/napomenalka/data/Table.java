package ru.sp.napomenalka.data;

public class Table {
    String name, type, dataStart, dataInf;
    int id;

    public Table(String name, String type, String dataStart, String dataInf, int id) {
        this.name = name;
        this.type = type;
        this.dataStart = dataStart;
        this.dataInf = dataInf;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDataStart() {
        return dataStart;
    }

    public void setDataStart(String dataStart) {
        this.dataStart = dataStart;
    }

    public String getDataInf() {
        return dataInf;
    }

    public void setDataInf(String dataInf) {
        this.dataInf = dataInf;
    }
}
