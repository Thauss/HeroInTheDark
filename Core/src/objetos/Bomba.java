package objetos;

public class Bomba extends Objeto {

	public Bomba() {
		super("Bomba de Fuego", 1);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "[nombre=" + nombre + ", cantidad=" + cantidad + "]";
	}

}
