package cantina;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage palcoPrincipal) throws Exception {
        // Carrega o arquivo fxml. Certifique-se de que o nome aqui seja igual ao do seu arquivo fxml
        Parent raiz = FXMLLoader.load(getClass().getResource("primary.fxml"));
        
        palcoPrincipal.setTitle("Cantina TOP");
        palcoPrincipal.setScene(new Scene(raiz, 500, 450));
        palcoPrincipal.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}