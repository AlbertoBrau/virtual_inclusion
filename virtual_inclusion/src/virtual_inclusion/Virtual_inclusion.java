package virtual_inclusion;

import com.panamahitek.ArduinoException;
import com.panamahitek.PanamaHitek_Arduino;
import controller.AccionesMouse;
import controller.vcontroller;
import java.util.Timer;
import java.util.TimerTask;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import jssc.SerialPortException;

public class Virtual_inclusion extends Application {

    String r = "";

    PanamaHitek_Arduino arduino = new PanamaHitek_Arduino();

    public static void main(String[] args) {
        
        launch(args);
    }

    public void Formulario() {
        try {
            arduino.arduinoTX("COM8", 9600);
        } catch (ArduinoException ex) {
            Logger.getLogger(Virtual_inclusion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        this.Formulario();
        AccionesMouse a = new AccionesMouse();
        a.cambiar(180, 65);
        Parent p = new FXMLLoader().load(this.getClass().getResource("../view/vvistaP.fxml"));

        Scene es = new Scene(p, 900, 400);
        es.getStylesheets().addAll(getClass().getResource("../view/style.css").toExternalForm());

        es.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                switch (event.getCode()) {
                    case UP:

                        break;
                    case DOWN:
                        if (r.equals("") || r.equals("ins")) {
                            a.cambiar(50, 100);
                            r = "p";
                            vcontroller.a = 3;

                        } else if (r.equals("ca")) {
                            a.cambiar(230, 130);
                            r = "ne";
                            vcontroller.a = 6;
                        }
                        break;
                    case LEFT:
                        if (r.equals("i")) {
                            a.cambiar(128, 65);
                            r = "ins";

                            vcontroller.a = 1;
                        } else if (r.equals("ta")) {
                            a.cambiar(280, 98);
                            r = "ca";
                            vcontroller.a = 4;
                        }
                        break;
                    case RIGHT:
                        if (r.equals("")) {
                            a.cambiar(180, 65);
                            r = "i";
                            vcontroller.a = 2;
                        } else if (r.equals("p")) {
                            a.cambiar(250, 98);
                            r = "ca";
                            vcontroller.a = 4;
                        } else if (r.equals("ca")) {
                            a.cambiar(360, 98);
                            r = "ta";
                            vcontroller.a = 5;
                        } else if (r.equals("ne")) {
                            a.cambiar(260, 140);
                            vcontroller.a = 7;
                            r = "cu";
                        } else if (r.equals("cu")) {
                            a.cambiar(290, 140);
                            r = "ra";

                            vcontroller.a = 8;
                        }
                        break;
                }
            }
        });

        es.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                try {
                    arduino.sendData("1");
                } catch (ArduinoException ex) {
                    Logger.getLogger(Virtual_inclusion.class.getName()).log(Level.SEVERE, null, ex);
                } catch (SerialPortException ex) {
                    Logger.getLogger(Virtual_inclusion.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });

        primaryStage.setScene(es);
        primaryStage.setFullScreen(true);
        primaryStage.show();

    }

}
