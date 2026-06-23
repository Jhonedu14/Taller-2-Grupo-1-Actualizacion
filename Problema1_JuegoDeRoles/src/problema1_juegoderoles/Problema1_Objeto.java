/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package problema1_juegoderoles;

/**
 *
 * @author LOQ
 */
public abstract class Problema1_Objeto {
    protected String nombre;

    public Problema1_Objeto(String nombre) {
        this.nombre = nombre;
    }
    public abstract int getModificador();
}
