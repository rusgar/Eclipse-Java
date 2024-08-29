package com.erc.model;
/**
 * CLASE MODELO QUE CONTENDRA LOS ELEMENTOS PARA RESOLVER LA OPERACION
 * @author EDU RC
 */

public class Operaciones {
	
	
	// ATRIBUTOS
	private double operando1, operando2;
	private String simbolo;
	
	
	
	/**
     * DECULEVE EL PRIMERO OPERANDO DE LA OPERACION     
     * @return double 
     */
	public double getOperando1() {
		return operando1;
	}
	
	
	
	/**
     * ESTABLECE EL VALOR DE OPERANDO1 DE LA OPERACION     
     * @param operando1 double
     */
	public void setOperando1(double operando1) {
		this.operando1 = operando1;
	}
	
	
	
	/**
	 * DECULEVE EL SEGUNDO OPERANDO DE LA OPERACION 
	 * @return double 
	 */	
	public double getOperando2() {
		return operando2;
	}
	
	
	
	
	/**
	 * ESTABLECE EL VALOR DE OPERANDO2 DE LA OPERACION  
	 * @param operando2 double
	 */
	public void setOperando2(double operando2) {
		this.operando2 = operando2;
	}
	
	
	/**
     * DEVUELE EL VALOR DEL SIMBOLO DE LA OPERACION ( "+", "-", "*","X", "/",":").
     * 
     * @return string
     */
	public String getSimbolo() {
		return simbolo;
	}
	
	
	/**
	 * ESTABLE EL SIMBOLO DE LA OPERACION
	 * @param simbolo string
	 */	
	public void setSimbolo(String simbolo) {
		this.simbolo = simbolo;
	}
	
	
	
	/**
	 * CONTRUCTORES POR DEFECTO Y INCIALIAZAMOS LAS VARIABLES POR DEFECTO
	 */
	public Operaciones() {
		super();
		this.operando1 = this.operando2 = 0.0;
		this.simbolo = "";
	}
	
	
	/**
	 * CONSTRUCTOR  QUE INICIALIZA LOS OPERANDOS  Y EL SIMBOLO DE LA OPERACION
	 * @param operando1 double
	 * @param operando2 double
	 * @param simbolo string
	 */
	public Operaciones(double operando1, double operando2, String simbolo) {
		super();
		this.operando1 = operando1;
		this.operando2 = operando2;
		this.simbolo = simbolo;
	}
	

	public String toString() {
		return "Operaciones [operando1=" + operando1 + ", operando2=" + operando2 + ", simbolo=" + simbolo + "]";
	}
	
	
	
	
	/**
	 *  ES UNA OPERACION QUE NOS DEVUELVE EL RESULTADO DE LA OPERACION, SEGUN EL SIMNOLO QUE PONGAMOS
	 * @return double
	 */
	public double calculaResultado() {
		double resultado =0.0;
		 switch (simbolo) {
		        case "+": {
		            resultado = operando1+operando2;
					break;
	                      }
		        case "-": {
		            resultado = operando1-operando2;
					break;
	                      }
		        case "*": {
		            resultado = operando1*operando2;
					break;
	                      }
		        case "x": {
		            resultado = operando1*operando2;
					break;
	                      }
		        case "/": {
		        	try {
		            resultado = operando1/operando2;
		        	}catch(ArithmeticException artEX) {
		        		artEX.printStackTrace();
		        	}
					break;
	                      }
		        case ":": {
		        	try {
		        	resultado = operando1/operando2;
	            	}catch(ArithmeticException artEX) {
	        	    	artEX.printStackTrace();
	        	    }
					break;
	                      }
		    default:
		    	System.out.println("Operacion no disponible");
			
		}
		
		return resultado;
	}

}
