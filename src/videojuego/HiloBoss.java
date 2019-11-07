package videojuego;

public class HiloBoss implements Runnable {

	private BossFinal boss;

	private Supervivencia su;

	public HiloBoss(BossFinal boss, Supervivencia su) {
		this.boss = boss;
		this.su = su;
	}

	@Override
	public void run() {
		su.sobrevivir(boss);
	}
}
