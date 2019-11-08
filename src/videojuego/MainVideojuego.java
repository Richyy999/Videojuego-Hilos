package videojuego;

import java.util.Scanner;

/**
 * 
 * @author Ricardo Bordería Pi
 *
 */
public class MainVideojuego {

	private static Scanner sc;

	public static void main(String[] args) {
		sc = new Scanner(System.in);
		String eleccion = "";
		do {
			System.out.println(
					"1.- Modo random\n2.- Modo normal\n3.- Asalto a la Fortaleza de Acnologia\n4.- Supervivencia\n5.- Salir");
			eleccion = sc.nextLine();
			switch (eleccion) {
			case "1":
				ramdon();
				break;
			case "2":
				personalizado();
				break;
			case "3":
				fortaleza();
				// Para mostrar el menú después de todas las batallas
				try {
					Thread.sleep(1100);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				break;
			case "4":
				supervivencia();
				// Para mostrar el menú después de todas las batallas
				try {
					Thread.sleep(1100);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				break;
			case "5":
				System.out.println("Adiós");
				break;
			default:
				System.out.println("Opción Inválida");
				break;
			}
		} while (!eleccion.equals("5"));
	}

	/**
	 * se generan aleatoriamente de 1 a 10 bosses y se enfrentan a tu luchador por
	 * turnos
	 */
	private static void supervivencia() {
		System.out.println("Elige un personaje");
		String personaje = sc.nextLine();
		System.out.println("Dale nombre a tu personaje");
		String nombre = sc.nextLine();
		Personaje aliado = Generar.generarPersonaje(personaje, nombre);

		System.out.println("Elige un arma");
		String arma = sc.nextLine();
		Arma armaAliado = Generar.generarArma(arma);
		aliado.equiparArma(armaAliado);

		Supervivencia sup = new Supervivencia(aliado);

		int rdm = (int) (Math.random() * 3) + 1;
		for (int i = 0; i < rdm; i++) {
			Personaje boss = Generar.generarBossFinal();
			Arma armaBoss = Generar.generarArmaRandom();
			boss.equiparArma(armaBoss);

			HiloBoss hb = new HiloBoss(boss, sup);

			Thread tb = new Thread(hb);

			tb.start();
		}
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("Has derrotado a " + sup.getNumBosses() + " de " + rdm + " bosses");
	}

	/**
	 * se generan aleatoriamente de 1 a 20 aliados y se enfrentan a un boss en la
	 * fortaleza por turnos
	 * 
	 * @see Fortaleza#entrar(Personaje)
	 */
	private static void fortaleza() {
		Fortaleza fort = new Fortaleza();
		int rdm = (int) (Math.random() * 19) + 1;

		for (int i = 1; i <= rdm; i++) {
			// Creo de manera random a los aliados y sus armas
			Personaje atacante1 = Generar.generarPersonajeRandom();
			Arma arma1 = Generar.generarArmaRandom();
			atacante1.equiparArma(arma1);

			// Creo un hilo personaje con el aliado generado y la fortaleza
			HiloPersonaje h1 = new HiloPersonaje(fort, atacante1);

			// Creo un hilo
			Thread t1 = new Thread(h1);

			// Activo el hilo y los personajes atacan uno por uno
			t1.start();
		}
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("Han habido " + fort.getBajas() + " bajas");
	}

	/**
	 * genera un aliado y un enemigo random con un arma random para cada uno
	 * 
	 * @see MainVideojuego#atacar(Personaje, Personaje)
	 */
	private static void ramdon() {
		Personaje aliado = Generar.generarPersonajeRandom();
		Arma armaAliado = Generar.generarArmaRandom();
		aliado.equiparArma(armaAliado);
		Personaje rival = Generar.generarPersonajeRandom();
		Arma armaRival = Generar.generarArmaRandom();
		rival.equiparArma(armaRival);
		if (rival.getNombre().equalsIgnoreCase(aliado.getNombre()))
			rival.setNombre("El " + rival.getNombre() + " enemigo");
		atacar(aliado, rival);
	}

	/**
	 * El usuario crea al aliado y al enemigo eligiendo sus armas y se enfrentan
	 * 
	 * @see Generar#generarPersonaje(String, String)
	 * @see Generar#generarArma(String)
	 * @see MainVideojuego#atacar(Personaje, Personaje)
	 */
	private static void personalizado() {
		System.out.println("Elige un personaje");
		String personaje = sc.nextLine();
		System.out.println("Dale nombre a tu personaje");
		String nombre = sc.nextLine();
		Personaje aliado = Generar.generarPersonaje(personaje, nombre);

		System.out.println("Elige un arma");
		String arma = sc.nextLine();
		Arma armaAliado = Generar.generarArma(arma);
		aliado.equiparArma(armaAliado);

		System.out.println("Elige un rival");
		personaje = sc.nextLine();
		System.out.println("Dale nombre a tu rival");
		nombre = sc.nextLine();
		Personaje rival = Generar.generarPersonaje(personaje, nombre);

		System.out.println("Elige un arma");
		arma = sc.nextLine();
		Arma armaRival = Generar.generarArma(arma);
		rival.equiparArma(armaRival);

		atacar(aliado, rival);
	}

	/**
	 * El aliado y el enemigo se enfrentan por turnos, empezando el aliado, hasta
	 * que uno de los dos se quede sin pv. Pueden atacar o utilizar su habilidad
	 * especial.
	 * 
	 * @param aliado tu unidad
	 * @param rival  tu enemigo
	 */
	public static void atacar(Personaje aliado, Personaje rival) {
		int turno = 0;
		while (aliado.getPv() > 0 && rival.getPv() > 0) {
			int habilidad = (int) (Math.random() * 6);
			if (habilidad == 1) {
				if (turno % 2 == 0)
					aliado.habEspecial(rival);
				else
					rival.habEspecial(aliado);
			} else {
				if (turno % 2 == 0)
					aliado.atacar(rival);
				else
					rival.atacar(aliado);
			}
			turno++;
		}
		if (aliado.getPv() > 0) {
			System.out.println("Ha ganado " + aliado.getNombre());
		} else if (aliado.getPv() <= 0 && rival.getPv() <= 0) {
			System.out.println("EMPATE");
		} else {
			System.out.println("Has sido derrotado por " + rival.getNombre());
		}
		System.out.println("\nResultado:\n" + aliado.getNombre() + " con " + aliado.getPv() + "PV\n" + rival.getNombre()
				+ " con " + rival.getPv() + "PV\n");
	}
}
