package org.kami.ballSettings.observer;

import org.kami.ballSettings.modelo.EstadoBola;

/**
 * Interfaz que define el comportamiento de los observadores de la bola.
 *
 * Forma parte del patrón de diseño Observer. Las clases que implementen
 * esta interfaz recibirán notificaciones cuando la bola cambie de estado,
 * por ejemplo cuando se mueva o cuando salga de la pantalla.
 *
 * @author Juan
 * @author Emma
 * @author Cami
 * @author Manu
 */
public interface ObserverBola {

    /**
     * Método que se ejecuta cuando la bola cambia de posición.
     *
     * @param estado estado actual de la bola
     */
    void onBolaMovida(EstadoBola estado);

    /**
     * Método que se ejecuta cuando la bola sale de la pantalla.
     *
     * @param estado estado final de la bola
     */
    void onBolaSalio(EstadoBola estado);
}