import { Component, Output } from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  constructor() {
    this.celOut = 0;
    this.fahOut = 32;
  }

  title = 'c-f-events-converter';
  celOut: number;
  fahOut: number;


  convertCtoF(value: number) {
    //(C * 9/5) + 32 -> F
    this.fahOut = (value * 9 / 5) + 32;
  }

  convertFtoC(value: number) {
    //(F - 32) * (5/9) -> C
    this.celOut = (value - 32) * (5 / 9);
  }
}
