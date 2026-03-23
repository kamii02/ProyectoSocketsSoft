/**
 * Paquete principal que agrupa todos los componentes relacionados
 * con la configuración, lógica, visualización y comportamiento de la bola.
 *
 * <p>
 * Este paquete actúa como módulo central del sistema, organizando
 * las diferentes capas y responsabilidades de la aplicación.
 * </p>
 *
 * <p>
 * Subpaquetes principales:
 * <ul>
 *     <li>config: Gestión de configuración de la aplicación.</li>
 *     <li>vista: Componentes de la interfaz gráfica (Swing).</li>
 *     <li>modelo: Representación del estado y lógica de la bola.</li>
 *     <li>factory: Creación de objetos relacionados con la bola.</li>
 *     <li>observer: Implementación del patrón Observer para notificación de cambios.</li>
 *     <li>animacion: Control de la animación mediante hilos.</li>
 * </ul>
 * </p>
 *
 * <p>
 * Este diseño sigue una separación de responsabilidades inspirada en
 * arquitecturas como MVC, permitiendo una mayor mantenibilidad,
 * escalabilidad y claridad en la estructura del proyecto.
 * </p>
 *
 * <p>
 * Cada subpaquete cumple una función específica y se comunica con los demás
 * de forma desacoplada, facilitando futuras extensiones del sistema.
 * </p>
 *
 * @since 1.0
 */
package org.kami.ballSettings;