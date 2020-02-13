package ru.sp.napomenalka.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ListView;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;
import ru.sp.napomenalka.data.Data;
import ru.sp.napomenalka.data.Table;

import java.util.ArrayList;

public class ControllerRemuv {
    public ListView list;
    ArrayList<String> organizationAddValuetAL = Data.LIST_ORGANIZATION_ADD.getValuetAL();
    ArrayList<String> listTypeOfSubscriptionAddValuetAL = Data.LIST_TYPE_OF_SUBSCRIPTION_ADD.getValuetAL();
    ArrayList<String> dateStartValuetAL = Data.DATE_START.getValuetAL();
    ArrayList<String> dateInfValuetAL = Data.DATE_INF.getValuetAL();
    ArrayList<CheckBox> checkBoxArrayList = new ArrayList<>();
    ObservableList<HBox> listOL = FXCollections.observableArrayList();

    public void initialize() {
        organizationAddValuetAL = Data.LIST_ORGANIZATION_ADD.getValuetAL();
        listTypeOfSubscriptionAddValuetAL = Data.LIST_TYPE_OF_SUBSCRIPTION_ADD.getValuetAL();
        dateStartValuetAL = Data.DATE_START.getValuetAL();
        dateInfValuetAL = Data.DATE_INF.getValuetAL();
        for (int i = 0; i < organizationAddValuetAL.size(); i++) {
            Text
                    name = new Text(organizationAddValuetAL.get(i)),
                    type = new Text(listTypeOfSubscriptionAddValuetAL.get(i)),
                    dataStart = new Text(dateStartValuetAL.get(i)),
                    dataInf = new Text(dateInfValuetAL.get(i));
            HBox hBox = new HBox(10);
            CheckBox checkBox = new CheckBox();
            checkBoxArrayList.add(checkBox);
            hBox.getChildren().addAll(checkBox, name, type, dataStart, dataInf);
            listOL.add(hBox);
        }

        list.setItems(listOL);

    }

    public void remuv(ActionEvent actionEvent) {
        organizationAddValuetAL = Data.LIST_ORGANIZATION_ADD.getValuetAL();
        listTypeOfSubscriptionAddValuetAL = Data.LIST_TYPE_OF_SUBSCRIPTION_ADD.getValuetAL();
        dateStartValuetAL = Data.DATE_START.getValuetAL();
        dateInfValuetAL = Data.DATE_INF.getValuetAL();
        for (int i = dateInfValuetAL.size() - 1; i >= 0; i--) {
            if (checkBoxArrayList.get(i).isSelected()) {
                System.out.println(i);
                organizationAddValuetAL.remove(i);
                listTypeOfSubscriptionAddValuetAL.remove(i);
                dateStartValuetAL.remove(i);
                dateInfValuetAL.remove(i);
            }
        }
        Data.LIST_ORGANIZATION_ADD.setValue(organizationAddValuetAL);
        Data.LIST_TYPE_OF_SUBSCRIPTION_ADD.setValue(listTypeOfSubscriptionAddValuetAL);
        Data.DATE_START.setValue(dateStartValuetAL);
        Data.DATE_INF.setValue(dateInfValuetAL);
        Data.save();

        organizationAddValuetAL = Data.LIST_ORGANIZATION_ADD.getValuetAL();
        listTypeOfSubscriptionAddValuetAL = Data.LIST_TYPE_OF_SUBSCRIPTION_ADD.getValuetAL();
        dateStartValuetAL = Data.DATE_START.getValuetAL();
        dateInfValuetAL = Data.DATE_INF.getValuetAL();
        ArrayList<Table> tables = new ArrayList<>();
        for (int i = 0; i < organizationAddValuetAL.size(); i++) {
            String
                    name = organizationAddValuetAL.get(i),
                    type = listTypeOfSubscriptionAddValuetAL.get(i),
                    dataStart = dateStartValuetAL.get(i),
                    dataInf = dateInfValuetAL.get(i);
            tables.add(new Table(name, type, dataStart, dataInf, tables.size()));
        }
        ObservableList<Table> list = FXCollections.observableArrayList();
        list.addAll(tables);
        ControllerMain.getMainItem.getTable().setItems(list);


        listOL.clear();
        organizationAddValuetAL = Data.LIST_ORGANIZATION_ADD.getValuetAL();
        listTypeOfSubscriptionAddValuetAL = Data.LIST_TYPE_OF_SUBSCRIPTION_ADD.getValuetAL();
        dateStartValuetAL = Data.DATE_START.getValuetAL();
        dateInfValuetAL = Data.DATE_INF.getValuetAL();
        checkBoxArrayList.clear();
        for (int i = 0; i < organizationAddValuetAL.size(); i++) {
            Text
                    name = new Text(organizationAddValuetAL.get(i)),
                    type = new Text(listTypeOfSubscriptionAddValuetAL.get(i)),
                    dataStart = new Text(dateStartValuetAL.get(i)),
                    dataInf = new Text(dateInfValuetAL.get(i));
            HBox hBox = new HBox(10);
            CheckBox checkBox = new CheckBox();
            checkBoxArrayList.add(checkBox);
            hBox.getChildren().addAll(checkBox, name, type, dataStart, dataInf);
            listOL.add(hBox);
        }

        this.list.setItems(listOL);
        Data.save();
    }
}
