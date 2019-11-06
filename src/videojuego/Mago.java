package videojuego;

/**
 * 
 * @author Ricardo Bordería Pi
 *
 */
public class Mago extends Personaje {

	public Mago(String nombre) {
		this.nombre = nombre;
		this.ataque = 30;
		this.magia = 40;
		this.defensa = 23;
		this.resistencia = 35;
		this.pv = 40;
	}

	@Override
	public void atacar(Personaje rival) {
		if (this.arma.getTipo().equals("fisico")) {
			int critico = (int) (Math.random() * 4);
			if (critico == 1) {
				gritarCritico();
				rival.setPv(rival.pv - (3 * (this.getAtaque() - rival.getDefensa())));
			} else {
				gritar();
				rival.setPv(rival.pv - (this.getAtaque() - rival.getDefensa()));
			}
		} else {
			int critico = (int) (Math.random() * 5);
			if (critico == 1) {
				gritarCritico();
				rival.setPv(rival.pv - (3 * (this.getMagia() - rival.getResistencia())));
			} else {
				gritar();
				rival.setPv(rival.pv - (this.getMagia() - rival.getResistencia()));
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
}
