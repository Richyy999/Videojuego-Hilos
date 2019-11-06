package videojuego;

import java.util.Scanner;

public class MainVideojuego {

	private static Scanner sc;

	public static void main(String[] args) {
		sc = new Scanner(System.in);
		String eleccion = "";
		do {
			System.out.println("1.- Modo random\n2.- Modo normal\n3.- Coliseo\n4.- Salir");
			eleccion = sc.nextLine();
			switch (eleccion) {
			case "1":
				ramdon();
				break;
			case "2":
				personalizado();
				break;
			case "3":
				coliseo();
				break;
			case "4":
				System.out.println("Adiós");
				break;
			default:
				System.out.println("Opción Inválida");
				break;
			}
		} while (!eleccion.equals("3"));
	}

	private static void coliseo() {
		Fortaleza fort = new Fortaleza();

//		Personaje atacante1 = Generar.generarPersonajeRandom();
//		Arma arma1 = Generar.generarArmaRandom();
//		atacante1.setNombre(atacante1.getNombre() + " 1");
//		atacante1.equiparArma(arma1);
//		Personaje atacante2 = Generar.generarPersonajeRandom();
//		Arma arma2 = Generar.generarArmaRandom();
//		atacante2.equiparArma(arma2);
//		atacante2.setNombre(atacante2.getNombre() + " 2");
//		Personaje atacante3 = Generar.generarPersonajeRandom();
//		Arma arma3 = Generar.generarArmaRandom();
//		atacante3.equiparArma(arma3);
//		atacante3.setNombre(atacante3.getNombre() + " 3");
//		Personaje atacante4 = Generar.generarPersonajeRandom();
//		Arma arma4 = Generar.generarArmaRandom();
//		atacante4.equiparArma(arma4);
//		atacante4.setNombre(atacante4.getNombre() + " 4");
//
//		HiloPersonaje hilo1 = new HiloPersonaje(fort, atacante1);
//		HiloPersonaje hilo2 = new HiloPersonaje(fort, atacante2);
//		HiloPersonaje hilo3 = new HiloPersonaje(fort, atacante3);
//		HiloPersonaje hilo4 = new HiloPersonaje(fort, atacante4);
//
//		Thread t1 = new Thread(hilo1);
//		Thread t2 = new Thread(hilo2);
//		Thread t3 = new Thread(hilo3);
//		Thread t4 = new Thread(hilo4);
//
//		t1.start();
//		t2.start();
//		t3.start();
//		t4.start();

		int rdm = (int) (Math.random() * 19) + 1;

		for (int i = 1; i <= rdm; i++) {
			Personaje atacante1 = Generar.generarPersonajeRandom();
			Arma arma1 = Generar.generarArmaRandom();
			atacante1.equiparArma(arma1);

			HiloPersonaje h1 = new HiloPersonaje(fort, atacante1);

			Thread t1 = new Thread(h1);

			t1.start();
		}
	}

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
