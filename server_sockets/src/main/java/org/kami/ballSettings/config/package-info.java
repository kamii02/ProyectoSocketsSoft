/**
 * Proporciona las clases e interfaces necesarias para la gestión de la configuración
 * de la aplicación.
 *
 * <p>
 * Este paquete define el contrato y las implementaciones encargadas de obtener
 * parámetros de configuración desde diferentes fuentes, como archivos de propiedades.
 * </p>
 *
 * <p>
 * Componentes principales:
 * <ul>
 *     <li>IConfigReader: Define el contrato para la lectura de configuración.</li>
 *     <li>PropertiesManager: Implementación que obtiene los valores desde un archivo .properties.</li>
 *     <li>configBola: Clase encargada de gestionar configuraciones específicas relacionadas con la bola.</li>
 * </ul>
 * </p>
 *
 * <p>
 * Las configuraciones actuales incluyen:
 * <ul>
 *     <li>Puerto del servidor.</li>
 *     <li>Estado inicial de la bola (activa o inactiva).</li>
 * </ul>
 * </p>
 *
 * <p>
 * Este paquete permite desacoplar la lógica de configuración del resto del sistema,
 * facilitando la extensibilidad y el mantenimiento.
 * </p>
 *
 * @since 1.0
 */
package org.kami.ballSettings.config;