module com.mycompany.jogo {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires org.postgresql.jdbc;

    opens com.mycompany.jogo to javafx.fxml;
    exports com.mycompany.jogo;
}
