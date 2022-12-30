package us.muit.fs.a4i.config;

import java.util.logging.Logger;
/**
 * Mantengo separada la l�gica de la gesti�n de configuraci�n de m�tricas e indicadores porque en el futuro van a ser bastante diferentes
 * En la versi�n actual son muy similares y por tanto el dise�o no es bueno ya que no identifica bien la reutilizaci�n
 * @author isa
 *
 */
public class Checker{
	private static Logger log = Logger.getLogger(Checker.class.getName());
		
    private MetricConfigurationI metricConf;
    private IndicatorConfigurationI indiConf;

	
	Checker(){
		this.metricConf=new MetricConfiguration();
		this.indiConf=new IndicatorConfiguration();
	}
	public MetricConfigurationI getMetricConfiguration() {
		return this.metricConf;
	} 
	public IndicatorConfigurationI getIndicatorConfiguration() {
		return this.indiConf;
	}
}


