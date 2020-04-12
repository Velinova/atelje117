import { Component, OnInit } from '@angular/core';
import {MatDialogRef, MAT_DIALOG_DATA, MatDialog} from '@angular/material/dialog';
import {ManageCoworkerDialogComponent} from "../my-coworkers/dialog/manage-coworker-dialog.component";
import {ManageGraniteOrderComponent} from "./dialog/manage-granite-order/manage-granite-order.component";

@Component({
  selector: 'app-granite-orders',
  templateUrl: './granite-orders.component.html',
  styleUrls: ['./granite-orders.component.scss']
})
export class GraniteOrdersComponent implements OnInit {

  constructor(public dialog: MatDialog) {

  }

  ngOnInit(): void {
  }

  summonDialog(){
    const dialogRef = this.dialog.open(
      ManageGraniteOrderComponent, {
        width: '60%',
        height: '67%',
        data: {
          Title: "Add granite order",
        }
      });
  }
}
