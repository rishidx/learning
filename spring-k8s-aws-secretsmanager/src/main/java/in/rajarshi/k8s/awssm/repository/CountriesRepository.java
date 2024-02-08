package in.rajarshi.k8s.awssm.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import in.rajarshi.k8s.awssm.model.Countries;

@Repository
public interface CountriesRepository extends CrudRepository<Countries, Integer> {
	
}
