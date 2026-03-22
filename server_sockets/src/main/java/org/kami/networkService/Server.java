package org.kami.networkService;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Clase que representa el servidor de red encargado de aceptar conexiones
 * entrantes desde un cliente mediante sockets.
 * <p>
 * Este servidor se inicializa en un puerto específico y queda en espera
 * hasta que un cliente se conecta. Una vez establecida la conexión,
 * permite obtener los flujos de entrada y salida para la comunicación.
 * </p>
 *
 * <p>
 * Generalmente se utiliza junto con {@link ListenService} y {@link SendService}
 * para gestionar la comunicación bidireccional.
 * </p>
 *
 * Ejemplo de uso:
 * <pre>
 * Server server = new Server();
 * server.iniciar(5000);
 *
 * BufferedReader in = server.getReader();
 * PrintWriter out = server.getWriter();
 * </pre>
 *
 * @author
 */
public class Server {
    /**
     * Socket del servidor encargado de escuchar conexiones entrantes.
     */
    private ServerSocket serverSocket;

    /**
     * Socket que representa la conexión con el cliente.
     */
    private Socket socket;

    /**
     * Inicia el servidor en el puerto especificado y espera la conexión
     * de un cliente.
     *
     * @param puerto puerto en el que el servidor escuchará conexiones.
     */
    public void iniciar(int puerto){
        try{
            serverSocket = new ServerSocket(puerto);
            System.out.println("servidor esperando coneccion...");

            socket = serverSocket.accept();
            System.out.println("cliente conectado...");
        }catch (IOException e){
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
