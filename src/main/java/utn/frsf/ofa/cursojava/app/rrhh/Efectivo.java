/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utn.frsf.ofa.cursojava.app.rrhh;

/**
 *
 * @author jalvarez
 */
public class Efectivo extends Empleado{
    private double SueldoBasico;
    private double Comisiones;
    private Integer CanMInHorObl;


    public double getSueldoBasico() {
        return SueldoBasico;
    }

    public void setSueldoBasico(double SueldoBasico) {
        this.SueldoBasico = SueldoBasico;
    }

    public double getComisiones() {
        return Comisiones;
    }

    public void setComisiones(double Comisiones) {
        this.Comisiones = Comisiones;
    }

    public Integer getCanMInHorObl() {
        return CanMInHorObl;
    }

    public void setCanMInHorObl(Integer CanMInHorObl) {
        this.CanMInHorObl = CanMInHorObl;
    }

    @Override
    public Double salario() {
        /* variables */
        double extra = 0;
        double resultado = 0;
        if(horasTrabajadas > CanMInHorObl){
            /* calculamos horas extras*/
            extra = (horasTrabajadas - CanMInHorObl) * (SueldoBasico/20);
            resultado = SueldoBasico + Comisiones + extra; 
        }else{		
	    resultado = SueldoBasico + Comisiones;	                        	
	     }
        return resultado;
    }
        @Override
    public Boolean esEfectivo(){
        return true;
    }
      
    @Override
    public Boolean esContratado(){
        return false;
    }
}
