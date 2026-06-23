/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package problema1_juegoderoles;

/**
 *
 * @author LOQ
 */
   public class Problema1_Arma extends Problema1_Objeto {

    private int ataqueExtra;

    public Problema1_Arma(String nombre, int ataqueExtra) {
        super(nombre);
        this.ataqueExtra = ataqueExtra;
    }

    @Override
    public int getModificador() {
        return ataqueExtra;
    }
}

