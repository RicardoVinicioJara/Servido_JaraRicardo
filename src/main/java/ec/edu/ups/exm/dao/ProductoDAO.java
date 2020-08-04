/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.ups.exm.dao;

import ec.edu.ups.exm.emtitis.Producto;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;


@Stateless
public class ProductoDAO {

    @PersistenceContext
    private EntityManager em;

    public ProductoDAO() {
    }
     
    
    public boolean insert(Producto producto) throws Exception {
        boolean bandera = true;
    	try {
            System.out.println("si creo que llega aca");
            em.persist(producto);
            bandera=true;
        } catch (Exception e) {
        	bandera=false;
            throw new Exception("Erro ingreso Producto " + e.getMessage());
            
        }
        
        return bandera;
    }
    
    public void delete(Producto producto) throws Exception {
        try {
            System.out.println("borrando");
            em.remove(read(producto.getId()));
        } catch (Exception e) {
            throw new Exception("oErro Eliminar Producto " +e.getMessage());
        }
    }
     

    public void deleteId(int id) throws Exception {
        try {
            System.out.println("borrando");
            em.remove(read(id));
        } catch (Exception e) {
            throw new Exception("oErro Eliminar Producto " +e.getMessage());
        }
    }
        

    public void update(Producto producto) throws Exception {
        try {
            em.merge(producto);
        } catch (Exception e) {
            throw new Exception("Erro actualizar Producto " +e.getMessage());
        }
    }
    
    public Producto read(int id) throws Exception {
        try {
            System.out.println("Estamos aca");
            return em.find(Producto.class, id);
        } catch (Exception e) {
            throw new Exception("Erro leer Producto " +e.getMessage());
        }
    }

    public List<Producto> findAll() throws Exception {

        try {
            Query q = em.createNamedQuery("Producto.findAll");
            List<Producto> lista = q.getResultList();
            return lista;
        } catch (Exception e) {
            throw new Exception("Erro listar Producto " +e.getMessage());
        }

    }

   
    
    
    public Producto findByID(String id) throws Exception {
        try {
            Query q = em.createNamedQuery("Producto.findById");
            q.setParameter("id", Integer.parseInt(id));
            return (Producto) q.getSingleResult();
        } catch (Exception e) {
            throw new Exception("Erro buscar por  ID " +e.getMessage());
        }

    }
   

}
