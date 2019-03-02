package it.mastermind.mmspring.services;

public interface TryService {

    void save(int id_user, int id_master, int n_tentativi, int pos_esatta, int num_esatto, String valori_inseriti);
}
