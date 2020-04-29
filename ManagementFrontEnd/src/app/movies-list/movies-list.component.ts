import { Component, OnInit } from '@angular/core';
import { Observable } from 'rxjs';

import { MovieService } from '../movie.service';
import { Movie } from '../movie';

@Component({
  selector: 'movies-list',
  templateUrl: './movies-list.component.html',
  styleUrls: ['./movies-list.component.css']
})
export class MoviesListComponent implements OnInit {

  movies: Observable<Movie[]>;

  constructor(private movieService: MovieService) { }

  ngOnInit() {
    this.reloadData();
  }

  deleteMovies() {
    this.movieService.deleteAll()
      .subscribe(
        data => {
          console.log(data);
          this.reloadData();
        },
        error => console.log('ERROR: ' + error));
  }

  reloadData() {
    this.movies = this.movieService.getMoviesList();
  }
}
