import { Component } from '@angular/core';
import { TestServService } from '../test-serv.service';

@Component({
  selector: 'app-left',
  templateUrl: './left.component.html',
  styleUrls: ['./left.component.css']
})
export class LeftComponent {
  constructor(pubService: TestServService) {
    this.pubService = pubService;
  }

  pubService: TestServService;
  input: string = "";

  publish(): void {
    console.log("Publishing...");
    this.pubService.publish(this.input);
  }
}
