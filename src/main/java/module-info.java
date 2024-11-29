module com.example.shaitantaxi {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires org.kordamp.bootstrapfx.core;

    opens com.example.shaitantaxi to javafx.fxml;
    exports com.example.shaitantaxi;
}