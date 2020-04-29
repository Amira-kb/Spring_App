package Web.Prog.Managment.Repository;

import Web.Prog.Managment.Model.Movie;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface MovieRepository extends CrudRepository<Movie, Long> {
    List<Movie> findByYear(int year);
}
