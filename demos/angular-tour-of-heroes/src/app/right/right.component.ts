import { Component } from '@angular/core';
import { TestServService } from '../test-serv.service';

@Component({
  selector: 'app-right',
  templateUrl: './right.component.html',
  styleUrls: ['./right.component.css']
})
export class RightComponent {
  constructor(pubServ: TestServService) {
    this.pubService = pubServ;
    pubServ.subscribe((publishedInfo: string) => {this.info = publishedInfo});
    //pubServ.subscribe(this.callback);
  }

  pubService: TestServService;

  info: string = '';



}
