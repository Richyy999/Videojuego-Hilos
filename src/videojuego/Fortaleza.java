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
		MainVideojuego.atacar(atacante, boss);
	}
}