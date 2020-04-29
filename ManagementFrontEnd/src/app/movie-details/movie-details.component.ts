import { Component, OnInit, Input } from '@angular/core';
import { MovieService } from '../movie.service';
import { Movie } from '../movie';

import { MoviesListComponent } from '../movies-list/movies-list.component';

@Component({
  selector: 'movie-details',
  templateUrl: './movie-details.component.html',
  styleUrls: ['./movie-details.component.css']
})
export class MovieDetailsComponent implements OnInit {

  @Input() movie: Movie;

  constructor(private movieService: MovieService, private listComponent: MoviesListComponent) { }

  ngOnInit() {
  }

  updateAvailable(isAvailable: boolean) {
    this.movieService.updateMovie(this.movie.id,
      { name: this.movie.name, year: this.movie.year, available: isAvailable })
      .subscribe(
        data => {
          console.log(data);
          this.movie = data as Movie;
        },
        error => console.log(error));
  }

  deleteMovie() {
    this.movieService.deleteMovie(this.movie.id)
      .subscribe(
        data => {
          console.log(data);
          this.listComponent.reloadData();
        },
        error => console.log(error));
  }
}
