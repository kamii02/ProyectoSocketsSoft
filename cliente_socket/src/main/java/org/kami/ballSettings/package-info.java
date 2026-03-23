/**
 * Paquete raíz que agrupa todos los módulos relacionados con el
 * comportamiento, configuración y visualización de la bola en la
 * aplicación de juego en red.
 *
 * <p>Cada subpaquete tiene una responsabilidad bien definida,
 * siguiendo los principios de separación de capas y bajo acoplamiento:</p>
 *
 * <ul>
 *   <li>{@code animacion} – hilo encargado de actualizar la posición
 *       de la bola a una tasa constante de frames por segundo.</li>
 *   <li>{@code config} – lectura de parámetros de configuración desde
 *       archivos {@code .properties} y constantes globales de la bola.</li>
 *   <li>{@code factory} – creación de instancias de la bola mediante
 *       el patrón de diseño <b>Factory Method</b>.</li>
 *   <li>{@code modelo} – lógica de dominio: movimiento, rebotes y
 *       ciclo de vida de la bola.</li>
 *   <li>{@code observer} – contratos del patrón <b>Observer</b> para
 *       notificar cambios de estado entre el modelo y la vista.</li>
 *   <li>{@code vista} – componentes Swing que renderizan la animación
 *       y gestionan la comunicación con la red al salir o recibir la bola.</li>
 * </ul>
 *
 * @author Juan
 * @author Emma
 * @author Cami
 * @author Manu
 */
package org.kami.ballSettings;