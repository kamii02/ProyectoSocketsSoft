/**
 * Proporciona las clases necesarias para la comunicación en red
 * mediante sockets dentro de la aplicación.
 *
 * <p>
 * Este paquete implementa una arquitectura básica cliente-servidor
 * que permite el envío y recepción de datos en tiempo real.
 * Está diseñado para transmitir información relacionada con el
 * movimiento de un objeto (por ejemplo, una pelota), específicamente
 * su posición en el eje Y y su velocidad.
 * </p>
 *
 * <h2>Componentes principales</h2>
 * <ul>
 *     <li><b>Server</b>: Encargado de iniciar el servidor y aceptar conexiones entrantes.</li>
 *     <li><b>SendService</b>: Maneja el envío de datos hacia el cliente.</li>
 *     <li><b>ListenService</b>: Escucha y procesa los datos recibidos desde la red.</li>
 *     <li><b>IOnDataReceived</b>: Interfaz que define el callback para manejar los datos recibidos.</li>
 * </ul>
 *
 * <h2>Flujo de funcionamiento</h2>
 * <ol>
 *     <li>El servidor se inicia y espera una conexión.</li>
 *     <li>Una vez conectado el cliente, se obtienen los flujos de entrada y salida.</li>
 *     <li>SendService envía datos en formato: {@code y,velocidadY}.</li>
 *     <li>ListenService recibe los datos, los procesa y notifica mediante IOnDataReceived.</li>
 * </ol>
 *
 * <h2>Formato de datos</h2>
 * <p>
 * Los mensajes intercambiados siguen el formato:
 * </p>
 * <pre>
 *     y,velocidadY
 * </pre>
 * donde ambos valores son enteros.
 *
 * <h2>Consideraciones</h2>
 * <ul>
 *     <li>La comunicación es síncrona y basada en texto.</li>
 *     <li>No se incluye manejo de múltiples clientes.</li>
 *     <li>No se implementa validación avanzada de mensajes.</li>
 * </ul>
 *
 * @author
 */
package org.kami.networkService;