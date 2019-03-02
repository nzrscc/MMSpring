package it.mastermind.mmspring.services;

import it.mastermind.mmspring.dao.TryRepository;
import it.mastermind.mmspring.models.TryModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class TryServiceImpl implements TryService {

    @Autowired
    private TryRepository theTryRepository;

    public TryServiceImpl() {
    }


    @Override
    public void save(int id_user, int idCombination, int n_tentativi, int pos_esatta, int num_esatto, String valori_inseriti) {

        String timeStamp= new SimpleDateFormat("dd.MM.yyyy - HH.mm.ss").format(new Date());
        TryModel theTryModel = new TryModel(id_user, idCombination, n_tentativi, pos_esatta, num_esatto, valori_inseriti, timeStamp);
        theTryRepository.save(theTryModel);
    }

    @Override
    public List<TryModel> getTryById_combination(Integer id_combination)
    {
       List<TryModel> lista = theTryRepository.getTryModelsByIdCombination(id_combination);
       return lista;
    }
}
