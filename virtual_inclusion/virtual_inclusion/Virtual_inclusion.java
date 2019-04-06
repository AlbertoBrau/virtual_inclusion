package virtual_inclusion;

import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Virtual_inclusion extends Application{
    
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent p = new FXMLLoader().load(this.getClass().getResource("../view/vvistaP.fxml"));
        
        Scene es = new Scene (p, 900, 400);
        es.getStylesheets().addAll(getClass().getResource("../view/style.css").toExternalForm());
        primaryStage.setScene(es);
        primaryStage.setFullScreen(true);
        primaryStage.show();
        
        
    }
    
}
