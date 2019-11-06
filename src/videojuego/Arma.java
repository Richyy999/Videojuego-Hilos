package videojuego;

public abstract class Arma {

	protected String tipo;
	protected double dano;

	public double getDano() {
		return this.dano;
	}

	public String getTipo() {
		return this.tipo;
	}
}
