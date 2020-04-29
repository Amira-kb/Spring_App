import { Component, OnInit } from '@angular/core';
import { Movie } from '../movie';
import { MovieService } from '../movie.service';

@Component({
  selector: 'search-movies',
  templateUrl: './search-movies.component.html',
  styleUrls: ['./search-movies.component.css']
})
export class SearchMoviesComponent implements OnInit {

  year: number;
  movies: Movie[];

  constructor(private dataService: MovieService) { }

  ngOnInit() {
    this.year = 0;
  }

  private searchMovies() {
    this.dataService.getMoviesByYear(this.year)
      .subscribe(movies => this.movies = movies);
  }

  onSubmit() {
    this.searchMovies();
  }
}
