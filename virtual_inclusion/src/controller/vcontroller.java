package controller;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.Timer;
import java.util.TimerTask;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;

public class vcontroller implements Initializable {

    @FXML
    private ImageView image;

    public static int a = 0;

    @FXML
    public MediaView mediaV;

    Image img;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        try {
            Toolkit t = Toolkit.getDefaultToolkit();
            Dimension size = Toolkit.getDefaultToolkit().getScreenSize();
            image.setFitHeight(size.height);
            image.setFitWidth(size.width);
            String s = getClass().getResource("../image/2.png") + "";
            img = new Image(new FileInputStream(s.substring(5, s.length())));
            image.setImage(img);
            // this.audio("C:\\Users\\Takit\\Documents\\NetBeansProjects\\virtual_inclusion\\src\\music\\thefatrat-never-be-alone-letra-en-espanol-e-ingles.mp3");
            this.posicion();
            a=1;

        } catch (FileNotFoundException ex) {
            Logger.getLogger(vcontroller.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void audio(String path) {

        Media media = new Media(new File(path).toURI().toString());
        MediaPlayer mediaPlayer = new MediaPlayer(media);
        mediaPlayer.setAutoPlay(true);
        mediaV.setMediaPlayer(mediaPlayer);
    }

    public void posicion() {
        Timer timer;
        timer = new Timer();

        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                if (a != 0) {
                    switch (a) {
                        case 1:
                            audio("C:\\Users\\Takit\\Documents\\NetBeansProjects\\virtual_inclusion\\src\\music\\Inicio.mp3");
                            break;
                        case 2:
                            audio("C:\\Users\\Takit\\Documents\\NetBeansProjects\\virtual_inclusion\\src\\music\\Insertar.mp3");
                            break;
                        case 3:
                            audio("C:\\Users\\Takit\\Documents\\NetBeansProjects\\virtual_inclusion\\src\\music\\Pegar.mp3");
                            break;
                        case 4:
                            audio("C:\\Users\\Takit\\Documents\\NetBeansProjects\\virtual_inclusion\\src\\music\\Calibrí cuerpo.mp3");
                            break;
                        case 5:
                            audio("C:\\Users\\Takit\\Documents\\NetBeansProjects\\virtual_inclusion\\src\\music\\Tamaño.mp3");
                            break;
                        case 6:
                            audio("C:\\Users\\Takit\\Documents\\NetBeansProjects\\virtual_inclusion\\src\\music\\Negrita.mp3");
                            break;
                        case 7:
                            audio("C:\\Users\\Takit\\Documents\\NetBeansProjects\\virtual_inclusion\\src\\music\\Cursiva.mp3");
                            break;
                        case 8:
                            audio("C:\\Users\\Takit\\Documents\\NetBeansProjects\\virtual_inclusion\\src\\music\\Subrayado.mp3");
                            break;
                    }

                    a = 0;
                }
            }
        };
        // Empezamos dentro de 10ms y luego lanzamos la tarea cada 1000ms
        timer.schedule(task, 0, 500);
    }

}
