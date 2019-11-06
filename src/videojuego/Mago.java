package videojuego;

public class Mago extends Personaje {

	public Mago(String nombre) {
		this.nombre = nombre;
		this.ataque = 40;
		this.defensa = 23;
		this.resistencia = 35;
		this.pv = 40;
	}

	public void atacar(Personaje rival) {
		int critico = (int) (Math.random() * 4);
		if (this.arma instanceof Varita) {
			if (critico == 1) {
				gritarCritico();
				rival.setPv(rival.pv - (3 * (this.getAtaque() - rival.getResistencia())));
			} else {
				gritar();
				rival.setPv(rival.pv - (this.getAtaque() - rival.getResistencia()));
			}
		} else {
			if (critico == 1) {
				gritarCritico();
				rival.setPv(rival.pv - (3 * (this.getAtaque() - rival.getDefensa())));
			} else {
				gritar();
				rival.setPv(rival.pv - (this.getAtaque() - rival.getDefensa()));
			}
		}
	}

	@Override
	public void habEspecial(Personaje rival) {
		System.out.println(this.nombre + " usó su habilidad especial");
		this.setPv(40f);
	}

	@Override
	public void gritar() {
		System.out.println(this.nombre + ": SHaaaahh");
	}

	@Override
	public void gritarCritico() {
		System.out.println(this.nombre + ": Forseti's range");
	}

	@Override
	public void equiparArma(Arma arma) {
		if (arma.getTipo().equals("magico"))
			this.ataque += arma.getDano();
		setArma(arma);
	}
}
