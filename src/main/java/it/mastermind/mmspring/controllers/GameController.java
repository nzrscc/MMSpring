package it.mastermind.mmspring.controllers;

import it.mastermind.mmspring.services.CombinationService;
import it.mastermind.mmspring.services.TryService;
import it.mastermind.mmspring.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.Arrays;

@Controller
public class GameController {

    @Autowired
    private CombinationService combinationService;

    @Autowired
    private UserService userService;

    @Autowired
    private TryService tryService;

    public GameController(){    }

    @PostMapping("/controllo")
    public ModelAndView controllo(Integer numero1, Integer numero2, Integer numero3, HttpSession session)
    {
        ModelAndView modelAndView=new ModelAndView();
        int numTentativi= (int) session.getAttribute("nTentativi");
        //MmspringApplication.getLogger().info("numTentativi= "+ numTentativi);
        int [] valori_inseriti = {numero1, numero2, numero3}, soluzioneV, esatto=new int[2];
        String username=userService.getUsernameById((Integer) session.getAttribute("idCurrentUser"));
        if(numTentativi==1)
        {
            session.setAttribute("idCombination", combinationService.save(username));
        }
        String soluzione=combinationService.getSoluzioneByUsername(username);
        session.setAttribute("soluzione", soluzione);
        //MmspringApplication.getLogger().info("Soluzione: "+soluzione);
        String[] items = soluzione.replaceAll("\\[", "").replaceAll("\\]", "").replaceAll("\\s", "").split(",");
        soluzioneV = new int[items.length];
        for (int i = 0; i < items.length; i++) {
            try {
                soluzioneV[i] = Integer.parseInt(items[i]);
            } catch (NumberFormatException nfe) {
                nfe.printStackTrace();
            }
        }
        esatto=combinationService.check(valori_inseriti,soluzioneV);
        modelAndView.addObject("currentResult", esatto);
        modelAndView.addObject("posizioneEsatta", esatto[0]);
        modelAndView.addObject("numeroEsatto", esatto[1]);
        tryService.save((Integer) session.getAttribute("idCurrentUser"), (Integer) session.getAttribute("idCombination"), numTentativi, esatto[0], esatto[1], Arrays.toString(valori_inseriti));
        session.setAttribute("nTentativo", 5-numTentativi);
        numTentativi=numTentativi+1;
        //MmspringApplication.getLogger().info("Dopo il +1, numTentativi: " + numTentativi);
        session.setAttribute("nTentativi", numTentativi);
        if(numTentativi>1)
        {
            session.setAttribute("start", 1);
            session.setAttribute("classificaTry",tryService.getTryById_combination((Integer) session.getAttribute("idCombination")));
        }
        if(numTentativi<6)
        {
            modelAndView.setViewName("game");
        }else
        {
            modelAndView.setViewName("risultato");
        }
        return modelAndView;
    }

    @GetMapping ("/risultato")
    public ModelAndView getClassificaRisultato(HttpSession session)
    {
        session.setAttribute("classificaTry",tryService.getTryById_combination((Integer) session.getAttribute("idCombination")));
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("risultato");
        return  modelAndView;
    }


}
