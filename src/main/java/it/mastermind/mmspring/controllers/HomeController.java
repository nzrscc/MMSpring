package it.mastermind.mmspring.controllers;

import it.mastermind.mmspring.models.UserModel;
import it.mastermind.mmspring.services.UserService;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.security.NoSuchAlgorithmException;
import java.util.Enumeration;


@Controller
public class HomeController {

    @Autowired
    private UserService userService;

    public HomeController()  {    }

    @RequestMapping("/")
    public String home(HttpSession session)  {

//        session.removeAttribute("nTentativi");
//        session.removeAttribute("soluzione");
//        session.removeAttribute("idCombination");
//        session.removeAttribute("start");
//        session.removeAttribute("idCurrentUser");
//        session.removeAttribute("nTentativo");
//        session.removeAttribute("classificaTry");
//        session.removeAttribute("username");

        return "home";
    }

    @RequestMapping("/scelta") //action
    public ModelAndView scelta(String scelta) //fare lo switch (vedere con ENum)
    {
        ModelAndView modelAndView = new ModelAndView();
        if (scelta.equals("MasterMind")) {
            modelAndView.setViewName("logIn"); //nome jsp
        }else if(scelta.equals("Classifica UserModel")){
            //setta classifica user
        }else if(scelta.equals("Classifica Tentativi")) {
            //setta classifica tentativi
        }

        return modelAndView;
    }

    @Scope("session")
    @PostMapping("/logIn")
    public ModelAndView logIn(@ModelAttribute("currentUser") UserModel user, HttpSession session)
    {
//        Enumeration e = session.getAttributeNames();
//        while ( e.hasMoreElements() ){
//            String key = (String)e.nextElement();
//            MmspringApplication.getLogger().info( key + " = " + session.getAttribute( key ) + " <br>" );
//        }
//
//        MmspringApplication.getLogger().info("metodo logIn chiamato");
//        MmspringApplication.getLogger().info("Username: "+user.getUsername()+"\tPasswd: "+user.getPassword());

        ModelAndView modelAndView = new ModelAndView();
        String passwdCrypt="";
        try{
            passwdCrypt=cifraPassword(user.getPassword());
        }catch (NoSuchAlgorithmException nsae)
        {
            nsae.printStackTrace();
        }
        if(userService.existsByUsernameAndPassword(user.getUsername(), passwdCrypt))
        {
            int idCurrentUser = userService.getIdByUsername(user.getUsername());
            //MmspringApplication.getLogger().info("In existByUsernameAndPassword, user: "+user.getUsername() + "\tidCurrentUser: " + idCurrentUser);
            session.setAttribute("idCurrentUser", idCurrentUser);
            session.setAttribute("username", user.getUsername());
//            modelAndView.addObject("nTentativi", 1);
//            modelAndView.addObject("nTentativo", 5);
            session.setAttribute("nTentativi", 1);
            session.setAttribute("nTentativo", 5);
            modelAndView.setViewName("game");
            return modelAndView;
        }else
        {
            modelAndView.addObject("logInRiprova", "si");
            modelAndView.setViewName("logIn");
            return modelAndView;
        }
    }

    @PostMapping("/registrati")
    public ModelAndView registrati()
    {
        //MmspringApplication.getLogger().info("Vado in registrati");
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("registrati");
        return modelAndView;
    }

    @PostMapping("/registrazione")
    public ModelAndView registrazione(@ModelAttribute("currentUser") UserModel user)
    {
        //MmspringApplication.getLogger().info("Sono in registrazione");
        ModelAndView modelAndView = new ModelAndView();
        if(userService.existsByUsername(user.getUsername()))
        {
            modelAndView.addObject("provaRegistrazione", "si");
            modelAndView.setViewName("registrati");
            return modelAndView;
        }else
        {
            try{
                String passwordCrypt = cifraPassword(user.getPassword());
                userService.save(user.getUsername(), passwordCrypt);
            }catch(NoSuchAlgorithmException nsae)
            {
                nsae.printStackTrace();
            }
            modelAndView.addObject("registrazioneTrue", "true");
            modelAndView.setViewName("logIn"); //da specificare dove si deve andare!!
            return modelAndView;
        }

    }

    private  String cifraPassword( String password ) throws NoSuchAlgorithmException {
        String passwordCrpyt = BCrypt.hashpw(password, "$2a$05$djeIcZogMlovcLVQ7i4rJ.");
        return passwordCrpyt;
    }




}
