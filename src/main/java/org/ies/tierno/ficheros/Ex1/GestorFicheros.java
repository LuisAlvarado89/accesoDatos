package org.ies.tierno.ficheros.Ex1;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;

public class GestorFicheros {

    //Ejercicio 1

    public boolean existeFicheroIO(String nombreFichero) {

        File fichero = new File(nombreFichero);

        return fichero.exists() && fichero.isFile();
    }

    //Ejercicio 2

    public boolean existeFicheroNIO(String nombreFichero) {
        Path fichero = Path.of(nombreFichero);
        return Files.exists(fichero) && Files.isRegularFile(fichero);

    }

    //Ejercicio 3
    public boolean estaEnNIO(String nombreFichero, String directorio) {
        Path fichero = Path.of(directorio, nombreFichero);
        return Files.exists(fichero) && Files.isRegularFile(fichero);
    }

    //Ejercicio 4

    public boolean esDirectorioIO(String nombre) {
        File fichero = new File(nombre);

        return fichero.isDirectory();
    }

    public boolean esDirectorioNIO(String nombre) {

        File fichero = new File(nombre);

        return fichero.isDirectory();
    }


}
