package carpool.reports.ridesreports.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.javafaker.Faker;

import carpool.reports.ridesreports.model.DataReportList;
import carpool.reports.ridesreports.model.RequestBean;
import carpool.reports.ridesreports.repository.IParticipationsRepository;
import carpool.reports.ridesreports.repository.IRideRepository;




@Service
public class EmployeeServiceImpl implements EmployeeService {

	final Faker faker = new Faker();
	final Random random = new Random();
	@Autowired
	private IParticipationsRepository partRepo;

	@Autowired
	private IRideRepository rideRepo;

	@Override
	public List<DataReportList> reporte(RequestBean request) {
		
		List<DataReportList> lista =  new ArrayList<>();
		
		lista = partRepo.listado(rideRepo.ride(request.getRideCode()));
		
		return lista;
		
	}
	
	
	
	
	
	
	
	
	
	
}
