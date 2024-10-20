package tarea_3;

import java.io.File;

public class Main {

	public static void main(String[] args) {

		/*
		 * Ejercicio 1
		 * 
		 * Crea un programa que lea de un fichero (que solicitará por teclado) y
		 * escribirá las líneas pares en otro fichero de texto (que también se
		 * solicitará por teclado).
		 */

		Tarea_3 ejercicio1 = new Tarea_3();
		//File ficheroLeido = ejercicio1.leeFichero();
		//ejercicio1.escribeFichero(ficheroLeido);

		/*
		 * Ejercicio 2
		 * 
		 * Crea un programa que solicita 3 ficheros de texto (2 de lectura y 1 de
		 * escritura), y escriba en el fichero de escritura el contenido de los ficheros
		 * de texto de forma alternativa (1 línea de cada fichero). El contenido final
		 * debe ser el de ambos ficheros de lectura entremezcladas las líneas.
		 */

		//Tarea_3 ejercicio2 = new Tarea_3();
		//File ficheroLeido2 = ejercicio1.leeFichero();
		//File ficheroLeido3 = ejercicio1.leeFichero();
		//ejercicio2.escribeFicheroAlternativas(ficheroLeido2, ficheroLeido3);

		/*
		 * Ejercicio 3
		 * 
		 * Crea un programa que solicita 1 fichero de texto ya existente y con contenido
		 * y añada al final de ese fichero todo lo que el usuario escriba en el teclado
		 * hasta una línea con la palabra “salir”.
		 */

		Tarea_3 ejercicio3 = new Tarea_3();
		File ficheroExistente = ejercicio1.leeFichero();
		ejercicio3.escribeAlFinal(ficheroExistente);	
	}
}