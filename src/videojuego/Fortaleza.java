package videojuego;

/**
 * 
 * @author Ricardo Bordería Pi
 *
 */
public class Fortaleza {
	/**
	 * Boss de la fortaleza
	 */
	private BossFinal boss;

	private int bajas;

	public Fortaleza() {
		this.boss = new BossFinal("Acnologia");
		boss.equiparArma(Generar.generarArmaRandom());
		this.bajas = 0;
	}

	/**
	 * Los atacantes entran uno por uno en la fortaleza
	 * 
	 * @param atacante aliado que luchará contra el boss
	 */
	public synchronized void entrar(Personaje atacante) {
		if (atacante.getPv() > 0) {
			MainVideojuego.atacar(atacante, boss);
			if (atacante.getPv() > 0) {
				bajas++;
				atacante.setPv(atacante.getPvMaximo());
			}
		}
	}

	public int getBajas() {
		return this.bajas;
	}
}