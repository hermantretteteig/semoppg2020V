package org.example.adminController;

import data.KomponentData;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.CheckBoxTableCell;
import javafx.scene.control.cell.ComboBoxTableCell;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.util.Callback;
import javafx.util.converter.DoubleStringConverter;
import javafx.util.converter.IntegerStringConverter;
import logikk.Advarsel;
import models.komponent.*;
import org.example.App;
import validering.Check;

public class EndreKomponentController {
    @FXML
    private TableView tableView;
    @FXML
    private TableColumn coTrodlos, coNumpad;
    @FXML
    private ChoiceBox choKomponentvelger;

    //Lagringsenhet
    @FXML
    private TableColumn coGb, coFormat, coLesehastighet, coSkrivehastighet;
    //Mus
    @FXML
    private TableColumn coMusTrodlos, coFarge;
    //Prosessor
    @FXML
    private TableColumn coKjerner, coKlokkehastighet;
    //Sjerm
    @FXML
    private TableColumn coHoyde, coBredde, co4K;
    //Gjelder alle komponenter
    @FXML
    private TableColumn coType, coSkKlokkehastighet, coMinne, coPris;
    //Filtrering
    @FXML
    private TextField txtPrisFra, txtPrisTil;

    //Hender liste over alle komponenter
    private KomponentData komponentene = new KomponentData();

    //Knapp som fører tilbake til dashboard
    @FXML
    public void tilbakeAction(ActionEvent event) throws Exception {
        App.setRoot("adminview/dashboardAdmin");
    }

    //Metode som sletter en komponent
    @FXML
    public void slettKomponent(ActionEvent event){
        //Kontrollerer at en komponent er valgt, for å forhindre nullpointerexception
        if(tableView.getSelectionModel().getSelectedItem()!=null) {
            //Caster objektet i tabellen til en komponent
            Komponent slettKom = (Komponent) tableView.getSelectionModel().getSelectedItem();
            //Sletter komponenten fra listen
            KomponentData.slettKomponent(slettKom);
            //Oppdaterer viewt ved å hente det inn på nytt
            komponentene.hentKomponenttype(tableView, choKomponentvelger.getValue().toString());
        }
    }

    //Knapp som brukes til å aktivere filtreringen på pris
    @FXML
    public void filtrerAction(ActionEvent event){
        //Kontroll som sjekker at verdiene i innputtfeltene er gyldig
        if(Check.desimaltallCheck(txtPrisFra.getText())==false || Check.desimaltallCheck(txtPrisTil.getText()) == false){
            //Gir informasjon om feilen til bruker hvis feil
            Advarsel.informasjonsAlert("Ugyldige verdier", "Prisene er ikke gyldig", "Prøv på nytt!");
        }
        else {
            //Hvis veridene er gyldig, parses de til double
            double prisFra = Double.parseDouble(txtPrisFra.getText());
            double prisTil = Double.parseDouble(txtPrisTil.getText());
            //Kaller på metoden filtrer pris i KomponentData med verdiene brukeren ønsker som som parametere
            komponentene.filtrerPris(tableView, prisFra, prisTil, choKomponentvelger.getValue().toString());
        }
    }

    //Knapp som nullstiller filtringen
    @FXML
    public void fjernFilterAction(ActionEvent event){
        //Nullstiller filtreringsfelter slik at det blir tydelig for brukeren at filteringen ikke gjelder lenger
        txtPrisFra.setText("");
        txtPrisTil.setText("");
        komponentene.hentKomponenttype(tableView, choKomponentvelger.getValue().toString());
    }

    /*
    Når valgboksen over de ulike komponentene endres kjøres denne metoden. Metoden filtrerer
    bort alle komponenttypene som ikke samsvarer med det brukeren har valgt*/
    @FXML
    public void hentAction(ActionEvent event) throws Exception {
        //Nullstiller filtreringsfelter slik at det blir tydelig for brukeren at filteringen ikke gjelder lenger
        txtPrisFra.setText("");
        txtPrisTil.setText("");
        //Alle kollonnene skjules
        SkjulAlleEkstrakolonner();

        /*En filtreringsmetode kalles. Denne filtrer bort
        alle komponentene som ikke samsvarer med den brukeren har valgt.*/
        komponentene.hentKomponenttype(tableView, choKomponentvelger.getValue().toString());

        //De kollonnene som er realatert til komponentypen som er valgt vises
        visEkstrakolonner(choKomponentvelger.getValue().toString());
    }

    @FXML
    public void initialize() {
        /*Konverterer double og integer til string, slik at disse verdiene kan bli endres i et tekstfelt.
          Dette må gjøres ettersom tekstfelt kun støtter å hente inn string.*/
        coPris.setCellFactory(TextFieldTableCell.forTableColumn(new EgendefinertDoubleConverter()));
        coGb.setCellFactory(TextFieldTableCell.forTableColumn(new EgendefinertIntegerConverterer()));
        coKjerner.setCellFactory(TextFieldTableCell.forTableColumn(new EgendefinertIntegerConverterer()));
        coKlokkehastighet.setCellFactory(TextFieldTableCell.forTableColumn(new EgendefinertDoubleConverter()));
        coBredde.setCellFactory(TextFieldTableCell.forTableColumn(new EgendefinertIntegerConverterer()));
        coHoyde.setCellFactory(TextFieldTableCell.forTableColumn(new EgendefinertIntegerConverterer()));
        coSkKlokkehastighet.setCellFactory(TextFieldTableCell.forTableColumn(new EgendefinertDoubleConverter()));
        coMinne.setCellFactory(TextFieldTableCell.forTableColumn(new EgendefinertIntegerConverterer()));

        /*Noen felter krever noe annet enn tekstfelt. Dette gjelder verdier som skal vises i lister eller
        sjekkbokser (true/false). For dette brukes nedtrekkslister (ComboBoxTableCell) og
        sjekkbokser (CheckBoxTableCell)*/
        coFormat.setCellFactory(ComboBoxTableCell.<Lagringsenhet, String>forTableColumn("SSD 2.5", "SDD M.2", "SSD mSATA", "HDD"));
        coNumpad.setCellFactory( CheckBoxTableCell.forTableColumn(coNumpad) );
        coTrodlos.setCellFactory(CheckBoxTableCell.forTableColumn(coTrodlos) );
        coFarge.setCellFactory(ComboBoxTableCell.<Lagringsenhet, String>forTableColumn("Grå", "Svart", "Blå", "Brun", "Rose", "Hvit", "Oransje", "Rød"));
        co4K.setCellFactory( CheckBoxTableCell.forTableColumn(co4K) );
        coMusTrodlos.setCellFactory( CheckBoxTableCell.forTableColumn(coMusTrodlos) );

        //Lager bindinger til tabell, kommentert i detalje lenger ned
        LagBindingFraDataTilTabell();

        //Setter startvisning til å være lagringsenhet
        choKomponentvelger.setValue("Vis alle");

        //Skjuler alle kollonner
        SkjulAlleEkstrakolonner();

        /*Metode som filtrer bort alle komponenttypene, borsett fra den
        komponenttypen som samsvarer med den brukeren har valgt å vise*/
        komponentene.hentKomponenttype(tableView, choKomponentvelger.getValue().toString());

        //Setter kolonner som gjelder for "Lagringsenhet" synlig
        visEkstrakolonner(choKomponentvelger.getValue().toString());
    }

    /*
    Under kommmer en rekke metoder for endring av data i tabellen. Metodene tar inn cellen/attributten som
    er i endring som parameter. Deretter valideres verdien i en check-metode som returnerer true/false. Dette
    svaret brukes av metoden "valider" som returnerer false og viser dialogvindu med feilinformasjon,
    eller returnerer "true" og oppdaterer objektet med den nye verdien.
     */

    public void VareMerkeEdit(TableColumn.CellEditEvent<Komponent, String> event) {
        //Validerer om veriden er gyldig og viser eventull feilmld hvis ikke.
        if(valider("For kort varemerkenavn. Minst to tegn", Check.lengdeCheck(event.getNewValue())) == true) {
            //Hvis gyldig endrer veriden
            event.getRowValue().setVaremerke(event.getNewValue());
        }
        else {
                //Hvis ugyldig setter cellen tilbake til den gamle verdien
                event.getRowValue().setVaremerke(event.getOldValue());
        }
        tableView.refresh();

    }

    public void PrisEdit(TableColumn.CellEditEvent<Komponent, Double> event) {
        //Sjekker hvis verdien fra konverteringsmetoden er er -1, hvis dette er tilfellet endres ikke verdien
        if(valider("Må kun inneholde tall", event.getNewValue()!=-1 == true)) {
            event.getRowValue().setPris(event.getNewValue());
        }
        else {
            event.getRowValue().setPris(event.getOldValue());
        }
        tableView.refresh();
    }

    public void ModellEdit(TableColumn.CellEditEvent<Komponent, String> event) {
        if(valider("For kort modelnavn. Minst to tegn", Check.lengdeCheck(event.getNewValue())) == true) {
            event.getRowValue().setModell(event.getNewValue());
        }
        else {
            event.getRowValue().setModell(event.getOldValue());
        }
        tableView.refresh();
    }

    //Tastatur
    public void NumpadEdit(TableColumn.CellEditEvent<Komponent, Boolean> event) {
        ((Tastatur) event.getRowValue()).setNumpad(event.getNewValue());
    }

    public void TrodlosEdit(TableColumn.CellEditEvent<Komponent, Boolean> event) {
        System.out.println("endrnge endr");
        ((Tastatur) event.getRowValue()).setTrodlos(event.getNewValue());
    }

    //Lagringsenhet
    public void FormatEdit(TableColumn.CellEditEvent<Komponent, String> event) {
        ((Lagringsenhet) event.getRowValue()).setFormat(event.getNewValue());
    }

    public void GbEdit(TableColumn.CellEditEvent<Komponent, Integer> event) {
        if(valider("Må kun inneholde tall", event.getNewValue()!=-1 == true)) {
            ((Lagringsenhet) event.getRowValue()).setGb(event.getNewValue());
        }
        else{
            ((Lagringsenhet) event.getRowValue()).setGb(event.getOldValue());
        }
        tableView.refresh();
    }

    public void SkrivehastighetEdit(TableColumn.CellEditEvent<Komponent, String> event) {
        if(valider("Må kun inneholde tall", Check.heltallCheck(event.getNewValue())) == true) {
            ((Lagringsenhet) event.getRowValue()).setSkriveHastighet(event.getNewValue());
        }
        else{
            ((Lagringsenhet) event.getRowValue()).setSkriveHastighet(event.getOldValue());
        }
        tableView.refresh();
    }

    public void LesehastighetEdit(TableColumn.CellEditEvent<Komponent, String> event) {
        if(valider("Må kun inneholde tall", Check.heltallCheck(event.getNewValue())) == true) {
            ((Lagringsenhet) event.getRowValue()).setLeseHastighet(event.getNewValue());
        }
        else{
            ((Lagringsenhet) event.getRowValue()).setLeseHastighet(event.getOldValue());
        }
        tableView.refresh();
    }

    //Mus
    public void MusTrodlosEdit(TableColumn.CellEditEvent<Komponent, Boolean> event) {
        ((Mus) event.getRowValue()).setTrodlos(event.getNewValue());
    }

    public void FargeEdit(TableColumn.CellEditEvent<Komponent, String> event){
        ((Mus) event.getRowValue()).setFarge(event.getNewValue());
    }

    //Prosessor
    public void KjernerEdit(TableColumn.CellEditEvent<Komponent, Integer> event) {
        if(valider("Må kun inneholde tall", event.getNewValue()!=-1)) {
            ((Prosessor) event.getRowValue()).setAntallKjerner(event.getNewValue());
        }
        else{
            ((Prosessor) event.getRowValue()).setAntallKjerner(event.getOldValue());
        }
        tableView.refresh();
    }

    public void KlokkehastgihetEdit(TableColumn.CellEditEvent<Komponent, Double> event) {
        if(valider("Må kun inneholde tall", event.getNewValue()!=-1)) {
            ((Prosessor) event.getRowValue()).setKlokkehastighet(event.getNewValue());
        }
        else{
            ((Prosessor) event.getRowValue()).setKlokkehastighet(event.getOldValue());
        }
        tableView.refresh();
    }

    //Skjerm
    public void HoydeEdit(TableColumn.CellEditEvent<Komponent, Integer> event) {
        if(valider("Må kun inneholde tall", event.getNewValue()!=-1)) {
            ((Skjerm) event.getRowValue()).setPixelHoyde(event.getNewValue());
        }
        else{
            ((Skjerm) event.getRowValue()).setPixelHoyde(event.getOldValue());
        }
        tableView.refresh();
    }

    public void BreddeEdit(TableColumn.CellEditEvent<Komponent, Integer> event) {
        if(valider("Må kun inneholde tall", event.getNewValue() != -1)) {
            ((Skjerm) event.getRowValue()).setPixelBredde(event.getNewValue());
        }
        else{
            ((Skjerm) event.getRowValue()).setPixelBredde(event.getOldValue());
        }
        tableView.refresh();
    }

    //Skjermkort
    public void SkKlokkehastgihetEdit(TableColumn.CellEditEvent<Komponent, Double> event) {
        if(valider("Må kun inneholde tall", event.getNewValue() != -1)) {
            ((Skjermkort) event.getRowValue()).setKlokkehastighet(event.getNewValue());
        }
        else{
            ((Skjermkort) event.getRowValue()).setKlokkehastighet(event.getOldValue());
        }
        tableView.refresh();
    }

    public void MinneEdit(TableColumn.CellEditEvent<Komponent, Integer> event) {
        if(valider("Må kun inneholde tall", event.getNewValue()!=-1)) {
            ((Skjermkort) event.getRowValue()).setMinne(event.getNewValue());
        }
        else{
            ((Skjermkort) event.getRowValue()).setMinne(event.getOldValue());
        }
        tableView.refresh();
    }

    /*
    Alle komponentene kan lastes inn i samme tabellview fordi alle de ulike komponentene arver
    fra klassen "Komponent". Derimot har de ulike komponenttypene ulike detaljer/attributter.
    For å kun vise de kollonnene som gjelder for komponenten brukeren har valgt skjules alle
    kollonnene, for deretter å sette de kollonnene som kun gjelder for komponenten synlige igjen.
     */
    public void SkjulAlleEkstrakolonner() {
        //Tastatur
        coTrodlos.setVisible(false);
        coNumpad.setVisible(false);

        //Lagringsenhet
        coGb.setVisible(false);
        coFormat.setVisible(false);
        coLesehastighet.setVisible(false);
        coSkrivehastighet.setVisible(false);

        //Mus
        coMusTrodlos.setVisible(false);
        coFarge.setVisible(false);

        //Prosessor
        coKjerner.setVisible(false);
        coKlokkehastighet.setVisible(false);

        //Skjerm
        coHoyde.setVisible(false);
        coBredde.setVisible(false);
        co4K.setVisible(false);

        //Skjermkort
        coSkKlokkehastighet.setVisible(false);
        coMinne.setVisible(false);

        //Type
        coType.setVisible(false);
    }
    /*
    Her gjøres de kollonnene som kun gjelder for den type komponent som brukeren har valgt synlig.
     Innparameteret er objektet/komponentens "SimpleName", dette navnet brukes i en switch som
     bestemmer hviklen kollonner som skal være synlig.
    */

    public void visEkstrakolonner(String type) {

        switch (type) {
            case "Lagringsenhet":
                coGb.setVisible(true);
                coFormat.setVisible(true);
                coLesehastighet.setVisible(true);
                coSkrivehastighet.setVisible(true);
                break;
            case "Tastatur":
                coTrodlos.setVisible(true);
                coNumpad.setVisible(true);
                break;
            case "Mus":
                coMusTrodlos.setVisible(true);
                coFarge.setVisible(true);
                break;
            case "Prosessor":
                coKjerner.setVisible(true);
                coKlokkehastighet.setVisible(true);
                break;
            case "Skjerm":
                coHoyde.setVisible(true);
                coBredde.setVisible(true);
                co4K.setVisible(true);
                break;
            case "Skjermkort":
                coSkKlokkehastighet.setVisible(true);
                coMinne.setVisible(true);
                break;
            case "Vis alle":
                coType.setVisible(true);
                break;
            default:
        }
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

    /*
    Metoden under lager bindinger til de datane som krever noe annet enn tekstfelt. I dette tilfellet er det
    valgvelger og sjekkboks.
     */
    private void LagBindingFraDataTilTabell() {
        coTrodlos.setCellValueFactory(
                new Callback<TableColumn.CellDataFeatures<Tastatur,Boolean>, ObservableValue<Boolean>>()
        {
            public ObservableValue<Boolean> call(TableColumn.CellDataFeatures<Tastatur, Boolean> event)
            {
                return event.getValue().getBpTrodlos();}
        });

        coNumpad.setCellValueFactory(
                new Callback<TableColumn.CellDataFeatures<Tastatur,Boolean>, ObservableValue<Boolean>>()
        {
            public ObservableValue<Boolean> call(TableColumn.CellDataFeatures<Tastatur, Boolean> event)
            {
                return event.getValue().getBpNumpad();}
        });
        co4K.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Skjerm,Boolean>, ObservableValue<Boolean>>()
        {
            public ObservableValue<Boolean> call(TableColumn.CellDataFeatures<Skjerm, Boolean> event)
            {
                return new SimpleBooleanProperty(event.getValue().getMin4K());}
        });
        coMusTrodlos.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Mus,Boolean>, ObservableValue<Boolean>>()
        {
            public ObservableValue<Boolean> call(TableColumn.CellDataFeatures<Mus, Boolean> event)
            {
                return event.getValue().getBpTrodlos();}
        });


        coFormat.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Lagringsenhet,String>, ObservableValue<String>>() {
            public ObservableValue<String> call(TableColumn.CellDataFeatures<Lagringsenhet, String> event) {
                return new SimpleStringProperty(event.getValue().getFormat());
            }
        });
    }

    /*
    Som nevnt er ikke alle attributtene/cellene lagret som string (for eksempel pris). For disse kreves
    det en egen konvertering som parser daten fra String til ønsket datatype når brukren endrer verdien.
    Konverteringen foregår ved at den først kontrollerer at veriden er gyldig i forhold til ønsket
    datatype. Hvis verdien er gyldig sendes verdien som retur. Hvis ikke sendes retur -1 som videre
    behandles og det vises en feilmelding.
     */
    public static class EgendefinertIntegerConverterer extends IntegerStringConverter {
        @Override
        public Integer fromString(String innputverdi) {
            //Sjekker at veriden er gyldig og returnerer den hvis den er gyldig.
            if(Check.heltallCheck(innputverdi)==true){
                return Integer.parseInt(innputverdi);
            }
            //Sender feilmeling -1 hvis ugylidg
            return -1;
        }
    }

    public static class EgendefinertDoubleConverter extends DoubleStringConverter {
        @Override
        public Double fromString(String innputverdi) {
            if(Check.heltallCheck(innputverdi)==true) {
                return Double.parseDouble(innputverdi);
            }
            return -1.0;
        }
    }
}

