/**
 * Provee las clases responsables de la creación de objetos {@link org.kami.ballSettings.modelo.Bola}
 * mediante el patrón de diseño <b>Factory Method</b>.
 *
 * <p>El patrón Factory Method permite delegar la lógica de construcción de la bola
 * a subclases especializadas, desacoplando al resto del sistema de los detalles
 * concretos de instanciación. Para crear un nuevo tipo de bola basta con extender
 * {@link org.kami.ballSettings.factory.CreadorBola} e implementar
 * {@code crearBola}, sin modificar el código existente.</p>
 *
 * <h2>Clases principales</h2>
 * <ul>
 *   <li>{@link org.kami.ballSettings.factory.CreadorBola} – clase abstracta que
 *       define el contrato de creación mediante {@code crearBola} y controla
 *       el proceso con el método final {@code obtenerBola}.</li>
 *   <li>{@link org.kami.ballSettings.factory.CreadorBolaImagen} – implementación
 *       concreta que construye una bola con una imagen cargada desde el sistema
 *       de archivos. Si la imagen no existe, la bola se crea sin representación
 *       gráfica para no interrumpir el flujo de la aplicación.</li>
 * </ul>
 *
 * <h2>Ejemplo de uso</h2>
 * <pre>
 *   CreadorBola creador = new CreadorBolaImagen("images.png");
 *   Bola bola = creador.obtenerBola(anchoPantalla, altoPantalla);
 * </pre>
 *
 * <h2>Extensibilidad</h2>
 * <p>Para agregar un nuevo tipo de bola (por ejemplo, una bola de color sólido),
 * basta con crear una nueva subclase de {@code CreadorBola}:</p>
 * <pre>
 *   public class CreadorBolaColor extends CreadorBola {
 *       {@literal @}Override
 *       protected Bola crearBola(int ancho, int alto) { ... }
 *   }
 * </pre>
 *
 * @author Juan
 * @author Emma
 * @author Cami
 * @author Manu
 */
package org.kami.ballSettings.factory;