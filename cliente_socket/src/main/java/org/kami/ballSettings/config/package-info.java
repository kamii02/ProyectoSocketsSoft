/**
 * Provee las clases e interfaces responsables de la configuración
 * de la aplicación cliente del juego de bolas en red.
 *
 * <p>Este paquete centraliza todo lo relacionado con la lectura y el
 * acceso a los parámetros necesarios para iniciar la aplicación:
 * dirección del servidor, puerto de conexión, estado inicial de la bola
 * y constantes visuales del panel de juego.</p>
 *
 * <h2>Clases principales</h2>
 * <ul>
 *   <li>{@link org.kami.ballSettings.config.IConfigReader} – contrato que
 *       define los parámetros mínimos que cualquier fuente de configuración
 *       debe exponer.</li>
 *   <li>{@link org.kami.ballSettings.config.PropertiesManager} – implementación
 *       de {@code IConfigReader} que lee la configuración desde un archivo
 *       {@code .properties} en el classpath.</li>
 *   <li>{@link org.kami.ballSettings.config.ConfigBola} – clase de utilidad
 *       con las constantes estáticas que controlan el comportamiento visual
 *       y la velocidad de la bola.</li>
 * </ul>
 *
 * <h2>Archivo de propiedades esperado</h2>
 * <p>La implementación {@code PropertiesManager} requiere un archivo
 * {@code application.properties} en el classpath con las siguientes claves:</p>
 * <pre>
 *   server.address = 192.168.1.x
 *   server.port    = 5000
 *   bola.activa    = true | false
 * </pre>
 *
 * @author Juan
 * @author Emma
 * @author Cami
 * @author Manu
 */
package org.kami.ballSettings.config;