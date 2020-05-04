package data;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import models.brukere.Admin;
import models.brukere.Kunde;


public class AdminData {
        private static ObservableList<Admin> adminer = FXCollections.observableArrayList();

        public static ObservableList<Admin> getAdminer() {
        return adminer;
    }

        public static void leggTilAdmin(Admin nyAdmin){
            adminer.add(nyAdmin);
    }

}
