import { AfterViewInit, Component, Input, OnChanges, OnInit, ViewChild } from '@angular/core';
import { MatDialog } from '@angular/material/dialog';
import { MatPaginator } from '@angular/material/paginator';
import { MatSort } from '@angular/material/sort';
import { MatTable, MatTableDataSource } from '@angular/material/table';
import { Subscription } from 'rxjs';
import { Radnik } from 'src/app/models/Radnik';
import { Sektor } from 'src/app/models/Sektor';
import { RadnikService } from 'src/app/services/radnik.service';
import { RadnikDialogComponent } from '../dialogs/radnik-dialog/radnik-dialog.component';

@Component({
  selector: 'app-radnik',
  templateUrl: './radnik.component.html',
  styleUrls: ['./radnik.component.css']
})
export class RadnikComponent implements OnInit, OnChanges, AfterViewInit {
  @ViewChild(MatPaginator) paginator!: MatPaginator;
  @ViewChild(MatSort) sort!: MatSort;
  @ViewChild(MatTable) table!: MatTable<Radnik>;

  displayedColumns = ['id', 'ime&prezime', 'broj_lk', 'obrazovanje', 'actions'];
  dataSource?: MatTableDataSource<Radnik>;
  sub?: Subscription;

  @Input() sektor!: Sektor;

  constructor(private service: RadnikService, private dialog: MatDialog) { }

  ngOnInit(): void {
    this.service.getRadnikBySektor(this.sektor.id!);
  }

  ngOnChanges(): void {
    this.service.getRadnikBySektor(this.sektor.id!);
  }

  ngAfterViewInit(): void {
    this.dataSource = new MatTableDataSource();
    this.dataSource.paginator = this.paginator;
    this.dataSource.sort = this.sort;
    this.table.dataSource = this.dataSource;

    this.service.getRadnikListener()
      .subscribe(data => {
        this.dataSource!.data = data;

        this.dataSource!.filterPredicate = (data: any, filter: string) => {
          const acc = (currentTerm: any, key: string) => {
            return key === 'obrazovanje' ? currentTerm + data.obrazovanje.stepenStrucneSpreme + data.obrazovanje.naziv : currentTerm + data[key];
          };
          const dataStr = Object.keys(data).reduce(acc, '').toLowerCase();
          const transformedFilter = filter.trim().toLowerCase();
          return dataStr.indexOf(transformedFilter) !== -1;
        };

        this.dataSource!.sortingDataAccessor = (data: any, prop) => {
          switch(prop) {
            case 'obrazovanje': return data.obrazovanje.naziv.toLocaleLowerCase();
            default: return data[prop];
          }
      };
      });
  }

  ngOnDestroy(): void {
    this.sub?.unsubscribe();
  }

  openDialog(flag: 'add' | 'update' | 'delete', radnik?: Radnik): void {
    const dialogRef = this.dialog.open(RadnikDialogComponent, {data: {...radnik}});
    dialogRef.componentInstance.flag = flag;
    if (flag === 'add') {
      dialogRef.componentInstance.dataDialog.sektor = this.sektor;
    }
  }

  applyFilter(target: EventTarget): void {
    let filterValue = (target as HTMLInputElement).value;
    filterValue = filterValue.trim().toLocaleLowerCase();
    this.dataSource!.filter = filterValue;
  }
}
