import { Component, OnInit } from '@angular/core';
import {UserService} from "../../_services/user.service";
import {TokenStorageService} from "../../_services/token-storage.service";

@Component({
  selector: 'app-profile',
  templateUrl: './profile.component.html',
  styleUrls: ['./profile.component.scss']
})
export class ProfileComponent implements OnInit {

  constructor(
    private userService: UserService,
    private tokenStorageService: TokenStorageService
  ) { }

  ngOnInit(): void {
    const user = this.tokenStorageService.getUser();
    this.userService.getUser(user.id).subscribe((result) => {
      console.log(result);});
  }

}
