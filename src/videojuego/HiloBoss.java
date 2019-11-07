package videojuego;

public class HiloBoss implements Runnable {

	private Personaje boss;

	private Supervivencia su;

	public HiloBoss(Personaje boss, Supervivencia su) {
		this.boss = boss;
		this.su = su;
	}

	@Override
	public void run() {
		su.sobrevivir(boss);
	}
}
