package org.kami.networkService;

import java.io.BufferedReader;
/**
 * Servicio encargado de escuchar datos entrantes desde un flujo de entrada
 * asociado a una conexión de red (por ejemplo, un socket).
 * <p>
 * Esta clase ejecuta un hilo independiente que permanece en escucha continua
 * de mensajes provenientes del otro extremo de la conexión.
 * </p>
 *
 * <p>
 * Cada mensaje recibido debe tener el formato:
 * <pre>
 *     y,velocidadY
 * </pre>
 * donde ambos valores son enteros.
 * </p>
 *
 * <p>
 * Cuando se recibe un mensaje válido, se notifica al listener mediante
 * la interfaz {@link IOnDataReceived}.
 * </p>
 *
 * Ejemplo de uso:
 * <pre>
 * BufferedReader in = ...;
 * IOnDataReceived listener = ...;
 * ListenService service = new ListenService(in, listener);
 * service.start();
 * </pre>
 *
 * @author
 */
public class ListenService {
    /**
     * Flujo de entrada desde el cual se leen los datos.
     */
    private BufferedReader in;
    /**
     * Listener que será notificado cuando se reciban datos.
     */
    private IOnDataReceived listener;

    /**
     * Constructor del servicio de escucha.
     *
     * @param in flujo de entrada asociado a la conexión.
     * @param listener implementación que manejará los datos recibidos.
     */
    public ListenService(BufferedReader in, IOnDataReceived listener){
        this.listener = listener;
        this.in = in;
    }

    /**
     * Inicia el servicio de escucha en un hilo separado.
     * <p>
     * Este método crea y ejecuta un nuevo hilo que:
     * <ul>
     *     <li>Lee continuamente mensajes del flujo de entrada.</li>
     *     <li>Parsea los datos recibidos.</li>
     *     <li>Notifica al listener con los valores obtenidos.</li>
     * </ul>
     * </p>
     *
     * <p>
     * Si ocurre un error durante la lectura o el procesamiento de los datos,
     * la excepción será impresa en consola.
     * </p>
     */
    public void start(){
        new  Thread(()->{
            try{
                String message;
                while((message = in.readLine())!=null){
                    System.out.println("Recibido:" + message);

                    String[] partes = message.split(",");
                    int y = Integer.parseInt(partes[0]);
                    int velocidadY = Integer.parseInt(partes[1]);

                    listener.onReceive(y, velocidadY);
                }
            }catch(Exception e){
                e.printStackTrace();
            }
        }).start();
    }
}
