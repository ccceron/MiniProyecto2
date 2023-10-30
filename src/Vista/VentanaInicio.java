/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package Vista;

import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import vista.VentanaJuego;

//Creo mi clase que hereda de JFrame
public final class VentanaInicio extends JFrame {
    
    
    public PanelFondo jpFondoInicial;
    private JLabel jlNombre;
    private JLabel jlTitulo;
    private JTextField txtNombre;
    private JButton btnJugar; 
    private JButton btnInstrucciones;
    
    
    //Método constructor
    public VentanaInicio(){
        iniciarComponentes();
        
    }
    
    //Método donde inicializo todos los componentes que tendrá mi ventana
    private void iniciarComponentes(){
        //Configuración de la ventana
        setTitle("Proyecto2");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(700,500);
        setLocationRelativeTo(null);
        setResizable(false);
        
        
        Toolkit miPantalla = Toolkit.getDefaultToolkit();
       
        
        
        //Configuración del Encabezado
        jpFondoInicial = new PanelFondo("/modelo/fondo2.png"); 
        jpFondoInicial.setSize(700,500);     
        jpFondoInicial.setLayout(null);
        add(jpFondoInicial);
        
        
        //Jlabel donde pondré el titulo
        jlTitulo = new JLabel("F I G U R A S",SwingConstants.CENTER );
        jlTitulo.setBounds(150,80, 400,35);
        jlTitulo.setForeground(Color.GRAY);
        jlTitulo.setFont(new Font("Agency FB", Font.BOLD, 40)); 
        
        //Jlabel donde preguntaré el nombre
        jlNombre = new JLabel("Ingresa tu nombre",SwingConstants.CENTER );
        jlNombre.setBounds(150,170, 400,35);
        jlNombre.setForeground(Color.GRAY);
        jlNombre.setFont(new Font("Agency FB", Font.BOLD, 30)); 
        
        //Boton para iniciar juego
        btnJugar = new JButton("Jugar");
        btnJugar.setFont(new Font("Agency FB", Font.BOLD, 20));
        btnJugar.setBounds(290,310, 110,35);
        
        //Botón para instrucciones
        btnInstrucciones = new JButton("Intrucciones");
        btnInstrucciones.setFont(new Font("Agency FB", Font.BOLD, 20)); 
        btnInstrucciones.setBounds(290,260, 110,35);
        
        //Caja para ingresar nombre
        txtNombre = new JTextField("");
        txtNombre.setHorizontalAlignment(JTextField.CENTER);
        txtNombre.setForeground(Color.gray);
        txtNombre.setFont(new Font("Agency FB", Font.BOLD, 20)); 
        txtNombre.setBounds(225,215,240, 25);
        
        //Agrego todos mis componentes
        jpFondoInicial.add(txtNombre);
        jpFondoInicial.add(jlNombre);
        jpFondoInicial.add(jlTitulo);        
        jpFondoInicial.add(btnJugar);
        jpFondoInicial.add(btnInstrucciones);
        
        ManejadorDeEventos manejadorEventos = new ManejadorDeEventos();
        
        btnJugar.addActionListener(manejadorEventos);
        btnInstrucciones.addActionListener(manejadorEventos);
        txtNombre.addKeyListener(manejadorEventos);
        
        txtNombre.requestFocusInWindow();
        
        setVisible(true);
        repaint();
        revalidate();
}
    private void iniciarVentanaJuego(){
        String nombre =txtNombre.getText();
        if(!nombre.trim().isEmpty() || nombre.trim().length() > 0){
            VentanaJuego jugar = new VentanaJuego(); 
            dispose();               
            String nombreUsuario = txtNombre.getText();
          
        } 
        else {
            JOptionPane.showMessageDialog(null,"Por favor ingrese su nombre", 
                    "Advertencia", JOptionPane.ERROR_MESSAGE);
            txtNombre.requestFocusInWindow();
        }
    }    
    
    
            class ManejadorDeEventos implements ActionListener, KeyListener{
        @Override
        public void actionPerformed(ActionEvent evento){
            if(evento.getSource() == btnJugar){

                iniciarVentanaJuego();
            }
            if(evento.getSource() == btnInstrucciones){                
                JOptionPane.showMessageDialog(rootPane, """
                                                        Apareceran en pantalla una serie de baldosas. Las baldosas van cambiando de 1 en 1 mostrando distintos diseños. Podras saber que baldosa cambie en cada momento gracias al reborde de color verde"""
                );
            }
        }
        
        @Override
        public void keyReleased(KeyEvent e) {
           /* System.out.println("Se liberó la tecla " + e.getKeyChar() +
                    " Con codigo " + e.getKeyCode());*/

        }
        
        @Override
        public void keyPressed(KeyEvent e) {
            /*System.out.println("Se presionó la tecla " + e.getKeyChar()+
                    " Con codigo " + e.getKeyCode());*/
            
        }
        
        @Override
        public void keyTyped(KeyEvent e) {
            /*System.out.println("Se digitó la tecla " + e.getKeyChar()+
                    " Con codigo " + e.getKeyCode());*/
        }

        private void dispose() {
            throw new UnsupportedOperationException("Not supported yet."); 
        }
               
    }
}            