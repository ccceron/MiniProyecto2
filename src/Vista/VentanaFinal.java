/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Vista;
import javax.swing.*;
import Vista.PanelFondo;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import Vista.VentanaInicio;


public class VentanaFinal extends JFrame {

    private JButton botonSalir;
    private JButton botonJugarDeNuevo;
    
    public VentanaFinal(int aciertos, int errores, int puntaje) {
        

        // Configuración de la ventana
        setTitle("Adosa2");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(700, 500);
        setLocationRelativeTo(null);
        setVisible(true);
        setResizable(false);

        // Configuración del fondo
        PanelFondo jpFondo = new PanelFondo("/imagenes/Fondo.jpg");
        jpFondo.setSize(700, 500);
        jpFondo.setLayout(null);
        add(jpFondo);
        
        JLabel labelaciertos = new JLabel(" Usted tuvo  "+  aciertos +  "  Aciertos");
        labelaciertos.setBounds(250, 100, 400, 150);
        labelaciertos.setForeground(Color.GRAY);
        labelaciertos.setFont(new Font("Agency FB", Font.BOLD, 25));
        jpFondo.add(labelaciertos);
        

           // Agregar texto2
        JLabel fallas = new JLabel(" Usted tuvo  "+ errores + "  fallas");
        fallas.setBounds(250, 160, 400, 150);
        fallas.setForeground(Color.GRAY);
        fallas.setFont(new Font("Agency FB", Font.BOLD, 25));
        jpFondo.add(fallas);
        
       

       
        JLabel labeltotal = new JLabel(" Total puntos:  "+ puntaje + " Puntos");
        labeltotal.setBounds(250, 220, 400, 150);
        labeltotal.setForeground(Color.GRAY);
        labeltotal.setFont(new Font("Agency FB", Font.BOLD, 25));
        jpFondo.add(labeltotal);
        
        
         botonJugarDeNuevo = new JButton("Jugar de Nuevo");
        botonJugarDeNuevo.setFont(new Font("Agency FB", Font.BOLD, 20));
        botonJugarDeNuevo.setBounds(270, 330, 160, 35);
        jpFondo.add(botonJugarDeNuevo);
        
        botonSalir = new JButton("Salir");
        botonSalir.setFont(new Font("Agency FB", Font.BOLD, 20)); 
        botonSalir.setBounds(290, 370, 110, 35);
        jpFondo.add(botonSalir);

        
       
        
        // Agregar ActionListener al botón "Salir" para cerrar la ventana
        botonSalir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Cierra la ventana actual
                dispose();
            }
        });
        
        botonJugarDeNuevo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Crea una nueva instancia de VentanaInicio con el controlador actual
                new VentanaInicio();
                // Cierra la ventana actual
                dispose();
            }
        });
    }
}
