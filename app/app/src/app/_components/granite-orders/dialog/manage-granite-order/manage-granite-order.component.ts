import {Component, Inject, NgZone, OnInit, ViewChild} from '@angular/core';
import { MatDialogRef, MAT_DIALOG_DATA } from '@angular/material/dialog';
import {MyCoworkersService} from "../../../my-coworkers/my-coworkers.service";
import {CdkTextareaAutosize} from '@angular/cdk/text-field';
import {take} from 'rxjs/operators';
import {any} from "codelyzer/util/function";
import {CoworkerService} from "../../../../_services/coworker.service";
import {TokenStorageService} from "../../../../_services/token-storage.service";
import {UserService} from "../../../../_services/user.service";
import {FormControl, FormGroup} from "@angular/forms";
import {Router} from "@angular/router";

@Component({
  selector: 'app-manage-granite-order',
  templateUrl: './manage-granite-order.component.html',
  styleUrls: ['./manage-granite-order.component.scss']
})
export class ManageGraniteOrderComponent implements OnInit {
  model: any;
  startDate: Date;
  @ViewChild('autosize') autosize: CdkTextareaAutosize;
  fontSize: any;
  artists: [];
  user: any;
  orderForm: FormGroup;

  constructor(
    @Inject(MAT_DIALOG_DATA) public data: any,
    public dialogRef: MatDialogRef<ManageGraniteOrderComponent>,
    private _ngZone: NgZone,
    private coworkerService: CoworkerService,
    private tokenService: TokenStorageService,
    private userService: UserService,
    private router:Router
  ) {
    this.model = {
      Client: {
        Name: " ",
        Surname: " ",
        BirthDate: " ",
        DeathDate: " ",
      },
      ArtistId: " ",
      DueTo: " ",
      GraniteType: " ",
      OrderType: " ",
      Epilogue: " ",
      CoworkerNote: " ",
      CoworkerId: " "
    };
    this.startDate  = new Date(2000, 0, 1);
  }

  //text area inputs


  triggerResize() {
    // Wait for changes to be applied, then trigger textarea resize.
    this._ngZone.onStable.pipe(take(1))
      .subscribe(() => this.autosize.resizeToFitContent(true));
  }


  ngOnInit(): void {
    let userId = this.tokenService.getUser().id;
    console.log(userId);
    this.userService.getUser(userId).subscribe((result) => {
      this.user = result;
      this.coworkerService.getArtists(Number(this.user.Id + 1)).subscribe(result =>{
        this.artists = result;
      });
    });


    console.log(this.artists);
    if (this.data.Id) {
      //this.myCoworkersService.getById(this.data.Id)
      //  .subscribe((result) => {
      //    this.model = result;
      //  })
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
      this.model.CoworkerId = Number(this.user.Id + 1);
      this.model.ArtistId = Number(this.model.ArtistId);
      this.coworkerService.addGraniteOrder(this.model).subscribe(result => {
          this.router.navigate(['/myartists']);
      }

      );
    }
  }
}
