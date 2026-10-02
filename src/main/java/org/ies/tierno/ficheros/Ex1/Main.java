package org.ies.tierno.ficheros.Ex1;

import java.io.File;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        File archivo = new File("/tmp/ComprobadorFicheros/introduccion.txt");
        File archivo2 = new File("/tmp/ComprobadorFicheros/Hola.txt");

        ComprobarFicheros comprobarFicheros = new ComprobarFicheros();
        System.out.println(comprobarFicheros.exists(archivo));
        System.out.println(comprobarFicheros.exists(archivo2));


    }
}