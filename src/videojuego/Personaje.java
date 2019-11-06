package videojuego;

public abstract class Personaje {

	protected String nombre;
	protected double pv;
	protected double ataque;
	protected int defensa;
	protected int resistencia;

	protected Arma arma;

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

	public abstract void habEspecial(Personaje rival);

	public abstract void gritar();

	public abstract void gritarCritico();

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
