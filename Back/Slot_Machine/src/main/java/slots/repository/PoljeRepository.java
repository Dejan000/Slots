package slots.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import slots.model.Polje;

public interface PoljeRepository extends JpaRepository<Polje,Long> {
	
	Polje findOneById(Long id);

}
