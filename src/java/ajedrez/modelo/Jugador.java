/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ajedrez.modelo;

import ajedrez.controlador.Juego;
import java.awt.Point;
import java.util.ArrayList;

/**
 *
 * @author Sebastian Salinas
 */
public class Jugador {
    
    private ArrayList<Ficha> fichas;
    private String Color;
    private boolean jug1;

    public Jugador(boolean jug1) {
        Juego j = new Juego();
        this.jug1 = jug1;
        this.setColor(jug1?"blanco":"negro");
        //Agregar Fichas del color que son
        fichas = new ArrayList<Ficha>();
        for(int i=0; i<8;i++){
            Point p = new Point(i, jug1?1:6);
            Ficha f = new Peon(this.getColor(), p, jug1?1:6, jug1?"&#9817;":"&#9823;");
            fichas.add(f);
            j.colocarFichaEnTablero(p, f);
        }
        for(int i=0; i<8;i++){
            Point p = new Point(i, jug1?0:7);
            if(i==0||i==7){
                Ficha f = new Torre(this.getColor(), p , jug1?"&#9814;":"&#9820;");
                fichas.add(f);
                j.colocarFichaEnTablero(p, f);
            }
            if(i==1||i==6){
                Ficha f = new Caballo(this.getColor(), p, jug1?"&#9816;":"&#9822;");
                fichas.add(f);
                j.colocarFichaEnTablero(p, f);
            }
            if(i==2||i==5){
                Ficha f = new Alfil(this.getColor(), p , jug1?"&#9815;":"&#9821;");
                fichas.add(f);
                j.colocarFichaEnTablero(p, f);
            }
            if(i==3){
                Ficha f = new Reina(this.getColor(), p, jug1?"&#9813;":"&#9819;");
                fichas.add(f);
                j.colocarFichaEnTablero(p, f);
            }
            if(i==4){
                Ficha f = new Rey(this.getColor(), p , jug1?"&#9812;":"&#9818;");
                fichas.add(f);
                j.colocarFichaEnTablero(p, f);
            }
        }
        
        
    }

    /**
     * @return the fichas
     */
    public ArrayList<Ficha> getFichas() {
        return fichas;
    }

    /**
     * @param fichas the fichas to set
     */
    public void setFichas(ArrayList<Ficha> fichas) {
        this.fichas = fichas;
    }

    /**
     * @return the Color
     */
    public String getColor() {
        return Color;
    }

    /**
     * @param Color the Color to set
     */
    public void setColor(String Color) {
        this.Color = Color;
    }
    
    
}
