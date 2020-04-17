package carpool.reports.ridesreports.service;

import java.util.List;

import carpool.reports.ridesreports.model.DataReportList;
import carpool.reports.ridesreports.model.RequestBean;


public interface EmployeeService {

	
	List<DataReportList> reporte(RequestBean request);
}
