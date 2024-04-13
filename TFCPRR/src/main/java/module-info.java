module com.example.tfcprr {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.MainPackage to javafx.fxml;
    exports com.example.MainPackage;
    exports Controllers;
    opens Controllers to javafx.fxml;
}