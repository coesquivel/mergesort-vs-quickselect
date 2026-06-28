/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.graficascomparativas;

/**
 *
 * @author User_001
 */


import java.util.Random;

public class QuickSelect {
    private TuplaNumerica[] arr;
    private int arr_len;
    private int comparisons;
    private Random random;

    // Constructor
    public QuickSelect(TuplaNumerica[] arr) {
        this.arr = arr;
        this.arr_len = arr.length;
        this.comparisons = 0;
        this.random = new Random(); // Instanciamos Random una sola vez
    }

    // Método auxiliar para intercambiar elementos en el arreglo (reemplaza arr[i], arr[j] = arr[j], arr[i])
    private void swap(TuplaNumerica[] array, int i, int j) {
        TuplaNumerica temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    // Partition function: Reorganiza elementos alrededor del pivote
    private int partition(TuplaNumerica[] array, int l, int r) {
        // Tomamos el valor decimal (equivalente a arr[r][1]) como pivote
        float x = array[r].getDecimal();
        int i = l;

        // Iteramos a través del subarreglo
        for (int j = l; j < r; j++) {
            // Movemos elementos <= pivote a la partición izquierda
            if (array[j].getDecimal() <= x) {
                swap(array, i, j);
                i++;
            }
        }
        
        // Colocamos el pivote en su posición correcta
        swap(array, i, r);
        
        // Nota: Mantuve el incremento de comparaciones igual que en tu Python.
        // (Aunque estrictamente hablando, las comparaciones reales ocurren dentro del 'for').
        this.comparisons += 1; 
        return i;
    }

    // Aleatoriza el pivote para evitar el peor caso de rendimiento
    private int randomPartition(TuplaNumerica[] array, int l, int r) {
        int n = r - l + 1;
        int pivot = random.nextInt(n);
        swap(array, l + pivot, r);
        return partition(array, l, r);
    }

    // Función para encontrar el k-ésimo elemento más pequeño
    private TuplaNumerica quickSelect(TuplaNumerica[] array, int l, int r, int k) {
        // Verifica si k está dentro del rango válido del subarreglo
        if (k > 0 && k <= r - l + 1) {
            
            // Particiona el arreglo y obtiene la posición final del pivote
            int pos = randomPartition(array, l, r);

            // Si el pivote es el k-ésimo elemento, lo retorna
            if (pos - l == k - 1) {
                return array[pos];
            }

            // Si la posición del pivote es mayor que k, busca en el subarreglo izquierdo
            if (pos - l > k - 1) {
                return quickSelect(array, l, pos - 1, k);
            }

            // De lo contrario, busca en el derecho ajustando k
            return quickSelect(array, pos + 1, r, k - (pos - l + 1));
        }
        
        // Retorna null para k inválido (manejo de errores equivalente a float('inf'))
        return null; 
    }

    public TuplaNumerica kthSmallest(TuplaNumerica[] array, int k) {
        int n = array.length;
        return quickSelect(array, 0, n - 1, k);
    }

    public TuplaNumerica USEQuickSelect(int k) {
        return kthSmallest(this.arr, k);
    }

    public int get_num_of_comparisons() {
        return this.comparisons;
    }

    public TuplaNumerica[] tener_lista() {
        return this.arr;
    }
}