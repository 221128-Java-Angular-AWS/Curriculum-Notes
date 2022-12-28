import { Component } from '@angular/core';
import { ChannelService, Subscription } from '../channel.service';

@Component({
  selector: 'app-subscriber',
  templateUrl: './subscriber.component.html',
  styleUrls: ['./subscriber.component.css']
})
export class SubscriberComponent {
  constructor(service: ChannelService) {
    this.service = service;
    this.message = "";

    this.unsubscribe = () => { };
  }

  type: string = "";
  service: ChannelService;
  message: string;
  unsubscribe: Function;


  subscribe() {
    this.unsubscribe = this.service.subscribe(new Subscription(this.type, (msg: string) => { this.message = msg }));
  }



}
