package org.kami;

import org.kami.ballSettings.vista.VentanaBolas;

import javax.swing.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
import javax.swing.SwingUtilities;

public class Main {
    public static void main(String[] args) {
        // Crear la ventana siempre en el EDT (hilo de eventos de Swing)
        SwingUtilities.invokeLater(VentanaBolas::new);
    }
}