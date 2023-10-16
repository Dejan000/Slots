package slots.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import slots.model.Znak;

@Repository
public interface ZnakRepository extends JpaRepository<Znak,Long> {
	
	public Znak findOneById(Long id);
	
	@Query("SELECT z FROM Znak z WHERE"+
	"(z.slot.id = :slot_id)"
			)
	List<Znak> getZnakovi(@Param("slot_id") Long slotId);
	
	Znak findOneByOznaka(String oznaka);

}
