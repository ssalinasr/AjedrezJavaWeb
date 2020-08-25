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
public class Rey extends Ficha{

    public Rey(String color, Point posicion, String modelo) {
        super(color, posicion, modelo);
        this.cargarAnimacion("animacionRey.gif");
    }

    @Override
    public ArrayList<Point> posiblesMovimientos(Tablero t) {
        ArrayList<Point> pm = new ArrayList<Point>();
        int x=0,y=0;
        x=this.getPosicion().x;
        y=this.getPosicion().y;
        if(x+1<8){
            pm.add(new Point(x+1,y));
        }
        if(x-1>=0){
            pm.add(new Point(x-1,y));
        }
        if(y+1<8){
            pm.add(new Point(x,y+1));
        }
        if(y-1>=0){
            pm.add(new Point(x,y-1));
        }
        if(x-1>=0&&y+1<8){
            pm.add(new Point(x-1,y+1));
        }
        if(x-1>=0&&y-1>=0){
            pm.add(new Point(x-1,y-1));
        }
        if(x+1<8&&y+1<8){
            pm.add(new Point(x+1,y+1));
        }
        if(x+1<8&&y-1>=0){
            pm.add(new Point(x+1,y-1));
        }
        return pm;
    }
}
