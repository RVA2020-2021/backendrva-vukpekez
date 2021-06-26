import { AfterViewInit, Component, OnDestroy, ViewChild } from '@angular/core';
import { MatDialog } from '@angular/material/dialog';
import { MatPaginator } from '@angular/material/paginator';
import { MatSort } from '@angular/material/sort';
import { MatTable, MatTableDataSource } from '@angular/material/table';
import { Subscription } from 'rxjs';
import { Sektor } from 'src/app/models/Sektor';
import { SektorService } from 'src/app/services/sektor.service';
import { SektorDialogComponent } from '../dialogs/sektor-dialog/sektor-dialog.component';

@Component({
  selector: 'app-sektor',
  templateUrl: './sektor.component.html',
  styleUrls: ['./sektor.component.css']
})
export class SektorComponent implements AfterViewInit, OnDestroy {
  @ViewChild(MatPaginator) paginator!: MatPaginator;
  @ViewChild(MatSort) sort!: MatSort;
  @ViewChild(MatTable) table!: MatTable<Sektor>;
  
  displayedColumns = ['id', 'naziv', 'oznaka', 'preduzece', 'actions'];
  dataSource?: MatTableDataSource<Sektor>;
  sub?: Subscription;

  selectedSektor?: Sektor;

  constructor(private service: SektorService, private dialog: MatDialog) { }

  ngAfterViewInit(): void {
    this.dataSource = new MatTableDataSource();
    this.dataSource.paginator = this.paginator;
    this.dataSource.sort = this.sort;
    this.table.dataSource = this.dataSource;

    this.sub = this.service.getAllSektor()
      .subscribe(data => {
        this.dataSource!.data = data;

        this.dataSource!.filterPredicate = (data: any, filter: string) => {
          const acc = (currentTerm: any, key: string) => {
            return key === 'preduzece' ? currentTerm + data.preduzece.naziv : currentTerm + data[key];
          };
          const dataStr = Object.keys(data).reduce(acc, '').toLowerCase();
          const transformedFilter = filter.trim().toLowerCase();
          return dataStr.indexOf(transformedFilter) !== -1;
        };

        this.dataSource!.sortingDataAccessor = (data: any, prop) => {
          switch(prop) {
            case 'preduzece': return data.preduzece.naziv.toLocaleLowerCase();
            default: return data[prop];
          };
      };
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

  openDialog(flag: 'add' | 'update' | 'delete', sektor?: Sektor): void {
    const dialogRef = this.dialog.open(SektorDialogComponent, {data: {...sektor}});
    dialogRef.componentInstance.flag = flag;
  }
}
