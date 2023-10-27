/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.shengdong.procesos;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 *
 * @author shengdong
 */
public class Procesos {

    public static void main(String[] args) throws IOException {
        Procesos procesos = new Procesos();
        
        //procesos.ejecutaComando();
        //procesos.ejecutaComandoyComprueba();
        //procesos.ejecutaComandoyEspera();
        //procesos.ejecutaComandoDirectorio();
        procesos.buscayGuarda();
        
    }
    
    public void ejecutaComando() throws IOException{
        ProcessBuilder pb = new ProcessBuilder("ping","www.google.com");
        pb.inheritIO();  
        Process p = pb.start();
        try {
            p.waitFor(5, TimeUnit.SECONDS);
        } catch (InterruptedException ex) {
           System.out.println("fallo");
        }
    }
    
    public void ejecutaComandoyComprueba() throws IOException{
        ProcessBuilder pb = new ProcessBuilder("ping","www.google.com");
        pb.inheritIO();  
        Process p = pb.start();

        try {
            while(p.isAlive()){
            p.waitFor(5, TimeUnit.SECONDS);
            System.out.println("Esperando...");
            }
        } catch (InterruptedException ex) {
           System.out.println("fallo");
        }
    }
    

    public void ejecutaComandoyEspera() throws IOException{
        ProcessBuilder pb = new ProcessBuilder("ping","www.google.com");
        pb.inheritIO();  
        Process p = pb.start();

        try {
            while(p.isAlive()){
            p.waitFor(5, TimeUnit.SECONDS);
            p.destroy();
                System.out.println("se ha cerrado el proceso");
            }
        } catch (InterruptedException ex) {
           System.out.println("fallo");
        }
    }
    
     public void ejecutaComandoDirectorio() throws IOException{
        ProcessBuilder pb = new ProcessBuilder( "cmd.exe","/c","dir");
        pb.directory(new File("C:\\Users\\15457\\Downloads\\Documentos\\procesos net"));

        pb.inheritIO();  


        try {
            Process p = pb.start();
            int resultado = p.waitFor();
            if(resultado == 0){
                System.out.println("El comando se ejecuto correctamente");
            }else{
                System.err.println("Error al ejecutar el comando directorio");
            }
        } catch (IOException | InterruptedException ex) {
            ex.printStackTrace();
        }
    }
    
    public void buscayGuarda() throws IOException{
       ProcessBuilder pb = new ProcessBuilder( "cmd.exe","/c", "findstr", "texto1", "archivo1.txt");
        pb.inheritIO();  
        pb.directory(new File("C:\\Users\\15457\\Downloads\\Documentos\\procesos net"));
        pb.redirectOutput(new File("C:\\Users\\15457\\Downloads\\Documentos\\procesos net\\archivo2.txt"));
       
        try {
            Process p = pb.start();
                System.out.println("Se ha buscado 'texto1' en el documento 'archivo1.txt' y se ha redirigido los resultados a 'archivo2.txt'");
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}

