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
    //controlo el buscar y el insert de efectivo
    @Test
    public void testCrear() {
       System.out.println("crear1");
        EmpleadoDaoJdbc = new EmpleadoDaoJDBC();
       //creo objeto empleado para llamar al metodo crear
       Efectivo empleado = new Efectivo();
       java.util.Date fechaActual = new java.util.Date();       
       empleado.setId(1);
       empleado.setNombre("Javier" );
       empleado.setCorreoElectronico("Javier@hotmail.COM");
       empleado.setCuil("232698624593");
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
       System.out.println("crear1 Contratado");
       //empleadoDaoJdbc = new EmpleadoDaoJdbc();
       EmpleadoDaoJdbc = new EmpleadoDaoJDBC();
       //creo objeto empleado para llamar al metodo crear
       Contratados empleado = new Contratados();
       System.out.println("creo objeto Contratados");
       java.util.Date fechaActual = new java.util.Date();       
       empleado.setId(1);//cualquiera total grava el que sigue
       empleado.setNombre("Juan" );
       empleado.setCorreoElectronico("Juan@hotmail.com");
       empleado.setCuil("21257131123");
       empleado.setFechaIngreso(fechaActual);
       empleado.setHorasTrabajadas(40);
       empleado.setMonPorHor(250);
       System.out.println(empleado.getNombre() + "Crear2_contratado:");        
       //empleadoDaoJdbc.crear(empleado);
       EmpleadoDaoJdbc.crear(empleado);
   }*/
    
}
