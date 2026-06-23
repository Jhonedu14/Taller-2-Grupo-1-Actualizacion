package problema1_juegoderoles;

import java.util.ArrayList;
import java.util.Scanner;
// CORRECCIONES
public class Problema1_JuegodeRoles {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Problema1_Personaje> personajes = new ArrayList<>();

        System.out.println("=== JUEGO DE ROLES ===");

        int cantidad = 0;
        while (cantidad < 2) {
            System.out.print("¿Cuántos personajes deseas crear?: ");
            if (sc.hasNextInt()) {
                cantidad = sc.nextInt();
                sc.nextLine();
                if (cantidad < 2) {
                    System.out.println("Debes crear al menos 2 personajes para iniciar el juego.");
                }
            } else {
                System.out.println("Ingresa un número válido.");
                sc.nextLine();
            }
        }

        for (int i = 0; i < cantidad; i++) {
            System.out.println("\nCreando personaje #" + (i + 1));
            System.out.print("Nombre del personaje: ");
            String nombre = sc.nextLine();

            int tipo = 0;
            while (tipo < 1 || tipo > 3) {
                System.out.print("Selecciona tipo (1: Guerrero, 2: Mago, 3: Arquero): ");
                tipo = sc.nextInt();
                sc.nextLine();
            }

            switch (tipo) {
                case 1:
                    personajes.add(new Problema1_Guerrero(nombre));
                    break;
                case 2:
                    personajes.add(new Problema1_Mago(nombre));
                    break;
                case 3:
                    personajes.add(new Problema1_Arquero(nombre));
                    break;
            }

            System.out.println("Personaje " + nombre + " creado exitosamente.");
        }

        System.out.println("\nLista de personajes disponibles:");
        for (int i = 0; i < personajes.size(); i++) {
            System.out.println((i + 1) + ". " + personajes.get(i).getNombre());
        }

        int p1 = 0, p2 = 0;
        while (p1 < 1 || p1 > personajes.size()) {
            System.out.print("\nElige el número del primer personaje para pelear: ");
            p1 = sc.nextInt();
        }

        while (p2 < 1 || p2 > personajes.size() || p2 == p1) {
            System.out.print("Elige el número del segundo personaje para pelear (distinto del primero): ");
            p2 = sc.nextInt();
        }

        Problema1_Personaje jugador1 = personajes.get(p1 - 1);
        Problema1_Personaje jugador2 = personajes.get(p2 - 1);
        
        jugador1.equiparArma(new Problema1_Arma("Espada Larga", 15));
        jugador2.equiparArmadura(new Problema1_Armadura("Cota de Malla", 10));

        System.out.println("\n¡La pelea comienza entre " + jugador1.getNombre() + " y " + jugador2.getNombre() + "!\n");

        int ronda = 1;
        while (jugador1.estaVivo() && jugador2.estaVivo()) {
            System.out.println("--------------------");
            System.out.println("Ronda " + ronda);
            
            if (ronda % 2 == 1) {
                if (ronda == 3) {
                    jugador1.usarHabilidadEspecial(jugador2);
                } else {
                    jugador1.atacar(jugador2);
                }
            } else {
                jugador2.atacar(jugador1);
                if (ronda == 2) {
                    jugador1.agregarEstado(new Problema1_EstadoEnvenenado());
                }
            }
            
            ronda++;
            System.out.println("Vida de " + jugador1.getNombre() + ": " + jugador1.getVida());
            System.out.println("Vida de " + jugador2.getNombre() + ": " + jugador2.getVida() + "\n");

            try {
                Thread.sleep(1000); 
            } catch (InterruptedException e) {
               Thread.currentThread().interrupt();
            }
        }

        System.out.println("¡La batalla ha terminado!");
        if (jugador1.estaVivo()) {
            System.out.println("Ganador: " + jugador1.getNombre());
        } else {
            System.out.println("Ganador: " + jugador2.getNombre());
        }
        sc.close();

        //PRUEBA
    }
}
