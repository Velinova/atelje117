import { Component, OnInit } from '@angular/core';
import { merge, of as observableOf } from 'rxjs';
import { catchError, map, startWith, switchMap } from 'rxjs/operators';
import { MyCoworkersService } from './my-coworkers.service';
import { ManageCoworkerDialogComponent } from './dialog/manage-coworker-dialog.component';
import { MatDialog } from '@angular/material/dialog';
import {TokenStorageService} from "../../_services/token-storage.service";
import {Router} from "@angular/router";
import {CoworkerService} from "../../_services/coworker.service";
import {ArtistService} from "../../_services/artist.service";
import {Location} from '@angular/common';
@Component({
  selector: 'app-my-coworkers',
  templateUrl: './my-coworkers.component.html',
  styleUrls: ['./my-coworkers.component.scss']
})
export class MyCoworkersComponent implements OnInit {
  //variables
  data: any[];
  userId: number ;
  displayedColumns: string[] = ['name', 'surname', 'city', 'totalOrders', 'graniteOrders', 'porcelainOrders', 'buttons'];
  coworkers: any[];
  showSelect: boolean;
  addCoworkerId: number;
  //constructor
  constructor(
    public dialog: MatDialog,
    public tokenStorageService: TokenStorageService,
    private myCoworkerService: MyCoworkersService,
    private coworkerService: CoworkerService,
    private artistService: ArtistService,
    private location: Location
  ) {
    this.data = [];
    this.showSelect = false;
  }

  //metoda koja se izvrsuva na load
  ngOnInit(): void {
    this.userId = Number(this.tokenStorageService.getUser().id + 1);
    console.log(this.userId);
    this.coworkerService.getCoworkers().subscribe(result => {
        this.coworkers = result;
    })
    setTimeout(() => this.getTable());
  }

  getTable() {
    merge()
      .pipe(
        startWith({}),

        switchMap(() => {
            const user = this.tokenStorageService.getUser();
         return this.myCoworkerService.getDatatable(user.id + 1);
        },
        ),
        map(data => {
          return data;
        }),
        catchError(() => {
          return observableOf([]);
        })
      ).subscribe(data => this.data = data);
  }
  delete(coworkerId: number){
    this.myCoworkerService.deleteCoworker(this.userId, coworkerId).subscribe(result => {
     location.reload();
    })
  }
  onSubmit(form: any): void {
    if (form.invalid)
      return;
    //add coworker
    this.artistService.addCoworker(this.userId, this.addCoworkerId).subscribe(result => {
      this.showSelect = false;
      location.reload();
    })
    }
  showSelectMethod() {
    this.showSelect = true;
  }
}
