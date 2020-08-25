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
 * @author Sebastian Salinas
 */
public class Peon extends Ficha{
    
    private int filaSalida;

    public Peon(String color, Point posicion, int FilaSalida, String modelo) {
        super(color, posicion, modelo);
        this.cargarAnimacion("animacionPeon.gif");
        this.filaSalida = FilaSalida;
    }

    public int getFilaSalida() {
        return filaSalida;
    }

    public void setFilaSalida(int filaSalida) {
        this.filaSalida = filaSalida;
    }

    
    @Override
    public ArrayList<Point> posiblesMovimientos(Tablero t) {
        ArrayList<Point> pm = new ArrayList<Point>();
        if(this.getColor().equals("blanco")){
            if((this.getPosicion().y == this.getFilaSalida())&&!t.verificarExistencia2(new Point((this.getPosicion().x),(this.getPosicion().y)+2), this)){
                pm.add(new Point(this.getPosicion().x,this.getPosicion().y+2));
            }
            if(this.getPosicion().y<8&&!t.verificarExistencia2(new Point((this.getPosicion().x),(this.getPosicion().y)+1), this)){
                pm.add(new Point(this.getPosicion().x,this.getPosicion().y+1));
            }
            if((this.getPosicion().x+1<8)&&(this.getPosicion().y+1<8)&&(t.verificarExistencia2(new Point((this.getPosicion().x)+1,(this.getPosicion().y)+1), this))){
                pm.add(new Point(this.getPosicion().x+1,this.getPosicion().y+1));
            }
            if((this.getPosicion().x-1>0)&&(this.getPosicion().y+1<8)&&(t.verificarExistencia2(new Point((this.getPosicion().x)-1,(this.getPosicion().y)+1), this))){
                pm.add(new Point(this.getPosicion().x-1,this.getPosicion().y+1));
            }
        }else{
            if(this.getPosicion().y == this.getFilaSalida()){
                pm.add(new Point(this.getPosicion().x,this.getPosicion().y-2));
            }
            if(this.getPosicion().y>0){
                pm.add(new Point(this.getPosicion().x,this.getPosicion().y-1));
            }
            
            if((this.getPosicion().x+1<8)&&(this.getPosicion().y-1>0)&&(t.verificarExistencia2(new Point(this.getPosicion().x+1,this.getPosicion().y-1), this))){
                pm.add(new Point(this.getPosicion().x+1,this.getPosicion().y-1));
            }
            if((this.getPosicion().x-1>0)&&(this.getPosicion().y-1>0)&&(t.verificarExistencia2(new Point(this.getPosicion().x-1,this.getPosicion().y-1), this))){
                pm.add(new Point(this.getPosicion().x-1,this.getPosicion().y-1));
            }
        }
        
        return pm;
    }

    
}
