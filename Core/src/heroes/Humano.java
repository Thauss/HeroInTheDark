package heroes;

import java.util.ArrayList;
import java.util.Scanner;

import objetos.Objeto;
import objetos.Pocion;

public class Humano {
	
		protected String nombre;
		protected int edad;
		protected int vida;
		protected int ataque =4;
		protected int defensa=3;
		protected final int maxvida=20;
		protected static ArrayList<Objeto> inventario;
		
		
		
		public Humano(String nombre, int edad) {
			super();
			this.nombre = nombre;
			this.edad = edad;
			this.vida = maxvida;
			this.inventario=new ArrayList<Objeto>();
		}
		
		public int getAtaque() {
			return ataque;
		}

		public void setAtaque(int ataque) {
			this.ataque = ataque;
		}

		public int getDefensa() {
			return defensa;
		}

		public void setDefensa(int defensa) {
			this.defensa = defensa;
		}

		public String getNombre() {
			return nombre;
		}

		public void setNombre(String nombre) {
			this.nombre = nombre;
		}

		public int getEdad() {
			return edad;
		}

		public void setEdad(int edad) {
			this.edad = edad;
		}

		public int getVida() {
			return vida;
		}

		public void setVida(int vida) {
			this.vida = vida;
		}

		public ArrayList<Objeto> getInventario() {
			return inventario;
		}

		public static void setInventario(ArrayList<Objeto> inventario) {
			Humano.inventario = inventario;
		}

		public int getMaxvida() {
			return maxvida;
		}

		public Humano() {
			super();
			this.nombre = "Thauss";
			this.edad = 15;
			this.vida = maxvida;
		}

		@Override
		public String toString() {
			return "Humano [nombre=" + nombre + ", edad=" + edad + ", vida="
					+ vida ;
		}

		
		
		
				
}
