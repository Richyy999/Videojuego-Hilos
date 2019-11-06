package videojuego;

public abstract class Arma {

	/**
	 * Si el arma es mágica o fñisica
	 */
	protected String tipo;
	/**
	 * Daño del arma
	 */
	protected double dano;

	public double getDano() {
		return this.dano;
	}

	public String getTipo() {
		return this.tipo;
	}
}
