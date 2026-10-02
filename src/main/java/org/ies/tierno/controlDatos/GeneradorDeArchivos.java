package org.ies.tierno.controlDatos;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class GeneradorDeArchivos {
    // Utiliza las Apis de NIO e IO para resolver cada uno de los ejercicios y compara los resultados.

    private String[] rutas= {"/tmp/acceso/introduccion.txt","/tmp/otro/ejemplo.txt",
            "acceso/introduccion.txt","otro/ejemplo.txt"};


    public GeneradorDeArchivos(String[] rutas)
    {
        if(rutas != null)
            this.rutas= rutas;
    }

    public void crearArchivosIO() throws IOException
    {
        System.out.println("Generando archivos con IO...");
        File[] archivos = new File[rutas.length];
        for(int i=0; i<rutas.length; i++)
            archivos[i]=new File(rutas[i]);

        for (File archivo : archivos)
        {
            File directorio = archivo.getParentFile();

            if (directorio != null)
                directorio.mkdirs();

            if (!archivo.exists())
                archivo.createNewFile();
        }
    }

    public void crearArchivosNIO() throws IOException
    {
        System.out.println("Generando archivos con NIO...");
        Path[] archivos = new Path[rutas.length];
        for(int i=0; i<rutas.length; i++)
            archivos[i]=Path.of(rutas[i]);

        for (Path archivo:archivos)
        {

            Files.createDirectories(archivo.getParent());
            if (Files.notExists(archivo))
                Files.createFile(archivo);
        }
    }

}



