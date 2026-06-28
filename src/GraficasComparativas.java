/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.graficascomparativas;

/**
 *
 * @author User_001
 */

//PARA REDUCIR ENORMEMENTE LAS OPERACIONES DEL CÓDIGO NO SE EJECUTARÁ EL ALGORITMO MERGESORT COMO TAL,
//PUES SU COMPORTAMIENTO ES CONOCIDO Y NO ES VIABLE COMPUTACIONALMENTE SOMETERLO A LAS MISMAS PRUEBAS DE
//EVALUACION DEL QUICKSORT, EL CUAL CUENTA CON COMPONENTES ALEATORIOS

public class GraficasComparativas {

    public static void main(String[] args) {
        //El Importador, conociendo el tamaño max se ahorra operaciones; no obstante,
        //sin ello ingresa únicamente el nombre del txt y se maneja esa situación
        
        //TuplaNumerica[] primerTercio = Importador.importarDatos("primerTercio.txt", 5236);
        //TuplaNumerica[] segundoTercio = Importador.importarDatos("segundoTercio.txt", 8396);
        //TuplaNumerica[] tercerTercio = Importador.importarDatos("tercerTercio.txt", 15156);
        
        ComparadorAlgoritmos com = new ComparadorAlgoritmos();
        
        //TuplaNumerica[] prueba = Importador.importarDatos("prueba.txt");
        //com.haciaCSV("primerTercio", prueba, prueba.length);
        
        //com.haciaCSV("primerTercio", primerTercio, primerTercio.length);
        //com.haciaCSV("segundoTercio", segundoTercio, segundoTercio.length);
        //boolean xd = True
        //com.haciaCSV("tercerTercio.csv", tercerTercio, tercerTercio.length);
        
        //Top 1% mayores gastadores
        //com.haciaCSV("primerTercio_Top001", primerTercio, primerTercio.length, 1);
        //com.haciaCSV("segundoTercio_Top001", segundoTercio, segundoTercio.length, 1);
        //com.haciaCSV("tercerTercio_Top100.csv", tercerTercio, tercerTercio.length, 1);
        
        //Top 10% mayores gastadores
        //com.haciaCSV("primerTercio_Top01", primerTercio, primerTercio.length, 10);
        //com.haciaCSV("segundoTercio_Top01", segundoTercio, segundoTercio.length, 10);
        //com.haciaCSV("tercerTercio_Top01.csv", tercerTercio, tercerTercio.length, 10);
    }        
    
}
