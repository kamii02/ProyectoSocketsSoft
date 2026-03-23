package org.kami.ballSettings.config;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Implementación de {@link IConfigReader} que lee la configuración
 * desde un archivo {@code .properties} en el classpath.
 *
 * <p>Las propiedades esperadas en el archivo son:</p>
 * <ul>
 *   <li>{@code server.port} – puerto del servidor (entero)</li>
 *   <li>{@code server.address} – dirección IP del servidor</li>
 *   <li>{@code bola.activa} – {@code true} si la bola inicia activa en este cliente</li>
 * </ul>
 *
 * <p>Si el archivo no se encuentra en el classpath, se lanza una
 * {@link RuntimeException}. Si ocurre un error de lectura, se imprime
 * un mensaje en consola y las propiedades quedan vacías.</p>
 *
 */
public class PropertiesManager implements IConfigReader {

    /** Contenedor de las propiedades cargadas desde el archivo. */
    Properties properties = new Properties();

    /**
     * Crea un {@code PropertiesManager} cargando las propiedades
     * desde el archivo especificado en el classpath.
     *
     * @param propFile nombre del archivo {@code .properties} a cargar
     *                 (por ejemplo, {@code "application.properties"})
     * @throws RuntimeException si el archivo no se encuentra en el classpath
     */
    public PropertiesManager(String propFile) {
        try (InputStream in = getClass().getClassLoader().getResourceAsStream(propFile)) {
            if (in == null) {
                throw new RuntimeException("Error:no se encontro el archivo");
            }
            properties.load(in);
        } catch (IOException e) {
            System.out.println("Error critico al ller las propiedades: " + e.getMessage());
        }
    }

    /**
     * Obtiene el puerto del servidor desde la propiedad {@code server.port}.
     *
     * @return número de puerto del servidor
     * @throws NumberFormatException si el valor de {@code server.port}
     *                               no es un entero válido
     */
    @Override
    public int getPort() {
        return Integer.parseInt(properties.getProperty("server.port"));
    }

    /**
     * Obtiene la dirección IP del servidor desde la propiedad {@code server.address}.
     *
     * @return IP del servidor en formato {@code "x.x.x.x"},
     *         o {@code null} si la propiedad no está definida
     */
    @Override
    public String getIpServer() {
        return properties.getProperty("server.address");
    }

    /**
     * Indica si la bola debe iniciar activa en este cliente,
     * leyendo la propiedad {@code bola.activa}.
     *
     * <p>Cualquier valor distinto de {@code "true"} (ignorando mayúsculas)
     * se interpreta como {@code false}.</p>
     *
     * @return {@code true} si {@code bola.activa=true} en el archivo
     *         de propiedades; {@code false} en caso contrario
     */
    @Override
    public boolean bolaActiva() {
        return Boolean.parseBoolean(properties.getProperty("bola.activa"));
    }
}