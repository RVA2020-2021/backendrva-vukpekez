import { Component, Inject, OnInit } from '@angular/core';
import { MatDialogRef, MAT_DIALOG_DATA } from '@angular/material/dialog';
import { MatSnackBar } from '@angular/material/snack-bar';
import { first } from 'rxjs/operators';
import { Preduzece } from 'src/app/models/Preduzece';
import { PreduzeceService } from 'src/app/services/preduzece.service';

@Component({
  selector: 'app-preduzece-dialog',
  templateUrl: './preduzece-dialog.component.html',
  styleUrls: ['./preduzece-dialog.component.css']
})
export class PreduzeceDialogComponent implements OnInit {

  flag?: 'add' | 'update' | 'delete';

  constructor(
    private dialogRef: MatDialogRef<PreduzeceDialogComponent>,
    @Inject(MAT_DIALOG_DATA) public dataDialog: Preduzece,
    private service: PreduzeceService,
    private snackBar: MatSnackBar) { }

  ngOnInit(): void {
  }

  submit(): void {
    let res$;
    if (this.flag === 'add') {
      res$ = this.service.addPreduzece({...this.dataDialog});
    } else if (this.flag === 'update') {
      res$ = this.service.updatePreduzece({...this.dataDialog});
    } else {
      res$ = this.service.deletePreduzece(this.dataDialog.id!);
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
