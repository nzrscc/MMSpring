package it.mastermind.mmspring.services;

import it.mastermind.mmspring.dao.CombinationRepository;
import it.mastermind.mmspring.models.CombinationModel;
import it.mastermind.mmspring.services.utils.Checker;
import it.mastermind.mmspring.services.utils.CheckerMasterMind;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

@Service
public class CombinationServiceImpl implements CombinationService {

    @Autowired
    private CombinationRepository theCombinationRepository;

    private Checker theChecker;

    public CombinationServiceImpl(){
        theChecker=new CheckerMasterMind();
    }


    @Override
    public int save(String username)
    {
        //System.out.println("Sono in save in combservimp");
        String timestamp= new SimpleDateFormat("dd.MM.yyyy - HH.mm.ss").format(new Date());
        int [] soluzione=new int[3];
        for (int i = 0; i < soluzione.length; i++) {
            soluzione[i] = (int) (Math.random() * 10);
        } //non escono i numeri(vedi tabella try)
        CombinationModel combinationModel =new CombinationModel(username, Arrays.toString(soluzione), timestamp);
        theCombinationRepository.save(combinationModel);
        return combinationModel.getID();
    }

    @Override
    public int[] check(int[] soluzione, int[] input)
    {
        return theChecker.doCheck(soluzione,input);
    }

    @Override
    public String getSoluzioneByUsername(String username)
    {
        List<CombinationModel> lista=theCombinationRepository.getCombinationByUsername(username);
        int j=0, indice=0;
        for(int i=0; i<lista.size();i++)
        {
            if(lista.get(i).getID()>j)
            {
                j=lista.get(i).getID();
                indice=i;
            }
        }

        return lista.get(indice).getSoluzione();
    }


}
