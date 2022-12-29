import { Component } from '@angular/core';
import { AuthService } from '../auth.service';

@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.css']
})
export class NavbarComponent {
  authService: AuthService;
  constructor(authService: AuthService) {
    this.authService = authService;//We should remove this line and see if the example code knows something I don't.
  }

  login() {
    this.authService.login();
  }

  logout() {
    this.authService.logout();
  }
}
