package com.project.kino.controllers;

import com.project.kino.entities.*;
import com.project.kino.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Controller
public class MainController extends BaseController {

    @Autowired
    UserService userService;

    @Autowired
    MoviesService moviesService;

    @Autowired
    GenresService genresService;

    @Autowired
    ActorsService actorsService;

    @Autowired
    ReviewsService reviewsService;

    @GetMapping(path = "/")
    public String index(Model model) {
        List<Movies> movies = moviesService.getAllMovies();
        model.addAttribute("movies", movies);
        return "index";
    }

    @GetMapping(path = "/actors")
    public String actors(Model model) {
        List<Actors> actors = actorsService.getAllActors();
        model.addAttribute("actors", actors);
        return "actors";
    }

    @GetMapping(path = "/genres")
    public String genres(Model model) {
        List<Genres> genres = genresService.getAllGenres();
        model.addAttribute("genres", genres);
        return "genres";
    }

    @GetMapping(path = "/movie/{id}")
    public String movie(Model model, @PathVariable(name = "id") Long id) {
        Movies movie = moviesService.getMovieById(id);
        model.addAttribute("movie", movie);
        return "movie";
    }

    @PreAuthorize("isAnonymous()")
    @GetMapping(path = "/login")
    public String login(Model model) {
        return "annonymous/login";
    }

    @PreAuthorize("isAnonymous()")
    @GetMapping(path = "/register")
    public String register(Model model) {
        return "annonymous/signup";
    }

    @PreAuthorize("hasAnyRole('ROLE_ADMIN')")
    @GetMapping(path = "/adminpage")
    public String adminpage(Model model) {
        List<Users> users = userService.getAllUsers();
        System.out.println(users);
        model.addAttribute("users", users);
        return "admin/index";
    }

    @PreAuthorize("hasAnyRole('ROLE_ADMIN')")
    @PostMapping(path = "/ban")
    public String ban(Model model, @RequestParam(name = "userID") Long id) {
        Users user = userService.getUserById(id).get();
        user.setDeletedAt(new Date());
        userService.updateUser(user);
        return "admin/index";
    }

    @PreAuthorize("hasAnyRole('ROLE_ADMIN')")
    @PostMapping(path = "/unban")
    public String unban(Model model, @RequestParam(name = "userID") Long id) {
        Users user = userService.getUserById(id).get();
        user.setDeletedAt(null);
        userService.updateUser(user);
        return "admin/index";
    }

    @PreAuthorize("hasAnyRole('ROLE_ADMIN')")
    @PostMapping(path = "/deleteUser")
    public String deleteUser(Model model, @RequestParam(name = "userID") Long id) {
        Users user = userService.getUserById(id).get();
        userService.deleteUser(user);
        return "admin/index";
    }

    // Get запросы для фильмов и тд
    @PreAuthorize("hasAnyRole('ROLE_ADMIN')")
    @GetMapping(path = "/addmovie")
    public String addMovie(Model model) {
        return "admin/addmovie";
    }

    @PreAuthorize("hasAnyRole('ROLE_ADMIN')")
    @GetMapping(path = "/addactor")
    public String addActor(Model model) {
        return "admin/addactor";
    }

    @PreAuthorize("hasAnyRole('ROLE_ADMIN')")
    @GetMapping(path = "/addgenre")
    public String addGenre(Model model) {
        return "admin/addgenre";
    }

    // Post запросы для добавления
    @PreAuthorize("hasAnyRole('ROLE_ADMIN')")
    @PostMapping(path = "/add/movie")
    public String addMovieDB(Model model,
                             @RequestParam(name = "title") String title,
                             @RequestParam(name = "description") String description
    ) {
        Movies movie = new Movies();
        movie.setTitle(title);
        movie.setDescription(description);
        movie.setCreatedAt(new Date());
        moviesService.saveMovie(movie);
        return "index";
    }

    @PreAuthorize("hasAnyRole('ROLE_ADMIN')")
    @PostMapping(path = "/add/actor")
    public String addActorDB(Model model,
                             @RequestParam(name = "fullName") String fullName
    ) {
        Actors actor = new Actors();
        actor.setFullName(fullName);
        actor.setCreatedAt(new Date());
        actorsService.saveActor(actor);
        return "actors";
    }

    @PreAuthorize("hasAnyRole('ROLE_ADMIN')")
    @PostMapping(path = "/add/genre")
    public String addGenreDB(Model model,
                             @RequestParam(name = "name") String name
    ) {
        Genres genre = new Genres();
        genre.setName(name);
        genre.setCreatedAt(new Date());
        genresService.saveGenre(genre);
        return "genres";
    }

    @PreAuthorize("hasAnyRole('ROLE_ADMIN')")
    @GetMapping(path = "/adminregister")
    public String adminRegister(Model model) {
        return "annonymous/signup";
    }

    @PostMapping(path = "/signup")
    public String signup(Model model,
                         @RequestParam(name = "user_email") String email,
                         @RequestParam(name = "user_password") String password,
                         @RequestParam(name = "user_password_repeat") String repeatpassword,
                         @RequestParam(name = "user_fullName") String fullName) {
        String redirect = "redirect:/";
        if (!repeatpassword.equals(password)) {
            model.addAttribute("password_error", "Passwords do not match");
            redirect = "annonymous/signup";
        }

        Roles role_user = new Roles("ROLE_USER");
        Set<Roles> roles = new HashSet<>();
        roles.add(role_user);
        Users user = new Users();
        user.setEmail(email);
        user.setFullName(fullName);
        user.setPassword(password);
        user.setRoles(roles);
        user.setCreatedAt(new Date());
        if (!userService.saveUser(user)) {
            model.addAttribute("email_username_error", "Email or username are already taken, try another");
            redirect = "annonymous/signup";
        }
        return redirect;
    }

    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_USER')")
    @GetMapping(path = "/profile")
    public String profile(Model model) {
        Users user = getUserData();
        List<Reviews> reviews = reviewsService.getAllReviewsByUser(user.getEmail());
        model.addAttribute("user", user);
        model.addAttribute("reviews", reviews);
        return "profile";
    }

    @PreAuthorize("hasAnyRole('ROLE_ADMIN')")
    @GetMapping(path = "/addpost")
    public String addPost(Model model) {
        return "admin/addpost";
    }

    @PreAuthorize("hasAnyRole('ROLE_ADMIN')")
    @PostMapping(path = "/addpost")
    public String addPost(
            @RequestParam(name = "title") String title,
            @RequestParam(name = "content") String content
    ) {
        Users currentUser = getUserData();
        return "redirect:/addpost?success";
    }

}
