import { Component, Inject, OnInit } from '@angular/core';
import { MatDialogRef, MAT_DIALOG_DATA } from '@angular/material/dialog';
import { MyCoworkersService } from '../my-coworkers.service';

@Component({
  selector: 'manage-coworker-dialog',
  templateUrl: './manage-coworker-dialog.component.html'
})
export class ManageCoworkerDialogComponent implements OnInit {
  model: any;
  startDate: Date;

  constructor(
    @Inject(MAT_DIALOG_DATA) public data: any,
    private myCoworkersService: MyCoworkersService,
    public dialogRef: MatDialogRef<ManageCoworkerDialogComponent>
  ) {
    this.model = {};
    this.startDate  = new Date(2000, 0, 1);
  }

  ngOnInit() {
    if (this.data.Id) {
      //this.myCoworkersService.getById(this.data.Id)
      //       //  .subscribe((result) => {
      //       //    this.model = result;
      //       //  })
    }
  }

  onNoClick(): void {
    this.dialogRef.close('cancel');
  }

  onSubmit(form: any): void {
    if (form.invalid)
      return;

    if (this.model.Id) {
      //update
    } else {
      //create
    }
  }

}
