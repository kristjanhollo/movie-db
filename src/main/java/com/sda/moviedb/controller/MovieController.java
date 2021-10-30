package com.sda.moviedb.controller;

import com.sda.moviedb.domain.Movie;
import com.sda.moviedb.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;


import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@Controller
public class MovieController {

    @Autowired private MovieRepository movieRepository;

    @GetMapping("/movies")
    public String showMovieList(Model model) {
        List<Movie> movies = movieRepository.findAll();
        model.addAttribute("movies", movies);
        return "get-movies";
    }



    @GetMapping("movies/add")
    public String showSignUpForm(Movie movie) {
        return "post-movie";
    }

    @PostMapping("movies/add/")
    public String addUser(@Valid Movie movie, BindingResult result, Model model) {

        if (result.hasErrors()) {
            return "post-movie";
        }
        model.addAttribute("movie",movie);
        movieRepository.save(movie);
        return "redirect:/movies";
    }


    // TODO: CHANGE ADD TO DELETE
    @GetMapping("movies/add/{id}")
    public String deleteUser(@PathVariable Long id, Model model) {
        Optional<Movie> movieOptional = movieRepository.findById(id);
        if(movieOptional.isPresent()) {
            Movie movie = movieOptional.get();
            movieRepository.delete(movie);
        }
        return "redirect:/movies";
    }
}
