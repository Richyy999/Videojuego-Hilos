package videojuego;

public class Supervivencia {

	private Personaje aliado;

	public Supervivencia(Personaje aliado) {
		this.aliado = aliado;
	}

	public synchronized void sobrevivir(BossFinal boss) {
		int turno = 0;
		while (aliado.getPv() > 0 && boss.getPv() > 0) {
			int habilidad = (int) (Math.random() * 6);
			if (habilidad == 1) {
				if (turno % 2 == 0)
					aliado.habEspecial(boss);
				else
					boss.habEspecial(aliado);
			} else {
				if (turno % 2 == 0)
					aliado.atacar(boss);
				else
					boss.atacar(aliado);
			}
			turno++;
		}
		if (aliado.getPv() > 0) {
			System.out.println("Ha ganado " + aliado.getNombre());
		} else if (aliado.getPv() <= 0 && boss.getPv() <= 0) {
			System.out.println("EMPATE");
		} else {
			System.out.println("Has sido derrotado por " + boss.getNombre());
		}
		System.out.println("\nResultado:\n" + aliado.getNombre() + " con " + aliado.getPv() + "PV\n" + boss.getNombre()
				+ " con " + boss.getPv() + "PV\n");
		if (aliado.getPv() > 0)
			aliado.setPv(aliado.getPvMaximo());
	}
}
