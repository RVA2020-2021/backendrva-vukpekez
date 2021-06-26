import { AfterViewInit, Component, OnDestroy, ViewChild } from '@angular/core';
import { MatDialog } from '@angular/material/dialog';
import { MatPaginator } from '@angular/material/paginator';
import { MatSort } from '@angular/material/sort';
import { MatTable, MatTableDataSource } from '@angular/material/table';
import { Subscription } from 'rxjs';
import { Obrazovanje } from 'src/app/models/Obrazovanje';
import { ObrazovanjeService } from 'src/app/services/obrazovanje.service';
import { ObrazovanjeDialogComponent } from '../dialogs/obrazovanje-dialog/obrazovanje-dialog.component';

@Component({
  selector: 'app-obrazovanje',
  templateUrl: './obrazovanje.component.html',
  styleUrls: ['./obrazovanje.component.css']
})
export class ObrazovanjeComponent implements AfterViewInit, OnDestroy {
  @ViewChild(MatPaginator) paginator!: MatPaginator;
  @ViewChild(MatSort) sort!: MatSort;
  @ViewChild(MatTable) table!: MatTable<Obrazovanje>;
  
  displayedColumns = ['id', 'naziv', 'stepenStrucneSpreme', 'opis', 'actions'];
  dataSource?: MatTableDataSource<Obrazovanje>;
  sub?: Subscription;

  constructor(private service: ObrazovanjeService, private dialog: MatDialog) { }

  ngAfterViewInit(): void {
    this.dataSource = new MatTableDataSource();
    this.dataSource.paginator = this.paginator;
    this.dataSource.sort = this.sort;
    this.table.dataSource = this.dataSource;

    this.sub = this.service.getAllObrazovanjeListener()
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

  openDialog(flag: 'add' | 'update' | 'delete', obrazovanje?: Obrazovanje): void {
    const dialogRef = this.dialog.open(ObrazovanjeDialogComponent, {data: {...obrazovanje}});
    dialogRef.componentInstance.flag = flag;
  }
}
