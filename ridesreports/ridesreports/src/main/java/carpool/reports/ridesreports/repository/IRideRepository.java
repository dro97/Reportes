package carpool.reports.ridesreports.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import carpool.reports.ridesreports.model.RidesEO;

@Transactional(readOnly = true)
@Repository
public interface IRideRepository extends JpaRepository<RidesEO, Long> {
	
	
	@Query("SELECT c from RidesEO c where rideCode=:rideCode")
	RidesEO ride(String rideCode);

}
