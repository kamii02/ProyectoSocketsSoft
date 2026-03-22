package org.kami.networkService;
/**
 * Interfaz que define el comportamiento para la recepción de datos
 * provenientes de una conexión de red (por ejemplo, mediante sockets).
 * <p>
 * Esta interfaz se utiliza como un callback que se ejecuta cuando
 * se reciben datos desde un cliente o servidor remoto.
 * </p>
 *
 * <p>
 * Los datos recibidos representan el estado en el eje Y de un objeto
 * (por ejemplo, una pelota) y su velocidad en dicho eje.
 * </p>
 *
 * @author
 */
public interface IOnDataReceived {
    /**
     * Método invocado cuando se reciben datos desde la red.
     *
     * @param y posición actual en el eje vertical.
     * @param velocidadY velocidad en el eje vertical.
     */
    void onReceive(int y, int velocidadY);
}