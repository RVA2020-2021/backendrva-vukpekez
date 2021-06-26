import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { BehaviorSubject, Observable } from 'rxjs';
import { tap } from 'rxjs/operators';
import { PREDUZECE_URL } from '../app.constants';
import { Preduzece } from '../models/Preduzece';

@Injectable({
  providedIn: 'root'
})
export class PreduzeceService {
  data = new BehaviorSubject<Preduzece[]>([]);

  constructor(private http: HttpClient) {
    http.get<Preduzece[]>(PREDUZECE_URL)
      .subscribe(data => {
        this.data.next(data);
      });
  }

  getAllPreduzece(): Observable<Preduzece[]> {
    return this.data.asObservable();
  }

  addPreduzece(preduzece: Preduzece): Observable<any> {
    return this.http.post(`${PREDUZECE_URL}`, preduzece)
      .pipe(tap(() => {
          const data = this.data.value;
          data.push(preduzece);
          const sorted = data.sort((a: Preduzece, b: Preduzece) => a.id! - b.id!);
          this.data.next(sorted);
        }));
  }

  updatePreduzece(preduzece: Preduzece): Observable<any> {
    return this.http.put(`${PREDUZECE_URL}`, preduzece)
      .pipe(tap(() => {
        const data = this.data.value;
        const index = data.findIndex((v) => v.id === preduzece.id);
        data[index] = preduzece;
        this.data.next(data);
      }));
  }

  deletePreduzece(id: number): Observable<any> {
    return this.http.delete(`${PREDUZECE_URL}/${id}`)
      .pipe(tap(() => {
        const data = this.data.value.filter(o => o.id !== id);
        this.data.next(data);
      }));
  }
}
