package it.mastermind.mmspring.dao;

import it.mastermind.mmspring.models.CombinationModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CombinationRepository extends JpaRepository<CombinationModel, Integer> {

    List<CombinationModel> getCombinationByUsername(String username);
}
