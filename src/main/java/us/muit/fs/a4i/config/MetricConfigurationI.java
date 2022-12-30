package us.muit.fs.a4i.config;

import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.List;

/**
 * @author isa
 *
 */
public interface MetricConfigurationI {
	/**
	 * <p>
	 * Comprueba si la m�trica est� definida en el fichero por defecto o en el de la
	 * aplicaci�n cliente
	 * </p>
	 * <p>
	 * Tambi�n verifica que el tipo es el adecuado
	 * </p>
	 * 
	 * @param metricName nombre de la m�trica que se quiere comprobar
	 * @param metricType tipo de la m�trica
	 * @return metricDefinition Si la m�trica est� definida y el tipo es correcto se devuelve un mapa con las unidades y la descripci�n
	 * @throws FileNotFoundException Si no se localiza el fichero de configuraci�n
	 */
	public HashMap<String,String> definedMetric(String name,String type) throws FileNotFoundException;

	List<String> listAllMetrics() throws FileNotFoundException;
}
