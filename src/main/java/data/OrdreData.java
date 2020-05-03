package data;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableView;
import models.kjop.Ordre;
import models.komponent.Komponent;

public class OrdreData {
        private static ObservableList<Ordre> ordre = FXCollections.observableArrayList();

        public static ObservableList<Ordre> getOrdre() {
            return ordre;
        }

        public static void leggTilOrdre(Ordre nyOrdre){
            ordre.add(nyOrdre);
        }

    public void hentKomponenttype(TableView tv) {
        tv.setItems(ordre);
    }
    }

