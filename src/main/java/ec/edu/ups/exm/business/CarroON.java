/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.ups.exm.business;

import ec.edu.ups.exm.dao.CarroDAO;
import ec.edu.ups.exm.dao.ProductoDAO;
import ec.edu.ups.exm.emtitis.Carro;
import ec.edu.ups.exm.emtitis.Producto;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 *
 * @author vinic
 */
@Stateless
public class CarroON {

    /**
     * Permite consumir la logica del clienteDAO
     */
    @Inject
    CarroDAO carroDAO;

    public CarroON() {
    }

    public boolean guardarCarro(Carro carro){
        try {
            return carroDAO.insert(carro);
        } catch (Exception ex) {
            Logger.getLogger(CarroON.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
    
    public List<Carro> listarCarro() {
        try {
            return carroDAO.findAll();
        } catch (Exception ex) {
            Logger.getLogger(CarroON.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public List<Carro> listarCarroCodigo(String codigo) {
        try {
            return carroDAO.findAllCodigo(codigo);
        } catch (Exception ex) {
            Logger.getLogger(CarroON.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

}
