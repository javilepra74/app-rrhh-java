/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import utn.frsf.ofa.cursojava.dao.ConexionJPA;

/**
 *
 * @author jalvarez
 */
public class ProyectoDaoJPA implements ProyectoDAO {
    private EntityManager em;
   
 @Override     
 public void crear(Proyecto e) {      
      this.em = ConexionJPA.get();
      try { 
           em.getTransaction().begin();             
           em.persist(e);             
           em.getTransaction().commit(); 
           System.out.println("hizo commit en crear");
          } 
      catch (Exception ex) {            
           ex.printStackTrace();             
           em.getTransaction().rollback();     
           System.out.println("hizo rollback en crear");
          } 
      finally {             
           em.close();         
          } 
 } 
 
 @Override     
 public void actualizar(Proyecto e) {         
      //throw new UnsupportedOperationException("Not supported yet.");      
      this.em = ConexionJPA.get();
      try { 
           em.getTransaction().begin();             
           em.merge(e);             
           em.getTransaction().commit();  
           System.out.println("hizo merge y commit en actualizar");
          } 
      catch (Exception ex) {            
           ex.printStackTrace();             
           em.getTransaction().rollback();
           System.out.println("hizo rollback en actualizar");
          } 
      finally {             
           em.close();         
          } 
	  } 
 
 /*@Override     
 public void eliminar(Proyecto e) {         
      throw new UnsupportedOperationException("Not supported yet.");      
	  } */
 
 @Override     
 public Proyecto buscarPorId(Integer id) { 
       System.out.println("entro por buscarPorId");
       this.em = ConexionJPA.get();       
       return em.find(Proyecto.class, id);
	  } 
 
 @Override     
 public List<Proyecto> buscarTodos() {         
      this.em = ConexionJPA.get();    
      List<Proyecto> resultado= new ArrayList<Proyecto>(); 
       try { 
           em.getTransaction().begin(); 
            resultado = this.em.createQuery("SELECT p FROM Proyecto p").getResultList();
            em.getTransaction().commit();
           }
       catch (Exception ex) { 
            ex.printStackTrace();
            em.getTransaction().rollback();      
           }
       finally {
	    em.close();
           } 
       return resultado;
  }
}