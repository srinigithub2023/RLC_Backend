package au.com.rlc.spring.boot.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import au.com.rlc.spring.boot.models.Clients;

@Repository
public interface ClientRepository extends JpaRepository<Clients, Long> {
	
	
	//@Query("SELECT rlcc FROM RLC_CLIENTS rlcc WHERE rlcc.clientname = ?1")
	Clients findByclientname(String clientname);
	Clients findByclientabn(String clientname);
	Clients findByemial(String clientname);
}
