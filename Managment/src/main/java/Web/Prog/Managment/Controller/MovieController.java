package Web.Prog.Managment.Controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import Web.Prog.Managment.Model.Movie;
import Web.Prog.Managment.Repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class MovieController {

    @Autowired
    MovieRepository repository;

    @GetMapping("/movies")
    public List<Movie> getAllMovies() {
        System.out.println("Get all Movies...");

        List<Movie> movies = new ArrayList<>();
        repository.findAll().forEach(movies::add);

        return movies;
    }

    @PostMapping(value = "/movies/create")
    public Movie postMovie(@RequestBody Movie movie) {

        Movie _movie = repository.save(new Movie(movie.getName(), movie.getyear()));
        return _movie;
    }

    @DeleteMapping("/movies/{id}")
    public ResponseEntity<String> deleteMovie(@PathVariable("id") long id) {
        System.out.println("Delete Movie with ID = " + id + "...");

        repository.deleteById(id);

        return new ResponseEntity<>("Movie has been deleted!", HttpStatus.OK);
    }

    @DeleteMapping("/movies/delete")
    public ResponseEntity<String> deleteAllMovies() {
        System.out.println("Delete All Movies...");

        repository.deleteAll();

        return new ResponseEntity<>("All movies have been deleted!", HttpStatus.OK);
    }

    @GetMapping(value = "movies/year/{year}")
    public List<Movie> findByyear(@PathVariable int year) {

        List<Movie> movies = repository.findByYear(year);
        return movies;
    }

    @PutMapping("/movies/{id}")
    public ResponseEntity<Movie> updateMovie(@PathVariable("id") long id, @RequestBody Movie movie) {
        System.out.println("Update Movie with ID = " + id + "...");

        Optional<Movie> movieData = repository.findById(id);

        if (movieData.isPresent()) {
            Movie _movie = movieData.get();
            _movie.setName(movie.getName());
            _movie.setyear(movie.getyear());
            _movie.setavailable(movie.isavailable());
            return new ResponseEntity<>(repository.save(_movie), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
