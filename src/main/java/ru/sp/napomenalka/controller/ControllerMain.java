package ru.sp.napomenalka.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.util.StringConverter;
import ru.sp.napomenalka.data.Data;
import ru.sp.napomenalka.data.Table;
import ru.sp.napomenalka.util.GetMainItem;
import ru.sp.napomenalka.util.StageDialog;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class ControllerMain {
    public ComboBox listOrganization;
    public ComboBox listType;
    public DatePicker dateStart;
    public DatePicker dateInf;
    public TableView table;
    public static GetMainItem getMainItem;
    ArrayList<Table> tables = new ArrayList<>();
    ArrayList<String> organizationAddValuetAL = Data.LIST_ORGANIZATION_ADD.getValuetAL();
    ArrayList<String> listTypeOfSubscriptionAddValuetAL = Data.LIST_TYPE_OF_SUBSCRIPTION_ADD.getValuetAL();
    ArrayList<String> dateStartValuetAL = Data.DATE_START.getValuetAL();
    ArrayList<String> dateInfValuetAL = Data.DATE_INF.getValuetAL();

    public void initialize() {
        getMainItem = new GetMainItem(listOrganization, listType, dateStart, dateInf, table);
        ObservableList<String> listOrganizationO = FXCollections.observableArrayList();
        listOrganizationO.addAll(Data.LIST_ORGANIZATION.getValuetAL());
        listOrganization.setItems(listOrganizationO);
        ObservableList<String> listTypeO = FXCollections.observableArrayList();
        listTypeO.addAll(Data.LIST_TYPE_OF_SUBSCRIPTION.getValuetAL());
        listType.setItems(listTypeO);


        listOrganization.setValue(Data.LIST_ORGANIZATION.getValuetAL().get(0));
        listType.setValue(Data.LIST_TYPE_OF_SUBSCRIPTION.getValuetAL().get(0));

        TableColumn<Table, String> TCorganization = new TableColumn<Table, String>("Организация");
        TableColumn<Table, String> TCtype = new TableColumn<Table, String>("Тип подписки");
        TableColumn<Table, String> TCdateStart = new TableColumn<Table, String>("Дата начала");
        TableColumn<Table, String> TCdateInf = new TableColumn<Table, String>("Дата предупрежденения");
        TCorganization.setCellValueFactory(new PropertyValueFactory<>("name"));
        TCtype.setCellValueFactory(new PropertyValueFactory<>("type"));
        TCdateStart.setCellValueFactory(new PropertyValueFactory<>("dataStart"));
        TCdateInf.setCellValueFactory(new PropertyValueFactory<>("dataInf"));
        table.getColumns().addAll(TCorganization, TCtype, TCdateStart, TCdateInf);
        arreyLoder();


        StringConverter<LocalDate> converter = new StringConverter<LocalDate>() {
            DateTimeFormatter dateFormatter =
                    DateTimeFormatter.ofPattern("dd/MM/yyyy");

            @Override
            public String toString(LocalDate date) {
                if (date != null) {
                    return dateFormatter.format(date);
                } else {
                    return "";
                }
            }

            @Override
            public LocalDate fromString(String string) {
                if (string != null && !string.isEmpty()) {
                    return LocalDate.parse(string, dateFormatter);
                } else {
                    return null;
                }
            }

        };
        dateStart.setPromptText("дд/мм/гггг");
        dateInf.setPromptText("дд/мм/гггг");
        dateStart.setConverter(converter);
        dateInf.setConverter(converter);


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
        this.table.setItems(list);

    }

    public void orgButton(ActionEvent actionEvent) {
        new StageDialog("addORG");
    }

    public void typeButton(ActionEvent actionEvent) {
        new StageDialog("addTYPE");
    }

    public void addList(ActionEvent actionEvent) {
        try {

            String
                    name = String.valueOf(listOrganization.getValue()),
                    type = String.valueOf(listType.getValue()),
                    dataStart = String.valueOf(dateStart.getValue()),
                    dataInf = String.valueOf(dateInf.getValue());

            organizationAddValuetAL.add(name);
            listTypeOfSubscriptionAddValuetAL.add(type);
            dateStartValuetAL.add(dataStart);
            dateInfValuetAL.add(dataInf);

            System.out.println(name);
            System.out.println(type);
            System.out.println(dataStart);
            System.out.println(dataInf);

            tables.add(new Table(name, type, dataStart, dataInf, tables.size()));
            ObservableList<Table> list = FXCollections.observableArrayList();
            list.addAll(tables);
            this.table.setItems(list);
            arreyWriter();
        } catch (Exception e) {

        }

    }

    void arreyLoder() {
        organizationAddValuetAL = Data.LIST_ORGANIZATION_ADD.getValuetAL();
        listTypeOfSubscriptionAddValuetAL = Data.LIST_TYPE_OF_SUBSCRIPTION_ADD.getValuetAL();
        dateStartValuetAL = Data.DATE_START.getValuetAL();
        dateInfValuetAL = Data.DATE_INF.getValuetAL();
    }

    void arreyWriter() {
        Data.LIST_ORGANIZATION_ADD.setValue(organizationAddValuetAL);
        Data.LIST_TYPE_OF_SUBSCRIPTION_ADD.setValue(listTypeOfSubscriptionAddValuetAL);
        Data.DATE_START.setValue(dateStartValuetAL);
        Data.DATE_INF.setValue(dateInfValuetAL);
        Data.save();
    }

    public void remyve(ActionEvent actionEvent) {
        new StageDialog("remuv");
    }
}
