package data;

import javafx.beans.Observable;
import javafx.collections.ObservableList;

public class Data {
    private static ObservableList<String> list;

    public static ObservableList<String> getList() {
        return list;
    }

    public static void leggTil(String nyttObjekt) {
        //this.list.add(nyttObjekt);
    }
    //Lister som lagrer objekter
}
