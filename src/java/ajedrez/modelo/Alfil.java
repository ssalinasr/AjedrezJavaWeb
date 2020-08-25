/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ajedrez.modelo;

import java.awt.Point;
import java.util.ArrayList;

/**
 *
 * @author Christian Galindo
 */
public class Alfil extends Ficha {

    public Alfil(String color, Point posicion, String modelo) {
        super(color, posicion, modelo);
        this.cargarAnimacion("animacionAlfil.gif");
    }

    @Override
    public ArrayList<Point> posiblesMovimientos(Tablero t) {
        int x = 0, y = 0;
        ArrayList<Point> pm = new ArrayList<Point>();
        x = this.getPosicion().x;
        y = this.getPosicion().y;
        while (x < 7 && y < 7) {
            if(t.verificarExistencia(new Point(x+1,y+1), this)) {
                break;
            }else{
                if(t.verificarExistencia2(new Point(x+1,y+1), this)){
                    pm.add(new Point(x+1,y+1));
                    break;
                }else{
                    pm.add(new Point(x+1,y+1));
                    x++;
                    y++;
                }
            }
        }
        x = this.getPosicion().x;
        y = this.getPosicion().y;
        while (x < 7 && y > 0) {
            if(t.verificarExistencia(new Point(x+1,y-1), this)){
                break;
            }else{
                if(t.verificarExistencia2(new Point(x+1,y-1), this)){
                    pm.add(new Point(x+1,y-1));
                    break;
                }else{
                    pm.add(new Point(x+1,y-1));
                    x++;
                    y--;
                }
            }
        }
        x = this.getPosicion().x;
        y = this.getPosicion().y;
        while (x > 0 && y < 7) {
            if(t.verificarExistencia(new Point(x-1,y+1), this)){
                break;
            }else{
                if(t.verificarExistencia2(new Point(x-1,y+1), this)){
                    pm.add(new Point(x-1,y+1));
                    break;
                }else{
                    pm.add(new Point(x-1,y+1));
                    x--;
                    y++;
                }
            }
        }
        x = this.getPosicion().x;
        y = this.getPosicion().y;
        while (x > 0 && y > 0) {
            if(t.verificarExistencia(new Point(x-1,y-1), this)){
                break;
            }else{
                if(t.verificarExistencia2(new Point(x-1,y-1), this)){
                    pm.add(new Point(x-1,y-1));
                    break;
                }else{
                    pm.add(new Point(x-1,y-1));
                    x--;
                    y--;
                }
            }
        }
        /*
        if(this.getColor()=="blanco"){
            t.movimientosJugador("negro");
        }*/
        
        return pm;
    }

}
