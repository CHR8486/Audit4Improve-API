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
	 * Consulta el tipo del informe
	 * @return tipo del informe
	 */
	ReportI.ReportType getType();
	/**
     * Obtiene el identificador de la entidad a la que se refiere el informe
     * @return Identificador un�voco de la entidad a la que se refiere el informe en el remoto
     */
	String getEntityId();
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
	 * Obtiene todos los indicadores del informe
	 * @return el conjunto de indicadores del informe
	 */
	Collection<ReportItem> getAllIndicators();

	/**
	 * A�ade un indicador al informe
	 * @param Nuevo indicador
	 */


	void addIndicator(ReportItem ind);

	/**
	 * Calcula un indicador a partir de su nombre y lo a�ade al informe
	 * Si se basa en m�tricas que no est�n a�n incluidas en el informe las incluye
	 * @param name Nombre del indicador que se quiere calcular
	 */

	




}