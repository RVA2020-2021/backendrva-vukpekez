import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { BehaviorSubject, Observable, of } from 'rxjs';
import { tap } from 'rxjs/operators';
import { OBRAZOVANJE_URL } from '../app.constants';
import { Obrazovanje } from '../models/Obrazovanje';

@Injectable({
  providedIn: 'root'
})
export class ObrazovanjeService {
  data = new BehaviorSubject<Obrazovanje[]>([]);

  constructor(private http: HttpClient) {
    this.http.get<Obrazovanje[]>(OBRAZOVANJE_URL)
      .subscribe(data => {
        this.data.next(data);
      });
  }

  getAllObrazovanje(): Observable<Obrazovanje[]> {
    return this.data.asObservable();
  }

  addObrazovanje(obrazovanje: Obrazovanje): Observable<any> {
    return this.http.post(`${OBRAZOVANJE_URL}`, obrazovanje)
      .pipe(tap(() => {
          const data = this.data.value;
          data.push(obrazovanje);
          const sorted = data.sort((a: Obrazovanje, b: Obrazovanje) => a.id! - b.id!);
          this.data.next(sorted);
        }));
  }

  updateObrazovanje(obrazovanje: Obrazovanje): Observable<any> {
    return this.http.put(`${OBRAZOVANJE_URL}`, obrazovanje)
      .pipe(tap(() => {
        const data = this.data.value;
        const index = data.findIndex((v) => v.id === obrazovanje.id);
        data[index] = obrazovanje;
        this.data.next(data);
      }));
  }

  deleteObrazovanje(id: number): Observable<any> {
    return this.http.delete(`${OBRAZOVANJE_URL}/${id}`)
      .pipe(tap(() => {
        const data = this.data.value.filter(o => o.id !== id);
        this.data.next(data);
      }));
  }
}

