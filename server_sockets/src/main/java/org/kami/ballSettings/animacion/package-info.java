/**
 * Contiene las clases encargadas de gestionar la animación
 * de los elementos visuales de la aplicación.
 *
 * <p>
 * Este paquete se encarga de controlar la actualización periódica
 * de la lógica de movimiento, como la posición y velocidad de la bola,
 * mediante el uso de hilos de ejecución.
 * </p>
 *
 * <p>
 * Componentes principales:
 * <ul>
 *     <li>HiloAnimacion: Hilo encargado de actualizar
 *     continuamente el estado de la bola para generar el efecto de movimiento.</li>
 * </ul>
 * </p>
 *
 * <p>
 * Responsabilidades:
 * <ul>
 *     <li>Actualizar la posición de la bola en intervalos de tiempo.</li>
 *     <li>Controlar la velocidad y dirección del movimiento.</li>
 *     <li>Coordinar la animación con la vista.</li>
 * </ul>
 * </p>
 *
 * <p>
 * Este paquete trabaja en conjunto con la vista y el modelo, pero
 * debe mantener independencia de la lógica de red.
 * </p>
 *
 * @since 1.0
 */
package org.kami.ballSettings.animacion;