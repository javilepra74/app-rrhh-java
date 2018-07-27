/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utn.frsf.ofa.cursojava.app.rrhh.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import utn.frsf.ofa.cursojava.app.rrhh.Contratados;
import utn.frsf.ofa.cursojava.app.rrhh.Efectivo;
import utn.frsf.ofa.cursojava.app.rrhh.Empleado;

/**
 *
 * @author jalvarez
 */
public class EmpleadoDaoJDBC implements EmpleadoDao {          
    
    private final String INSERT_EMPLEADO = "INSERT INTO EMPLEADOS (NOMBRE, CORREO, CUIL, "             
            + "FECHA_INGRESO, HS_TRABAJADAS, SUELDO_BASICO, "             
            + "COMISIONES, HS_MINIMAS, COSTO_HORA, TIPO_EMPLEADO) "             
            + "VALUES (?,?,?,?,?,?,?,?,?,?)";
    
   @Override     
 public void crear(Empleado e) {         
     //Connection conn = null; 
     Connection conn = null; ;
        try {
            conn = ConexionJDBC.getConexion();
        } catch (SQLException ex) {
            Logger.getLogger(EmpleadoDaoJDBC.class.getName()).log(Level.SEVERE, null, ex);
        }
     System.out.println("entro crear");
        try(PreparedStatement ps = conn.prepareStatement(INSERT_EMPLEADO)){ 
            System.out.println("entro al try");
          //  conn = ConexionJDBC.getConexion();
            ps.setString(1, e.getNombre());             
		 ps.setString(2, e.getCorreoElectronico());             
		 ps.setString(3, e.getCuil()); 
                 System.out.println("antes del date");
		 // ver como pasar fecha
                 //ps.setDate(4,  new Date(e.getFechaIngreso().getTime())); 
                 //ps.setDate(4, "2018-01-01" ); 
                 System.out.println("despues del date");
		 ps.setInt(5, e.getHorasTrabajadas());             
		 if(e.esEfectivo()){                 
		    Efectivo empEf = (Efectivo) e;                 
		    ps.setDouble(6, empEf.getSueldoBasico());                 
		    ps.setDouble(7, empEf.getComisiones());                 
		    ps.setInt(8, empEf.getCanMInHorObl());                 
		    ps.setInt(10, 1);             
			}             
		 if(e.esContratado()){                 
		    Contratados c = (Contratados) e;                 
		    ps.setDouble(9, c.getMonPorHor());                 
		    ps.setInt(10, 2);             
			}             
		int filasInsertadas = ps.executeUpdate();                    
        } catch (SQLException ex) {
            System.out.println("entro al catch");
            Logger.getLogger(EmpleadoDaoJDBC.class.getName()).log(Level.SEVERE, null, ex);
        }
	/* try(PreparedStatement ps = conn.prepareStatement(INSERT_EMPLEADO)){             
	     ps.setString(1, e.getNombre());             
		 ps.setString(2, e.getCorreoElectronico());             
		 ps.setString(3, e.getCuil());             
		 ps.setDate(4, (java.sql.Date) new Date(e.getFechaIngreso().getTime()));             
		 ps.setInt(5, e.getHorasTrabajadas());             
		 if(e.esEfectivo()){                 
		    Efectivo empEf = (Efectivo) e;                 
		    ps.setDouble(6, empEf.getSueldoBasico());                 
		    ps.setDouble(7, empEf.getComisiones());                 
		    ps.setInt(8, empEf.getCanMInHorObl());                 
		    ps.setInt(10, 1);             
			}             
		 if(e.esContratado()){                 
		    Contratados c = (Contratados) e;                 
		    ps.setDouble(9, c.getMonPorHor());                 
		    ps.setInt(10, 2);             
			}             
		int filasInsertadas = ps.executeUpdate();         
	   }
             catch(SQLException ex){             
		    ex.printStackTrace();         
	   }*/
     }  
    
}          

