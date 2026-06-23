package problema1_juegoderoles;
public class Problema1_Guerrero extends Problema1_Personaje {
    public Problema1_Guerrero(String nombre) { super(nombre); }
    
    @Override
    public void atacar(Problema1_Personaje enemigo) {
        procesarEstados();
        int dano = 30 + (arma != null ? arma.getBonoDano() : 0);
        System.out.println("+️ " + nombre + " ataca con su espada a " + enemigo.getNombre());
        enemigo.defender(dano);
        subirNivel();
        procesarTurno();
    }

    @Override
    public void defender(int dano) {
        int defensa = 10 + (armadura != null ? armadura.getBonoDefensa() : 0);
        int danoReducido = dano - defensa;
        if (danoReducido < 0) danoReducido = 0;
        vida -= danoReducido;
        System.out.println("- " + nombre + " bloquea. Recibe " + danoReducido + " de daño. Vida: " + vida);
    }

    @Override
    public void usarHabilidadEspecial(Problema1_Personaje enemigo) {
        if (energia >= 20 && cooldown == 0) {
            energia -= 20;
            cooldown = 3;
            System.out.println("!!! " + nombre + " usa GOLPE DEMOLEDOR !!!");
            enemigo.defender(50);
        } else {
            System.out.println("X " + nombre + " no tiene energía o la habilidad está en cooldown.");
        }
    }
}