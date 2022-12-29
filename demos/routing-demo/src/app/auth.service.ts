import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class AuthService {

  constructor() { }

  isLoggedIn: boolean = false;

  login(): void {
    this.isLoggedIn = true;
  }

  logout() {
    this.isLoggedIn = false;
  }
}
