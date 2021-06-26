import { AfterViewInit, Component, OnDestroy, ViewChild } from '@angular/core';
import { MatDialog } from '@angular/material/dialog';
import { MatPaginator } from '@angular/material/paginator';
import { MatSort } from '@angular/material/sort';
import { MatTable, MatTableDataSource } from '@angular/material/table';
import { Subscription } from 'rxjs';
import { Preduzece } from 'src/app/models/Preduzece';
import { PreduzeceService } from 'src/app/services/preduzece.service';
import { PreduzeceDialogComponent } from '../dialogs/preduzece-dialog/preduzece-dialog.component';

@Component({
  selector: 'app-preduzece',
  templateUrl: './preduzece.component.html',
  styleUrls: ['./preduzece.component.css']
})
export class PreduzeceComponent implements AfterViewInit, OnDestroy {
  @ViewChild(MatPaginator) paginator!: MatPaginator;
  @ViewChild(MatSort) sort!: MatSort;
  @ViewChild(MatTable) table!: MatTable<Preduzece>;

  displayedColumns = ['id', 'naziv', 'pib', 'sediste', 'opis', 'actions'];
  dataSource?: MatTableDataSource<Preduzece>;
  sub?: Subscription;

  constructor(private service: PreduzeceService, private dialog: MatDialog) { }

  ngAfterViewInit(): void {
    this.dataSource = new MatTableDataSource();
    this.dataSource.paginator = this.paginator;
    this.dataSource.sort = this.sort;
    this.table.dataSource = this.dataSource;

    this.service.getAllPreduzeceListener()
      .subscribe(data => {
        this.dataSource!.data = data;
      });
  }

  ngOnDestroy(): void {
    this.sub?.unsubscribe();
  }

  applyFilter(target: EventTarget): void {
    let filterValue = (target as HTMLInputElement).value;
    filterValue = filterValue.trim().toLocaleLowerCase();
    this.dataSource!.filter = filterValue;
  }

  openDialog(flag: 'add' | 'update' | 'delete', preduzece?: Preduzece): void {
    const dialogRef = this.dialog.open(PreduzeceDialogComponent, {data: {...preduzece}});
    dialogRef.componentInstance.flag = flag;
  }
}
