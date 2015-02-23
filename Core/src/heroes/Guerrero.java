package heroes;

public class Guerrero extends Humano {
		private boolean espada;
		private boolean arco;
		
	
	public Guerrero(String nombre, int edad,boolean espada, boolean arco) {
		super(nombre, edad);
		
		this.espada=espada;
		this.arco=arco;
		
		if(espada){
			super.ataque=6;
		}
		if(arco){
			super.ataque=4;
		}
		
	}


	public boolean isEspada() {
		return espada;
	}


	public void setEspada(boolean espada) {
		this.espada = espada;
	}


	public boolean isArco() {
		return arco;
	}


	public void setArco(boolean arco) {
		this.arco = arco;
	}


	@Override
	public String toString() {
		return super.toString()+"Guerrero [espada=" + espada + ", arco=" + arco + "]";
	}

	

}
