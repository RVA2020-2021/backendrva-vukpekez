import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { BehaviorSubject, Observable } from 'rxjs';
import { tap } from 'rxjs/operators';
import { RADNIK_URL } from '../app.constants';
import { Radnik } from '../models/Radnik';

@Injectable({
  providedIn: 'root'
})
export class RadnikService {
  data = new BehaviorSubject<Radnik[]>([]);

  constructor(private http: HttpClient) {}

  getRadnikBySektor(id: number): void {
    this.http.get<Radnik[]>(`${RADNIK_URL}BySektor/${id}`)
    .subscribe(data => {
      this.data.next(data);
    });
  }

  getRadnikListener(): Observable<Radnik[]> {
    return this.data.asObservable();
  }

  addRadnik(radnik: Radnik): Observable<any> {
    return this.http.post(`${RADNIK_URL}`, radnik)
      .pipe(tap(() => {
          const data = this.data.value;
          data.push(radnik);
          const sorted = data.sort((a: Radnik, b: Radnik) => a.id! - b.id!);
          this.data.next(sorted);
        }));
  }

  updateRadnik(radnik: Radnik): Observable<any> {
    return this.http.put(`${RADNIK_URL}`, radnik)
      .pipe(tap(() => {
        const data = this.data.value;
        const index = data.findIndex((v) => v.id === radnik.id);
        data[index] = radnik;
        this.data.next(data);
      }));
  }

  deleteRadnik(id: number): Observable<any> {
    return this.http.delete(`${RADNIK_URL}/${id}`)
      .pipe(tap(() => {
        const data = this.data.value.filter(o => o.id !== id);
        this.data.next(data);
      }));
  }
}
