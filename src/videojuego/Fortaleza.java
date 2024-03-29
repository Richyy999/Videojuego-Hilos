package videojuego;

/**
 * 
 * @author Ricardo Border�a Pi
 *
 */
public class Fortaleza {
	/**
	 * Boss de la fortaleza
	 */
	private BossFinal boss;

	private int bajas;

	public Fortaleza() {
		this.boss = new BossFinal("Jotaro");
		boss.equiparArma(Generar.generarArmaRandom());
		this.bajas = 0;
	}

	/**
	 * Los atacantes entran uno por uno en la fortaleza
	 * 
	 * @param atacante aliado que luchar� contra el boss
	 */
	public synchronized void entrar(Personaje atacante) {
		if (boss.getPv() > 0) {
			MainVideojuego.atacar(atacante, boss);
			if (atacante.getPv()<= 0)
				bajas++;
		}
	}

	public int getBajas() {
		return this.bajas;
	}
}