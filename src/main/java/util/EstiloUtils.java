package util;

import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.ListView;

public class EstiloUtils {
    public static final String STYLE_PRIMARY = "-fx-background-color: #444444; -fx-text-fill: #ffffff; -fx-font-size: 13px; -fx-font-weight: bold; -fx-background-radius: 4; -fx-border-radius: 4; -fx-border-color: #666666; -fx-border-width: 1; -fx-padding: 8 20; -fx-cursor: hand;";
    public static final String STYLE_PRIMARY_HOVER = "-fx-background-color: #555555; -fx-text-fill: #ffffff; -fx-font-size: 13px; -fx-font-weight: bold; -fx-background-radius: 4; -fx-border-radius: 4; -fx-border-color: #888888; -fx-border-width: 1; -fx-padding: 8 20; -fx-cursor: hand;";

    public static final String STYLE_SECONDARY = "-fx-background-color: #2e2e2e; -fx-text-fill: #cccccc; -fx-font-size: 13px; -fx-font-weight: bold; -fx-background-radius: 4; -fx-border-radius: 4; -fx-border-color: #444444; -fx-border-width: 1; -fx-padding: 8 20; -fx-cursor: hand;";
    public static final String STYLE_SECONDARY_HOVER = "-fx-background-color: #3e3e3e; -fx-text-fill: #ffffff; -fx-font-size: 13px; -fx-font-weight: bold; -fx-background-radius: 4; -fx-border-radius: 4; -fx-border-color: #666666; -fx-border-width: 1; -fx-padding: 8 20; -fx-cursor: hand;";

    public static final String STYLE_ACTION = "-fx-background-color: #2e2e2e; -fx-text-fill: #ffffff; -fx-font-size: 12px; -fx-font-weight: bold; -fx-background-radius: 4; -fx-border-radius: 4; -fx-border-color: #555555; -fx-border-width: 1; -fx-padding: 6 12; -fx-cursor: hand;";
    public static final String STYLE_ACTION_HOVER = "-fx-background-color: #3e3e3e; -fx-text-fill: #ffffff; -fx-font-size: 12px; -fx-font-weight: bold; -fx-background-radius: 4; -fx-border-radius: 4; -fx-border-color: #555555; -fx-border-width: 1; -fx-padding: 6 12; -fx-cursor: hand;";

    public static final String STYLE_COMBAT = "-fx-background-color: #aa3333; -fx-text-fill: #ffffff; -fx-font-size: 13px; -fx-font-weight: bold; -fx-background-radius: 4; -fx-border-radius: 4; -fx-border-color: #cc4444; -fx-border-width: 1; -fx-padding: 8 20; -fx-cursor: hand;";
    public static final String STYLE_COMBAT_HOVER = "-fx-background-color: #bb4444; -fx-text-fill: #ffffff; -fx-font-size: 13px; -fx-font-weight: bold; -fx-background-radius: 4; -fx-border-radius: 4; -fx-border-color: #cc4444; -fx-border-width: 1; -fx-padding: 8 20; -fx-cursor: hand;";

    public static final String STYLE_TEXT_INPUT = "-fx-background-color: #2e2e2e; -fx-text-fill: #ffffff; -fx-prompt-text-fill: #808080; -fx-border-color: #555555; -fx-border-width: 1; -fx-border-radius: 4; -fx-background-radius: 4; -fx-padding: 6;";
    public static final String STYLE_LIST_VIEW = "-fx-background-color: #2a2a2a; -fx-border-color: #444444; -fx-border-radius: 4; -fx-background-radius: 4;";

    public static void aplicarBotaoPrimario(Button btn) {
        btn.setStyle(STYLE_PRIMARY);
        btn.setOnMouseEntered(e -> btn.setStyle(STYLE_PRIMARY_HOVER));
        btn.setOnMouseExited(e -> btn.setStyle(STYLE_PRIMARY));
    }

    public static void aplicarBotaoSecundario(Button btn) {
        btn.setStyle(STYLE_SECONDARY);
        btn.setOnMouseEntered(e -> btn.setStyle(STYLE_SECONDARY_HOVER));
        btn.setOnMouseExited(e -> btn.setStyle(STYLE_SECONDARY));
    }

    public static void aplicarBotaoAcao(Button btn) {
        btn.setStyle(STYLE_ACTION);
        btn.setOnMouseEntered(e -> btn.setStyle(STYLE_ACTION_HOVER));
        btn.setOnMouseExited(e -> btn.setStyle(STYLE_ACTION));
    }

    public static void aplicarBotaoCombate(Button btn) {
        btn.setStyle(STYLE_COMBAT);
        btn.setOnMouseEntered(e -> btn.setStyle(STYLE_COMBAT_HOVER));
        btn.setOnMouseExited(e -> btn.setStyle(STYLE_COMBAT));
    }

    public static void aplicarCampoTexto(TextField tf) {
        tf.setStyle(STYLE_TEXT_INPUT);
    }

    public static void aplicarListView(ListView<?> lv) {
        lv.setStyle(STYLE_LIST_VIEW);
    }
}
