package org.kami.networkService;

import java.io.PrintWriter;
/**
 * Servicio encargado de enviar datos a través de una conexión de red
 * (por ejemplo, mediante sockets).
 * <p>
 * Esta clase encapsula el uso de un {@link PrintWriter} para transmitir
 * información hacia el otro extremo de la conexión.
 * </p>
 *
 * <p>
 * Los datos se envían en formato de texto siguiendo la estructura:
 * <pre>
 *     y,velocidadY
 * </pre>
 * donde ambos valores representan enteros.
 * </p>
 *
 * <p>
 * Este servicio suele trabajar en conjunto con {@link ListenService}
 * para manejar la comunicación bidireccional.
 * </p>
 *
 * Ejemplo de uso:
 * <pre>
 * PrintWriter out = ...;
 * SendService sender = new SendService(out);
 * sender.enviar(100, 5);
 * </pre>
 *
 * @author
 */
public class SendService {
    /**
     * Flujo de salida utilizado para enviar datos.
     */
    private PrintWriter out;

    /**
     * Constructor del servicio de envío.
     *
     * @param out flujo de salida asociado a la conexión.
     */
    public SendService(PrintWriter out) {
        this.out = out;
    }

    /**
     * Envía datos al otro extremo de la conexión.
     * <p>
     * Convierte los valores recibidos en una cadena de texto
     * separada por comas y la envía a través del flujo de salida.
     * </p>
     *
     * @param y posición actual en el eje vertical.
     * @param velocidadY velocidad en el eje vertical.
     */
    public void enviar(int y, int velocidadY){
        out.println(y+","+velocidadY);
    }
}
