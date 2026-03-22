package org.kami.ballSettings.modelo;

import org.kami.ballSettings.observer.ObserverBola;
import org.kami.ballSettings.observer.SubjectBola;

import java.awt.Image;
import java.util.ArrayList;
import java.util.List;

/**
 * Clase que representa una bola que se mueve dentro de una pantalla.
 *
 * La bola se desplaza horizontalmente hacia la derecha y verticalmente según
 * su velocidad. Cuando toca los bordes superior o inferior rebota.
 * Cuando sale por el borde derecho de la pantalla se desactiva y notifica
 * a los observadores.
 *
 * Implementa el patrón Observer mediante la interfaz {@code SubjectBola},
 * permitiendo notificar a otros componentes cuando la bola se mueve
 * o cuando sale de la pantalla.
 *
 * @author Juan
 * @author Emma
 * @author Cami
 * @author Manu
 */
public class Bola implements SubjectBola {

    /** Posición horizontal actual de la bola */
    private int posX;

    /** Posición vertical actual de la bola */
    private int posY;

    /** Velocidad horizontal (siempre positiva para avanzar a la derecha) */
    private final int vx;

    /** Velocidad vertical (puede ser positiva o negativa) */
    private int vy;

    /** Tamaño (diámetro) de la bola */
    private final int tamanio;

    /** Imagen utilizada para dibujar la bola */
    private final Image imagen;

    /** Ancho de la pantalla donde se mueve la bola */
    private final int anchoPantalla;

    /** Alto de la pantalla donde se mueve la bola */
    private final int altoPantalla;

    /** Indica si la bola está activa dentro de la pantalla */
    private boolean activa;

    /** Lista de observadores que reciben eventos de la bola */
    private final List<ObserverBola> observers = new ArrayList<>();

    /**
     * Constructor de la clase Bola.
     *
     * @param posX posición inicial en X
     * @param posY posición inicial en Y
     * @param vx velocidad horizontal
     * @param vy velocidad vertical
     * @param tamanio tamaño de la bola
     * @param imagen imagen usada para representarla gráficamente
     * @param anchoPantalla ancho del área donde se mueve
     * @param altoPantalla alto del área donde se mueve
     */
    public Bola(int posX, int posY,
                int vx, int vy,
                int tamanio, Image imagen,
                int anchoPantalla, int altoPantalla) {

        this.posX          = posX;
        this.posY          = posY;
        this.vx            = Math.abs(vx);
        this.vy            = vy;
        this.tamanio       = tamanio;
        this.imagen        = imagen;
        this.anchoPantalla = anchoPantalla;
        this.altoPantalla  = altoPantalla;
        this.activa        = true;
    }

    /**
     * Actualiza la posición de la bola en cada ciclo de animación.
     * <p>
     * Realiza tres operaciones:
     * <ul>
     * <li>Desplaza la bola</li>
     * <li>Verifica rebotes verticales</li>
     * <li>Comprueba si salió de la pantalla</li>
     * </ul>
     */
    public void mover() {
        if (!activa) return;

        desplazar();
        corregirReboteVertical();
        verificarSalidaDerecha();
    }

    /**
     * Realiza el desplazamiento de la bola según su velocidad.
     */
    private void desplazar() {
        posX += vx;
        posY += vy;
    }

    /**
     * Verifica si la bola tocó el borde superior o inferior
     * y corrige su posición generando un rebote vertical.
     */
    private void corregirReboteVertical() {
        if (posY <= 0) {
            posY = 0;
            vy   = Math.abs(vy);
        } else if (posY + tamanio >= altoPantalla) {
            posY = altoPantalla - tamanio;
            vy   = -Math.abs(vy);
        }
    }

    /**
     * Verifica si la bola salió por el borde derecho de la pantalla.
     * <p>
     * Si sale, se desactiva y notifica a los observadores.
     * Si no, simplemente notifica su nuevo movimiento.
     */
    private void verificarSalidaDerecha() {
        if (posX >= anchoPantalla) {
            activa = false;
            notificarSalida();
        } else {
            notificarMovimiento();
        }
    }

    /**
     * Reinicia la bola en el lado izquierdo de la pantalla.
     *
     * @param nuevaPosY nueva posición vertical inicial
     */
    public void reiniciar(int nuevaPosY) {
        this.posX   = 0;
        this.posY   = nuevaPosY;
        this.activa = true;
    }

    /**
     * Agrega un observador que será notificado
     * cuando la bola cambie de estado.
     *
     * @param observer observador a registrar
     */
    @Override
    public void agregarObserver(ObserverBola observer) {
        if (!observers.contains(observer)) {
            observers.add(observer);
        }
    }

    /**
     * Elimina un observador de la lista de notificaciones.
     *
     * @param observer observador a eliminar
     */
    @Override
    public void eliminarObserver(ObserverBola observer) {
        observers.remove(observer);
    }

    /**
     * Notifica a todos los observadores que la bola se ha movido.
     */
    @Override
    public void notificarMovimiento() {
        EstadoBola estado = getEstado();
        new ArrayList<>(observers).forEach(obs -> obs.onBolaMovida(estado));
    }

    /**
     * Notifica a todos los observadores que la bola salió de la pantalla.
     */
    @Override
    public void notificarSalida() {
        EstadoBola estado = getEstado();
        new ArrayList<>(observers).forEach(obs -> obs.onBolaSalio(estado));
    }

    /**
     * Devuelve el estado actual de la bola.
     *
     * @return objeto con posición y tamaño de la bola
     */
    public EstadoBola getEstado() {
        return new EstadoBola(posX, posY, tamanio);
    }

    /**
     * Obtiene la imagen usada para representar la bola.
     *
     * @return imagen de la bola
     */
    public Image getImagen() {
        return imagen;
    }

    /**
     * Indica si la bola sigue activa dentro de la pantalla.
     *
     * @return true si está activa, false si ya salió
     */
    public boolean isActiva() {
        return activa;
    }
}