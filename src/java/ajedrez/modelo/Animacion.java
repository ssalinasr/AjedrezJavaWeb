/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ajedrez.modelo;

/**
 *
 * @author Sebastian Salinas
 */
public class Animacion {
    
    private String recurso;
    public void ejecutarAnimacion(){
        //TODO crear la funcionalidad de ejecutar animación
    }

    public Animacion(String recurso) {
        this.recurso = recurso;
    }

    /**
     * @return the recurso
     */
    public String getRecurso() {
        return recurso;
    }

    /**
     * @param recurso the recurso to set
     */
    private void setRecurso(String recurso) {
        this.recurso = recurso;
    }
    
    
    
}
