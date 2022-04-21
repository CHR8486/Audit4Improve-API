/**
 * 
 */
package us.muit.fs.a4i.control;

import java.util.logging.Logger;

import us.muit.fs.a4i.exceptions.IndicatorException;
import us.muit.fs.a4i.exceptions.MetricException;
import us.muit.fs.a4i.exceptions.ReportNotDefinedException;
import us.muit.fs.a4i.model.entities.ReportI;
import us.muit.fs.a4i.model.remote.RemoteEnquirer;
import us.muit.fs.a4i.persistence.PersistenceManager;
import us.muit.fs.a4i.persistence.ReportFormaterI;

/**
 * @author Isabel Rom�n
 *
 */
public class ReportManager implements ReportManagerI {
	private static Logger log=Logger.getLogger(ReportManager.class.getName());
	private ReportI report;
	private PersistenceManager persister;
	private RemoteEnquirer enquirer;
	private ReportFormaterI formater;
	private IndicatorsCalculator calc;
	private String entityId;

	

	@Override
	public void setRemoteEnquirer(RemoteEnquirer remote) {
		this.enquirer=remote;

	}

	@Override
	public void setPersistenceManager(PersistenceManager persistence) {
		this.persister=persistence;

	}

	@Override
	public void setFormater(ReportFormaterI formater) {
		this.formater=formater;

	}

	@Override
	public void setIndicatorCalc(IndicatorsCalculator calc) {
		this.calc=calc;

	}

	@Override
	public void saveReport(ReportI report) {
		persister.setReport(report);
		persister.setFormater(formater);
		try {
			persister.saveReport();
		} catch (ReportNotDefinedException e) {
			log.info("No deber�a entrar aqu� porque se acaba de establecer el informe");
			e.printStackTrace();
		}
	}

	@Override
	public void save() throws ReportNotDefinedException {
		if(report!=null) {
			saveReport(report);
		}else throw new ReportNotDefinedException();
		
	}
   
	@Override
	public ReportI createReport(String entityId) {
		report=enquirer.buildReport(entityId);
		return report;
	}

	@Override
	public void deleteReport(ReportI report) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteReport() {
		// TODO Auto-generated method stub

	}

	/**
	 * Devuelve el informe que est� manejando este gestor
	 */
	@Override
	public ReportI getReport() {
		return report;
	}
    /**
     * <p>Verifica si el informe est� ya creado, si no primero lo crea</p>
     * <p>verifica si la m�trica exist�a ya, si no se a�ade</p>
     */
	@Override
	public void addMetric(String metricName) {
		if(report==null & entityId!=null) {
			createReport(entityId);
		}
		if(entityId!=null & report.getMetricByName(metricName)==null)
		{
		try {
			report.addMetric(this.enquirer.getMetric(metricName, this.entityId));
		} catch (MetricException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
		
	}
	 /**
     * <p>Verifica si el informe est� ya creado, si no primero lo crea</p>
     * <p>verifica si el indicador exist�a ya, si no se a�ade</p>
     */
	@Override
	public void addIndicator(String indicatorName) {
		if(report==null & entityId!=null) {
			createReport(entityId);
		}
		if(entityId!=null && report.getIndicatorByName(indicatorName)==null) {
		try {
			calc.calcIndicator(indicatorName, this);
		} catch (IndicatorException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
		
	}

}
