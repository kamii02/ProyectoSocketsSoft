package org.kami.ballSettings.vista;

import javax.swing.JFrame;

/**
 * Ventana principal de la aplicación que contiene el panel donde se
 * dibuja la animación de la bola.
 *
 * Esta clase extiende JFrame y se encarga de crear la ventana
 * gráfica donde se mostrará el PanelBolas.
 *
 * Configura propiedades básicas de la ventana como el título,
 * el tamaño automático, la posición en pantalla y el comportamiento
 * al cerrarse.
 *
 * @author Juan
 * @author Emma
 * @author Cami
 * @author Manu
 */
public class VentanaBolas extends JFrame {

    /**
     * Constructor de la ventana principal.
     * Inicializa la interfaz gráfica y agrega el panel donde
     * se dibuja la bola.
     * @param  panelBolas PanelBolas es el que ya esta construido previamente
     */
    public VentanaBolas(PanelBolas panelBolas) {
        setTitle("Bola TCP — Pantalla Local");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        add(panelBolas);

        pack();
        setLocationRelativeTo(null);
        setResizable(false);
        setVisible(true);
    }
}