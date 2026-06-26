module com.mycompany.jogo {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    //requires org.postgresql.jdbc;
    requires javafx.graphics;
    requires javafx.base;

    opens com.mycompany.jogo to javafx.fxml;
    opens controller to javafx.fxml;
    opens model to javafx.base, javafx.fxml;
    opens util to javafx.fxml;

    exports com.mycompany.jogo;
    exports controller;
    exports model;
    exports util;
}
