package videojuego;

public class Supervivencia {

	private Personaje aliado;

	private int numBosses;

	public Supervivencia(Personaje aliado) {
		this.numBosses = 0;
		this.aliado = aliado;
	}

	public synchronized void sobrevivir(Personaje boss) {
		if (aliado.getPv() > 0) {
			MainVideojuego.atacar(aliado, boss);
			if (aliado.getPv() > 0) {
				numBosses++;
				System.out.println("PV: " + aliado.getPv());
				aliado.setPv(aliado.getPvMaximo());
			}
		}
	}

	public int getNumBosses() {
		return numBosses;
	}
}
