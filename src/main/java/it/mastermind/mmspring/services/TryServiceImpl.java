package it.mastermind.mmspring.services;

import it.mastermind.mmspring.dao.TryRepository;
import it.mastermind.mmspring.models.TryModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;

@Service
public class TryServiceImpl implements TryService {

    private TryRepository theTryRepository;

    @Autowired
    public TryServiceImpl(TryRepository theTryRepository) {
        this.theTryRepository = theTryRepository;
    }


    @Override
    public void save(int id_user, int id_master, int n_tentativi, int pos_esatta, int num_esatto, String valori_inseriti) {

        String timeStamp= new SimpleDateFormat("dd.MM.yyyy - HH.mm.ss").format(new Date());
        TryModel theTryModel = new TryModel(id_user, id_master, n_tentativi, pos_esatta, num_esatto, valori_inseriti, timeStamp);
        theTryRepository.save(theTryModel);
    }
}
