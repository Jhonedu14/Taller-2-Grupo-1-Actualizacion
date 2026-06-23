package problema1_juegoderoles;
import java.util.ArrayList;
import java.util.List;

public abstract class Problema1_Personaje {
    protected String nombre;
    protected int vida;
    protected int experiencia;
    
    protected Problema1_Arma arma;
    protected Problema1_Armadura armadura;
    
    protected List<Problema1_IEstadoAlterado> estados;
    
    protected int energia;
    protected int cooldown;

    public Problema1_Personaje(String nombre) {
        this.nombre = nombre;
        this.vida = 100;
        this.experiencia = 0;
        this.estados = new ArrayList<>();
        this.energia = 50;
        this.cooldown = 0;
    }

    public void equiparArma(Problema1_Arma arma) { this.arma = arma; }
    public void equiparArmadura(Problema1_Armadura armadura) { this.armadura = armadura; }

    public void agregarEstado(Problema1_IEstadoAlterado estado) { estados.add(estado); }
    public void procesarEstados() {
        estados.removeIf(Problema1_IEstadoAlterado::haTerminado);
        for(Problema1_IEstadoAlterado e : estados) { e.aplicarEfecto(this); }
    }
    public void recibirDanoDirecto(int dano) { this.vida -= dano; }

    public abstract void usarHabilidadEspecial(Problema1_Personaje enemigo);
    public void procesarTurno() { 
        if(cooldown > 0) cooldown--; 
        energia += 10;
    }

    public abstract void atacar(Problema1_Personaje enemigo);
    public abstract void defender(int dano);
    
    public void subirNivel() {
        experiencia += 15;
        if (experiencia >= 50) {
            vida += 20;
            experiencia = 0;
            System.out.println(nombre + " ha subido de nivel! Vida aumentada a " + vida);
        }
    }
    public boolean estaVivo(){ return vida > 0; }
    public String getNombre() { return nombre; }
    public int getVida() { return vida; }
}