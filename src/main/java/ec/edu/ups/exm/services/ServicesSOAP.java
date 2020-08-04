package ec.edu.ups.exm.services;

import ec.edu.ups.exm.business.CarroON;
import ec.edu.ups.exm.business.ProductoON;
import ec.edu.ups.exm.emtitis.Carro;
import ec.edu.ups.exm.emtitis.Producto;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.inject.Inject;
import javax.jws.WebMethod;
import javax.jws.WebService;
//​​​​​​​​​http://localhost:8080/Servido_JaraRicardo/ServicesSOAP?wsdl

@WebService
public class ServicesSOAP {

    public ServicesSOAP() {
    }
    
    

    @Inject
    private ProductoON productoON;
    
    @Inject
    private CarroON carroON;

    @WebMethod
    public List<Producto> listaProductos() {
        return productoON.listarProductos();
    }
    
    @WebMethod
    public String llenarCarrito(List<Carro> list) {
        for (Carro c : list) {
            Carro cc = new Carro();
            System.out.println("|"+c.getCodigocompra()+"|");
            cc.setCodigocompra(c.getCodigocompra());
            cc.setPrecio(c.getPrecio());
            cc.setProducto(c.getProducto());
            carroON.guardarCarro(cc);
            c.getProducto().setStock(c.getProducto().getStock() - 1);
            productoON.actProducto(c.getProducto());
        }
        return "Compra almacenada";
    }
    
    @WebMethod
    public String addCarrito(Carro c) {
            Carro cc = new Carro();
            System.out.println("|"+c.getCodigocompra()+"|");
            cc.setCodigocompra(c.getCodigocompra());
            cc.setPrecio(c.getPrecio());
            cc.setProducto(c.getProducto());
            carroON.guardarCarro(cc);
            c.getProducto().setStock(c.getProducto().getStock() - 1);
            productoON.actProducto(c.getProducto());
        return "carrito agregado";
    }
    
    
    @WebMethod
    public List<Carro> miCarrito(String codigo) {
        codigo = codigo.replace(" ", "");
        return carroON.listarCarroCodigo(codigo);
    }
    
    
    
    
    @WebMethod
    public String crearProducto(Producto p) {
        try {
            Producto pro = new Producto();
            pro.setNombre(p.getNombre());
            pro.setCodigo(p.getCodigo());
            pro.setStock(p.getStock());
            pro.setPrecio(p.getPrecio());
            productoON.guardarProducto(pro);
            return "Producto ingresado";
        } catch (Exception ex) {
            return "Error ingresar producto";
        }
        
    }
}
