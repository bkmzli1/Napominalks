package ru.sp.napomenalka.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.TextField;
import ru.sp.napomenalka.data.Data;

import java.util.ArrayList;

public class controllerAddORG {
    public TextField text;

    public void initialize() {
    }

    public void textAdd(ActionEvent actionEvent) {
        ArrayList<String> arrayList = Data.LIST_ORGANIZATION.getValuetAL();
        arrayList.add(text.getText());
        Data.LIST_ORGANIZATION.setValue(arrayList);
        ObservableList<String> listOrganizationO = FXCollections.observableArrayList();
        listOrganizationO.addAll(Data.LIST_ORGANIZATION.getValuetAL());
        ObservableList<String> listTypeO = FXCollections.observableArrayList();
        listTypeO.addAll(Data.LIST_TYPE_OF_SUBSCRIPTION.getValuetAL());
        ControllerMain.getMainItem.getListOrganization().setItems(listOrganizationO);
        ControllerMain.getMainItem.getListType().setItems(listTypeO);

        Data.save();
    }
}
