package videojuego;

/**
 * Genera personajes y armas
 * 
 * @author Ricardo Bordería Pi
 *
 */
public class Generar {
	/**
	 * Genera un personaje del tipo y con el nombre indicado
	 * 
	 * @param personaje tipo de personaje
	 * @param nombre    nombre del personaje
	 * @return personaje generado
	 */
	public static Personaje generarPersonaje(String personaje, String nombre) {
		if ("guerrero".startsWith(personaje.toLowerCase()))
			return new Guerrero(nombre);
		else if ("mago".startsWith(personaje.toLowerCase()))
			return new Mago(nombre);
		else if ("berserker".startsWith(personaje.toLowerCase()))
			return new Berserker(nombre);
		else
			return null;
	}

	/**
	 * genera un personaje random
	 * 
	 * @return personaje generado
	 */
	public static Personaje generarPersonajeRandom() {
		int random = (int) (Math.random() * 3);
		switch (random) {
		case 0:
			return new Guerrero("Zelgius");
		case 1:
			return new Berserker("Dio");
		case 2:
			return new Mago("Lewyn");
		default:
			return null;
		}
	}

	/**
	 * Genera un arma del tipo indicado
	 * 
	 * @param arma tipo de arma
	 * @return arma generada
	 */
	public static Arma generarArma(String arma) {
		if ("espada".startsWith(arma.toLowerCase()))
			return new Espada();
		else if ("arco".startsWith(arma.toLowerCase()))
			return new Arco();
		else if ("varita".startsWith(arma.toLowerCase()) || "grimorio".startsWith(arma.toLowerCase()))
			return new Varita();
		else
			return null;
	}

	/**
	 * genera un arma random
	 * 
	 * @return arma generada
	 */
	public static Arma generarArmaRandom() {
		int random = (int) (Math.random() * 3);
		switch (random) {
		case 0:
			return new Espada();
		case 1:
			return new Arco();
		case 2:
			return new Varita();
		default:
			return null;
		}
	}
}
