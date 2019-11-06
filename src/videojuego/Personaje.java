package videojuego;

/**
 * Personajes del videojuego
 * 
 * @author Ricardo Border�a Pi
 *
 */
public abstract class Personaje {

	/**
	 * Nombre del Personaje
	 */
	protected String nombre;
	/**
	 * Puntos de vida del personaje
	 */
	protected double pv;
	/**
	 * Ataque del personaje
	 */
	protected double ataque;
	/**
	 * Defensa f�sica del personaje
	 */
	protected int defensa;
	/**
	 * Resistencia m�gica del personaje
	 */
	protected int resistencia;

	/**
	 * Arma del personaje
	 */
	protected Arma arma;

	/**
	 * El personaje da�a a su enemigo y ese ataque puede ser cr�tico, ejerciendo el
	 * triple de da�o
	 * 
	 * @param rival enemigo del personaje que realiza el ataque
	 */
	public void atacar(Personaje rival) {
		int critico = (int) (Math.random() * 5);
		if (critico == 1) {
			gritarCritico();
			rival.setPv(rival.pv - (3 * (this.getAtaque() - rival.getDefensa())));
		} else {
			gritar();
			rival.setPv(rival.pv - (this.getAtaque() - rival.getDefensa()));
		}
	}

	/**
	 * Habilidad especial que puede ejecutar en vez de atacar
	 * 
	 * @param rival el enemigo del que utilize la habilidad
	 */
	public abstract void habEspecial(Personaje rival);

	/**
	 * Grito de guera del personaje
	 */
	public abstract void gritar();

	/**
	 * Grito de guerra del personaje cuando realiza un ataque cr�tico
	 */
	public abstract void gritarCritico();

	/**
	 * Si el arma es de un tipo que el personaje pueda usar, se suma al ataque de
	 * dicho personaje el da�o del arma. Despu�s se inicializa el atributo arma
	 * independientemente de si el personaje puede usarla o no
	 * 
	 * @param arma arma que se equipar� el personaje
	 * @see Personaje#setArma(Arma)
	 */
	public abstract void equiparArma(Arma arma);

	public double getAtaque() {
		return ataque;
	}

	public String getNombre() {
		return this.nombre;
	}

	public int getDefensa() {
		return defensa;
	}

	public int getResistencia() {
		return resistencia;
	}

	public double getPv() {
		return this.pv;
	}

	public void setPv(double pv) {
		this.pv = pv;
	}

	protected void setArma(Arma arma) {
		this.arma = arma;
	}

	public void setAtaque(double ataque) {
		this.ataque = ataque;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
}
