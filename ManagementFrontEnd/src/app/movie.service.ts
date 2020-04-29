import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class MovieService {

  private baseUrl = 'http://localhost:8080/api/movies';

  constructor(private http: HttpClient) { }

  getMovie(id: number): Observable<Object> {
    return this.http.get(`${this.baseUrl}/${id}`);
  }

  createMovie(movie: Object): Observable<Object> {
    return this.http.post(`${this.baseUrl}` + `/create`, movie);
  }

  updateMovie(id: number, value: any): Observable<Object> {
    return this.http.put(`${this.baseUrl}/${id}`, value);
  }

  deleteMovie(id: number): Observable<any> {
    return this.http.delete(`${this.baseUrl}/${id}`, { responseType: 'text' });
  }

  getMoviesList(): Observable<any> {
    return this.http.get(`${this.baseUrl}`);
  }

  getMoviesByYear(year: number): Observable<any> {
    return this.http.get(`${this.baseUrl}/year/${year}`);
  }

  deleteAll(): Observable<any> {
    return this.http.delete(`${this.baseUrl}` + `/delete`, { responseType: 'text' });
  }
}
