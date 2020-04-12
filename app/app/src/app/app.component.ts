import { Component, OnInit } from '@angular/core';
import { TokenStorageService } from './_services/token-storage.service';
import {UserService} from "./_services/user.service";

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss']
})
export class AppComponent implements OnInit {
  isLoggedIn = false;
  user: any;
  userRole: string;
  constructor(private tokenStorageService: TokenStorageService,
              private userService: UserService) {
    this.user = {
      Name: '',
      Surname: '',
      Username: ''
    }
  }

  ngOnInit() {
    this.isLoggedIn = !!this.tokenStorageService.getToken();

    if (this.isLoggedIn) {
      let userId = this.tokenStorageService.getUser().id;
      this.userService.getUser(userId).subscribe((result) => {
        this.userRole = result.Role;
        this.user = result;
      });

    }
  }

  logout() {
    this.tokenStorageService.signOut();
    window.location.reload();
  }
}
