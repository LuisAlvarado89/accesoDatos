package org.ies.tierno.controlDatos;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Files;

public class ApisComparatorIO {
    // Utiliza las Apis de NIO e IO para resolver cada uno de los ejercicios y compara los resultados.

    //1.	Codifica un método que cree los siguientes archivos:
    //a.	 /tmp/ acceso/ introduccion.txt
    //b.	 /tmp/otro/ejemplo.txt
    //c.	 acceso/introduccion.txt
    //d.	otro/ejemplo.txt

    private String[] rutas = {"/tmp/acceso/introduccion.txt", "/tmp/otro/ejemplo.txt",
            "acceso/introduccion.txt", "otro/ejemplo.txt"};

    public ApisComparatorIO(String[] rutas) {
        if (rutas != null) {
            this.rutas = rutas;
        }
    }

    public void creadorArchivosIO() throws IOException {
        System.out.println("Generador de archivos con IO...");
        File[] archivos = new File[rutas.length];
        for (int i = 0; i < rutas.length; i++) {
            archivos[i] = new File(rutas[i]);
        }
        for (File archivo : archivos) {
            File directorio = archivo.getParentFile();

            if (directorio != null) {
                directorio.mkdirs();
            }
            if (!archivo.exists()) {
                archivo.createNewFile();
            }
        }
    }

    public void crearArchivosNIO() throws IOException {
        System.out.println("Creador archivos con NIO...");

        Path[] archivos = new Path[rutas.length];
        for (int i = 0; i < rutas.length; i++) {
            archivos[i] = Path.of(rutas[i]);
        }
        for (Path archivo : archivos) {
            Files.createDirectories(archivo.getParent());

            if (Files.notExists(archivo)) {
                Files.createFile(archivo);
            }
        }
    }


}

//2. Codifica un método que muestre las rutas absolutas de los siguientes archivos:
//a.	 /tmp/ acceso/ introduccion.txt
//b.	 /tmp/otro/ejemplo.txt
//c.	acceso/introduccion.txt
//d.	otro/ejemplo.txt





