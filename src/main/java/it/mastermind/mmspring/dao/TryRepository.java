package it.mastermind.mmspring.dao;

import it.mastermind.mmspring.models.TryModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TryRepository extends JpaRepository<TryModel, Integer> {


}
