package org.example.adminController;

import data.KundeData;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import models.brukere.Kunde;
import org.example.App;
import validering.Check;

public class EndreKunde {
        @FXML
        private TableView tableView;

        //Objekt som inneholder alle kundedaten
        private KundeData kunder = new KundeData();

        //Knapp som sender brukeren tilbake til dashboard
        @FXML
        public void tilbakeAction(ActionEvent event) throws Exception {
            App.setRoot("adminView/dashboardAdmin");
        }

        //Metode for å slette en kunde
        @FXML
        public void slettKunde(ActionEvent event){
            //Sjekker at en kunde faktisk er valgt
            if(tableView.getSelectionModel().getSelectedItem()!=null){
                Kunde slettKunde =  (Kunde) tableView.getSelectionModel().getSelectedItem();
                KundeData.slettKunde(slettKunde);
                kunder.hentAlleKunder(tableView);
            }
        }

        @FXML
        public void initialize() {
            kunder.hentAlleKunder(tableView);
            /*
            Veridene til kollonnene blir hentet direkte fra FXML-filen, ved bruk av "cellValueFactory"
             */
        }

        /*
        Under kommmer en rekke metoder for endring av data i tabellen. Metodene tar inn cellen/attributten som
        er i endring som parameter. Deretter valideres verdien i en check-metode som returnerer true/false. Dette
        svaret brukes av metoden "valider" som returnerer false og viser dialogvindu med feilinformasjon,
        eller returnerer "true" og oppdaterer objektet med den nye verdien.
         */
        public void FornavnEdit(TableColumn.CellEditEvent<Kunde, String> event) {
            if(valider("Må kun inneholde bokstaver", Check.bokstavercheck(event.getNewValue()))==true){
            event.getRowValue().setFornavn(event.getNewValue()); }
            tableView.refresh();
        }

        public void EtternavnEdit(TableColumn.CellEditEvent<Kunde, String> event) {
            if(valider("Må kun inneholde bokstaver", Check.bokstavercheck(event.getNewValue()))==true){
            event.getRowValue().setEtternavn(event.getNewValue()); }
            tableView.refresh();
        }

        public void BrukernavnEdit(TableColumn.CellEditEvent<Kunde, String> event) {
            if(valider("For kort brukernavn. Minst to tegn", Check.lengdeCheck(event.getNewValue()))==true){
            event.getRowValue().setBrukernavn(event.getNewValue()); }
            tableView.refresh();
        }

        public void PassordEdit(TableColumn.CellEditEvent<Kunde, String> event) {
            if(valider("Ugyldig passord! \nMå være små og store bokstaver, \nminst 8 tegn og inneholde tall", Check.passordchecker(event.getNewValue()))==true){
            event.getRowValue().setPassord(event.getNewValue()); }
            tableView.refresh();
        }

        public void EpostEdit(TableColumn.CellEditEvent<Kunde, String> event) {
            if(valider("Du har skrevet inn en ugyldig epost", Check.epostchecker(event.getNewValue()))==true){
            event.getRowValue().setEpost(event.getNewValue()); }
            tableView.refresh();
        }

        /*
        Brukes til endring av celler. Hvis valideringen ikke er gyldig vises feil om dette.
        Hvis den er gyldig returnerer metoden true, og den nye verdien til cellen blir lagret.
         */
        public static boolean valider(String msg, Boolean feil){
            if (feil == false) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Wooops!");
                alert.setHeaderText(msg);
                alert.setContentText("Prøv igjen!");
                alert.showAndWait();
                return false;
            }
            return true;
        }
    }