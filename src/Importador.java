/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


/**
 *
 * @author User_001
 */

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Importador {
    
    public static TuplaNumerica[] importarDatos(String rutaArchivo, int size) { //Conociendo el tamaño max
        TuplaNumerica[] tupla_lista = new TuplaNumerica[size];
        int posicion = 0;
        // Usamos try-with-resources para asegurar que el archivo se cierre automáticamente
        try (BufferedReader br = new BufferedReader(new FileReader(rutaArchivo))) {
            String linea;
            
            while ((linea = br.readLine()) != null) {
                String[] valores = linea.trim().split(",");
                
                if (valores.length >= 2) {
                    try {
                        int valorEntero = Integer.parseInt(valores[0].trim());
                        float valorDecimal = Float.parseFloat(valores[1].trim());
                        
                        tupla_lista[posicion++] = new TuplaNumerica(valorEntero, valorDecimal);
                        
                    } catch (NumberFormatException e) {
                        System.err.println("Advertencia: Dato no numérico saltado en la línea -> " + linea);
                    }
                }
            }
        } catch (IOException e) {
            System.err.println("Error al intentar leer el archivo: " + e.getMessage());
        }
        
        return tupla_lista;
    }
    
    public static TuplaNumerica[] importarDatos(String rutaArchivo) { //Sin conocer el tamaño max
        int size = 0;
        // Usamos try-with-resources para asegurar que el archivo se cierre automáticamente
        try (BufferedReader br = new BufferedReader(new FileReader(rutaArchivo))) {
            while (br.readLine() != null) {
                size++;
            }
        } catch (IOException e) {
            System.err.println("Error al intentar leer el archivo: " + e.getMessage());
        }
            
        TuplaNumerica[] tupla_lista = new TuplaNumerica[size];
        int posicion = 0;
        
        try (BufferedReader br = new BufferedReader(new FileReader(rutaArchivo))) {
            String linea;
            
            while ((linea = br.readLine()) != null) {
                String[] valores = linea.trim().split(",");
                
                if (valores.length >= 2) {
                    try {
                        int valorEntero = Integer.parseInt(valores[0].trim());
                        float valorDecimal = Float.parseFloat(valores[1].trim());
                        
                        tupla_lista[posicion++] = new TuplaNumerica(valorEntero, valorDecimal);
                        
                    } catch (NumberFormatException e) {
                        System.err.println("Advertencia: Dato no numérico saltado en la línea -> " + linea);
                    }
                }
            }
        } catch (IOException e) {
            System.err.println("Error al intentar leer el archivo: " + e.getMessage());
        }
        
        return tupla_lista;
    }
    
}
