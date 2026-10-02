package org.ies.tierno.controlDatos;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class ApisComparatorNIO {
    public static void main(String[] args) {

        Path[] archivos = {
                Paths.get("/tmp/acceso/introduccion.txt"),
                Paths.get("/tmp/otro/ejemplo.txt"),
                Paths.get("acceso/introduccion.txt"),
                Paths.get("otro/ejemplo.txt")
        };

        for (Path archivo : archivos) {
            try {
                // Crear los directorios necesarios
                Path directorio = archivo.getParent();

                if (directorio != null) {
                    Files.createDirectories(directorio);
                }

                // Crear el archivo
                if (Files.notExists(archivo)) {
                    Files.createFile(archivo);
                    System.out.println("Creado: " + archivo);
                } else {
                    System.out.println("Ya existe: " + archivo);
                }

            } catch (IOException e) {
                System.out.println("Error al crear " + archivo);
                e.printStackTrace();
            }
        }
    }
}
