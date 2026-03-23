/**
 * Provee las interfaces del patrón de diseño <b>Observer</b> aplicado
 * al sistema de notificación de eventos de la bola.
 *
 * <p>Este paquete define el contrato de comunicación entre la bola
 * (sujeto observado) y los componentes que reaccionan a sus cambios
 * de estado (observadores), manteniendo un bajo acoplamiento entre
 * el modelo y la vista.</p>
 *
 * <h2>Interfaces principales</h2>
 * <ul>
 *   <li>{@link org.kami.ballSettings.observer.SubjectBola} – contrato del
 *       sujeto. Define los métodos para registrar y eliminar
 *       observadores, y para emitir notificaciones de movimiento y salida.
 *       Es implementado por {@link org.kami.ballSettings.modelo.Bola}.</li>
 *   <li>{@link org.kami.ballSettings.observer.ObserverBola} – contrato del
 *       observador. Define los callbacks que se invocan cuando
 *       la bola se mueve ({@code onBolaMovida}) o sale de la pantalla
 *       ({@code onBolaSalio}). Es implementado por la vista del panel de juego.</li>
 * </ul>
 *
 * <h2>Estructura del patrón</h2>
 * <ul>
 *   <li>SubjectBola ──────▶ ObserverBola</li>
 *   <li>Bola (modelo) implementa SubjectBola</li>
 *   <li>PanelBolas (vista) implementa ObserverBola</li>
 * </ul>
 *
 * <h2>Flujo de notificación</h2>
 * <ol>
 *   <li>{@code PanelBolas} se registra como observador con
 *       {@code bola.agregarObserver(this)}.</li>
 *   <li>En cada frame, {@code Bola} llama a {@code notificarMovimiento()}
 *       → {@code PanelBolas.onBolaMovida(estado)} → se repinta la pantalla.</li>
 *   <li>Al salir por el borde derecho, {@code Bola} llama a
 *       {@code notificarSalida()} → {@code PanelBolas.onBolaSalio(estado)}
 *       → se envía la bola al otro cliente por la red.</li>
 * </ol>
 *
 * @author Juan
 * @author Emma
 * @author Cami
 * @author Manu
 */
package org.kami.ballSettings.observer;