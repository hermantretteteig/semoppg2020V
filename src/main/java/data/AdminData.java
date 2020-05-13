package data;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import models.brukere.Admin;

public class AdminData {
    private static ObservableList<Admin> admins = FXCollections.observableArrayList();

    static ObservableList<Admin> getAdminer() {
        return admins;
    }

    //TODO fjerne?
    public static Admin getAdmin(String adminnr){
        Admin admin = null;
        for (Admin enAdmin : admins) {
            if (adminnr.equals(enAdmin.getAdminnummer())) {
                admin = enAdmin;
            }
        }
        return admin;
    }

    public static void leggTilAdmin(Admin nyAdmin){
        admins.add(nyAdmin);
    }

    public static void setAdmins(ObservableList<Admin> admins) {
        AdminData.admins = admins;
    }
}
