package problema1_juegoderoles;

public interface Problema1_IEstadoAlterado {
    void aplicarEfecto(Problema1_Personaje p);
    boolean haTerminado();
}
