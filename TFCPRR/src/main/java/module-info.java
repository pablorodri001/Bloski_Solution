module com.example.tfcprr {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.tfcprr to javafx.fxml;
    exports com.example.tfcprr;
}