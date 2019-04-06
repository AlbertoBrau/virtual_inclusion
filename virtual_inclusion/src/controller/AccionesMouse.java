package controller;

import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.PointerInfo;
import java.awt.Robot;
import java.util.Timer;
import java.util.TimerTask;

public class AccionesMouse {

    Point punto;
    String a = "";
    int xx=28, yy=108,rx,ry,c=1;
    Robot robot = null;
    int origenx = 130, origeny = 100;

    public AccionesMouse() {
        try {
            robot = new Robot();
        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }

    
    public void redireccion() {
        if (c == 1) {
            cambiar(300,98);
            c++;
        }else if (c == 2) {
            cambiar(285,130);
            c++;
        }else if (c == 3) {
             cambiar(395,98);
            c++;
        }
    }

    public void cambiar(int px, int py) {
        origenx = px;
        origeny = py;
        
        robot.mouseMove(px, py);
       
    }
}
