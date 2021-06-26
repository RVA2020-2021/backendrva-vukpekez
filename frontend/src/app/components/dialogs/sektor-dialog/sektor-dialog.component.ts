import { Component, Inject, OnInit } from '@angular/core';
import { MatDialogRef, MAT_DIALOG_DATA } from '@angular/material/dialog';
import { MatSnackBar } from '@angular/material/snack-bar';
import { Observable } from 'rxjs';
import { first } from 'rxjs/operators';
import { Preduzece } from 'src/app/models/Preduzece';
import { Sektor } from 'src/app/models/Sektor';
import { PreduzeceService } from 'src/app/services/preduzece.service';
import { SektorService } from 'src/app/services/sektor.service';

@Component({
  selector: 'app-sektor-dialog',
  templateUrl: './sektor-dialog.component.html',
  styleUrls: ['./sektor-dialog.component.css']
})
export class SektorDialogComponent implements OnInit {
  flag?: 'add' | 'update' | 'delete';
  preduzeca$?: Observable<Preduzece[]>;

  constructor(
    private dialogRef: MatDialogRef<SektorDialogComponent>,
    @Inject(MAT_DIALOG_DATA) public dataDialog: Sektor,
    private sektorService: SektorService,
    private preduzeceService: PreduzeceService,
    private snackBar: MatSnackBar) { }

  submit(): void {
    let res$;
    if (this.flag === 'add') {
      res$ = this.sektorService.addSektor({...this.dataDialog});
    } else if (this.flag === 'update') {
      res$ = this.sektorService.updateSektor({...this.dataDialog});
    } else {
      res$ = this.sektorService.deleteSektor(this.dataDialog.id!);
    }

    const action = this.flag === 'add' ? 'Dodavanje' : this.flag === 'update' ? 'Izmena' : 'Brisanje';

    res$.pipe(first()).subscribe(() => {
      this.snackBar.open(`${action} uspesno.`, 'OK', {duration:2500})
    },
    (error: Error) => {
      console.error(error.message);
      this.snackBar.open(`${action} neuspesno.`, 'Zatvori', {duration:2500});
    })
    .add(() => {
      this.dialogRef.close();
    });
  }

  ngOnInit(): void {
    this.preduzeca$ = this.preduzeceService.getAllPreduzeceListener();
  }

  compareFn(a: Preduzece, b: Preduzece): boolean {
    return a?.id === b?.id;
  }
}
