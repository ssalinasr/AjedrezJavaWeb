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
public class Caballo extends Ficha{

    public Caballo(String color, Point posicion, String modelo) {
        super(color, posicion, modelo);
        this.cargarAnimacion("animacionCaballo.gif");
    }

    @Override
    public ArrayList<Point> posiblesMovimientos(Tablero t) {
        ArrayList<Point> pm = new ArrayList<Point>();
      
        if((this.getPosicion().x)+1<8&&(this.getPosicion().y)+2<8){
            if(!t.verificarExistencia(new Point((this.getPosicion().x)+1,(this.getPosicion().y)+2), this)){
                pm.add(new Point((this.getPosicion().x)+1,(this.getPosicion().y)+2));
            }
        }
        if((this.getPosicion().x)+2<8&&(this.getPosicion().y)+1<8){
            if(!t.verificarExistencia(new Point((this.getPosicion().x)+2,(this.getPosicion().y)+1), this)){
                pm.add(new Point((this.getPosicion().x)+2,(this.getPosicion().y)+1));
            }
        }
        if((this.getPosicion().x)+2<8&&(this.getPosicion().y)-1>=0){
            if(!t.verificarExistencia(new Point((this.getPosicion().x)+2,(this.getPosicion().y)-1), this)){
                pm.add(new Point((this.getPosicion().x)+2,(this.getPosicion().y)-1));
            }
        }
        if((this.getPosicion().x)+1<8&&(this.getPosicion().y)-2>=0){
            if(!t.verificarExistencia(new Point((this.getPosicion().x)+1,(this.getPosicion().y)-2), this)){
                pm.add(new Point((this.getPosicion().x)+1,(this.getPosicion().y)-2));
            }
        }
        if((this.getPosicion().x)-1>=0&&(this.getPosicion().y)-2>=0){
            if(!t.verificarExistencia(new Point((this.getPosicion().x)-1,(this.getPosicion().y)-2), this)){
                pm.add(new Point((this.getPosicion().x)-1,(this.getPosicion().y)-2));
            }
        }
        if((this.getPosicion().x)-2>=0&&(this.getPosicion().y)-1>=0){
            if(!t.verificarExistencia(new Point((this.getPosicion().x)-2,(this.getPosicion().y)-1), this)){
                pm.add(new Point((this.getPosicion().x)-2,(this.getPosicion().y)-1));
            }
        }
        if((this.getPosicion().x)-2>=0&&(this.getPosicion().y)+1<8){
            if(!t.verificarExistencia(new Point((this.getPosicion().x)-2,(this.getPosicion().y)+1), this)){
                pm.add(new Point((this.getPosicion().x)-2,(this.getPosicion().y)+1));
            }
        }
        if((this.getPosicion().x)-1>=0&&(this.getPosicion().y)+2<8){
            if(!t.verificarExistencia(new Point((this.getPosicion().x)-1,(this.getPosicion().y)+2), this)){
                pm.add(new Point((this.getPosicion().x)-1,(this.getPosicion().y)+2));
            }
        }
        return pm;
    }
    
}
