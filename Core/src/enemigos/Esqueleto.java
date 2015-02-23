package enemigos;

public class Esqueleto {
	int vida;
	final int vidamax=40;
	int ataque=2;
	
	public Esqueleto() {
		super();
		this.vida = 10;
		this.ataque = 2;
	}

	public int getVida() {
		return vida;
	}

	public void setVida(int vida) {
		this.vida = vida;
	}

	public int getAtaque() {
		return ataque;
	}

	public void setAtaque(int ataque) {
		this.ataque = ataque;
	}

	@Override
	public String toString() {
		return "Esqueleto [vida=" + vida + ", ataque=" + ataque + "]";
	}
	
}
