/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.List;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author jalvarez
 */
public class ProyectoDAOTest {
    
    ProyectoDAO proyectoDao;
    
    public ProyectoDAOTest() {
    }
    
    @Before
    public void setUp() {
        proyectoDao = new ProyectoDaoJPA(); 
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void testSomeMethod() {
    }
    
    @Test     
    public void testCrearProyecto() { 
         System.out.println("entro a testCrearProyecto");        
         List<Proyecto> lista = proyectoDao.buscarTodos();         
	 int proyectos = lista.size();         
	 Proyecto pry = new Proyecto();         
	 pry.setId(2); 
         pry.setNombre("Proyecto 2");         
	 pry.setDescripcion("Descripcion proyecto 2");        
	 pry.setPresupuestoMaximo(222.0);         
	 proyectoDao.crear(pry);         
	 lista = proyectoDao.buscarTodos();         
	 int proyectosMas1 = lista.size();         
	 assertEquals(proyectos+1, proyectosMas1);     
    }  
    
    @Test
    public void testActualizarProyecto() {
        System.out.println("entro a testActualizarProyecto");
        Proyecto pry2 = proyectoDao.buscarPorId(99);
        String descr1 = pry2.getDescripcion();
        String descr1a = descr1 + "actualizado"; // le agrego una actualizado
        pry2.setDescripcion(descr1a);
        proyectoDao.actualizar(pry2);
        
        Proyecto pry3 = proyectoDao.buscarPorId(99);
        String descr2 = pry3.getDescripcion();
        
        Boolean bandera;
        if(descr1.equals(descr2)){
            bandera = false; // no actualizo
        }else{
             bandera = true; // si actualizó
        }
        assertTrue(bandera);        
       // assertEquals(1, 1);
    }
}
