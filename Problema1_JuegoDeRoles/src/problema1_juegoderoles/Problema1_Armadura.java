/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package problema1_juegoderoles;

public class Problema1_Armadura extends Problema1_Objeto {

    private int defensaExtra;

    public Problema1_Armadura(String nombre, int defensaExtra) {
        super(nombre);
        this.defensaExtra = defensaExtra;
    }

    @Override
    public int getModificador() {
        return defensaExtra;
    }
}
