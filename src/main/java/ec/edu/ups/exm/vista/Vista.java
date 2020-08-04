/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.ups.exm.vista;

import ec.edu.ups.exm.business.ProductoON;
import ec.edu.ups.exm.emtitis.Producto;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Vinicio
 */
//http://localhost:8080/Servido_JaraRicardo/Vista

@WebServlet(name = "Vista", urlPatterns = {"/Vista"})
public class Vista extends HttpServlet {

    @Inject
    ProductoON productoON;
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            response.getWriter().println("<h1> HOLA </h1>");
            Producto p = new Producto();
            p.setNombre("Papas");
            p.setCodigo("p001");
            p.setStock(100+"");
            
            response.getWriter().println("<h1> HOLA " +productoON.guardarProducto(p));
        } catch (Exception ex) {
            response.getWriter().println("<h1> HOLA </h1>");
            Logger.getLogger(Vista.class.getName()).log(Level.SEVERE, null, ex);
        }
    }


}
