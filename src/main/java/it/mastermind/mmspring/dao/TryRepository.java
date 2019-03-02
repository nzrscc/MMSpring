package it.mastermind.mmspring.dao;

import it.mastermind.mmspring.models.TryModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public interface TryRepository extends JpaRepository<TryModel, Integer> {

    List<TryModel> getTryModelsByIdCombination(Integer id_combination);

}
