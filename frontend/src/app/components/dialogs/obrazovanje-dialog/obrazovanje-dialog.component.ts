import { Component, Inject, OnInit } from '@angular/core';
import { MatDialogRef, MAT_DIALOG_DATA } from '@angular/material/dialog';
import { MatSnackBar } from '@angular/material/snack-bar';
import { first } from 'rxjs/operators';
import { Obrazovanje } from 'src/app/models/Obrazovanje';
import { ObrazovanjeService } from 'src/app/services/obrazovanje.service';

@Component({
  selector: 'app-obrazovanje-dialog',
  templateUrl: './obrazovanje-dialog.component.html',
  styleUrls: ['./obrazovanje-dialog.component.css']
})
export class ObrazovanjeDialogComponent {

  flag?: 'add' | 'update' | 'delete';

  constructor(
    private dialogRef: MatDialogRef<ObrazovanjeDialogComponent>,
    @Inject(MAT_DIALOG_DATA) public dataDialog: Obrazovanje,
    private service: ObrazovanjeService,
    private snackBar: MatSnackBar) { }

  submit(): void {
    let res$;
    if (this.flag === 'add') {
      res$ = this.service.addObrazovanje({...this.dataDialog});
    } else if (this.flag === 'update') {
      res$ = this.service.updateObrazovanje({...this.dataDialog});
    } else {
      res$ = this.service.deleteObrazovanje(this.dataDialog.id!);
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
}
