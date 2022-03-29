module com.example.labo1v2 {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.xml;


    opens com.example.labo1v2 to javafx.fxml;
    exports com.example.labo1v2;
}