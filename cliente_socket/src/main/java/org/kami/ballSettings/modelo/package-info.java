/**
 * Provee las clases que representan el modelo de dominio de la bola
 * dentro de la aplicación de juego en red.
 *
 * <p>Este paquete contiene la lógica central del movimiento, rebote y
 * ciclo de vida de la bola, así como el objeto de valor que transporta
 * su estado hacia otros componentes del sistema.</p>
 *
 * <h2>Clases principales</h2>
 * <ul>
 *   <li>{@link org.kami.ballSettings.modelo.Bola} – entidad principal del juego.
 *       Gestiona el movimiento, los rebotes verticales y la detección de salida
 *       por el borde derecho. Implementa el patrón <b>Observer</b> como sujeto,
 *       notificando a sus observadores cuando se mueve o cuando sale de la pantalla.</li>
 *   <li>{@link org.kami.ballSettings.modelo.EstadoBola} – instantánea inmutable
 *       de la posición y tamaño de la bola en un momento dado. Se utiliza como
 *       objeto de transferencia (<em>Value Object</em>) entre la bola y sus
 *       observadores, garantizando que el estado no pueda modificarse
 *       accidentalmente una vez creado.</li>
 * </ul>
 *
 * <h2>Ciclo de vida de la bola</h2>
 * <ol>
 *   <li>La bola se crea activa en el borde izquierdo de la pantalla.</li>
 *   <li>En cada frame, {@code mover()} actualiza su posición y notifica observadores.</li>
 *   <li>Al salir por el borde derecho, se desactiva y notifica {@code onBolaSalio}.</li>
 *   <li>El otro cliente recibe la bola y llama a {@code reiniciar()} para reactivarla.</li>
 * </ol>
 *
 * @author Juan
 * @author Emma
 * @author Cami
 * @author Manu
 */
package org.kami.ballSettings.modelo;