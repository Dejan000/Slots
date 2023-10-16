package slots.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import slots.model.Linija;

public interface LinijeRepository extends JpaRepository<Linija,Long> {
	
	Linija findOneById(Long id);

}
