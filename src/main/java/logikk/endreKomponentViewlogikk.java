package logikk;

import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Tab;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class endreKomponentViewlogikk {
    public static TableColumn coTrodlos;
    public TableColumn coNumpad;
    public TableColumn coPris;


    public ChoiceBox choKomponentvelger;

    //Lagrinsenhet
    public TableColumn coGb;
    public TableColumn coFormat;
    public TableColumn coLesehastighet;
    public TableColumn coSkrivehastighet;

    public static void overForTableColumn(TableColumn coTrodlos1, TableColumn coNumpad, TableColumn coPris){
        coTrodlos = coTrodlos1;
    }

    public static void visLagrinsenhet(){

    }
}
