/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;
import java.awt.Color;
import java.util.ArrayList;
import java.util.List;
import Vista.Frame;

public class Modelo {
    
    //creo una lista de colores
     List<Color> listaColores = new ArrayList<>();
     
     //Creo contructor
     public Modelo (){
     listaColores = new ArrayList<>();   
     
     //Agrego los colores a la lista
     listaColores.add(new Color(255, 182, 193)); //Rosado
     listaColores.add(new Color(255, 255, 182)); //Amarillo pastel
     listaColores.add(new Color(173, 255, 47)); //Verde pastel
     listaColores.add(new Color(173, 216, 230));  // Azul Pastel
     listaColores.add(new Color(230, 230, 250));  // Lavanda Pastel
     listaColores.add(new Color(255, 218, 185));  // Melocotón Pastel
     
     
}
     
   Frame frame = new Frame();
     
  
    
}
             

