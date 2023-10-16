package slots.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import slots.model.Slot;

@Repository
public interface SlotRepository extends JpaRepository<Slot,Long> {
	
	public Slot findOneById(Long id);

}
