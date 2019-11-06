package videojuego;

public class Berserker extends Personaje {

	public Berserker(String nombre) {
		this.nombre = nombre;
		this.ataque = 44;
		this.defensa = 35;
		this.resistencia = 15;
		this.pv = 45;
	}

	@Override
	public void habEspecial(Personaje rival) {
		System.out.println(this.nombre + " usó su habilidad especial");
		rival.setPv(rival.getPv() - 30);
		this.setPv(this.getPv() - 20);
	}

	@Override
	public void gritar() {
		System.out.println(this.nombre + ": WRYYYYY");
	}

	@Override
	public void gritarCritico() {
		System.out.println(this.nombre + ": Road roller da mudamudamudamudamudamuda");
	}

	@Override
	public void equiparArma(Arma arma) {
		if (arma.getTipo().equals("fisico"))
			this.ataque += arma.getDano();
		setArma(arma);
	}
}
