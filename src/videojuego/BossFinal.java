package videojuego;

/**
 * 
 * @author Ricardo Bordería Pi
 *
 */
public class BossFinal extends Personaje {

	public BossFinal(String nombre) {
		this.nombre = nombre;
		this.pv = 80;
		this.ataque = 50;
		this.magia = 35;
		this.defensa = 40;
		this.resistencia = 35;
	}

	@Override
	public void habEspecial(Personaje rival) {
		System.out.println(this.nombre + " usó su habilidad especial");
		if (this.arma.getTipo().equals("fisico")) {
			if (rival.getDefensa() < rival.getResistencia()) {
				rival.setPv(rival.getPv() - (this.ataque - rival.getDefensa()));
			} else
				rival.setPv(rival.getPv() - (this.ataque - rival.getResistencia()));
		} else {
			if (rival.getDefensa() < rival.getResistencia()) {
				rival.setPv(rival.getPv() - (this.magia - rival.getDefensa()));
			} else
				rival.setPv(rival.getPv() - (this.magia - rival.getResistencia()));
		}
	}

	@Override
	public void gritar() {
		System.out.println(this.nombre + ": oraoraoraoraoraoraoraoraora");
	}

	@Override
	public void gritarCritico() {
		System.out.println(this.nombre + ": Star Finger");
	}
}
