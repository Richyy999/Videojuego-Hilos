package videojuego;

public class Fortaleza {

	private Personaje boss;

	public Fortaleza() {
		this.boss = new BossFinal("Acnologia");
	}

	public synchronized void entrar(Personaje atacante) {
		MainVideojuego.atacar(atacante, boss);
	}
} 