/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utn.frsf.ofa.cursojava.app.rrhh.dao;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import utn.frsf.ofa.cursojava.app.rrhh.Contratados;
import utn.frsf.ofa.cursojava.app.rrhh.Efectivo;
import utn.frsf.ofa.cursojava.app.rrhh.Empleado;

/**
 *
 * @author jalvarez
 */
public class EmpleadoDaoJDBCTest {
    
    EmpleadoDaoJDBC EmpleadoDaoJdbc;
    
    public EmpleadoDaoJDBCTest() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void testSomeMethod() {
    }
    //el insert de efectivo
    @Test
    public void testCrear() {
       System.out.println("crear1");
        EmpleadoDaoJdbc = new EmpleadoDaoJDBC();
       //creo objeto empleado para llamar al metodo crear
       Efectivo empleado = new Efectivo();
       java.util.Date fechaActual = new java.util.Date();       
       empleado.setId(1);
       empleado.setNombre("Raul" );
       empleado.setCorreoElectronico("Raul@hotmail.COM");
       empleado.setCuil("25999999993");
       empleado.setFechaIngreso(fechaActual);
       empleado.setHorasTrabajadas(40);
       empleado.setCanMInHorObl(40);
       empleado.setComisiones(2000.0);
       empleado.setSueldoBasico(30000.0);       
       System.out.println(empleado.getNombre() + "Crear2:");        
       EmpleadoDaoJdbc.crear(empleado);
       /*System.out.println(empleado.getNombre() + "Crear3:");
       Empleado empleado2 =  empleadoDaoJdbc.buscarPorId(1);
       assertEquals(empleado.getNombre(), empleado2.getNombre());*/
   }
    /*@Test
    public void testCrearCon() {
       System.out.println("crear1_Contratado");
        EmpleadoDaoJdbc = new EmpleadoDaoJDBC();
       //creo objeto empleado para llamar al metodo crear
       Contratados empleado = new Contratados();
       java.util.Date fechaActual = new java.util.Date();       
       empleado.setId(1);
       empleado.setNombre("Pilar" );
       empleado.setCorreoElectronico("Pilar@hotmail.com");
       empleado.setCuil("23523652553");
       empleado.setFechaIngreso(fechaActual);
       empleado.setHorasTrabajadas(40);       
       empleado.setMonPorHor(250);    
       System.out.println(empleado.getNombre() + "Crear_Contrtados:");        
       EmpleadoDaoJdbc.crear(empleado);*/
       /*System.out.println(empleado.getNombre() + "Crear3:");
       Empleado empleado2 =  empleadoDaoJdbc.buscarPorId(1);
       assertEquals(empleado.getNombre(), empleado2.getNombre());*/
   //}
    
    
   @Test
    public void testActualizar() {
       System.out.println("Actualizar Test");
       EmpleadoDaoJdbc = new EmpleadoDaoJDBC();
       //creo objeto empleado para llamar al metodo crear
       Efectivo empleado = new Efectivo();
       int posicion = 1;
       for(int i=1 ;i<200;i++){
           Empleado empleadox =  EmpleadoDaoJdbc.buscarPorId(i);
            if (empleadox != null){              
                if ("Mateo".equals(empleadox.getNombre()) && empleadox.esEfectivo()){
                    posicion = i;
                    i = 201;
                } else {
                }  
            }
       }
       System.out.println("encontro un ID");
       java.util.Date fechaActual = new java.util.Date();       
       empleado.setId(posicion);
       empleado.setNombre("Pilar Actualizado" );
       empleado.setCorreoElectronico("Pilar@hotmail.COM");
       empleado.setCuil("21523652553");
       empleado.setFechaIngreso(fechaActual);
       empleado.setHorasTrabajadas(40);
       empleado.setCanMInHorObl(40);
       empleado.setComisiones(2000.0);
       empleado.setSueldoBasico(30000.0);       
       System.out.println(empleado.getNombre() + "Actualizar2:" + posicion);        
       EmpleadoDaoJdbc.actualizar(empleado); 
       /*System.out.println(empleado.getNombre() + "Actualizar3:");
       Empleado empleado2 =  empleadoDaoJdbc.buscarPorId(posicion);
       assertEquals(empleado.getNombre(), empleado2.getNombre());*/
   } 
}
