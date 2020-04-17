package carpool.reports.ridesreports.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import carpool.reports.ridesreports.model.CarpoolUsersEO;

@Transactional(readOnly = true)
@Repository
public interface IUsuarioRepository extends JpaRepository<CarpoolUsersEO, Long>{
	
	
	@Query("SELECT c from  CarpoolUsersEO c where c.userCode =:userCode")
	CarpoolUsersEO getNick(@Param(value = "userCode") String userCode);

}
