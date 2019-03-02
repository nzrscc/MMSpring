package it.mastermind.mmspring.services;


public interface CombinationService {

     int[] check(int[] valori_inseriti, int[] soluzione);

     int save(String username);

     String getSoluzioneByUsername(String username);

}
