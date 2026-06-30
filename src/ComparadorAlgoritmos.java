/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


/**
 *
 * @author User_001
 */

import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.IOException;
import java.util.Random;

public class ComparadorAlgoritmos {

    public ComparadorAlgoritmos(){}
    
    public void haciaCSV(String nombreArchivo, TuplaNumerica[] tupla_lista, int numero) {
        
        Random random = new Random();

        if (!nombreArchivo.endsWith(".csv")) {
            nombreArchivo += ".csv"; 
        }
        
        try (PrintWriter writer = new PrintWriter(new FileWriter(nombreArchivo))) {
            
            writer.println("N,QuickSelect,MergeSort");
            
            long quickselectComparisons;
            //long mergesortComparisons;
        
            double Q_quick, M_merge;
        
            for (int i = 0; i <= numero; i++) {
                Q_quick = 0;
                //M_merge = 0;
            
                quickselectComparisons = 0;
                //mergesortComparisons = 0;
                for (int j = 0; j < Math.min(i, 100) ; j++) {
                    TuplaNumerica[] nums = generate_list(tupla_lista, i);
                
                    TuplaNumerica[] numsParaQuick = nums.clone();
                    //TuplaNumerica[] numsParaMerge = nums.clone();
                
                    // --- QUICKSELECT ---
                    QuickSelect qckselect = new QuickSelect(numsParaQuick);
                    //Simulamos casos X de puestos aleatorios
                    qckselect.USEQuickSelect( random.nextInt(1, Math.max(1,i)) ); //Evitamos el error de bound menor a 1 por i=0
                    quickselectComparisons += qckselect.get_num_of_comparisons(); 
                
                    // --- MERGESORT ---
                    //MergeSort mersort = new MergeSort(numsParaMerge);
                    //mersort.USEMergeSort();
                    //mergesortComparisons += mersort.get_num_of_comparisons();
                }
                Q_quick = (double) quickselectComparisons / Math.min(i, 100);
                //M_merge = (double) mergesortComparisons / Math.min(i, 100);
            
                writer.println(i + "," + Q_quick + "," + numero);
            }//Mayor detalle de las omisiones para el MergeSort en último método abajo
            
            System.out.println("Éxito: Se ha generado el archivo '" + nombreArchivo + "' listo para Excel.");
            
        } catch (IOException e) {
            System.err.println("Ocurrió un error al intentar crear el archivo: " + e.getMessage());
        }
    }
    
    public static TuplaNumerica[] generate_list(TuplaNumerica[] original, int size) {
        //Lista con tamaño hasta cierto número
        TuplaNumerica[] gen_list = new TuplaNumerica[size];
        
        System.arraycopy(original, 0, gen_list, 0, size);
        return gen_list; 
    }
    
    public void haciaCSV(String nombreArchivo, TuplaNumerica[] tupla_lista, int numero, int topPercent) {
        
        //Random random = new Random();

        if (!nombreArchivo.endsWith(".csv")) {
            nombreArchivo += ".csv"; 
        }
        
        try (PrintWriter writer = new PrintWriter(new FileWriter(nombreArchivo))) {
            
            // Escribimos los encabezados (la primera fila en Excel)
            writer.println("N,QuickSelect,MergeSort");
        
            long quickselectComparisons;
            long mergesortComparisons;
        
            //writer.println(0 + "," + 0 + "," + 0);
            topPercent = (100/topPercent);
            double Q_quick, M_merge;
            int top001 = numero/topPercent;
        
            for (int i = 1; i <= top001; i++) {
            
                //Se clona para manejar las mismas condiciones a ambos algoritmos en cada iteración
                TuplaNumerica[] nums = tupla_lista.clone();
            
                // --- QUICKSELECT ---
                TuplaNumerica[] numsParaQuick;
                quickselectComparisons = 0;
                //POR SU CARACTERISTICA ALEATORIA, SE HARÁ EL PROMEDIO DE UNA MUESTRA DE SOLAMENTE 100 PARA NO RECARGAR EN OPERACIONES EL CODIGO
                for (int j = 0; j < 100; j++){
                    numsParaQuick = nums.clone();
                    QuickSelect qckselect = new QuickSelect(numsParaQuick);
                    qckselect.USEQuickSelect(i);
                    quickselectComparisons += qckselect.get_num_of_comparisons(); 
                }
            
                // --- MERGESORT --- PARA REDUCIR ENORMEMENTE LAS OPERACIONES DEL CÓDIGO NO SE EJECUTARÁ EL ALGORITMO COMO TAL
                //TuplaNumerica[] numsParaMerge = nums.clone();
                //MergeSort mersort = new MergeSort(numsParaMerge);
                //mersort.USEMergeSort();
            
                Q_quick = (double) quickselectComparisons / 100;
                //M_merge = (double) mersort.get_num_of_comparisons();
            
                //MERGESORT HARÁ SIEMPRE COMPARACIONES COMO EL TAMAÑO DE LA LISTA, ASI QUE DIRECTAMENTE COLOCAMOS <numero>
                writer.println(i + "," + Q_quick + "," + numero);
                //DESCOMENTAR LAS LINEAS RESPECTIVAS AL MERGE Y LINEA SIGUIENTE A ESTA Y COMENTAR LA ANTERIOR EN CASO DESEE APLICAR EL ALGORITMO EN CADA ITERACION
                //writer.println(i + "," + quickselectComparisons + "," + (double) mersort.get_num_of_comparisons());
            }
            
            System.out.println("Éxito: Se ha generado el archivo '" + nombreArchivo + "' listo para Excel.");
            
        } catch (IOException e) {
            System.err.println("Ocurrió un error al intentar crear el archivo: " + e.getMessage());
        }
    }
    
}
