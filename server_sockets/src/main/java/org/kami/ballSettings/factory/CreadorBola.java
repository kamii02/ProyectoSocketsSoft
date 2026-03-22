package org.kami.ballSettings.factory;

import org.kami.ballSettings.modelo.Bola;

/**
 * Clase abstracta que define el proceso para crear objetos de tipo Bola.
 *
 * Implementa el patrón de diseño Factory Method. Las clases que hereden
 * de esta deberán implementar el método crearBola para definir cómo se
 * construye una bola específica.
 *
 * El método obtenerBola controla el proceso de creación y devuelve
 * la bola ya creada.
 *
 * @author Juan
 * @author Emma
 * @author Cami
 * @author Manu
 */
public abstract class CreadorBola {

    /**
     * Método que debe ser implementado por las subclases para definir
     * cómo se crea una instancia de Bola.
     *
     * @param anchoPantalla ancho del área donde se moverá la bola
     * @param altoPantalla alto del área donde se moverá la bola
     * @return nueva instancia de Bola
     */
    protected abstract Bola crearBola(int anchoPantalla, int altoPantalla);

    /**
     * Método que obtiene una bola utilizando el método de creación definido
     * en las subclases. También muestra en consola el estado inicial de la bola.
     *
     * @param anchoPantalla ancho del área donde se moverá la bola
     * @param altoPantalla alto del área donde se moverá la bola
     * @return objeto Bola creado
     */
    public final Bola obtenerBola(int anchoPantalla, int altoPantalla) {
        Bola bola = crearBola(anchoPantalla, altoPantalla);
        System.out.println("[CreadorBola] Bola creada: " + bola.getEstado());
        return bola;
    }
}