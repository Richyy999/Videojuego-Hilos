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

	private static int bajas = 0;

	public Fortaleza() {
		this.boss = new BossFinal("Acnologia");
		boss.equiparArma(Generar.generarArmaRandom());
	}

	/**
	 * Los atacantes entran uno por uno en la fortaleza
	 * 
	 * @param atacante aliado que luchará contra el boss
	 */
	public synchronized void entrar(Personaje atacante) {
		if (boss.getPv() > 0) {
			MainVideojuego.atacar(atacante, boss);
		}
	}
}