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
public class Torre extends Ficha{

    public Torre(String color, Point posicion, String modelo) {
        super(color, posicion, modelo);
        this.cargarAnimacion("animacionTorre.gif");
    }

    @Override
    public ArrayList<Point> posiblesMovimientos(Tablero t) {
        ArrayList<Point> pm = new ArrayList<Point>();
        int x=0,y=0;
        x=this.getPosicion().x;
        y=this.getPosicion().y;
        while(x<7){
            if(t.verificarExistencia(new Point(x+1,y), this)){
                break;
            }else{
                if(t.verificarExistencia2(new Point(x+1,y), this)){
                    pm.add(new Point(x+1,y));
                    break;
                }else{
                    pm.add(new Point(x+1,y));
                    x++;
                }
            }
        }
        x=this.getPosicion().x;
        y=this.getPosicion().y;
        while(x>0){
            if(t.verificarExistencia(new Point(x-1,y), this)){
                break;
            }else{
                if(t.verificarExistencia2(new Point(x-1,y), this)){
                    pm.add(new Point(x-1,y));
                    break;
                }else{
                    pm.add(new Point(x-1,y));
                    x--;
                }
            }
        }
        x=this.getPosicion().x;
        y=this.getPosicion().y;
        while(y<7){
            if(t.verificarExistencia(new Point(x,y+1), this)){
                break;
            }else{
                if(t.verificarExistencia2(new Point(x,y+1), this)){
                    pm.add(new Point(x,y+1));
                    break;
                }else{
                    pm.add(new Point(x,y+1));
                    y++;
                }
            }
        }
        x=this.getPosicion().x;
        y=this.getPosicion().y;
        while(y>0){
            if(t.verificarExistencia(new Point(x,y-1), this)){
                break;
            }else{
                if(t.verificarExistencia2(new Point(x,y-1), this)){
                    pm.add(new Point(x,y-1));
                    break;
                }else{
                    pm.add(new Point(x,y-1));
                    y--;
                }
            }
        }
        return pm;
    }
    
}
