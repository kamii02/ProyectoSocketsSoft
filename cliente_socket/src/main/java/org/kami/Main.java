package org.kami;

import org.kami.ballSettings.config.IConfigReader;
import org.kami.ballSettings.config.PropertiesManager;
import org.kami.ballSettings.vista.PanelBolas;
import org.kami.ballSettings.vista.VentanaBolas;
import org.kami.networkService.Client;
import org.kami.networkService.ListenService;
import org.kami.networkService.SendService;

import javax.swing.*;
import javax.swing.SwingUtilities;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Punto de entrada principal de la aplicación cliente del juego de bolas en red.
 *
 * <p>Esta clase inicializa todos los componentes necesarios para el funcionamiento
 * del cliente: lee la configuración, establece la conexión con el servidor mediante
 * sockets, y lanza la interfaz gráfica junto con los servicios de envío y escucha
 * de mensajes en red.</p>
 *
 * <p>Flujo general de ejecución:</p>
 * <ol>
 *   <li>Lectura de parámetros de configuración (IP, puerto, estado de la bola).</li>
 *   <li>Conexión al servidor mediante {@link Client}.</li>
 *   <li>Creación del servicio de envío {@link SendService}.</li>
 *   <li>Inicialización del panel gráfico {@link PanelBolas} y la ventana {@link VentanaBolas}.</li>
 *   <li>Arranque del servicio de escucha {@link ListenService} para recibir la bola del otro cliente.</li>
 * </ol>
 */
public class Main {

    /**
     * Método principal que arranca la aplicación cliente.
     *
     * <p>Lee la configuración desde {@code application.properties}, conecta con el
     * servidor en la IP y puerto especificados, y lanza la interfaz gráfica en el
     * hilo de eventos de Swing ({@link SwingUtilities#invokeLater}).</p>
     *
     * <p>Dentro del hilo de Swing se crean:</p>
     * <ul>
     *   <li>{@link PanelBolas}: panel de juego que gestiona el movimiento y envío de la bola.</li>
     *   <li>{@link ListenService}: hilo que escucha mensajes entrantes del servidor
     *       y notifica al panel cuando llega una bola con su posición {@code y} y velocidad {@code vy}.</li>
     *   <li>{@link VentanaBolas}: ventana principal que contiene el panel de juego.</li>
     * </ul>
     *
     * @param args argumentos de línea de comandos (no utilizados).
     * @throws IOException si ocurre un error al conectar con el servidor o al
     *                     obtener los flujos de entrada/salida del socket.
     */
    public static void main(String[] args) throws IOException {
        IConfigReader configReader = new PropertiesManager("application.properties");
        String ipServer = configReader.getIpServer();
        int port = configReader.getPort();
        boolean bolaActiva = configReader.bolaActiva();

        BufferedReader in;
        PrintWriter out;
        Client client = new Client();
        client.conn(ipServer, port);
        in = client.getReader();
        out = client.getWriter();

        SendService sender = new SendService(out);
        SwingUtilities.invokeLater(() -> {
            PanelBolas panelBolas = new PanelBolas(sender, bolaActiva);

            ListenService listenService = new ListenService(in, (y, vy) -> {
                panelBolas.recibirBola(y, vy);
            });
            listenService.start();

            VentanaBolas ventana = new VentanaBolas(panelBolas);
            ventana.setVisible(true);
        });
    }
}