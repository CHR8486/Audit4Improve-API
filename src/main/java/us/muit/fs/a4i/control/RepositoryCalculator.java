/**
 * 
 */
package us.muit.fs.a4i.control;

import java.util.logging.Logger;

import us.muit.fs.a4i.exceptions.IndicatorException;
import us.muit.fs.a4i.model.entities.Indicator;
import us.muit.fs.a4i.model.entities.Indicator.IndicatorBuilder;
import us.muit.fs.a4i.model.entities.ReportI;

/**
 * <p>Implementa los m�todos para calcular indicadores referidos a un repositorio repositorio</p>
 * <p>Puede hacerse uno a uno o todos a la vez</p>
 * @author Isabel Rom�n
 *
 */
public class RepositoryCalculator implements IndicatorsCalculator {
	private static Logger log=Logger.getLogger(RepositoryCalculator.class.getName());
	/**
	 * <p>Elije el algoritmo para calcular el indicador</p>
	 * @throws IndicatorException 
	 */
	@Override
	public void calcIndicator(String name, ReportManagerI reportManager) throws IndicatorException {
		log.info("Elige algoritmo para el indicador de nombre "+name);
		switch(name) {
		case "additionsRatio": additionsRatio(reportManager);
		break;
		default: throw (new IndicatorException("Indicador desconocido"));
		}
		
		
		
	}
/**
 * Calcula todos los indicadores definidos para un repositorio
 * Recupera todas las m�tricas que necesite y que no est�n en el informe y las a�ade al mismo * 
 * 
 */
	@Override
	public void calcAllIndicators(ReportManagerI reportManager) {
		log.info("Calcula todos los indicadores del repositorio y los incluye en el informe");
	}
  
	@Override
	public ReportI.ReportType getReportType() {
		return ReportI.ReportType.REPOSITORY;
	}
	/**
	 * El algoritmo para cada indicador: Tiene que mirar si est�n ya las m�tricas que necesita
	 * Si est�n lo calcula
	 * Si no est�n busca las m�tricas, las a�ade y lo calcula
	 * 
	 */
	  private void additionsRatio(ReportManagerI reportManager) {
	    	Indicator<Double> indicator=null;
	    	if(reportManager.getReport().getMetricByName("totalAdditions")==null){
	    		reportManager.addMetric("totalAdditions");	
	    	}
	    	if(reportManager.getReport().getMetricByName("totalDeletions")==null){
	    		reportManager.addMetric("totalDeletions");	
	    	}
	    	int add=(Integer) reportManager.getReport().getMetricByName("totalAdditions").getValue();
	    	int del=(Integer) reportManager.getReport().getMetricByName("totalDeletions").getValue();
	        double indicatorValue= add/(add+del);
	        IndicatorBuilder<Double> builder= new IndicatorBuilder<Double>("additionsRatio", indicatorValue).source("calculated").description("ratio additions/total changes");
	        indicator=builder.build();
	        reportManager.getReport().addIndicator(indicator);
	    	
	    }
}
