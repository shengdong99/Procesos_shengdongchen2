/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.shengdong.procesos;

import java.io.IOException;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author shengdong
 */
public class Procesos {

    public static void main(String[] args) throws IOException {
        ProcessBuilder pb = new ProcessBuilder("ping","www.google.com");
        pb.inheritIO();       
        try {
            Process p = pb.start();
            p.waitFor();
        } catch (InterruptedException ex) {
           System.out.println(ex);
        }
 
    }
}
