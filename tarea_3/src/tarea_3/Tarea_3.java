package tarea_3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Tarea_3 {

	private static Scanner sc = new Scanner(System.in);
	private final String MARCA_INICIO = "***************************** INICIO FICHERO ********************************";
	private final String MARCA_FIN = "***************************** FINAL FICHERO ********************************";
	private File ficheroLectura;
	private File ficheroEscritura;
	private BufferedReader br = null;
	private BufferedWriter bw = null;
	private BufferedReader br1 = null;
	private BufferedReader br2 = null;
	
	public File leeFichero() {
		System.out.print("Nombre del fichero a leer: ");
		String nombreFicheroLectura = sc.nextLine();
		ficheroLectura = new File("\\AD\\tarea_3\\src\\" + nombreFicheroLectura);

		if (ficheroLectura.exists() && ficheroLectura.isFile() && ficheroLectura.canRead()
				&& ficheroLectura.length() > 0) {
			try {
				br = new BufferedReader(new FileReader(ficheroLectura));
				String linea = "";

				System.out.println(MARCA_INICIO);

				while ((linea = br.readLine()) != null) {
					System.out.println(linea);
				}

				System.out.println(MARCA_FIN);

			} catch (IOException e) {
				e.printStackTrace();
			} finally {
				if (br != null) {
					try {
						br.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			}
		} else {
			if (ficheroLectura.length() == 0) {
				System.out.println("El fichero " + ficheroLectura.getName() + " está vacío.");
			} else {
				System.out.println("Existe algún problema con el fichero " + ficheroLectura.getName());
			}
		}
		return ficheroLectura;
	}

	public void escribeFichero(File fichero) {
		System.out.print("Nombre del fichero a escribir: ");
		String nombreFicheroEscritura = sc.nextLine();
		ficheroEscritura = new File("\\AD\\tarea_3\\src\\" + nombreFicheroEscritura);
		if (!ficheroEscritura.exists()) {
			try {
				bw = new BufferedWriter(new FileWriter(ficheroEscritura));
				br = new BufferedReader(new FileReader(fichero));

				ficheroEscritura.createNewFile();
				System.out.println("El fichero: " + ficheroEscritura.getName() + " ha sido creado correctamente");

				String linea = "";
				int numeroLinea = 1;

				while ((linea = br.readLine()) != null) {

					if (numeroLinea % 2 == 0) {
						bw.write(linea);
						bw.newLine();
						numeroLinea++;
					} else {
						numeroLinea++;
					}
				}

			} catch (IOException e) {
				e.printStackTrace();
			} finally {
				if (bw != null) {
					try {
						bw.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
				if (br != null) {
					try {
						br.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			}
		} else {
			System.out.println("El fichero " + ficheroEscritura.getName() + " ya existe");
		}
	}

	public void escribeFicheroAlternativas(File fichero1, File fichero2) {
		System.out.print("Nombre del fichero a escribir: ");
		String nombreFicheroEscritura = sc.nextLine();
		ficheroEscritura = new File("\\AD\\tarea_3\\src\\" + nombreFicheroEscritura);
		if (!ficheroEscritura.exists()) {
			try {
				bw = new BufferedWriter(new FileWriter(ficheroEscritura));

				br1 = new BufferedReader(new FileReader(fichero1));
				br2 = new BufferedReader(new FileReader(fichero2));

				ficheroEscritura.createNewFile();
				System.out.println("El fichero: " + ficheroEscritura.getName() + " ha sido creado correctamente");

				String linea1, linea2 = "";

				while ((linea1 = br1.readLine()) != null && (linea2 = br2.readLine()) != null) {
					bw.write(linea1);
					bw.newLine();
					bw.write(linea2);
					bw.newLine();
				}

			} catch (IOException e) {
				e.printStackTrace();
			} finally {
				if (bw != null) {
					try {
						bw.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
				if (br1 != null) {
					try {
						br1.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
				if (br2 != null) {
					try {
						br2.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			}
		} else {
			System.out.println("El fichero " + ficheroEscritura.getName() + " ya existe");
		}
	}

	public void escribeAlFinal(File fichero) {
		if (fichero.length() > 0) {
			System.out.println("Escriba las líneas que desee añadir al fichero: " + fichero.getName());
			System.out.println("(Escriba la palabra SALIR para terminar).");

			try {
				bw = new BufferedWriter(new FileWriter(fichero, true));

				String linea = "";

				do {
					linea = sc.nextLine();
					if (linea.equalsIgnoreCase("salir")) {
						System.out
								.println("La operación sobre el fichero " + fichero.getName() + " ha sido finalizada.");
					} else {
						bw.newLine();
						//linea = sc.nextLine();
						bw.append(linea);
						bw.newLine();
					}
				} while (!linea.equalsIgnoreCase("salir") && fichero.length() > 0);

			} catch (IOException e) {
				e.printStackTrace();
			} finally {
				if (bw != null) {
					try {
						bw.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			}
		} else {
			System.out.println(
					"El fichero: " + fichero.getName() + " está vacio y no se puede utilizar en el ejercio 3.");
		}
	}
}