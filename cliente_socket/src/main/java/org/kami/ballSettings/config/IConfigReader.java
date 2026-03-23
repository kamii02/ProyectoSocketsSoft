package org.kami.ballSettings.config;

/**
 * Contrato para la lectura de configuración de la aplicación.
 *
 * <p>Define los parámetros mínimos que cualquier fuente de configuración
 * debe proveer para que el cliente pueda conectarse al servidor y
 * determinar su rol en el juego (si la bola inicia activa o no).</p>
 *
 * <p>Las implementaciones pueden leer la configuración desde distintas
 * fuentes, como archivos {@code .properties}, variables de entorno,
 * bases de datos, etc.</p>
 */
public interface IConfigReader {

    /**
     * Obtiene el puerto en el que el servidor está escuchando.
     *
     * @return número de puerto del servidor
     */
    int getPort();

    /**
     * Obtiene la dirección IP del servidor al que el cliente debe conectarse.
     *
     * @return IP del servidor en formato {@code "x.x.x.x"}
     */
    String getIpServer();

    /**
     * Indica si la bola debe iniciar activa en este cliente.
     *
     * <p>Cuando es {@code true}, este cliente es el dueño inicial de la bola
     * y arranca su animación. Cuando es {@code false}, el cliente espera
     * recibirla desde el otro extremo de la conexión.</p>
     *
     * @return {@code true} si la bola comienza activa en este cliente;
     *         {@code false} en caso contrario
     */
    boolean bolaActiva();
}