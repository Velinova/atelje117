import { Component, OnInit } from '@angular/core';
import { TokenStorageService } from './_services/token-storage.service';
import {UserService} from "./_services/user.service";

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss']
})
export class AppComponent implements OnInit {
  private roles: string[];
  isLoggedIn = false;
  showAdminBoard = false;
  showModeratorBoard = false;
  username: string;

  constructor(private tokenStorageService: TokenStorageService,
              private userService: UserService) { }

  ngOnInit() {
    this.isLoggedIn = !!this.tokenStorageService.getToken();

    if (this.isLoggedIn) {
      const user = this.tokenStorageService.getUser();
      this.userService.getUser(user.id).subscribe((result) => {
        console.log(result);});

      //this.showAdminBoard = this.roles.includes('ROLE_ADMIN');
      //this.showModeratorBoard = this.roles.includes('ROLE_MODERATOR');

      this.username = user.username;
    }
  }

  logout() {
    this.tokenStorageService.signOut();
    window.location.reload();
  }
}
