/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.ups.exm.dao;

import ec.edu.ups.exm.emtitis.Carro;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;


@Stateless
public class CarroDAO {

    @PersistenceContext
    private EntityManager em;

    public CarroDAO() {
    }
     
    
    public boolean insert(Carro carro) throws Exception {
        boolean bandera = true;
    	try {
            System.out.println("si creo que llega aca");
            em.persist(carro);
            bandera=true;
        } catch (Exception e) {
        	bandera=false;
            throw new Exception("Erro ingreso Carro " + e.getMessage());
            
        }
        
        return bandera;
    }
    
    public void delete(Carro carro) throws Exception {
        try {
            System.out.println("borrando");
            em.remove(read(carro.getIdCarro()));
        } catch (Exception e) {
            throw new Exception("oErro Eliminar Carro " +e.getMessage());
        }
    }
     

    public void deleteId(int id) throws Exception {
        try {
            System.out.println("borrando");
            em.remove(read(id));
        } catch (Exception e) {
            throw new Exception("oErro Eliminar Carro " +e.getMessage());
        }
    }
        

    public void update(Carro carro) throws Exception {
        try {
            em.merge(carro);
        } catch (Exception e) {
            throw new Exception("Erro actualizar Carro " +e.getMessage());
        }
    }
    
    public Carro read(int id) throws Exception {
        try {
            System.out.println("Estamos aca");
            return em.find(Carro.class, id);
        } catch (Exception e) {
            throw new Exception("Erro leer Carro " +e.getMessage());
        }
    }

    public List<Carro> findAll() throws Exception {

        try {
            Query q = em.createNamedQuery("Carro.findAll");
            List<Carro> lista = q.getResultList();
            return lista;
        } catch (Exception e) {
            throw new Exception("Erro listar Carro " +e.getMessage());
        }

    }
    
    public List<Carro> findAllCodigo(String codigo) throws Exception {

        try {
            Query q = em.createNamedQuery("Carro.findByCodigocompra");
            q.setParameter("codigocompra", codigo);
            System.out.println("acaa estamos buscando");
            List<Carro> lista = q.getResultList();
            return lista;
        } catch (Exception e) {
            throw new Exception("Erro listar Carro " +e.getMessage());
        }

    }
    

   
    
    
    public Carro findByID(String id) throws Exception {
        try {
            Query q = em.createNamedQuery("Carro.findById");
            q.setParameter("id", Integer.parseInt(id));
            return (Carro) q.getSingleResult();
        } catch (Exception e) {
            throw new Exception("Erro buscar por  ID " +e.getMessage());
        }

    }
   

}
