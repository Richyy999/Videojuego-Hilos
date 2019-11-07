package videojuego;

public class Supervivencia {

	private Personaje aliado;

	private static int numBosses = 0;

	public Supervivencia(Personaje aliado) {
		this.aliado = aliado;
	}

	public synchronized void sobrevivir(Personaje boss) {
		if (aliado.getPv() > 0) {
			MainVideojuego.atacar(aliado, boss);
			if (aliado.getPv() > 0) {
				numBosses++;
				aliado.setPv(aliado.getPvMaximo());
			}
		}
	}

	public static int getNumBosses() {
		return numBosses;
	}
}
