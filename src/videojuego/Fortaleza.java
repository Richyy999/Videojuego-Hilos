package videojuego;

public class Fortaleza {

	private BossFinal boss;

	public Fortaleza() {
		this.boss = new BossFinal("Acnologia");
	}

	public synchronized void entrar(Personaje atacante) {
		MainVideojuego.atacar(atacante, boss);
	}
} 