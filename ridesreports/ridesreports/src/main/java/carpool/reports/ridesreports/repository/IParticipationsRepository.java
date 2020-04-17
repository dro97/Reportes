/**
 * 
 */
package carpool.reports.ridesreports.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import carpool.reports.ridesreports.model.DataReportList;
import carpool.reports.ridesreports.model.ParticipationsEO;
import carpool.reports.ridesreports.model.RidesEO;

/**
 * @author wizar
 *
 */
@Transactional(readOnly = true)
@Repository
public interface IParticipationsRepository extends JpaRepository<ParticipationsEO, Long> {
	
	
	@Query("SELECT new  carpool.reports.ridesreports.model.DataReportList (c.nick,c.name,c.email) FROM  CarpoolUsersEO c "
			+"JOIN ParticipationsEO d ON c.id = d.users.id  WHERE  d.rides = :ride")
	List<DataReportList> listado(RidesEO ride);

}
