/**
 * 
 */
package carpool.reports.ridesreports.service;

import java.util.List;


import carpool.reports.ridesreports.model.DataReportList;
import carpool.reports.ridesreports.model.RequestBean;
import net.sf.jasperreports.engine.JRException;

/**
 * @author wizar
 *
 */
public interface IPdfCreation {

	String createReportPDF(final List<DataReportList> list,RequestBean request) throws JRException;
	
}
