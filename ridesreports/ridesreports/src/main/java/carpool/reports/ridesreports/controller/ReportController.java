/**
 * 
 */
package carpool.reports.ridesreports.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import carpool.reports.ridesreports.model.RequestBean;
import carpool.reports.ridesreports.model.ResponseBean;
import carpool.reports.ridesreports.service.EmployeeService;
import carpool.reports.ridesreports.service.IPdfCreation;
import net.sf.jasperreports.engine.JRException;

/**
 * @author wizar
 *
 */
@Controller
@RequestMapping(value = "/carpool_report")
public class ReportController {
	
	
	
	
	@Autowired
	private IPdfCreation pdf;
	
	
	@Autowired
	private EmployeeService eservice;

	// Method to display the index page of the application.
	@RequestMapping(value ="/single_day_report",method = RequestMethod.POST)
    public ResponseEntity<?> create(@RequestBody RequestBean entrada  ){
	 
		ResponseBean respuesta = new ResponseBean();

	
		
		try {
			respuesta.setMsgError(pdf.createReportPDF(eservice.reporte(entrada),entrada));
		} catch (JRException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		respuesta.setCodeError("HI");
		
	 return ResponseEntity.ok(respuesta);
      
    }
	
	

	

	
	
}
