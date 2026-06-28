/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.graficascomparativas;

/**
 *
 * @author User_001
 */
public class TuplaNumerica {
    private int entero;
    private float decimal;

    public TuplaNumerica(int entero, float decimal) {
        this.entero = entero;
        this.decimal = decimal;
    }

    // Getters para acceder a los datos
    public int getEntero() { return entero; }
    public float getDecimal() { return decimal; }
    
    @Override
    public String toString() {
        return "(" + entero + ", " + decimal + "f)";
    }
}
