package ru.sp.napomenalka.util;

import javafx.collections.ObservableList;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableView;

public class GetMainItem {
    ComboBox listOrganization;
    ComboBox listType;
    DatePicker dateStart;
    DatePicker dateInf;
    TableView table;

    public GetMainItem(ComboBox listOrganization, ComboBox listType, DatePicker dateStart, DatePicker dateInf, TableView table) {
        this.listOrganization = listOrganization;
        this.listType = listType;
        this.dateStart = dateStart;
        this.dateInf = dateInf;
        this.table = table;
    }

    public ComboBox getListOrganization() {
        return listOrganization;
    }

    public void setListOrganization(ComboBox listOrganization) {
        this.listOrganization = listOrganization;
    }

    public ComboBox getListType() {
        return listType;
    }

    public void setListType(ComboBox listType) {
        this.listType = listType;
    }

    public DatePicker getDateStart() {
        return dateStart;
    }

    public void setDateStart(DatePicker dateStart) {
        this.dateStart = dateStart;
    }

    public DatePicker getDateInf() {
        return dateInf;
    }

    public void setDateInf(DatePicker dateInf) {
        this.dateInf = dateInf;
    }

    public TableView getTable() {
        return table;
    }

    public void setTable(TableView table) {
        this.table = table;
    }


}
