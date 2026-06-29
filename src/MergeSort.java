/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


/**
 *
 * @author User_001
 */

public class MergeSort {
    private TuplaNumerica[] arr;
    private int arr_len;
    private int comparisons;

    // Constructor
    public MergeSort(TuplaNumerica[] arr) {
        this.arr = arr;
        this.arr_len = arr.length;
        this.comparisons = 0;
    }

    private void merge(TuplaNumerica[] array, int left, int mid, int right) {
        // Mantenemos el conteo de comparaciones tal como lo definiste en Python
        this.comparisons++;

        int n1 = mid - left + 1;
        int n2 = right - mid;

        // Creamos arreglos temporales
        TuplaNumerica[] L = new TuplaNumerica[n1];
        TuplaNumerica[] R = new TuplaNumerica[n2];

        // Copiamos los datos a los arreglos temporales L[] y R[]
        for (int i = 0; i < n1; ++i) {
            L[i] = array[left + i];
        }
        for (int j = 0; j < n2; ++j) {
            R[j] = array[mid + 1 + j];
        }

        int i = 0;
        int j = 0;
        int k = left;

        // Combinamos los arreglos temporales de vuelta en array[left..right]
        while (i < n1 && j < n2) {
            // Usamos getDecimal() para comparar el equivalente a la posición [1] en Python
            if (L[i].getDecimal() <= R[j].getDecimal()) {
                array[k] = L[i];
                i++;
            } else {
                array[k] = R[j];
                j++;
            }
            k++;
        }

        // Copiamos los elementos restantes de L[], si hay alguno
        while (i < n1) {
            array[k] = L[i];
            i++;
            k++;
        }

        // Copiamos los elementos restantes de R[], si hay alguno
        while (j < n2) {
            array[k] = R[j];
            j++;
            k++;
        }
    }

    private void mergeSort(TuplaNumerica[] array, int left, int right) {
        if (left < right) {
            // En Java, calcular el mid de esta forma previene desbordamientos de enteros en arreglos masivos
            int mid = left + (right - left) / 2;

            mergeSort(array, left, mid);
            mergeSort(array, mid + 1, right);
            merge(array, left, mid, right);
        }
    }

    public void USEMergeSort() {
        mergeSort(this.arr, 0, this.arr_len - 1);
    }

    public int get_num_of_comparisons() {
        return this.comparisons;
    }

    public TuplaNumerica[] tener_lista() {
        return this.arr;
    }
}