package data;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import models.kjop.Ordre;

    public class OrdeData {
        private static ObservableList<Ordre> ordre = FXCollections.observableArrayList();

        public static ObservableList<Ordre> getOrdre() {
            return ordre;
        }

        public static void leggTilOrdre(Ordre nyOrdre){
            ordre.add(nyOrdre);
        }
    }

