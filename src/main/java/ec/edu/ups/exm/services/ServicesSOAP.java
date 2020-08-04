package ec.edu.ups.exm.services;

import ec.edu.ups.exm.business.ProductoON;
import ec.edu.ups.exm.emtitis.Producto;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.inject.Inject;
import javax.jws.WebMethod;
import javax.jws.WebService;
//​​​​​​​​​?wsdl

@WebService
public class ServicesSOAP {
	@Inject
	private ProductoON productoON;

	@WebMethod
    public List<Producto> listaClientes(){
        return productoON.listarProductos();
    }
}
