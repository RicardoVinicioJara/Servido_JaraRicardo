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
//Actualzate

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
        return carroON.guardarLista(list);
    }

    @WebMethod
    public String addCarrito(Carro c) {
        return carroON.guardarCarro(c);
    }

    @WebMethod
    public List<Carro> miCarrito(String codigo) {
        return carroON.listarCarroCodigo(codigo);
    }

    @WebMethod
    public String crearProducto(Producto p) {
        return productoON.guardarProducto(p);
    }
}
