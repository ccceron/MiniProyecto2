/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package FuncionesAdicionales;

import java.awt.Image;
import java.io.File;
import javax.swing.ImageIcon;

public class MetodoAdicional {
   
    public static ImageIcon establecerIcon(String rutaArchivo, int ancho, int alto)
            {
        
        String rutaImagen = new File("").getAbsolutePath();
        ImageIcon imagen = new ImageIcon(rutaImagen.concat(rutaArchivo));
        Image image = (imagen).getImage().getScaledInstance(ancho, alto, Image.SCALE_SMOOTH);
        // System.out.println("El path es: " + imagen);
        
        return new ImageIcon(image);
    }
}


