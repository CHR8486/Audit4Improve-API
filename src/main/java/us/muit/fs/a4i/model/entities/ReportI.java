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

	public static enum ReportType{
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
	Metric getMetricByName(String name);
	/**
	 * Obtiene todas las m�tricas del informe
	 * @return Colleci�n de m�tricas que contiene el informe
	 */
	Collection<Metric> getAllMetrics();
    /**
     * A�ade una m�trica al informe
     * @param met Nueva m�trica
     */
	void addMetric(Metric met);
	/**
	 * Obtiene un indicador del informe a partir del nombre del mismo
	 * @param name Nombre del indicador consultado
	 * @return El indicador
	 */

	Indicator getIndicatorByName(String name);
	/**
	 * A�ade un indicador al informe
	 * @param ind Nuevo indicador
	 */

	void addIndicator(Indicator ind);


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
	 * Establece el tipo del informe, s�lo se puede establecer una vez y debe coincidir con la el tipo de la calculadora usada
	 * @param type Tipo del informe 
	 */
	void setType(ReportI.ReportType type);
	/**
	 * Obtiene el tipo del informe
	 * @return Tipo del informe
	 */
	ReportI.ReportType getType();

}