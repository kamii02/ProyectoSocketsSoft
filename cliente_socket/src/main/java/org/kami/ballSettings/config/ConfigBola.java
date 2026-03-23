package org.kami.ballSettings.config;

/**
 * Clase de configuración que contiene las constantes utilizadas
 * para el comportamiento y la visualización de la bola en la aplicación.
 *
 * Todas las variables son constantes estáticas para que puedan ser
 * utilizadas desde cualquier parte del programa sin necesidad de crear
 * una instancia de esta clase.
 *
 * @author Juan
 * @author Emma
 * @author Cami
 * @author Manu
 */
public final class ConfigBola {

    /** Ancho del panel donde se mueve la bola */
    public static final int ANCHO_PANEL  = 1366;

    /** Alto del panel donde se mueve la bola */
    public static final int ALTO_PANEL   = 768;

    /** Tamaño de la bola en píxeles */
    public static final int TAMANIO_BOLA = 70;

    /** Velocidad horizontal de la bola */
    public static final int VELOCIDAD_X = 4;

    /** Velocidad vertical de la bola */
    public static final int VELOCIDAD_Y = 3;

    /** Cantidad de frames por segundo de la animación */
    public static final int FPS = 60;

    /** Tiempo de espera entre frames en milisegundos */
    public static final long DELAY_MS = 1000L / FPS;

    /** Ruta de la imagen utilizada para representar la bola */
    public static final String RUTA_IMAGEN = "images.png";

    /**
     * Constructor privado para evitar que la clase sea instanciada.
     */
    private ConfigBola() {
        throw new UnsupportedOperationException("Clase de utilidad, no instanciar.");
    }
}