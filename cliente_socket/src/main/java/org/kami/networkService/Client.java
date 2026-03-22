package org.kami.networkService;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
/**
 * Clase que representa un cliente en una arquitectura cliente-servidor.
 *
 * <p>Permite establecer una conexión con un servidor mediante sockets,
 * así como obtener los flujos de entrada y salida para la comunicación
 * de datos.</p>
 *
 * <p>Esta clase se encarga de:
 * <ul>
 *   <li>Conectarse a un servidor remoto mediante IP y puerto</li>
 *   <li>Proveer mecanismos para leer datos desde el servidor</li>
 *   <li>Proveer mecanismos para enviar datos al servidor</li>
 * </ul>
 * </p>
 */
public class Client {
    /**
     * Socket utilizado para establecer la conexión con el servidor.
     */
    private Socket socket;

    /**
     * Establece una conexión con un servidor utilizando una dirección IP y un puerto.
     *
     * <p>Este método intenta crear un socket cliente que se conecta a un servidor remoto.
     * Si la conexión es exitosa, se muestra un mensaje en consola indicando que se ha
     * establecido correctamente. En caso de error, se captura la excepción y se imprime
     * el detalle del fallo.</p>
     *
     * @param ip Dirección IP del servidor al que se desea conectar.
     * @param puerto Número de puerto en el que el servidor está escuchando.
     */
    public void conn(String ip, int puerto) {
        try {
            System.out.println("Conectando a " + ip + ":" + puerto);
            socket = new Socket(ip, puerto);
            System.out.println("Conexión encontrada :)");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Obtiene un {@link BufferedReader} para leer datos enviados por el cliente.
     *
     * @return flujo de entrada asociado a la conexión.
     * @throws IOException si ocurre un error al obtener el flujo.
     */
    public BufferedReader getReader() throws IOException{
        return new BufferedReader(new InputStreamReader(socket.getInputStream()));
    }

    /**
     * Obtiene un {@link PrintWriter} para enviar datos al cliente.
     *
     * @return flujo de salida asociado a la conexión.
     * @throws IOException si ocurre un error al obtener el flujo.
     */
    public PrintWriter getWriter() throws IOException{
        return new PrintWriter(socket.getOutputStream(), true);
    }
}
