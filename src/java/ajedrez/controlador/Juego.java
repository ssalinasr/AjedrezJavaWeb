/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ajedrez.controlador;

import ajedrez.modelo.Ficha;
import ajedrez.modelo.Jugador;
import ajedrez.modelo.Tablero;
import java.awt.Point;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

/**
 *
 * @author Sebastian Salinas
 */
public class Juego {
    
    public static Jugador j1,j2;
    public static Tablero t;
    public boolean jaque_j1 = false;
    public boolean jaque_j2 = false;
    public boolean mate_j1 = false;
    public boolean mate_j2 = false;
    boolean jaqueBlanco=false;
    boolean jaqueNegro=false;
    Ficha ReyBlanco;
    Ficha ReyNegro;
    
    public void iniciar(){
        t = new Tablero();
        j1 = new Jugador(true);
        j2 = new Jugador(false);
        ReyBlanco = t.getRey("blanco");
        ReyNegro= t.getRey("negro");
        mate_j1 = false;
        mate_j2 = false;
    }
    
    public Ficha[][] obtenerTablero(){
        return t.getFichas();
    }
      
    public ArrayList<Integer> coordenadas(String comando){
        ArrayList<Integer> cord = new ArrayList<>();
        String[] comando_split = comando.split(",");
        for(String com : comando_split){
            cord.add(Integer.parseInt(com));
        }
        return cord;       
    }
    
    public boolean cord_existentes(int x, int y){
        if(x < 0 || x > 7 || y < 0 || y > 7 || t.getFicha(new Point(x,y)) == null){
            return false;
        }
        else{
            return true;
        }    
    }
    
    public boolean cord_pertenecientes(int x, int y, String color){
        Ficha verf_j1 = t.getFicha(new Point(x,y));
        if(!verf_j1.getColor().equals(color)){
            return false;
        }
        else{
            return true;
        }
        
    }
    
    public boolean movimientos_disponibles(int x, int y){
        ArrayList<Point> pmvs_j1 = t.mirarMovimientos(x, y, t);
        if(pmvs_j1.isEmpty()){
            return false;
        }
        else{
             return true;
        }    
    }
    
    public boolean movimiento_posible(int x, int y, ArrayList<Point> pos){
        Point bus = new Point(x,y);
        System.out.println("Buscado: "+bus);
        for(Point p : pos){
            System.out.println("Encontrado: "+p);
            if((bus.x == p.x) && (bus.y == p.y)){
                return true;
            }
        }
        return false;
    }
    
    public boolean movJug1(String comando){
        if(jaqueBlanco){
            System.out.println("El rey está en jaque, debe moverlo o taparlo");

            }
            System.out.println("Ficha a mover, jugador 1");
            
            ArrayList<Integer> cord = coordenadas(comando);
  
            //Movimientos para el jugador 1
            int j1_x = cord.get(0);
            int j1_y = cord.get(1);
            
            if(this.cord_existentes(j1_x, j1_y) == false){
                System.out.println("Coordenadas inexistentes o no válidas...");
                return false;
            }
            
            if(this.cord_pertenecientes(j1_x, j1_y, "blanco") == false){
                System.out.println("Ficha no válida, no es del jugador 1...");
                return false;
            }
            
            if(this.movimientos_disponibles(j1_x, j1_y) == false){
                System.out.println("Esa ficha no tiene movimientos disponibles...");
                return false;
            }
            
            Ficha verf_j1 = t.getFicha(new Point(j1_x,j1_y));
            ArrayList<Point> pmvs_j1 = t.mirarMovimientos(j1_x, j1_y, t);
              
            int j1_x2 = cord.get(2);
            int j1_y2 = cord.get(3);
            
            if(this.movimiento_posible(j1_x2, j1_y2, pmvs_j1) == false){
                System.out.println("Ese movimiento no es posible para esa ficha...");
                return false;
            }
                       
            moverFichaEnTablero(new Point(j1_x2,j1_y2),verf_j1);
            
            if(moverJaque(ReyBlanco)){
                System.out.println("Debe devolverse...");
                System.out.println("Debe devolverse...");
                t.colocarFicha(new Point(j1_x,j1_y), verf_j1);
                System.out.println("Ficha colocada en: " + new Point(j1_x,j1_y));
                t.removerFicha(verf_j1.getPosicion(), verf_j1);
                System.out.println("Ficha removida de: "+ verf_j1.getPosicion());
                t.actualizarPosFicha(new Point(j1_x , j1_y));
                return false;
            }
            
        jaqueNegro=hayJaque(t.getFicha(new Point(j1_x2,j1_y2)),ReyNegro);
        if(this.hayMate(ReyNegro) && jaqueNegro){
            System.out.println(this.hayMate(ReyNegro));
            this.mate_j1 = true;
        }
        return true;
    }
    
    public boolean movJug2(String comando){
            if(jaqueNegro){
                System.out.println("El rey está en jaque, debe moverlo o taparlo");

            }
            System.out.println("Ficha a mover, jugador 2");
            ArrayList<Integer> cord = this.coordenadas(comando);

            //Movimientos jugador 2
            int j2_x = cord.get(0);
            int j2_y = cord.get(1);
            
            if(this.cord_existentes(j2_x, j2_y) == false){
                System.out.println("Coordenadas inexistentes o no válidas...");
                return false;
            }
            
            if(this.cord_pertenecientes(j2_x, j2_y, "negro") == false){
                System.out.println("Ficha no válida, no es del jugador 2...");
                return false;
            }
            
            if(this.movimientos_disponibles(j2_x, j2_y) == false){
                System.out.println("Esa ficha no tiene movimientos disponibles...");
                return false;
            }
            
            Ficha verf_j2 = t.getFicha(new Point(j2_x,j2_y));
            ArrayList<Point> pmvs_j2 = t.mirarMovimientos(j2_x, j2_y, t);
            
            int j2_x2 = cord.get(2);
            int j2_y2 = cord.get(3);
            
            if(this.movimiento_posible(j2_x2, j2_y2, pmvs_j2) == false){
                System.out.println("Ese movimiento no es posible para esa ficha...");
                return false;
            }
            
            moverFichaEnTablero(new Point(j2_x2,j2_y2),verf_j2);
            
            if(moverJaque(ReyNegro)){
                System.out.println("Debe devolverse...");
                System.out.println("Debe devolverse...");
                t.colocarFicha(new Point(j2_x,j2_y), verf_j2);
                System.out.println("Ficha colocada en: " + new Point(j2_x,j2_y));
                t.removerFicha(verf_j2.getPosicion(), verf_j2);
                System.out.println("Ficha removida de: "+ verf_j2.getPosicion());
                t.actualizarPosFicha(new Point(j2_x , j2_y));
                return false;
            }
            
            jaqueBlanco=hayJaque(t.getFicha(new Point(j2_x2,j2_y2)),ReyBlanco);
            if(this.hayMate(ReyBlanco) && jaqueBlanco){
                    System.out.println(this.hayMate(ReyBlanco));
                    this.mate_j2 = true;
            }
        return true;
    }
    
     
    public static void imprimirTablero(){
        t.imprimirTablero();
    }
    
    public static void colocarFichaEnTablero(Point p, Ficha f){
        t.colocarFicha(p, f);
    }
    
    public static void moverFichaEnTablero(Point p, Ficha f){
        Point pos = f.getPosicion();
        ArrayList<Point> pmvs = t.mirarMovimientos(pos.x, pos.y, t);
        for(Point pt: pmvs){
            if(pt.equals(p)){
                t.colocarFicha(p, f);
                System.out.println("Ficha colocada en:" + p);
                t.removerFicha(f.getPosicion(), f);
                System.out.println("Ficha removida de:"+ f.getPosicion());
                t.actualizarPosFicha(p);
                break;
            }
            else{
                //do nothing :v
            }
        }
    }
    /*
    public boolean hayJaque(Ficha Rey){
        HashMap<Point,ArrayList> pmov = new HashMap<>();
        ArrayList<Point> totalmov = new ArrayList<>();
        Point posRey = Rey.getPosicion();
        if(Rey.getColor().equals("blanco")){
            pmov = t.movimientosJugador("negro");
            for(ArrayList p: pmov.values()){         
                for(Object pt: p){
                    totalmov.add((Point) pt);
                }
            }
        }
        else{
            pmov = t.movimientosJugador("blanco");
            for(ArrayList p: pmov.values()){         
                for(Object pt: p){
                    totalmov.add((Point) pt);
                }
            }        
        }
        
        if(totalmov.contains(posRey)){
            System.out.println("El rey del jugador "+Rey.getColor()+" se encuentra en jaque");
            return true;
        }
        return false;
    }*/
    
    public boolean hayJaque(Ficha movida, Ficha Rey){
        boolean jaque;
        ArrayList<Point> pm = new ArrayList<>();
        pm = t.mirarMovimientos(movida.getPosicion().x, movida.getPosicion().y, t);
        Point posRey = Rey.getPosicion();
        jaque=pm.contains(posRey);
        if(jaque){
            System.out.println("El rey "+Rey.getColor()+" se encuentra en jaque");
        }
        return jaque;
    }
    
    public boolean moverJaque(Ficha Rey){
        HashMap<Point,ArrayList> pmov = new HashMap<>();
        ArrayList<Point> totalmov = new ArrayList<>();
        Point posRey = Rey.getPosicion();
        if(Rey.getColor().equals("blanco")){
            pmov = t.movimientosJugador("negro");
            for(ArrayList p: pmov.values()){         
                for(Object pt: p){
                    totalmov.add((Point) pt);
                }
            }
        }
        else{
            pmov = t.movimientosJugador("blanco");
            for(ArrayList p: pmov.values()){         
                for(Object pt: p){
                    totalmov.add((Point) pt);
                }
            }        
        }
        
        if(totalmov.contains(posRey)){
            return true;
        }
        return false;
    }
    
    public boolean hayMate(Ficha Rey){
        ArrayList<Point> movRey = new ArrayList<>();
        ArrayList<Integer> posible = new ArrayList<>();
        Point pos = Rey.getPosicion();
        movRey = t.mirarMovimientos(pos.x, pos.y, t);
        for(Point m : movRey){
            t.colocarFicha(m, Rey);
            t.removerFicha(pos, Rey);
            t.actualizarPosFicha(m);
            if(this.moverJaque(Rey)){
              t.colocarFicha(pos, Rey);
              t.removerFicha(m, Rey);
              t.actualizarPosFicha(pos);
              posible.add(1);
            }
            else{
                t.colocarFicha(pos, Rey);
                t.removerFicha(m, Rey);
                t.actualizarPosFicha(pos);
                posible.add(0);
            }
        }
        
        for(int i : posible){
            System.out.println("hay Jaque?????: " + i);
            if(i == 0){
                return false;
            }
        }
        return true;
    }
    
}
