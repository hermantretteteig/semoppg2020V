module org.example {
    requires javafx.controls;
    requires javafx.fxml;

    opens org.example to javafx.fxml;
    opens org.example.kundeController to javafx.fxml;
    opens org.example.adminController to javafx.fxml;

    exports org.example;
    exports org.example.kundeController;
    exports org.example.adminController.nyKomponent;
    exports org.example.adminController;
    exports org.example.adminController.endreKomponent;



}