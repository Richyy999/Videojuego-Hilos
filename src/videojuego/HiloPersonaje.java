package videojuego;

public class HiloPersonaje implements Runnable {

	private Fortaleza fort;

	private Personaje atacante;

	public HiloPersonaje(Fortaleza fort, Personaje atacante) {
		this.fort = fort;
		this.atacante = atacante;
	}

	@Override
	public void run() {
		fort.entrar(atacante);
	}
}
