module com.example.tfcprr {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.persistence;
    requires org.hibernate.orm.core;
    requires java.naming;


    opens com.example.MainPackage to javafx.fxml;
    exports com.example.MainPackage;
    exports Controllers;
    opens Controllers to javafx.fxml;
}