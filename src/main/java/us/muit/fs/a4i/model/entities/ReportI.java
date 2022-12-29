package us.muit.fs.a4i.model.entities;

import java.util.Collection;
import java.util.List;

import us.muit.fs.a4i.control.IndicatorsCalculator;
import us.muit.fs.a4i.exceptions.IndicatorException;

public interface ReportI {
	/**
	 * <p>Tipos de informes, puede necesitarse cuando los algoritmos de c�lculo de indicadores difieran seg�n el tipo de informe</p>
	 * <p>Un informe s�lo es de un tipo y no se puede modificar una vez establecido</p>
	 * 
	 */

	public static enum Type{
    	REPOSITORY,
    	DEVELOPER,
    	PROJECT,
    	ORGANIZATION
    }
	
	/**
	 * Consulta una m�trica de un informe a partir del nombre
	 * @param name Nombre de la m�trica solicitada
	 * @return M�trica solicitada
	 */
	ReportItem getMetricByName(String name);
	/**
	 * Obtiene todas las m�tricas del informe
	 * @return Colleci�n de m�tricas que contiene el informe
	 */
	Collection<ReportItem> getAllMetrics();
    /**
     * A�ade una m�trica al informe
     * @param met Nueva m�trica
     */
	void addMetric(ReportItem met);
	/**
	 * Obtiene un indicador del informe a partir del nombre del mismo
	 * @param name Nombre del indicador consultado
	 * @return El indicador
	 */

	ReportItem getIndicatorByName(String name);
	/**
	 * A�ade un indicador al informe
	 * @param ind Nuevo indicador
	 */

	void addIndicator(ReportItem ind);
	/**
	 * Calcula un indicador a partir de su nombre y lo a�ade al informe
	 * Si se basa en m�tricas que no est�n a�n incluidas en el informe las incluye
	 * @param name Nombre del indicador que se quiere calcular
	 */

	void calcIndicator(String name);

	/**
	 * Establede el identificador un�voco de la entidad a la que se refiere el informe, debe ser el identificador usado en el remoto
	 * @param id Identificador un�voco de la entidad a la que se refiere el informe en el remoto
	 */
	void setId(String id);
	
    /**
     * Obtiene el identificador de la entidad a la que se refiere el informe
     * @return Identificador un�voco de la entidad a la que se refiere el informe en el remoto
     */
	String getId();
	/**
	 * Establece la calculadora de indicadores, debe ser espec�fica para el tipo de informe
	 * @param calc calculadora a utilizar para el c�lculo de indicadores
	 * @throws IndicatorException Si el tipo de la calculadora no coincide con el tipo de informe
	 */
	void setIndicatorsCalculator(IndicatorsCalculator calc) throws IndicatorException;
	/**
	 * Calcula todos los indicadores especificados por defecto para el tipo de informe y los incluye en el informe
	 * Tambi�n incluye las m�tricas utiizadas
	 */
	void calcAllIndicators();
	/**
	 * Establece el tipo del informe, s�lo se puede establecer una vez y debe coincidir con la el tipo de la calculadora usada
	 * @param type Tipo del informe 
	 */
	void setType(ReportI.Type type);
	/**
	 * Obtiene el tipo del informe
	 * @return Tipo del informe
	 */
	ReportI.Type getType();

}