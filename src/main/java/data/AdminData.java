package data;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import models.brukere.Admin;
import models.komponent.Komponent;

import java.util.ArrayList;

public class AdminData {
    private static ObservableList<Admin> admins = FXCollections.observableArrayList();

    public static ObservableList<Admin> getAdmins() {
        return admins;
    }

    //Metode som henter alle komponentene i listen og returnerer som arraylist
    public static ArrayList<Admin> getAdminArray() {
        return new ArrayList<>(admins);
    }

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

    public static void setAlleAdmins(ArrayList<Admin> admins) {
        AdminData.admins = FXCollections.observableArrayList(admins);
    }
}
