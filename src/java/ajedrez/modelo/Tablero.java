/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ajedrez.modelo;

import java.awt.Point;
import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author Sebastian Salinas
 */
public class Tablero {
    private Ficha[][] fichas = new Ficha[8][8];
    public ArrayList<Point> mirarMovimientos(int x, int y, Tablero t){
        ArrayList<Point> pmov = this.getFichas()[y][x].posiblesMovimientos(t);
        ArrayList<Point> rem = new ArrayList<Point>();
        Ficha rey,f;
        Point pos;
        for(Point p : pmov){
            if(!this.verificarExistencia(p, this.getFichas()[y][x])){
                System.out.println(p);
            }
            else{
                rem.add(p);
            }
        }
        
        
        for(Point p : rem){
            pmov.remove(p);
        }
/*
        if(this.getFichas()[y][x].getColor().equals("blanco")){
            rey=getRey("blanco");
            for(Point p : pmov){
                pos=this.getFichas()[y][x].getPosicion();
                f=this.getFicha(pos);
                t.colocarFicha(p, f);
                t.removerFicha(pos,f);
                t.actualizarPosFicha(p);
                for(ArrayList ps: movimientosJugador("negro").values()){         
                    if(ps.contains(rey.getPosicion())){
                        pmov.remove(p);
                    }
                }
                t.colocarFicha(pos,f);
                t.removerFicha(p,f);
                t.actualizarPosFicha(pos);
            }
        }
        
        if(this.getFichas()[y][x].getColor().equals("negro")){
            rey=getRey("negro");
            for(Point p : pmov){
                pos=this.getFichas()[y][x].getPosicion();
                t.colocarFicha(p, this.getFicha(pos));
                t.removerFicha(pos, this.getFicha(pos));
                t.actualizarPosFicha(p);
                for(ArrayList ps: movimientosJugador("blanco").values()){         
                    if(ps.contains(rey.getPosicion())){
                        pmov.remove(p);
                    }
                }
                t.colocarFicha(pos, this.getFicha(p));
                t.removerFicha(p,this.getFicha(p));
                t.actualizarPosFicha(pos);
            }
        }
        */
        
        return pmov;         
        //TODO agregar movimientos posibles en entorno gráfico
    }
    
    public HashMap<Point,ArrayList> movimientosJugador(String color){
        HashMap<Point,ArrayList> movJ = new HashMap();
        if(color.equals("negro")){
            for(int x = 0; x < 8; x++){
                for(int y = 0; y < 8; y++){
                    if(this.getFichas()[x][y] != null && this.getFichas()[x][y].getColor().equals("negro")){
                       movJ.put(this.getFichas()[x][y].getPosicion(),this.getFichas()[x][y].posiblesMovimientos(this)); 
                    }
                    
                }
            }
        }
        else{
            if(color.equals("blanco")){
                for(int x = 0; x < 8; x++){
                    for(int y = 0; y < 8; y++){
                        if(this.getFichas()[x][y] != null && this.getFichas()[x][y].getColor().equals("blanco")){
                           movJ.put(this.getFichas()[x][y].getPosicion() ,this.getFichas()[x][y].posiblesMovimientos(this)); 
                        }
                    }
                }                
            }

        }
        return movJ;
    }

    /**
     * @return the fichas
     */
    public Ficha[][] getFichas() {
        return fichas;
    }
    
    public Ficha getFicha(Point p){
        return fichas[p.y][p.x];
    }
    
    public Ficha getRey(String color){
        Ficha rey = null;
        for(int x = 0;x<8 ;x++){
            for(int y = 0;y<8;y++){
                if(this.getFichas()[x][y] instanceof Rey){
                    if(this.getFichas()[x][y].getColor().equals(color)){
                        rey = this.getFichas()[x][y];
                    }
                }
            } 
        }
        return rey;
    }

    /**
     * @param fichas the fichas to set
     */
    public void setFichas(Ficha[][] fichas) {
        this.fichas = fichas;
    }
    
    public void colocarFicha(Point p, Ficha f){
        fichas[p.y][p.x] = f;
    }
    
    public void actualizarPosFicha(Point p){
        fichas[p.y][p.x].setPosicion(p);
    }
    
    public void removerFicha(Point p, Ficha f){
        fichas[p.y][p.x] = null;
    }
    
    public void imprimirTablero(){
        System.out.println("Equipo Negro");
        for(int x = 7; x >= 0; x--){
            System.out.print(x);
            for(int y = 0; y<8;y++){
                //System.out.print(y);
                if(this.getFichas()[x][y] instanceof Torre){
                    if(this.getFichas()[x][y].getColor().equals("blanco")){
                        System.out.print("| Tb |");
                    }
                    else{
                        System.out.print("| Tn |");
                    }                
                }
                else{
                    if(this.getFichas()[x][y] instanceof Caballo){
                        if(this.getFichas()[x][y].getColor().equals("blanco")){
                        System.out.print("| Cb |");
                    }
                    else{
                        System.out.print("| Cn |");
                    }
                    }
                    else{
                       if(this.getFichas()[x][y] instanceof Alfil){
                        if(this.getFichas()[x][y].getColor().equals("blanco")){
                            System.out.print("| Ab |");
                    }
                    else{
                        System.out.print("| An |");
                    }
                        }
                       else{
                            if(this.getFichas()[x][y] instanceof Rey){
                                if(this.getFichas()[x][y].getColor().equals("blanco")){
                                  System.out.print("| Kb |");
                              }
                    else{
                        System.out.print("| Kn |");
                         } 
                            }
                            else{
                              if(this.getFichas()[x][y] instanceof Reina){
                                 if(this.getFichas()[x][y].getColor().equals("blanco")){
                                    System.out.print("| Rb |");
                                 }
                               else{
                                  System.out.print("| Rn |");
                                } 
                                }
                              else{
                                  if(this.getFichas()[x][y] instanceof Peon){
                                      if(this.getFichas()[x][y].getColor().equals("blanco")){
                                      System.out.print("| Pb |");
                                        }
                                    else{
                                       System.out.print("| Pn |");
                                     } 
                                     }
                                  else{
                                      System.out.print("|    |");
                                  }
                              }
                            }
                       }
                    }
                }
            }
            System.out.println("");
        }
        for(int i=0;i<8;i++){
            System.out.print(" | "+(i)+" |");
        }
        System.out.println("");
        System.out.println("Equipo Blanco");
    }
    
    public boolean verificarExistencia(Point p, Ficha f){
        Ficha fic = this.getFicha(p);
        if(fic != null){
            if(fic.getColor().equals(f.getColor())){
                return true;
            }
            else{
                return false;
            }         
        }
        return false;
    }
    
     public boolean verificarExistencia2(Point p, Ficha f){
        Ficha fic = this.getFicha(p);
        if(fic != null){
            if(!fic.getColor().equals(f.getColor())){
                return true;
            }
            else{
                return false;
            }         
        }
        return false;
    }
    
}
