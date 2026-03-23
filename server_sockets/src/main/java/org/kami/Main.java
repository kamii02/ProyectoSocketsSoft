package org.kami;

import org.kami.ballSettings.config.IConfigReader;
import org.kami.ballSettings.config.PropertiesManager;
import org.kami.ballSettings.vista.PanelBolas;
import org.kami.ballSettings.vista.VentanaBolas;
import org.kami.networkService.ListenService;
import org.kami.networkService.SendService;
import org.kami.networkService.Server;

import javax.swing.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.concurrent.CountDownLatch;

/**
 * Clase principal de la aplicación.
 * <p>
 * Se encarga de:
 * <ul>
 *     <li>Leer la configuración desde un archivo de propiedades.</li>
 *     <li>Inicializar el servidor de sockets.</li>
 *     <li>Configurar los servicios de envío y recepción de datos.</li>
 *     <li>Crear e iniciar la interfaz gráfica.</li>
 *     <li>Coordinar la sincronización entre hilos.</li>
 * </ul>
 *
 * <p>
 * La aplicación permite la comunicación entre clientes mediante sockets
 * para sincronizar el movimiento de una bola en pantalla.
 * </p>
 *
 * @author Manuel
 * @version 1.0
 * @since 1.0
 */
public class Main {
    /**
     * Método principal que inicia la ejecución del programa.
     *
     * <p>
     * Flujo de ejecución:
     * <ol>
     *     <li>Lee configuración desde {@code application.properties}.</li>
     *     <li>Inicia el servidor en el puerto especificado.</li>
     *     <li>Obtiene los flujos de entrada y salida.</li>
     *     <li>Configura los servicios de red (envío y escucha).</li>
     *     <li>Inicializa la interfaz gráfica en el hilo de Swing.</li>
     *     <li>Sincroniza la ejecución usando {@link CountDownLatch}.</li>
     * </ol>
     *
     * @param args argumentos de línea de comandos (no utilizados).
     * @throws IOException si ocurre un error en la comunicación de red.
     * @throws InterruptedException si el hilo es interrumpido mientras espera.
     */
    public static void main(String[] args) throws IOException, InterruptedException {
        /**
         * Lector de configuración que obtiene los valores desde un archivo de propiedades.
         */
        IConfigReader reader = new PropertiesManager("application.properties");

        /**
         * Puerto en el que el servidor escuchará conexiones entrantes.
         */
        int port = reader.getPort();

        /**
         * Indica si la bola está activa al iniciar la aplicación.
         */
        boolean bolaActiva = reader.bolaActiva();

        BufferedReader in;
        PrintWriter out;

        /**
         * Servidor encargado de aceptar conexiones y proporcionar los streams de comunicación.
         */
        Server server = new Server();
        server.iniciar(port);

        /**
         * Flujo de entrada para recibir datos desde el cliente.
         */
        in = server.getReader();

        /**
         * Flujo de salida para enviar datos al cliente.
         */
        out = server.getWriter();

        /**
         * Servicio encargado de enviar información a través del socket.
         */
        SendService sender = new SendService(out);

        /**
         * Mecanismo de sincronización para esperar a que la interfaz gráfica se inicialice.
         */

        CountDownLatch latch = new CountDownLatch(1);

        /**
         * Inicialización de la interfaz gráfica en el hilo de eventos de Swing.
         */
        SwingUtilities.invokeLater(() ->{

            /**
             * Panel que gestiona la lógica y renderizado de la bola.
             */
            PanelBolas panel = new PanelBolas(sender, bolaActiva);

            /**
             * Servicio que escucha datos entrantes y actualiza la posición de la bola.
             */
            ListenService listener = new ListenService(in,(y, vy) ->{
               panel.recibirBola(y, vy);
            });
            listener.start();

            /**
             * Ventana principal que contiene el panel de la bola.
             */
            VentanaBolas ventana = new VentanaBolas(panel);
            ventana.setVisible(true);

            /**
             * Indica que la interfaz ya está lista.
             */
            latch.countDown();
        });
        /**
         * Espera hasta que la interfaz gráfica haya sido inicializada.
         */
        latch.await();

    }
}
