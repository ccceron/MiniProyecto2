/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package vista;

import LogicaJuego.Logica;
import Controlador.Baldosas;
import FuncionesAdicionales.BotonMatch;
import FuncionesAdicionales.MetodoAdicional;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.Timer;


/**

 * Clase que representa la ventana del juego ya ejecutandose
 */
public class VentanaJuego extends JFrame {

    
    // Saber si ya pasaron los tres segundos
    // Cambiar cuano se integre la pantalla principal
    private boolean puedeJugar = true;
    private boolean puedeTirar = true;
    private double tAux = 0;
    private boolean inicioJuego = true;

    //baldosaCambiada
    private int baldosaCambiada = -1;

    //logica
    private Logica logica;

    //controlador de baldosas(imagenes)
    private Baldosas imgsBaldosas;

    //timer
    private Timer tiempo;

    //Ancho y alto de ventana
    private int anchoV = 700;
    private int largoV = 500;

    //Ruta absoluta
    private String rutaAbsoluta;

    //Fondo lbl
    private JLabel lblFondo;

    //labelContador
    private JLabel lblContador;

    //Botones
    private JButton btnBlanco;

    //Label puntaje
    private JLabel lblPuntaje;

    //Labels vidas
    private ArrayList<JLabel> listaVidas;

    //Contendero principal
    private Container contPrincipal;

    //Baldosas 
    private ArrayList<JLabel> listaBaldosas;

    //Imagenes
    private ImageIcon imgFondo;
    private ImageIcon iconoBtnNorm;
    private ImageIcon iconoBtnPress;
    private ImageIcon iconoBtnRoll;
   
    //Constructor
    public VentanaJuego() {
        iniciarVentana();
        iniciarComponentes();
    }

    //
    private void iniciarVentana() {
        setSize(anchoV, largoV);
        setVisible(true);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Image icon = new ImageIcon(getClass().getResource("/imagenes/iconoVentana.png")).getImage();
        // setIconImage(icon);

        setTitle("Mini Proyecto 2");

        setResizable(false);

    }

    //
    private void iniciarComponentes() {

        //Ruta absoluta//
        rutaAbsoluta = new File("").getAbsolutePath();

        //logica
        logica = new Logica();

        //baldosas (controlador)
        imgsBaldosas = new Baldosas();

        //timer//
        tiempo = new Timer(100, new ManejadorDeEventosTiempo());
        tiempo.start();

        //Fondo (provisonal)//
        imgFondo = MetodoAdicional.establecerIcon("\\src\\imagenes\\FondoProyecto.png", anchoV - 10,
                largoV - 38);
        lblFondo = new JLabel(imgFondo);
        lblFondo.setLayout(null);

        //Labels punatje//
        lblPuntaje = new JLabel("Puntaje: 0000");
        lblPuntaje.setForeground(new Color(255, 255, 255));
        lblPuntaje.setBounds(5, 0, 300, 50);
        lblPuntaje.setFont(new Font("Agency FB", Font.PLAIN, 35));

        //Labels de vidas// (temporales)
        listaVidas = new ArrayList<>();
        inicializarVidas();

        //Botn balnco//
        btnBlanco = new BotonMatch();
        btnBlanco.setBounds(520, 320, 100, 100);

        iconoBtnNorm = MetodoAdicional.establecerIcon("\\src\\imagenes\\btnNorm.png", 100, 100);
        btnBlanco.setIcon(iconoBtnNorm);

        iconoBtnPress = MetodoAdicional.establecerIcon("\\src\\imagenes\\btnPress.png", 100, 100);
        btnBlanco.setPressedIcon(iconoBtnPress);

        iconoBtnRoll = MetodoAdicional.establecerIcon("\\src\\imagenes\\btnRoll.png", 100, 100);
        btnBlanco.setRolloverIcon(iconoBtnRoll);
        
        //Baldosas
        
        listaBaldosas = new ArrayList<>();
        inicializarBaldosas();
        // [javax.swing.JLabel[,30,170,100x100,invalid,hidden,alignmentX=0.0,alignmentY=0.0,border=,flags=8388608,maximumSize=,minimumSize=,preferredSize=,defaultIcon=javax.swing.ImageIcon@4f7d0008,disabledIcon=,horizontalAlignment=CENTER,horizontalTextPosition=TRAILING,iconTextGap=4,labelFor=,text=,verticalAlignment=CENTER,verticalTextPosition=CENTER],
        // javax.swing.JLabel[,140,170,100x100,invalid,hidden,alignmentX=0.0,alignmentY=0.0,border=,flags=8388608,maximumSize=,minimumSize=,preferredSize=,defaultIcon=javax.swing.ImageIcon@56235b8e,disabledIcon=,horizontalAlignment=CENTER,horizontalTextPosition=TRAILING,iconTextGap=4,labelFor=,text=,verticalAlignment=CENTER,verticalTextPosition=CENTER], 
        // javax.swing.JLabel[,440,178,100x100,invalid,hidden,alignmentX=0.0,alignmentY=0.0,border=,flags=8388608,maximumSize=,minimumSize=,preferredSize=,defaultIcon=javax.swing.ImageIcon@3632be31,disabledIcon=,horizontalAlignment=CENTER,horizontalTextPosition=TRAILING,iconTextGap=4,labelFor=,text=,verticalAlignment=CENTER,verticalTextPosition=CENTER], 
        // javax.swing.JLabel[,550,178,100x100,invalid,hidden,alignmentX=0.0,alignmentY=0.0,border=,flags=8388608,maximumSize=,minimumSize=,preferredSize=,defaultIcon=javax.swing.ImageIcon@5abca1e0,disabledIcon=,horizontalAlignment=CENTER,horizontalTextPosition=TRAILING,iconTextGap=4,labelFor=,text=,verticalAlignment=CENTER,verticalTextPosition=CENTER], 
        // javax.swing.JLabel[,292, 7 ,100x100,invalid,hidden,alignmentX=0.0,alignmentY=0.0,border=,flags=8388608,maximumSize=,minimumSize=,preferredSize=,defaultIcon=javax.swing.ImageIcon@2286778,disabledIcon=,horizontalAlignment=CENTER,horizontalTextPosition=TRAILING,iconTextGap=4,labelFor=,text=,verticalAlignment=CENTER,verticalTextPosition=CENTER], 
        // javax.swing.JLabel[,292,108,100x100,invalid,hidden,alignmentX=0.0,alignmentY=0.0,border=,flags=8388608,maximumSize=,minimumSize=,preferredSize=,defaultIcon=javax.swing.ImageIcon@4e9ba398,disabledIcon=,horizontalAlignment=CENTER,horizontalTextPosition=TRAILING,iconTextGap=4,labelFor=,text=,verticalAlignment=CENTER,verticalTextPosition=CENTER], 
        // javax.swing.JLabel[,292,353,100x100,invalid,hidden,alignmentX=0.0,alignmentY=0.0,border=,flags=8388608,maximumSize=,minimumSize=,preferredSize=,defaultIcon=javax.swing.ImageIcon@6d7b4f4c,disabledIcon=,horizontalAlignment=CENTER,horizontalTextPosition=TRAILING,iconTextGap=4,labelFor=,text=,verticalAlignment=CENTER,verticalTextPosition=CENTER], 
        // javax.swing.JLabel[,292,252,100x100,invalid,hidden,alignmentX=0.0,alignmentY=0.0,border=,flags=8388608,maximumSize=,minimumSize=,preferredSize=,defaultIcon=javax.swing.ImageIcon@527740a2,disabledIcon=,horizontalAlignment=CENTER,horizontalTextPosition=TRAILING,iconTextGap=4,labelFor=,text=,verticalAlignment=CENTER,verticalTextPosition=CENTER]]

        //lblContador//
        lblContador = new JLabel();
        lblContador.setBounds(300, 100, 300, 250);
        lblContador.setBorder(null);

        //Contenedor Principal//
        contPrincipal = getContentPane();
        contPrincipal.setLayout(new GridLayout(1, 1));
        //Añadiendo objetos
        contPrincipal.add(lblFondo);

        lblFondo.add(lblPuntaje);
        lblFondo.add(lblContador);
        lblFondo.add(btnBlanco);
        //se añaden las baldosas
        for (int i = 0; i < 8; i++) {
            lblFondo.add(listaBaldosas.get(i));
        }
        for (int i = 0; i < 3; i++) {
            lblFondo.add(listaVidas.get(i));
        }
        
        // Cambiando visibilidad de las primeras baldosas
        modificarBaldosas();

        //Añadiendo listenrs//
        btnBlanco.addMouseListener(new ManejadorDeEventosMouse());
    }
    
    
    //Metodo para inciailizar las baldosas
    private void inicializarBaldosas() {
        //cordenadas de cada baldosa
        int coordenadas[][] = {{30, 170}, {140, 170}, {440, 178}, {550, 178},
        {292, 7}, {292, 108}, {292, 353}, {292, 252}};

        //Se añaden 8 baldosas
        for (int i = 0; i < 8; i++) {
            JLabel baldosa = new JLabel(imgsBaldosas.getImgBaldosa(i));
            baldosa.setBounds(coordenadas[i][0], coordenadas[i][1],
                    100, 100);
            baldosa.setVisible(false);
            this.listaBaldosas.add(baldosa);
        }
    }

    //metodo que iniclliza las vidas
    private void inicializarVidas() {
        int coordenadas[][] = {{480, 10}, {550, 10}, {620, 10}};
        for (int i = 0; i < 3; i++) {
            LblVida lblVida = new LblVida();
            lblVida.setBounds(coordenadas[i][0], coordenadas[i][1], 50, 50);
            lblVida.setIcon(MetodoAdicional.
                    establecerIcon("\\src\\imagenes\\imgVidaActiva.png",50,50));
            listaVidas.add(lblVida);
        }
    }

    //metodo que verfiica baldosas iguales(con la logica)
    private boolean baldosasIguales(int baldosaCambiada) {
    //Logica logica = new Logica();
        //VAriable que indicara si hay dos baldosas iguales
        boolean hayBaldosasIguales = false;
        
        if (baldosaCambiada != -1) {
            //lista auxiliar del indice de las baldosas visibles
            ArrayList<Integer> baldosasEnPantalla = logica.getBaldosasAMostrar();
            //Imagen de la baldosa cambiada anteriroremenet
            Icon imgBaldosaCambiada = listaBaldosas.get(baldosaCambiada).getIcon();
            //se verifica si hay dos baldosa iguales//
            for (int i = 0; i < baldosasEnPantalla.size(); i++) {
                //se verfica que no sea la misma baldosa
                if (baldosaCambiada != baldosasEnPantalla.get(i)) {
                    Icon imgBaldosa = listaBaldosas.get(baldosasEnPantalla.get(i)).getIcon();
                    //se verfica si sus imagenes son iguales
                    if (imgBaldosaCambiada == imgBaldosa) {
                        hayBaldosasIguales = true;
                    }
                }
            }
        }
        return hayBaldosasIguales;
    }

    //metodo que modifica las Lblvidas si se pierde una vida
    private void quitarUnaVida() {
        if (logica.getVidas() > 0) {
            listaVidas.get(logica.getVidas()).setIcon(MetodoAdicional.
                    establecerIcon("\\src\\imagenes\\imgVidaPerdida.png",50,50));
        }

    }

    //metodo que modifica la visibilidad de las badldosas segun el caso
    private void modificarBaldosas() {
        System.out.println("Se modificaron las baldosas");
        //Se recorre cda baldosa
        for (int i = 0; i < 8; i++) {
            //Se ponen visibles o no visibles degun el caso
            if (logica.baldosaMostrandose(i)) {
                listaBaldosas.get(i).setVisible(true);
            } else {
                listaBaldosas.get(i).setVisible(false);
            }
            listaBaldosas.get(i).setIcon(imgsBaldosas.getImgBaldosa(i));
        }
    }

    //metodo que realiza las acciones correspondientes al cometer un fallo
    private void falloCometido() {
      
        //se pone normal la baldosa anteriroemnet ressaltada
        if (baldosaCambiada != -1) {
            listaBaldosas.get(baldosaCambiada).setBorder(null);
        }
        baldosaCambiada = -1;

        //se resta una vida
        logica.errorCometido();
        quitarUnaVida();
        System.out.println("Se cometió un error y perdió una vida");

        //se añade un error
        logica.aumentarErrores();

        //se aumenta el tiempo de cambio
        logica.aumentarTiempoDeCambio();

        //se verfica si quedan vidas
        if (logica.getVidas() > 0) {
            //se estbalcen nuevas baldosas
            logica.nuevasBaldosasAMostrar();
            modificarBaldosas();
        } else {
            tiempo.stop();
            dispose();

            

           
        }

    }

    // Metodo que muestra las aciones que realiza al acertar
    private void acierto() {

        //se pone normal la baldosa anteriroemnet ressaltada
        listaBaldosas.get(baldosaCambiada).setBorder(null);

        //se suma el puntaje
        logica.aumentarPuntaje();
        logica.aumentarPuntajeASumar();
        lblPuntaje.setText("Puntaje: " + logica.getPuntaje());

        //se añade un acierto
        logica.aumentarAciertos();

        //se reduce el tiempo de cambio
        logica.disminuirTiempoDeCambio();

        //se estbalcen nuevas baldosas
        logica.aumentarBaldosasAMostrar();
        logica.nuevasBaldosasAMostrar();
        modificarBaldosas();

        baldosaCambiada = -1;
    }

   
    //clase manejadora de eventos del mouse
    private class ManejadorDeEventosMouse extends MouseAdapter {

        @Override
        public void mousePressed(MouseEvent e) {
            //si se da click en el boton balnco
            if (e.getSource() == btnBlanco) {
                System.out.println("Click en el botón");
                if (puedeJugar && puedeTirar) {
                    System.out.println("Puede jugar y puede tirar");
                    //si hay baldosas iguales
                    if (baldosasIguales(baldosaCambiada)) {
                        tAux = 0;
                        acierto();

                    } else {
                        tAux = 0;
                        falloCometido();
                    }
                }
            }
        }
    }

    //clase Manejadora de eventos de tiempo
    private class ManejadorDeEventosTiempo implements ActionListener {

        //tiempo
        private double tiempo = 0;

        @Override
        public void actionPerformed(ActionEvent e) {
            //se aumenta el tiempo 1 decimo de segundo
            tAux += 0.1;
            tiempo += 0.1;

            if (tAux > 0.5) {
                puedeTirar = true;
            } else {
                if (!inicioJuego) {
                    puedeTirar = false;
                }
            }

            if (tiempo >= 4) {
               
                puedeJugar = true;
                puedeTirar = true;
                inicioJuego = false;
            }

            if (tiempo > logica.getTiempoDeCambio()) {
                //se reinicia el tiempo
                tiempo = 0;

                //se verifica si hay baldosas iguales
                if (baldosasIguales(baldosaCambiada)) {
                    falloCometido();
                } else {
                    //se pone normal la baldosa anteriroemnet ressaltada
                    if (baldosaCambiada != -1) {
                        listaBaldosas.get(baldosaCambiada).setBorder(null);
                    }

                    //se cambia la baldosa
                    int baldosaACambiar = logica.baldosaACambiar();
                    listaBaldosas.get(baldosaACambiar).
                            setIcon(imgsBaldosas.getImgBaldosaAleatoria());
                    listaBaldosas.get(baldosaACambiar).
                            setBorder(BorderFactory.
                                    createLineBorder(Color.GREEN, 3));
                    baldosaCambiada = baldosaACambiar;
                }
            }
        }
    }
    
    //clase de las vidas
    private class LblVida extends JLabel {
        public LblVida() {
            setOpaque(true);
            setBackground(new Color(0, 0, 0, 3));
        }
    }
}