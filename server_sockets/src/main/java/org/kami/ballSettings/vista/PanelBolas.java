package org.kami.ballSettings.vista;

import org.kami.ballSettings.animacion.HiloAnimacion;
import org.kami.ballSettings.config.ConfigBola;
import org.kami.ballSettings.factory.CreadorBola;
import org.kami.ballSettings.factory.CreadorBolaImagen;
import org.kami.ballSettings.modelo.Bola;
import org.kami.ballSettings.modelo.EstadoBola;
import org.kami.ballSettings.observer.ObserverBola;

import javax.swing.JPanel;
import java.awt.*;

/**
 * Panel gráfico encargado de mostrar la bola en pantalla.
 *
 * Esta clase forma parte de la capa de vista del programa y utiliza Swing
 * para dibujar la animación. Implementa ObserverBola para recibir
 * actualizaciones cuando la bola cambia de posición o sale de la pantalla.
 *
 * Cada vez que el estado de la bola cambia, el panel actualiza su estado
 * interno y solicita a Swing que repinte el componente.
 *
 * @author Juan
 * @author Emma
 * @author Cami
 * @author Manu
 */
public class PanelBolas extends JPanel implements ObserverBola {

    /** Bola que se mostrará en el panel */
    private Bola bola;

    /** Estado actual de la bola utilizado para dibujarla */
    private volatile EstadoBola estadoActual;

    /**
     * Constructor del panel. Inicializa el tamaño, color de fondo,
     * crea la bola utilizando una fábrica y arranca el hilo de animación.
     */
    public PanelBolas() {
        setPreferredSize(new Dimension(ConfigBola.ANCHO_PANEL, ConfigBola.ALTO_PANEL));
        setBackground(new Color(0x52, 0x00, 0x80));

        CreadorBola creador = new CreadorBolaImagen(ConfigBola.RUTA_IMAGEN);
        this.bola = creador.obtenerBola(ConfigBola.ANCHO_PANEL, ConfigBola.ALTO_PANEL);

        this.bola.agregarObserver(this);
        this.estadoActual = bola.getEstado();

        new HiloAnimacion(bola).iniciar();
    }

    /**
     * Método llamado cuando la bola se mueve.
     * Actualiza el estado y solicita repintar el panel.
     *
     * @param estado estado actualizado de la bola
     */
    @Override
    public void onBolaMovida(EstadoBola estado) {
        this.estadoActual = estado;
        repaint();
    }

    /**
     * Método llamado cuando la bola sale de la pantalla.
     * Muestra el último estado de la bola y registra el evento.
     *
     * @param estado estado final de la bola
     */
    @Override
    public void onBolaSalio(EstadoBola estado) {
        this.estadoActual = estado;
        repaint();
        System.out.println("[PanelBolas] Bola salió → " + estado
                + " | TCP enviaría esto a la otra pantalla.");
    }

    /**
     * Método de Swing encargado de dibujar el contenido del panel.
     *
     * @param g objeto Graphics utilizado para realizar el dibujo
     */
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        if (bola == null || estadoActual == null) return;
        if (!bola.isActiva()) return;

        Graphics2D g2d = (Graphics2D) g;
        aplicarCalidadRenderizado(g2d);
        dibujarBola(g2d);
    }

    /**
     * Configura opciones de renderizado para mejorar la calidad del dibujo.
     *
     * @param g2d objeto Graphics2D usado para renderizar la imagen
     */
    private void aplicarCalidadRenderizado(Graphics2D g2d) {
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.setRenderingHint(RenderingHints.KEY_RENDERING,
                RenderingHints.VALUE_RENDER_QUALITY);
        g2d.setRenderingHint(RenderingHints.KEY_INTERPOLATION,
                RenderingHints.VALUE_INTERPOLATION_BILINEAR);
    }

    /**
     * Dibuja la bola en el panel usando su estado actual.
     * Si la imagen no está disponible, se dibuja un círculo como respaldo.
     *
     * @param g2d objeto Graphics2D utilizado para dibujar
     */
    private void dibujarBola(Graphics2D g2d) {
        int x   = estadoActual.getPosX();
        int y   = estadoActual.getPosY();
        int tam = estadoActual.getTamanio();

        if (bola.getImagen() != null) {
            g2d.drawImage(bola.getImagen(), x, y, tam, tam, this);
        } else {
            g2d.setColor(Color.WHITE);
            g2d.fillOval(x, y, tam, tam);
            g2d.setColor(Color.LIGHT_GRAY);
            g2d.drawOval(x, y, tam, tam);
        }
    }
}