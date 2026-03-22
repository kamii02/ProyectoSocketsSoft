package org.kami.ballSettings.observer;

/**
 * Interfaz que representa al sujeto observado en el patrón Observer.
 *
 * Define los métodos necesarios para registrar, eliminar y notificar
 * a los observadores sobre los cambios en el estado de la bola.
 * Las clases que implementen esta interfaz serán responsables de
 * mantener la lista de observers y enviarles actualizaciones.
 *
 * @author Juan
 * @author Emma
 * @author Cami
 * @author Manu
 */
public interface SubjectBola {

    /**
     * Registra un observer para recibir eventos de la bola.
     *
     * @param observer observador que se quiere registrar
     */
    void agregarObserver(ObserverBola observer);

    /**
     * Elimina un observer previamente registrado.
     *
     * @param observer observador que se quiere eliminar
     */
    void eliminarObserver(ObserverBola observer);

    /**
     * Notifica a todos los observers que la bola se movió.
     * Este método se ejecuta después de cada actualización de posición.
     */
    void notificarMovimiento();

    /**
     * Notifica a todos los observers que la bola salió de la pantalla.
     */
    void notificarSalida();
}