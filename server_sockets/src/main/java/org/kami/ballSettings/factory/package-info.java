/**
 * Proporciona las clases encargadas de la creación de objetos relacionados
 * con la representación de la bola utilizando el patrón Factory.
 *
 * <p>
 * Este paquete encapsula la lógica de instanciación de diferentes tipos de
 * bolas, permitiendo seleccionar la implementación adecuada sin acoplar
 * el código cliente a clases concretas.
 * </p>
 *
 * <p>
 * Componentes principales:
 * <ul>
 *     <li>CreadorBola: Clase base o fábrica encargada de definir la creación de bolas.</li>
 *     <li>CreadorBolaImagen: Implementación concreta que crea bolas con representación basada en imágenes.</li>
 * </ul>
 * </p>
 *
 * <p>
 * Este diseño facilita:
 * <ul>
 *     <li>La extensión para nuevos tipos de bolas (por ejemplo, formas, colores, animaciones).</li>
 *     <li>La reutilización de la lógica de creación.</li>
 *     <li>La separación entre la lógica de creación y el uso de los objetos.</li>
 * </ul>
 * </p>
 *
 * <p>
 * El uso del patrón Factory permite que el sistema sea más flexible y
 * mantenible frente a cambios en los tipos de objetos a crear.
 * </p>
 *
 * @since 1.0
 */
package org.kami.ballSettings.factory;