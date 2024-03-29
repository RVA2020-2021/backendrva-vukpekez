import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { BehaviorSubject, Observable } from 'rxjs';
import { tap } from 'rxjs/operators';
import { SEKTOR_URL } from '../app.constants';
import { Sektor } from '../models/Sektor';

@Injectable({
  providedIn: 'root'
})
export class SektorService {
  data = new BehaviorSubject<Sektor[]>([]);

  constructor(private http: HttpClient) {
    this.getAllSektor();
  }

  getAllSektor(): void {
    this.http.get<Sektor[]>(SEKTOR_URL)
      .subscribe(data => {
        this.data.next(data);
      });
  }

  getAllSektorListener(): Observable<Sektor[]> {
    return this.data.asObservable();
  }

  addSektor(sektor: Sektor): Observable<any> {
    return this.http.post(`${SEKTOR_URL}`, sektor)
      .pipe(tap(() => {
          this.getAllSektor();
        }));
  }

  updateSektor(sektor: Sektor): Observable<any> {
    return this.http.put(`${SEKTOR_URL}`, sektor)
      .pipe(tap(() => {
        const data = this.data.value;
        const index = data.findIndex((v) => v.id === sektor.id);
        data[index] = sektor;
        this.data.next(data);
      }));
  }

  deleteSektor(id: number): Observable<any> {
    return this.http.delete(`${SEKTOR_URL}/${id}`)
      .pipe(tap(() => {
        const data = this.data.value.filter(o => o.id !== id);
        this.data.next(data);
      }));
  }
}
