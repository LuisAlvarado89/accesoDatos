package org.ies.tierno.escribirFicheros;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;

import static java.nio.file.StandardOpenOption.APPEND;

public class MaquinaDeEscribir {

    public static void main(String[] args) {
        String[] cadena = {"Luis", "Ariedna", "Erick"};
        // depositarContenido(cadena, "ejemplo.txt");
        leerContenido("ejemplo.txt");

    }

    //Ejercicio 1

    public static void depositarContenido(String[] cadena, String nombreFichero) {
        Path fichero = Path.of(nombreFichero);

        try {
            if (!Files.exists(fichero)) {
                Files.createFile(fichero);
            }
            for (String palabra : cadena) {
                Files.writeString(
                        fichero,
                        palabra + "*",
                        StandardCharsets.UTF_8,
                        APPEND
                );
            }
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());

        }
    }

    //Ejercicio 2
    public static void leerContenido(String nombreFichero) {
        Path fichero = Path.of(nombreFichero);

        try {
            if (Files.exists(fichero)) {
                String linea = Files.readString(
                                fichero,
                                StandardCharsets.UTF_8)
                        .replace("*", "%n");
                System.out.printf(linea);
            } else {
                System.out.printf("El fichero no existe");
            }
        } catch (IOException e) {
            System.out.printf("Error:  %s ", e.getMessage());
        }
    }
}