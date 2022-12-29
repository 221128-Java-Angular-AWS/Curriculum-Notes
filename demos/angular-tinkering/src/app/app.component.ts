import { Component } from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'angular-tinkering';

  count = 9;
  countChange(event: any) {
    console.log("Synthetic event object: ", event);
    this.count = event;
  }
}
