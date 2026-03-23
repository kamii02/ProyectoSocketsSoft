/**
 * Provee los componentes gráficos de la capa de vista de la aplicación,
 * responsables de mostrar la animación de la bola en pantalla mediante Swing.
 *
 * <p>Este paquete actúa como la capa de presentación del sistema,
 * recibiendo actualizaciones del modelo a través del patrón Observer
 * y reflejándolas visualmente en tiempo real.</p>
 *
 * <h2>Clases principales</h2>
 * <ul>
 *   <li>{@link org.kami.ballSettings.vista.PanelBolas} – panel Swing que
 *       dibuja la bola en cada frame. Implementa
 *       {@link org.kami.ballSettings.observer.ObserverBola} para recibir
 *       notificaciones de movimiento y salida. Cuando la bola sale, envía
 *       su estado al servidor mediante {@link org.kami.networkService.SendService}.
 *       Cuando la recibe desde la red, la reinicia y lanza un nuevo hilo
 *       de animación.</li>
 *   <li>{@link org.kami.ballSettings.vista.VentanaBolas} – ventana principal
 *       {@code JFrame} que contiene y muestra el {@code PanelBolas}. Configura
 *       el título, tamaño, posición y comportamiento al cierre de la ventana.</li>
 * </ul>
 *
 * <h2>Flujo de la vista</h2>
 * <ol>
 *   <li>{@code VentanaBolas} recibe un {@code PanelBolas} ya construido y lo
 *       agrega a la ventana.</li>
 *   <li>{@code PanelBolas} recibe notificaciones de {@code Bola} vía Observer
 *       y llama a {@code repaint()} para actualizar la pantalla.</li>
 *   <li>Al salir la bola, {@code PanelBolas} delega el envío de datos en
 *       {@code SendService} y deja de dibujar hasta recibir la bola de vuelta.</li>
 *   <li>Al recibir la bola por red, {@code recibirBola(y, vy)} reinicia el
 *       modelo y arranca un nuevo {@code HiloAnimacion}.</li>
 * </ol>
 *
 * @author Juan
 * @author Emma
 * @author Cami
 * @author Manu
 */
package org.kami.ballSettings.vista;