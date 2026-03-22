/**
 * Proporciona las clases necesarias para la comunicación desde el cliente
 * hacia un servidor mediante sockets.
 *
 * <p>
 * Este paquete implementa la lógica de conexión a un servidor remoto
 * utilizando su dirección IP y puerto, permitiendo el envío y recepción
 * de datos en tiempo real.
 * </p>
 *
 * <h2>Responsabilidad del cliente</h2>
 * <ul>
 *     <li>Establecer conexión con el servidor.</li>
 *     <li>Enviar datos del estado local (por ejemplo, posición de la pelota).</li>
 *     <li>Recibir datos del servidor para sincronización.</li>
 * </ul>
 *
 * <h2>Componentes principales</h2>
 * <ul>
 *     <li><b>Client</b>: Se encarga de conectarse al servidor mediante IP y puerto.</li>
 *     <li><b>SendService</b>: Envía datos hacia el servidor.</li>
 *     <li><b>ListenService</b>: Escucha los datos provenientes del servidor.</li>
 *     <li><b>IOnDataReceived</b>: Define el callback para manejar los datos recibidos.</li>
 * </ul>
 *
 * <h2>Flujo de funcionamiento</h2>
 * <ol>
 *     <li>El cliente intenta conectarse al servidor usando su IP.</li>
 *     <li>Una vez conectado, obtiene los flujos de entrada y salida.</li>
 *     <li>SendService envía datos en formato: {@code y,velocidadY}.</li>
 *     <li>ListenService recibe los datos y los procesa.</li>
 *     <li>Se notifica a través de IOnDataReceived para actualizar la lógica local.</li>
 * </ol>
 *
 * <h2>Formato de datos</h2>
 * <pre>
 *     y,velocidadY
 * </pre>
 * donde ambos valores son enteros.
 *
 * <h2>Consideraciones</h2>
 * <ul>
 *     <li>La comunicación depende de la disponibilidad del servidor.</li>
 *     <li>No se implementa reconexión automática.</li>
 *     <li>No hay validación avanzada de errores en los mensajes.</li>
 * </ul>
 *
 * @author Camila Prada
 */
package org.kami.networkService;