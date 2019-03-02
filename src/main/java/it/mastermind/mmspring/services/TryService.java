package it.mastermind.mmspring.services;

import it.mastermind.mmspring.models.TryModel;

import java.util.List;

public interface TryService {

    void save(int id_user, int idCombination, int n_tentativi, int pos_esatta, int num_esatto, String valori_inseriti);

    List<TryModel> getTryById_combination(Integer id_combination);

}
