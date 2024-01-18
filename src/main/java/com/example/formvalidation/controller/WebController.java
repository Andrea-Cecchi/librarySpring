package com.example.formvalidation.controller;

import com.example.formvalidation.Dao.BookDao;
import com.example.formvalidation.Dao.ListaPubDao;
import com.example.formvalidation.Dao.UserDao;
import com.example.formvalidation.model.Book;
import com.example.formvalidation.model.ListaPub;
import com.example.formvalidation.model.User;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Controller
public class WebController {

    private ArrayList<User> users = new ArrayList<User>();
    private ArrayList<Book> books = new ArrayList<Book>();
    private Boolean authenticated = false;

    @Autowired
    private UserDao userRepository;

    @Autowired
    private BookDao bookRepository;

    @Autowired
    private ListaPubDao listaPubRepository;

    @GetMapping("/")
    public String login(User user) {return "login";}

    @PostMapping("/")
    public String checkLogin(User user, BindingResult bindingResult, HttpSession session){
        User userc = userRepository.login(user.getEmail(), user.getPassword());
        System.out.println(userc);


        if(bindingResult.hasErrors()){
            System.out.println("erroree");
            return "login";
        }else {
            if(userc != null){
                session.setAttribute("loggedUser", userc);
                return "redirect:/aggiungiLibro";
            }
            bindingResult.addError(new ObjectError("loginError","Username o password errati"));
            return "login";
        }

        //users.add(new User("Andrea","cecchi", "andrea", "123456"));
        /*if(bindingResult.hasErrors()){
            return "login";
        }else {
            if(users.stream().anyMatch(usr -> usr.getEmail().equals(user.getEmail()) && usr.getPassword().equals(user.getPassword()))){
                authenticated = true;
                return "redirect:/aggiungiLibro";
            }
            bindingResult.addError(new ObjectError("loginError","Username o password errati"));
            return "login";
        }*/

    }

    @GetMapping("/register")
    public String register(User user) {return "register";}

    @PostMapping("/register")
    public String checkRegister(@Valid User user, BindingResult bindingResult, HttpSession session){
        if(bindingResult.hasErrors()){
            return "/register";
        }else {

            if(userRepository.findByEmail(user.getEmail()) == null){
                userRepository.save(user);

                session.setAttribute("loggedUser", user);
                return "redirect:/aggiungiLibro";
            }
            return "register";
        }
    }

    @RequestMapping(value = "/listaLibri")
    public String listaLibri(Model model){
        model.addAttribute("books", bookRepository.findAll());
        model.addAttribute("authenticated", authenticated);
        return "listaLibri";
    }

    @RequestMapping(value = "/myBooks")
    public String myBooks(Model model, HttpSession session){
        User user = (User) session.getAttribute("loggedUser");

        if(user == null){
            return "redirect:/";
        }
        List<ListaPub> listePub = listaPubRepository.findByUserId(user.getId());
        List<Book> books =  new ArrayList<>();

        for (ListaPub el: listePub) {
            books.add(el.getBook());
        }

        model.addAttribute("books", books);
        model.addAttribute("authenticated", authenticated);
        return "mybooks";
    }

    @GetMapping(value = "/aggiungiLibro")
    public String aggiungiLibro(Book book, HttpSession session){
        User user = (User) session.getAttribute("loggedUser");
        if(user != null){
            return "aggiungiLibro";
        }
        return "redirect:/";
    }

    @PostMapping("/aggiungiLibro")
    public String checkLibro(@Valid Book book, BindingResult bindingResult, HttpSession session){
        User user = (User) session.getAttribute("loggedUser");
        if(bindingResult.hasErrors()){
            return "/aggiungiLibro";
        }else {
            bookRepository.save(book);
            listaPubRepository.save(new ListaPub(user,book));
            return "redirect:/listaLibri";
        }
    }

    @RequestMapping(value = "/dettaglioLibro")
    public String dettaglioLibro(@RequestParam(value = "libro", required = false) String libro, Model model){
        if (libro != null && books.size() > 0) {
            List<Book> matches = books.stream().filter(lbr -> lbr.getTitolo().equals(libro)).toList();
            model.addAttribute("libro", matches.get(0));
        }else{
            model.addAttribute("libro", new Book("", "", "", 0));
        }

        return "dettaglioLibro";
    }

    @RequestMapping(value = "/dettaglioUtente")
    public String dettaglioUtente(@RequestParam(value = "utente", required = false) String email, Model model){
        if(email != null && users.size() > 0){
            List<User> matches = users.stream().filter(usr -> usr.getEmail().equals(email)).toList();
            model.addAttribute("utente", matches.get(0));
        }else{
            model.addAttribute("utente", new User("andrea","cecchi","andrricecchi", "123456"));
        }
        return "dettaglioUtente";
    }
}
