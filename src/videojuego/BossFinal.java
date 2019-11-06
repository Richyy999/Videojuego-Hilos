package videojuego;

public class BossFinal extends Personaje {

	public BossFinal(String nombre) {
		this.nombre = nombre;
		this.pv = 80;
		this.ataque = 50;
		this.defensa = 40;
		this.resistencia = 35;
	}

	@Override
	public void habEspecial(Personaje rival) {
		System.out.println(this.nombre + " usó su habilidad especial");
		boolean defensa = rival.getDefensa() < rival.getResistencia();
		if (defensa) {
			rival.setPv(rival.getPv() - (this.ataque - rival.getDefensa()));
		} else
			rival.setPv(rival.getPv() - (this.ataque - rival.getResistencia()));
	}

	@Override
	public void gritar() {
		System.out.println(this.nombre + ": mudamudamudamudamudamuda");
	}

	@Override
	public void gritarCritico() {
		System.out.println(this.nombre + ": The World");
	}

	@Override
	public void equiparArma(Arma arma) {
		this.ataque += arma.getDano();
		setArma(arma);
	}
}
