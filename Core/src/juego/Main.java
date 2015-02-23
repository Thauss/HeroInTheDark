package juego;

import heroes.Arcano;
import heroes.Guerrero;
import heroes.Humano;
import heroes.Sacerdote;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

import objetos.Bomba;
import objetos.Objeto;
import objetos.Pocion;
import enemigos.EArquero;
import enemigos.EGuerrero;
import enemigos.Esqueleto;

public class Main {
	static ArrayList<Humano> personajes;
	static int cnt;
	static int opcion;

	public static void main(String[] args) {
		personajes = new ArrayList<Humano>();
		Guerrero Thauss = new Guerrero("Thauss", 12, true, false);
		Thauss.getInventario().add(new Pocion());
		Thauss.getInventario().add(new Bomba());
		personajes.add(Thauss);
		menu();

	}

	public static void menu() {
		int opcion = 0;
		Scanner s = new Scanner(System.in);
		Humano jugador = null;
		do {
			System.out.println("Que opci�n desea hacer?");
			System.out.println("1.Crear personaje");
			System.out.println("2.Seleccionar personaje");
			System.out.println("3.Jugar");
			System.out.println("4.Salir");
			opcion = Entrada.entero();

			switch (opcion) {
			case 1:
				crearpersonaje();

				break;

			case 2:
				mostrarPersonaje();
				jugador = seleccionarPersonaje(personajes);
				break;

			case 3:
				
				jugar(jugador);

				break;

			case 4:
				System.out.println("Hasta luego");

				break;

			default:
				break;
			}

		} while (opcion != 4);

	}

	private static Humano seleccionarPersonaje(ArrayList<Humano> ah) {
		Humano j = null;
		boolean b = false;

		do {
			System.out.println("Introduce el nombre del personaje a buscar");
			String n = Entrada.cadena();
			for (int i = 0; i < ah.size(); i++) {
				if (ah.get(i).getNombre().equalsIgnoreCase(n)) {
					j = ah.get(i);
					b = true;
					System.out.println("Has seleccionado a "
							+ ah.get(i).toString());
				}
			}
			if (!b) {
				System.out.println("Nombre no encontrado");
			}
		} while (!b);

		return j;
	}

	private static void jugar(Humano j) {
		ArrayList<Esqueleto> n = new ArrayList<Esqueleto>();
		boolean ok = false;
		Esqueleto e = null;

		e = crearEnemigo();
		n.add(e);
		do {
			mostrarPantalla(j, e);
			do {
				System.out.println("1.Atacar");
				System.out.println("2.Objeto");
				opcion = Entrada.entero();
				switch (opcion) {
				case 1:
					atacar(j, e);
					ok = true;
					break;

				case 2:
					ok = objeto(j, e);
					break;

				default:
					break;
				}
			} while (!ok);
			if (e.getVida() < 0) {
				cnt++;
				System.out.println("=========================================");
				System.out.println("=========================================");
				System.out.println("==========  ENEMIGO ABATIDO    ==========");
				System.out.println("=========================================");
				System.out.println("=========================================");
				System.out.println("*****************************************");
				System.out.println("=========================================");
				System.out.println("==========   BOTIN RECIBIDO    ==========");
				System.out.println("=========================================");
				System.out.println("=========================================");
				generarBotin(j);
				break;
			} else {
				ataqueEnemigo(j, e);
				mostrarPantalla(j, e);

			}

		} while (j.getVida() > 0);
		// }while(cnt<4);
		if (j.getVida() > 0) {
			System.out.println("Has ganado!");
			jugar(j);

		} else {
			System.out.println("Has abatido a " + cnt + " enemigos");
		}

	}

	private static  void generarBotin(Humano j) {
		Random r = new Random();
		int op;
		op = r.nextInt(100);
		if(op>=0 && op <70){
			Pocion p=new Pocion();
			j.getInventario().add(p);
			System.out.println("Te ha tocado una Pocion!!!");
		}
			
		else{
			if(op<=71 && op >90){
				Bomba bom=new Bomba();
				j.getInventario().add(bom);
				System.out.println("Te ha tocado una Bomba de fuego!!!");
			}
				
			else
				System.out.println("No te ha soltado nada el muy agarrao");
		}

		
		

	}

	private static boolean objeto(Humano j, Esqueleto e) {
		String ob;
		if (j.getInventario().isEmpty()) {
			System.out.println("No hay objetos en tu inventario");
			return false;
		} else {
			for (int i = 0; i < j.getInventario().size(); i++) {
				System.out.println(j.getInventario().get(i).toString());
				
			}
			System.out
					.println("Escribe el nombre de el objeto que deseas usar");
			System.out.println("Escribe salir si no quieres usar nada");
			ob = Entrada.cadena();
			if (ob.equalsIgnoreCase("salir")) {
				return false;
			} else {
				usarObjeto(j, e, ob);
				return true;
			}

		}

	}

	private static void usarObjeto(Humano j, Esqueleto e, String ob) {
		if (ob.equalsIgnoreCase("Pocion")) {
			j.setVida(j.getVida() + 10);
			if (j.getVida() > j.getMaxvida()) {
				j.setVida(20);
			}
		} else if (ob.equalsIgnoreCase("bomba de fuego")) {
			e.setVida(e.getVida() - 7);
		}

	}

	private static Humano ataqueEnemigo(Humano j, Esqueleto e) {

		j.setVida(j.getVida() - e.getAtaque());

		return j;
	}

	private static Esqueleto atacar(Humano j, Esqueleto e) {

		e.setVida(e.getVida() - j.getAtaque());

		return e;
	}

	private static Esqueleto crearEnemigo() {
		Esqueleto e = null;
		int n;
		Random r = new Random();
		n = r.nextInt(2);

		switch (n) {
		case 0:
			e = new Esqueleto();
			break;
		case 1:
			e = new EArquero();
			break;
		case 2:
			e = new EGuerrero();
			break;

		default:
			break;
		}
		return e;
	}

	private static void mostrarPantalla(Humano j, Esqueleto e) {
		System.out.println("===============================================");
		System.out.println("   " + e.toString());
		System.out.println("=");
		System.out.println("=");
		System.out.println("=");
		System.out.println("=");
		System.out.println("=");
		System.out.println("=");
		System.out.println("=");
		System.out.println("=");
		System.out.println("   " + j.toString());
		System.out.println("=");
		System.out.println("=");

	}

	private static void mostrarPersonaje() {
		for (int i = 0; i < personajes.size(); i++) {
			System.out.println(personajes.get(i));
		}

	}

	public static void crearpersonaje() {
		int o = 0;
		String nombre, dato;
		int edad;
		boolean a = false;
		boolean b = false;
		boolean c = false;
		boolean d = false;

		Scanner s = new Scanner(System.in);
		System.out.println("Que tipo desea ser?");
		System.out.println("1.guerrero");
		System.out.println("2.mago");
		o = Entrada.entero();

		switch (o) {
		case 1:
			System.out.println("Como se llama?");
			nombre = Entrada.cadena();
			System.out.println("Cu�ntos a�os tiene?");
			edad = Entrada.entero();
			do {
				System.out.println("tiene espada?");
				dato = Entrada.cadena();
				if (dato.equalsIgnoreCase("Si")) {
					a = true;
					personajes.add(new Guerrero(nombre, edad, a, b));
				} else if (dato.equalsIgnoreCase("no")) {
					System.out.println("Entonces tiene un arco");
					b = true;
					personajes.add(new Guerrero(nombre, edad, a, b));
				} else {
					System.out.println("opci�n incorrecta");
				}
			} while (!(dato.equalsIgnoreCase("si") || dato
					.equalsIgnoreCase("no")));

			break;

		case 2:
			System.out.println("1.Arcano");
			System.out.println("2.Sacerdote");
			o = Entrada.entero();
			switch (o) {
			case 1:
				System.out.println("Como se llama?");
				nombre = Entrada.cadena();
				System.out.println("Cu�ntos a�os tiene?");
				edad = Entrada.entero();
				do {
					System.out.println("tiene bast�n?");
					dato = Entrada.cadena();
					if (dato.equalsIgnoreCase("Si")) {
						a = true;
					} else if (dato.equalsIgnoreCase("no")) {
						System.out.println("Entonces tiene una varita");
						b = true;
					} else {
						System.out.println("opci�n incorrecta");
					}
				} while (!(dato.equalsIgnoreCase("si") || dato
						.equalsIgnoreCase("no")));

				do {
					System.out.println("Es Arcano?");
					dato = Entrada.cadena();
					if (dato.equalsIgnoreCase("Si")) {
						c = true;
						personajes.add(new Arcano(nombre, edad, a, b, c, d));
					} else if (dato.equalsIgnoreCase("no")) {
						System.out.println("Entonces es de Hielo");
						d = true;
						personajes.add(new Arcano(nombre, edad, a, b, c, d));
					} else {
						System.out.println("opci�n incorrecta");
					}
				} while (!(dato.equalsIgnoreCase("si") || dato
						.equalsIgnoreCase("no")));

				break;

			case 2:
				System.out.println("Como se llama?");
				nombre = Entrada.cadena();
				System.out.println("Cu�ntos a�os tiene?");
				edad = Entrada.entero();
				do {
					System.out.println("tiene bast�n?");
					dato = Entrada.cadena();
					if (dato.equalsIgnoreCase("Si")) {
						a = true;
					} else if (dato.equalsIgnoreCase("no")) {
						System.out.println("Entonces tiene una varita");
						b = true;
					} else {
						System.out.println("opci�n incorrecta");
					}
				} while (!(dato.equalsIgnoreCase("si") || dato
						.equalsIgnoreCase("no")));

				do {
					System.out.println("Cura?");
					dato = Entrada.cadena();
					if (dato.equalsIgnoreCase("Si")) {
						c = true;
						personajes.add(new Sacerdote(nombre, edad, a, b, c, d));
					} else if (dato.equalsIgnoreCase("no")) {
						System.out.println("Entonces Maldice");
						d = true;
						personajes.add(new Sacerdote(nombre, edad, a, b, c, d));
					} else {
						System.out.println("opci�n incorrecta");
					}
				} while (!(dato.equalsIgnoreCase("si") || dato
						.equalsIgnoreCase("no")));

				break;

			default:
				break;
			}

			break;

		default:
			break;
		}
	}

}
