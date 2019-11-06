package videojuego;
/**
 * 
 * @author Ricardo Bordería Pi
 *
 */
public class Guerrero extends Personaje {

	public Guerrero(String nombre) {
		this.nombre = nombre;
		this.ataque = 42;
		this.magia = 20;
		this.defensa = 30;
		this.resistencia = 22;
		this.pv = 42;
	}

	@Override
	public void habEspecial(Personaje rival) {
		System.out.println(this.nombre + " usó su habilidad especial");
		rival.setPv(rival.getPv() - 2 * (this.getAtaque() - rival.getDefensa()));
	}

	@Override
	public void gritar() {
		System.out.println(this.nombre + ": HYyyaaaa");
	}

	@Override
	public void gritarCritico() {
		System.out.println(this.nombre + ": Know your place");
	}
}
