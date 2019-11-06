package videojuego;

/**
 * 
 * @author Ricardo Border�a Pi
 *
 */
public abstract class Arma {

	/**
	 * Si el arma es m�gica o f�sica
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
