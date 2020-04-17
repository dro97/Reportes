/**
 * 
 */
package carpool.reports.ridesreports.service;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.util.Base64;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import carpool.reports.ridesreports.model.DataReportList;
import carpool.reports.ridesreports.model.RequestBean;
import carpool.reports.ridesreports.model.RidesEO;
import carpool.reports.ridesreports.repository.IRideRepository;
import carpool.reports.ridesreports.repository.IUsuarioRepository;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.export.JRPdfExporter;
import net.sf.jasperreports.export.SimpleExporterInput;
import net.sf.jasperreports.export.SimpleOutputStreamExporterOutput;
import net.sf.jasperreports.export.SimplePdfExporterConfiguration;

/**
 * @author wizar
 *
 */
@Service
public class PdfCreation implements IPdfCreation {
	
	@Autowired 
	private IRideRepository rideRepo;
	@Autowired
	private IUsuarioRepository userRepo;
	
	@Override
	public String createReportPDF(final List<DataReportList> list,RequestBean datos) throws JRException {
		
		String data = null;
		// Fetching the .jrxml file from the resources folder.
		final InputStream stream = this.getClass().getResourceAsStream("/testReport.jrxml");

		// Compile the Jasper report from .jrxml to .japser
		final JasperReport report = JasperCompileManager.compileReport(stream);

		// Fetching the employees from the data source.
		final JRBeanCollectionDataSource source = new JRBeanCollectionDataSource(list);
		
		RidesEO ride = new RidesEO();
		ride = rideRepo.ride(datos.getRideCode());

		// Adding the additional parameters to the pdf.
		final Map<String, Object> parameters = new HashMap<>();
		parameters.put("driver", "Conductor");
				
	parameters.put("drivername", userRepo.getNick(ride.getRiderCode()).getName());
	parameters.put("nick","Nick");
	parameters.put("name","Name");
	parameters.put("email","Email");
	parameters.put("origen",ride.getOrigin());
	parameters.put("destino",ride.getDestiny());
	parameters.put("fecha",ride.getRideDate().toString());
	
	
	parameters.put("ItemDataSourcer",source);
	

		// Filling the report with the employee data and additional parameters information.
		final JasperPrint print = JasperFillManager.fillReport(report, parameters, source);

		

		JRPdfExporter exporter = new JRPdfExporter();
		exporter.setExporterInput(new SimpleExporterInput(print));

	
		
		ByteArrayOutputStream out2 = new ByteArrayOutputStream();
		exporter.setExporterOutput(new SimpleOutputStreamExporterOutput(out2));
		SimplePdfExporterConfiguration configuration = new SimplePdfExporterConfiguration();
		configuration.setMetadataAuthor("Carpool");  //why not set some config as we like
		exporter.setConfiguration(configuration);
		exporter.exportReport();
		
		data =  Base64.getEncoder().encodeToString(out2.toByteArray()); 
		
			return data;

		
	}
	
}
