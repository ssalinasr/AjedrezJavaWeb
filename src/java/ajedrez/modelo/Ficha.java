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
public abstract class Ficha implements Animable{
    
    private Animacion animacion;

    public Ficha(String color, Point posicion, String modelo) {
        this.color = color;
        this.posicion = posicion;
        this.modelo = modelo;
    }
    
    private String color;
    private Point posicion;
    private String modelo;

    /**
     * @return the color
     */
    public String getColor() {
        return color;
    }

    /**
     * @param color the color to set
     */
    public void setColor(String color) {
        this.color = color;
    }

    /**
     * @return the posicion
     */
    public Point getPosicion() {
        return posicion;
    }

    /**
     * @param posicion the posicion to set
     */
    public void setPosicion(Point posicion) {
        this.posicion = posicion;
    }
    
    public abstract ArrayList<Point> posiblesMovimientos(Tablero t);
    
    public void mover(Point nuevo){
        this.setPosicion(nuevo);
        //TODO: si esta posición esta ocupada, entonces capturar y realizar animación
    }

    /**
     * @return the animacion
     */
    public Animacion getAnimacion() {
        return animacion;
    }

    /**
     * @param animacion the animacion to set
     */
    public void setAnimacion(Animacion animacion) {
        this.animacion = animacion;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }
    
    
    
    @Override
    public void realizarAnimacion() {
        this.getAnimacion().ejecutarAnimacion();
    }

    @Override
    public void cargarAnimacion(String recurso) {
        this.setAnimacion(new Animacion(recurso));
    }
    
    
}
