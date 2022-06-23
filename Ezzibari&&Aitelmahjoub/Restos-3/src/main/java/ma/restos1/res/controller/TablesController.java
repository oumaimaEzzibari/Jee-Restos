package ma.restos1.res.controller;

import java.util.List;

import ma.restos1.res.entities.Reservation;
import ma.restos1.res.entities.utilisateur;
import ma.restos1.res.repository.ReservationRespository;
import ma.restos1.res.repository.UtilisateurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import ma.restos1.res.entities.Tables_Restos;
import ma.restos1.res.repository.TablesRepository;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class TablesController {
	@Autowired
    TablesRepository tableRepository;

     @Autowired
    ReservationRespository reservationRepository;
    @Autowired
    UtilisateurRepository userRepository;

    @GetMapping("/Accueil")
    public String Index(Model model) {
        return "accueil";
    }

    @GetMapping("/Menu")
    public String Menu(Model model) {
        return "menu";
    }

    //ContactUs
    @GetMapping("/ContactUs")
    public String Contact_Us(Model m,Integer id) {
        System.out.println("id: "+id);
        Tables_Restos tb=tableRepository.findById(id).get();

        System.out.println("name: "+tb.getName_Table());
        m.addAttribute("table_a_reserver",tb );
        return "contactus";
    }
    @PostMapping(path="/ContactUs")
    public String Contact_Us(Reservation reservation) {

        reservationRepository.save(reservation);
        return "redirect:/Nos_Tables";
    }

//AboutUs
    @GetMapping("/About_Us")
    public String AboutUs(Model model) {
        return "aboutus";
    }

    //Table
    @GetMapping("/Nos_Tables")
    public String Nos_Tables(Model model) {
        List<Tables_Restos> tabeResos=tableRepository.findAll();
        model.addAttribute("liste_Tables",tabeResos);
        return "tables";
    }
    @GetMapping(path="/Liste_table_admin")
    public String les_Tables_admin(Model model) {
        List<Tables_Restos> tabeResos=tableRepository.findAll();
        model.addAttribute("table",tabeResos);
        return "liste_table_admin";
    }



    @GetMapping(path="/delete")
    public String delete_Table(Integer id) {
        System.out.println("Table:   supprimer");
       tableRepository.deleteById(id);
        return "redirect:/Liste_table_admin";
    }
    @RequestMapping("/")

    public String index() {
        return "accueil";
    }
    //table edit
    @GetMapping("/Edit_table")
    public String edit_table(Model m,Integer id) {
        System.out.println("table: "+id);
        m.addAttribute("tables", tableRepository.findById(id).get());
        return "edit_table";
    }
    @PostMapping(path="/Edit_table")
    public String edit_table(Tables_Restos table,Integer id) {
        Tables_Restos tbn=table;
        String pt=tableRepository.findById(id).get().getPath_Table().toString();
        tableRepository.deleteById(id);
        tbn.setPath_Table(pt);
        tbn.setID_Table(id);
        tableRepository.save(tbn);
        return "redirect:/Liste_table_admin";
    }

    //Mesage

    @GetMapping(path="/Liste_Messasge")
    public String listMessage(Model model) {
        List<Reservation> reservation=reservationRepository.findAll();
        model.addAttribute("message",reservation);
        //return "liste_message";
        return "liste_msg2";
    }
    @GetMapping("/InfoMessage")
    public String message(Model m,Integer id) {
        System.out.println("message : "+id);
        m.addAttribute("message", reservationRepository.findById(id).get());
        return "message";
    }
    @PostMapping(path="/InfoMessageRep")
    public String message(Integer id,String rep) {

        System.out.println("message recu: "+id);
        System.out.println("rep recu : "+rep);

        Reservation rsv=reservationRepository.findById(id).get();
        System.out.println("table : "+rsv.getTable());
        reservationRepository.deleteById(id);
         rsv.setReponse(rep.toString());
        rsv.setID_Reservation(id);
        reservationRepository.save(rsv);
        return "redirect:/Liste_Messasge";
    }

    //

    //add Table
    @GetMapping(path="/Tables")
    public String add_table(Model model) {return "addTable";}

    @PostMapping(path="/Tables")
    public String add_table( Tables_Restos table) {
        table.setPath_Table("images/table_intra.jpg");
        tableRepository.save(table);
        return "redirect:/Liste_table_admin";
    }


    //user
    @GetMapping("/Deleteuser")
    public String Delete_User(Integer id) {
        userRepository.deleteById(id);
        return "redirect:/Liste_Utilisateur";
    }



    @GetMapping("/Inscription")
    public String Inscrire(Model model) {
        return "inscription";
    }

    @PostMapping("/Inscription")
    public String Inscrire( utilisateur user, BindingResult br) {
        if(br.hasErrors())
            return "inscription";

        userRepository.save(user);
        return "Accueil";
    }
//Admin
    @GetMapping("/Admin")
    public String Admin_Auth(Model model) {
        return "admin_authentification";
    }
    @PostMapping("/Admin")
    public String Admin_Auth( ) {
        return "Liste_table_admin";
    }


    @GetMapping("/Authentification")
    public String Client_Auth(Model model) {
        return "client_authentification";
    }
    @PostMapping("/Authentification")
    public String client_authentif() {

        return "Accueil";
    }


    @GetMapping("/Liste_Utilisateur")
    public String List_Utilisateur(Model model) {
        List<utilisateur> UserRepo=userRepository.findAll();
        model.addAttribute("liste_Users",UserRepo);
        return "utilisateurs";
    }



}
