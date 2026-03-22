package org.kami.ballSettings.animacion;

import org.kami.ballSettings.config.ConfigBola;
import org.kami.ballSettings.modelo.Bola;

/**
 * Clase que se encarga de ejecutar la animación de la bola en un hilo independiente.
 * Implementa Runnable para permitir que la animación se ejecute de manera concurrente
 * sin bloquear el hilo principal de la aplicación.
 *
 * El hilo mueve la bola continuamente y controla el tiempo entre cada actualización
 * para mantener una velocidad de animación constante. Cuando la bola sale de la pantalla
 * el hilo se detiene automáticamente.
 *
 * @author Juan
 * @author Emma
 * @author Cami
 * @author Manu
 */
public class HiloAnimacion implements Runnable {

    /** Bola que será animada */
    private final Bola bola;

    /** Indica si el hilo de animación sigue ejecutándose */
    private volatile boolean corriendo;

    /**
     * Constructor que recibe la bola que será animada.
     *
     * @param bola objeto bola que se moverá en la animación
     */
    public HiloAnimacion(Bola bola) {
        this.bola      = bola;
        this.corriendo = false;
    }

    /**
     * Inicia el hilo de animación.
     * Crea un nuevo hilo que ejecuta el método run().
     */
    public void iniciar() {
        corriendo = true;
        Thread hilo = new Thread(this, "HiloAnimacion");
        hilo.setDaemon(true);
        hilo.start();
        System.out.println("[HiloAnimacion] Hilo iniciado.");
    }

    /**
     * Detiene la ejecución del hilo de animación.
     */
    public void detener() {
        corriendo = false;
    }

    /**
     * Método principal del hilo.
     * Se ejecuta en un ciclo mientras la animación esté activa.
     * En cada iteración mueve la bola y controla el tiempo entre frames.
     */
    @Override
    public void run() {
        while (corriendo) {
            long inicioFrame = System.currentTimeMillis();

            bola.mover();

            if (!bola.isActiva()) {
                corriendo = false;
                System.out.println("[HiloAnimacion] Bola fuera de pantalla. Hilo detenido.");
                break;
            }

            esperarSiguienteFrame(inicioFrame);
        }
    }

    /**
     * Espera el tiempo necesario para mantener la velocidad de animación.
     *
     * @param inicioFrame tiempo en que comenzó el frame actual
     */
    private void esperarSiguienteFrame(long inicioFrame) {
        long tiempoUsado    = System.currentTimeMillis() - inicioFrame;
        long tiempoRestante = ConfigBola.DELAY_MS - tiempoUsado;

        if (tiempoRestante > 0) {
            try {
                Thread.sleep(tiempoRestante);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                corriendo = false;
            }
        }
    }
}