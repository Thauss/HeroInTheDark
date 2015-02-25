package objetos;

public class Objeto {

	protected String nombre;
	protected int cantidad;
	
	
	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public int getCantidad() {
		return cantidad;
	}


	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}


	public Objeto(String nombre, int cantidad) {
		super();
		this.nombre = nombre;
		this.cantidad = cantidad;
	}


	@Override
	public String toString() {
		return "Objeto [nombre=" + nombre + ", precio=" + cantidad + "]\n";
	}
	
	

}
