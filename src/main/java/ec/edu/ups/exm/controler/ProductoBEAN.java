/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.ups.exm.controler;

import ec.edu.ups.exm.business.ProductoON;
import ec.edu.ups.exm.emtitis.Producto;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author Vinicio
 */
;

@ManagedBean
@ViewScoped
public class ProductoBEAN {

    @Inject
    ProductoON productoON;
    
    Producto producto;
    

    public ProductoBEAN() {
    }

   
    @PostConstruct
    public void init() {
        producto = new Producto();
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    
    public String guardarProducto(){
        try {
            productoON.guardarProducto(producto);
            System.out.println("Guardando");
        } catch (Exception ex) {
            Logger.getLogger(ProductoBEAN.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "";
    }
  
}
