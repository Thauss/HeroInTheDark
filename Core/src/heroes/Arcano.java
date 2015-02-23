package heroes;

public class Arcano extends Mago {

	boolean fuego;
	boolean hielo;
	
	public Arcano(String nombre, int edad, boolean baston, boolean varita, boolean fuego, boolean hielo) {
		super(nombre, edad, baston, varita);
		this.fuego=fuego;
		this.hielo=hielo;
		if(fuego){
			super.ataque=6;
		}
		if(hielo){
			super.ataque=4;
		}
	}

	public boolean isFuego() {
		return fuego;
	}

	public void setFuego(boolean fuego) {
		this.fuego = fuego;
	}

	public boolean isHielo() {
		return hielo;
	}

	public void setHielo(boolean hielo) {
		this.hielo = hielo;
	}

	@Override
	public String toString() {
		return super.toString()+" Arcano [fuego=" + fuego + ", hielo=" + hielo +"]";
	}
	
}
