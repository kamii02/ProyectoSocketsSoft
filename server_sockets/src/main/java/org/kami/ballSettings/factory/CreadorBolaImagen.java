package org.kami.ballSettings.factory;

import org.kami.ballSettings.config.ConfigBola;
import org.kami.ballSettings.modelo.Bola;

import javax.imageio.ImageIO;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

/**
 * Implementación concreta del creador de bolas que utiliza una imagen
 * para representar visualmente la bola.
 *
 * Esta clase hereda de CreadorBola e implementa el método crearBola,
 * definiendo cómo se construye una bola utilizando una imagen cargada
 * desde el sistema de archivos.
 *
 * Si la imagen no puede cargarse, la bola se crea igualmente pero
 * sin imagen, permitiendo que el sistema continúe funcionando.
 *
 * @author Juan
 * @author Emma
 * @author Cami
 * @author Manu
 */
public class CreadorBolaImagen extends CreadorBola {

    /** Ruta del archivo de imagen que se utilizará para la bola */
    private final String rutaImagen;

    /**
     * Constructor que recibe la ruta de la imagen de la bola.
     *
     * @param rutaImagen ubicación del archivo de imagen
     */
    public CreadorBolaImagen(String rutaImagen) {
        this.rutaImagen = rutaImagen;
    }

    /**
     * Crea una instancia de Bola configurada con los valores definidos
     * en ConfigBola y utilizando una imagen como representación gráfica.
     *
     * @param anchoPantalla ancho del área donde se moverá la bola
     * @param altoPantalla alto del área donde se moverá la bola
     * @return nueva instancia de Bola
     */
    @Override
    protected Bola crearBola(int anchoPantalla, int altoPantalla) {
        Image imagen = cargarImagen();

        return new Bola(
                0,                              // posición inicial en X
                altoPantalla / 2,               // posición inicial en Y
                ConfigBola.VELOCIDAD_X,         // velocidad horizontal
                ConfigBola.VELOCIDAD_Y,         // velocidad vertical
                ConfigBola.TAMANIO_BOLA,        // tamaño de la bola
                imagen,                         // imagen de la bola
                anchoPantalla,
                altoPantalla
        );
    }

    /**
     * Carga la imagen desde el archivo especificado en la ruta.
     *
     * @return objeto Image si la carga fue exitosa, o null si ocurrió un error
     */
    private Image cargarImagen() {
        try {
            File archivo = new File(rutaImagen);
            if (!archivo.exists()) {
                System.err.println("[CreadorBolaImagen] Imagen no encontrada: " + rutaImagen);
                return null;
            }
            return ImageIO.read(archivo);
        } catch (IOException e) {
            System.err.println("[CreadorBolaImagen] Error al cargar imagen: " + e.getMessage());
            return null;
        }
    }
}