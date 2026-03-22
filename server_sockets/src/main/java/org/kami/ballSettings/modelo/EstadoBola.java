package org.kami.ballSettings.modelo;

/**
 * Representa una instantánea inmutable del estado de una bola.
 *
 * Esta clase se utiliza para transportar la información de posición
 * y tamaño de la bola hacia otros componentes del sistema, como los
 * observadores del patrón Observer.</p>
 *
 * Al ser inmutable (sus atributos son {@code final} y no tienen setters),
 * garantiza que el estado de la bola no pueda modificarse accidentalmente
 * después de ser creado.
 *
 * única responsabilidad es almacenar y proporcionar información
 * sobre la posición actual de la bola.
 *
 * @author Juan
 * @author Emma
 * @author Cami
 * @author Manu
 */
public final class EstadoBola {

    /** Posición horizontal actual de la bola */
    private final int posX;

    /** Posición vertical actual de la bola */
    private final int posY;

    /** Tamaño (diámetro) de la bola en píxeles */
    private final int tamanio;

    /**
     * Crea un nuevo objeto que representa el estado actual de la bola.
     *
     * @param posX posición horizontal de la bola
     * @param posY posición vertical de la bola
     * @param tamanio tamaño de la bola en píxeles
     */
    public EstadoBola(int posX, int posY, int tamanio) {
        this.posX    = posX;
        this.posY    = posY;
        this.tamanio = tamanio;
    }

    /**
     * Obtiene la posición horizontal de la bola.
     *
     * @return posición en el eje X
     */
    public int getPosX() {
        return posX;
    }

    /**
     * Obtiene la posición vertical de la bola.
     *
     * @return posición en el eje Y
     */
    public int getPosY() {
        return posY;
    }

    /**
     * Obtiene el tamaño de la bola.
     *
     * @return tamaño (ancho y alto) en píxeles
     */
    public int getTamanio() {
        return tamanio;
    }

    /**
     * Indica si la bola ha salido por el borde derecho de la pantalla.
     *
     * @param anchoPantalla ancho del área donde se mueve la bola
     * @return {@code true} si la posición X de la bola es mayor o igual
     * al ancho de la pantalla
     */
    public boolean salio(int anchoPantalla) {
        return posX >= anchoPantalla;
    }

    /**
     * Devuelve una representación en texto del estado de la bola.
     *
     * @return cadena con la posición y tamaño de la bola
     */
    @Override
    public String toString() {
        return "EstadoBola{x=" + posX + ", y=" + posY + ", tam=" + tamanio + "}";
    }
}