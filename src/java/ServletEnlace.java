/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import ajedrez.controlador.Juego;
import ajedrez.modelo.*;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.Point;
import java.util.Arrays;

/**
 *
 * @author FliaSalinasRodriguez
 */
@WebServlet(name = "ServletEnlace", urlPatterns = {"/ServletEnlace"})
public class ServletEnlace extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    
    private Tablero t;
    private Jugador j1;
    private Jugador j2;
    private Ficha[][] tablero;
    private Juego j;
     
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("application/json;charset=UTF-8");
        String comando = request.getParameter("comando");
        if(comando.equals("cargar")){
        j = new Juego();
        j.iniciar();
        tablero = j.obtenerTablero();
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("{");
            for(int x = 0 ; x < 8;x++){
                for (int y = 0; y < 8; y++){
                    if(tablero[x][y] != null){
                    String equis = Integer.toString(x);
                    String ye = Integer.toString(y);
                    String id = "ficha"+equis + ye +"";
                    System.out.println(id);
                    out.println("\""+id+"\":\""+tablero[x][y].getModelo()+"\",");
                    if(x == 7 && y == 7){
                        System.out.println(id);
                        out.println("\""+id+"\":\""+tablero[x][y].getModelo()+"\"");
                    }
                    }
                    else{
                        String equis = Integer.toString(x);
                        String ye = Integer.toString(y);
                        String id = "ficha"+equis + ye +"";
                        System.out.println(id);
                        out.println("\""+id+"\":\""+""+"\",");
                        if(x == 7 && y == 7){
                            System.out.println(id);
                            out.println("\""+id+"\":\""+""+"\""); 
                        }
                    }
                }
            }
            out.println("}"); 

        }           
        }
        else{
            if(comando.equals("actualizar")){
                try (PrintWriter out = response.getWriter()) {
                out.println("{");
                for(int x = 0 ; x < 8;x++){
                    for (int y = 0; y < 8; y++){
                        if(tablero[x][y] != null){
                        String equis = Integer.toString(x);
                        String ye = Integer.toString(y);
                        String id = "ficha"+equis + ye +"";
                        System.out.println(id);
                        out.println("\""+id+"\":\""+tablero[x][y].getModelo()+"\",");
                        if(x == 7 && y == 7){
                            System.out.println(id);
                            out.println("\""+id+"\":\""+tablero[x][y].getModelo()+"\"");
                        }
                    }
                    else{
                        String equis = Integer.toString(x);
                        String ye = Integer.toString(y);
                        String id = "ficha"+equis + ye +"";
                        System.out.println(id);
                        out.println("\""+id+"\":\""+""+"\",");
                        if(x == 7 && y == 7){
                            System.out.println(id);
                            out.println("\""+id+"\":\""+""+"\""); 
                        }
                    }
                }
            }
            out.println("}"); 

        }   
            }
            else{
                if(comando.contains("comando_1")){
                    System.out.println("Este comando 1 funciona :v");
                    String[] comando_div = comando.split(":");
                    String comando_pos = comando_div[1];
                    System.out.println(comando_pos);
                    boolean resultado = j.movJug1(comando_pos);
                    boolean matej1 = j.mate_j1;
                    boolean matej2 = j.mate_j2;
                try (PrintWriter out = response.getWriter()) {
                    out.println("{");
                    out.println("\"resultado\":\""+resultado+"\",");
                    out.println("\"mate_1\":\""+matej1+"\",");
                    out.println("\"mate_2\":\""+matej2+"\"");
                    out.println("}");          
                 }  
                }
                else{
                    if(comando.contains("comando_2")){
                        System.out.println("Este comando 2 funciona :v");
                        String[] comando_div = comando.split(":");
                        String comando_pos = comando_div[1];
                        boolean resultado = j.movJug2(comando_pos);
                        boolean matej1 = j.mate_j1;
                        boolean matej2 = j.mate_j2;
                        try (PrintWriter out = response.getWriter()) {
                            out.println("{");
                            out.println("\"resultado\":\""+resultado+"\",");
                            out.println("\"mate_1\":\""+matej1+"\",");
                            out.println("\"mate_2\":\""+matej2+"\"");
                            out.println("}");          
                 }  
                    }
                }
            }
        }
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            
            out.println("{");
            out.println("\"comando\":\""+comando+"\"");
            out.println("}");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
