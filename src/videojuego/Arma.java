package videojuego;

/**
 * 
 * @author Ricardo Bordería Pi
 *
 */
public abstract class Arma {

	/**
	 * Si el arma es mágica o física
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
