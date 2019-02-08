/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package notacionpolaca;

import java.util.LinkedList;
import java.util.Scanner;
import java.util.Stack;
import javax.swing.JOptionPane;

/**
 *
 * @author juliana
 */
public class CalculadoraNotacionPolaca {

    /**
     * @param args the command line arguments
     */
     public static String mostrarInfijo(String infijo){
		Pila p1 = conversion(infijo); //Pila del tamaño del texto
		String text = "";//Inicializando el texto
		while (p1.i > 0)
			text = p1.pop() + text; //Muestra el texto
		return text;
	}
   public static Pila conversion(String infijo) {
		infijo +=')'; // Agregamos al final del infijo un &#8216;)&#8217
		int tamaño = infijo.length();//tamaño de  acuerdo a la palabra
		Pila PilaDefinitiva = new Pila(tamaño); //Pila 1
		Pila PilaTemp = new Pila(tamaño);//Pila 2
		PilaTemp.push('('); // Agregamos a la pila temporal un &#8216;(&#8216;<br />
                
		for (int i = 0; i < tamaño; i++) {
			char caracter = infijo.charAt(i); //Lee caracter por caracter
			switch (caracter) {
			case '(':
				PilaTemp.push(caracter);
				break;
			case '+':case '-':case '^':case '*':case '/':
				while (Jerarquia(caracter) <= Jerarquia(PilaTemp.nextPop()))
					PilaDefinitiva.push(PilaTemp.pop());
				PilaTemp.push(caracter);
				break;
			case ')':
				while (PilaTemp.nextPop() != '(')
					PilaDefinitiva.push(PilaTemp.pop());
				PilaTemp.pop();
				break;
			default:
				PilaDefinitiva.push(caracter);
			}
		}
		return PilaDefinitiva;
	}
   public static int Jerarquia(char elemento) {
		int res = 0;
		switch (elemento) {
		case ')':
			res = 5; break;
		case '^':
			res = 4; break;
		case '*': case '/':
			res = 3; break;
		case '+': case '-':
			res = 2; break;
		case '(':
			res = 1; break;
		}
		return res;
	}
   public static  double resuelve (String posfijo1){
            Stack Pila=new Stack();
            int tamañito=posfijo1.length();

            double resultado, a , b;
            
            for(int j=0;j<tamañito;j++){
                char c = posfijo1.charAt(j);
                
                if(Character.isDigit(c)){
                    Pila.push(c);
                }else{
                    
                     String Str =Pila.pop().toString();
                        b=Double.valueOf(Str).doubleValue();
                       //b=(double)Pila.pop();
                        Str =Pila.pop().toString();
                        a=Double.valueOf(Str).doubleValue();
                    
                    if (c == '+')
                            Pila.push(a+b);
                        else if (c == '-')
                            Pila.push(a-b);
                        else if (c == '*')
                             Pila.push(a*b);
                         else if (c == '/')
                             Pila.push(a/b);
                        else if (c == '^')
                           Pila.push( Math.pow(a,b));
                }
              
            }
            
            System.out.println("RESULTADO "+Pila.peek());
         return (double) Pila.peek();
            
          }
            /*
             while(tamañito>0)
                {
                int j;
                    for(j=0;j<posfijo.length();j++){
                    char dato=posfijo.charAt(j);
                    
                    if (Character.isDigit(dato))
                        Pila.push(dato);
                    else
                       {
                        String Str =Pila.pop().toString();
                        b=Double.valueOf(Str).doubleValue();
                       //b=(double)Pila.pop();
                        Str =Pila.pop().toString();
                        a=Double.valueOf(Str).doubleValue();
                        
                        if (dato == '+')
                            Pila.push(a+b);
                        else if (dato == '-')
                            Pila.push(a-b);
                        else if (dato == '*')
                             Pila.push(a*b);
                         else if (dato == '/')
                             Pila.push(a/b);
                        else if (dato == '^')
                           Pila.push( Math.pow(a,b));

                        }
                    }
                }
                        String Str =Pila.pop().toString();
                        resultado=Double.valueOf(Str).doubleValue();
                        System.out.println(resultado);
                         return resultado;*/

          
   
   
   public static void main(String[] args){
       System.out.println("Ingrese la operación");
       Scanner leer = new Scanner(System.in);
                String text=leer.nextLine();
                String posfijo = mostrarInfijo(text);
		System.out.println("Posfijo : "+ posfijo);
                resuelve(posfijo);
   }
}
