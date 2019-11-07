package videojuego;

/**
 * Personajes del videojuego
 * 
 * @author Ricardo Bordería Pi
 *
 */
public abstract class Personaje {

	/**
	 * Nombre del Personaje
	 */
	protected String nombre;
	/**
	 * Pv máximos del personaje
	 */
	protected double pvMaximo;
	/**
	 * Puntos de vida del personaje
	 */
	protected double pv;
	/**
	 * Ataque físico del personaje
	 */
	protected int ataque;
	/**
	 * Ataque mágico del perdonaje
	 */
	protected int magia;
	/**
	 * Defensa física del personaje
	 */
	protected int defensa;
	/**
	 * Resistencia mágica del personaje
	 */
	protected int resistencia;

	/**
	 * Arma del personaje
	 */
	protected Arma arma;

	/**
	 * El personaje daña a su enemigo y ese ataque puede ser crítico, ejerciendo el
	 * triple de daño
	 * 
	 * @param rival enemigo del personaje que realiza el ataque
	 */
	public void atacar(Personaje rival) {
		if (this.arma.getTipo().equals("fisico")) {
			int critico = (int) (Math.random() * 5);
			if (critico == 1) {
				gritarCritico();
				rival.setPv(rival.pv - (3 * (this.getAtaque() - rival.getDefensa())));
			} else {
				gritar();
				rival.setPv(rival.pv - (this.getAtaque() - rival.getDefensa()));
			}
		} else {
			int critico = (int) (Math.random() * 5);
			if (critico == 1) {
				gritarCritico();
				rival.setPv(rival.pv - (3 * (this.getMagia() - rival.getResistencia())));
			} else {
				gritar();
				rival.setPv(rival.pv - (this.getMagia() - rival.getResistencia()));
			}
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
	 * Grito de guerra del personaje cuando realiza un ataque crítico
	 */
	public abstract void gritarCritico();

	/**
	 * Si el arma es de un tipo que el personaje pueda usar, se suma al ataque de
	 * dicho personaje el daño del arma. Después se inicializa el atributo arma
	 * independientemente de si el personaje puede usarla o no
	 * 
	 * @param arma arma que se equipará el personaje
	 * @see Personaje#setArma(Arma)
	 */
	public void equiparArma(Arma arma) {
		if (arma.getTipo().equals("magico"))
			this.magia += arma.getDano();
		else
			this.ataque += arma.getDano();
		this.setArma(arma);
	}

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

	public int getMagia() {
		return this.magia;
	}

	public double getPvMaximo() {
		return this.pvMaximo;
	}

	public void setPv(double pv) {
		this.pv = pv;
	}

	protected void setArma(Arma arma) {
		this.arma = arma;
	}

	public void setAtaque(int ataque) {
		this.ataque = ataque;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
}
