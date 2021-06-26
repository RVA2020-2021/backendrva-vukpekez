import { Component, Inject, OnInit } from '@angular/core';
import { MatDialogRef, MAT_DIALOG_DATA } from '@angular/material/dialog';
import { MatSnackBar } from '@angular/material/snack-bar';
import { Observable } from 'rxjs';
import { first } from 'rxjs/operators';
import { Radnik } from 'src/app/models/Radnik';
import { Obrazovanje } from 'src/app/models/Obrazovanje';
import { ObrazovanjeService } from 'src/app/services/obrazovanje.service';
import { RadnikService } from 'src/app/services/radnik.service';

@Component({
  selector: 'app-radnik-dialog',
  templateUrl: './radnik-dialog.component.html',
  styleUrls: ['./radnik-dialog.component.css']
})
export class RadnikDialogComponent implements OnInit {

  flag?: 'add' | 'update' | 'delete';
  obrazovanja$?: Observable<Obrazovanje[]>;

  constructor(
    private dialogRef: MatDialogRef<RadnikDialogComponent>,
    @Inject(MAT_DIALOG_DATA) public dataDialog: Radnik,
    private radnikService: RadnikService,
    private obrazovanjeService: ObrazovanjeService,
    private snackBar: MatSnackBar) { }

  submit(): void {
    let res$;
    if (this.flag === 'add') {
      res$ = this.radnikService.addRadnik({...this.dataDialog});
    } else if (this.flag === 'update') {
      res$ = this.radnikService.updateRadnik({...this.dataDialog});
    } else {
      res$ = this.radnikService.deleteRadnik(this.dataDialog.id!);
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
    this.obrazovanja$ = this.obrazovanjeService.getAllObrazovanjeListener();
  }

  compareFn(a: Radnik, b: Radnik): boolean {
    return a?.id === b?.id;
  }
}
