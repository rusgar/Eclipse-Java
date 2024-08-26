package com.erc.helpers;

import java.text.DecimalFormat;
import java.util.Scanner;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class CommonHelpers {
	
		
		public String leerTeclado() {
		String retorno="";
		Scanner sca= new Scanner(System.in);
		retorno=sca.nextLine();
		return retorno;
	}
		public int leerTecladoInt() {
			Scanner sca = new Scanner(System.in);
	        String entrada = sca.nextLine();
	        int valor = Integer.parseInt(entrada);
	        return valor;
		}
		public double leerTecladoDouble() {
			Scanner sca = new Scanner(System.in);
	        String entrada = sca.nextLine();
	        double valor = Double.parseDouble(entrada);
	        return valor;
	}
		

		public void imprimirSalto(String mensaje) {
			 System.out.println(mensaje);
		}
		public void imprimirContinuo(String mensaje) {
			 System.out.print(mensaje);
		}
		
		public int obtenerEntero(String cadena) {
			int retorno=0;
			retorno = Integer.parseInt(cadena);
			return retorno;
		}
		public double obtenerDouble(String cadena) {
			double retorno=0;
			retorno =Double.parseDouble(cadena);
			return retorno;
		}
		
		public String obtenerString(int entrada) {
			String retorno= "";
			retorno = String.valueOf(retorno);
			return retorno;
		}
		public String obtenerString(double entrada) {
			String retorno= "";
			retorno = String.valueOf(retorno);
			return retorno;
		}
		public String obtenerString(float entrada) {
			String retorno= "";
			retorno = String.valueOf(retorno);
			return retorno;
		}
		public float redondearFloat(float numero) {
			float numeroRedondeado = (float)0.0;
			String cadenaFormateada=String.format("%.2f", numero);
			numeroRedondeado = Float.parseFloat(cadenaFormateada);
			return numeroRedondeado;
		}
		public double redondearDouble(double numero) {
			double numeroRedondeado = 0.0;
			String cadenaFormateada=String.format("%.2f", numero);
			numeroRedondeado = Double.parseDouble(cadenaFormateada);
			return numeroRedondeado;
		}
		
		public double redondearDoubleN(double numero, int numeroDecimales) {
			double numeroRedondeado = (float)0.0;
			String cadenaFormateada=String.format("%" +numeroDecimales+".2f", numero);
			numeroRedondeado = Double.parseDouble(cadenaFormateada);
			return numeroRedondeado;
		}
	
		public double redondearND(double numero,
				int numeroDecimales) {
			double numeroRedondeado=0.0;
			String cadenaFormateada=
					String.format("%."+numeroDecimales+"f",
							numero);
			cadenaFormateada=cadenaFormateada.replace(',','.');
			numeroRedondeado= Double.parseDouble(cadenaFormateada);
			return numeroRedondeado;
		}
		
		public double redondear2D(double numero) {
			double numeroRedondeado=0.0;
			String cadenaFormateada=
					String.format("%.2f", numero);
			cadenaFormateada=cadenaFormateada.replace(',','.');
			numeroRedondeado= Double.parseDouble(cadenaFormateada);
			return numeroRedondeado;
		}
		
		public float redondear2D(float numero) {
			float numeroRedondeado=(float)0.0;
			DecimalFormat df = new DecimalFormat("#.00");
			String cadenaFormateada= df.format(numero);
			cadenaFormateada=cadenaFormateada.replace(',','.');
			numeroRedondeado= Float.parseFloat(cadenaFormateada);
			return numeroRedondeado;
		}
		
		 public boolean continuarBucle() {
			 boolean retorno=true;
			 imprimirSalto("¿Desea continuar? (y/n)");
			 String leido= leerTeclado();
			 if(leido.equalsIgnoreCase("n") ||(leido.equalsIgnoreCase("no"))) {
				 retorno =false;
				 imprimirSalto("Recuerdo que Java es molto divertente");
			 }return retorno;
		 }
			public String soloNumeros(String acumulador, char leido) {
				String retorno = acumulador;
				if(leido==',') {
					leido = '.';
				}
				boolean existeComa= false;
				if(retorno.contains(".")) {
					existeComa =true;
				}
			
				if(Character.isDigit(leido) || (leido== '.' && !existeComa)  || leido == '-'&& retorno.equalsIgnoreCase("") ) {
					retorno+=leido;
				}
				if(retorno.equals("") ) {
					retorno = "";
				}
				return retorno;
			}
			
			// METODO PARA LEER EL TEXTOINTRODUCIDO DEN UN jTEXTFILED Y CONVERTIRLO EN UN NUMERO DOUBLE EN ESTE CASO
	        public double getDoubleFromTextField(JTextField textField) {
	            String text = textField.getText().trim();
	            if (text.isEmpty()) {
	                return 0;  // 
	            }
	            try {
	                return Double.parseDouble(text);
	            } catch (NumberFormatException e) {
	                // MANEJAMOS EL ERROR PARA ADMITIR SOLO NUMEROS...TENEMOS OTRO METODO QUE ADMITA SOLO NUMEROS
	                throw new IllegalArgumentException("El valor ingresado no es un número válido: " + text);
	            }
	        }
	        
	     // METODO PARA LEER EL TEXTOINTRODUCIDO DEN UN jTEXTFILED Y CONVERTIRLO EN UN NUMERO ENTERO EN ESTE CASO
	        public int getIntFromTextField(JTextField textField) {
	            String text = textField.getText().trim();
	            if (text.isEmpty()) {
	                return 0;  // Retorna un valor por defecto si el campo está vacío
	            }
	            try {
	                return Integer.parseInt(text);
	            } catch (NumberFormatException e) {
	                // Manejar el error si el texto no es un número válido
	                throw new IllegalArgumentException("El valor ingresado no es un número entero válido: " + text);
	            }
	        }

	        public void mostrarMensaje(JFrame marco,
	        		String mensaje,
	        		String tipo) {
	        	int recursoIcono=0;
	        	String titulo="";
	        	switch (tipo) {
	        	case "informacion": {
	        		recursoIcono=JOptionPane.INFORMATION_MESSAGE;
	        		titulo="Información";
	        		break;
	        	}
	        	case "aviso": {
	        		recursoIcono=JOptionPane.WARNING_MESSAGE;
	        		titulo="Aviso";
	        		break;
	        	}
	        	case "error": {
	        		recursoIcono=JOptionPane.ERROR_MESSAGE;
	        		titulo="Error";
	        		break;
	        	}
	        	}
	        	
	        	JOptionPane.showMessageDialog(marco, 
	        			mensaje,titulo,recursoIcono);
	        	
	        	
	        	
	        }
	}


