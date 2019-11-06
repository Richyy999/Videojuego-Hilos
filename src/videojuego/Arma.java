package videojuego;

public abstract class Arma {

	/**
	 * Si el arma es m�gica o f�isica
	 */
	protected String tipo;
	/**
	 * Da�o del arma
	 */
	protected double dano;

	public double getDano() {
		return this.dano;
	}

	public String getTipo() {
		return this.tipo;
	}
}
