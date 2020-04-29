import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { MoviesListComponent } from './movies-list/movies-list.component';
import { CreateMovieComponent } from './create-movie/create-movie.component';
import { SearchMoviesComponent } from './search-movies/search-movies.component';

const routes: Routes = [
  { path: '', redirectTo: 'movie', pathMatch: 'full' },
  { path: 'movie', component: MoviesListComponent },
  { path: 'add', component: CreateMovieComponent },
  { path: 'findbyyear', component: SearchMoviesComponent },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})

export class AppRoutingModule { }
