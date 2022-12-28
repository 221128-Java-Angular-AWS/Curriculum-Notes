import { Component } from '@angular/core';
import { ChannelService } from '../channel.service';


@Component({
  selector: 'app-publisher',
  templateUrl: './publisher.component.html',
  styleUrls: ['./publisher.component.css']
})
export class PublisherComponent {
  constructor(service: ChannelService) {
    this.service = service;
  }

  service: ChannelService;
  input: string = "";
  type: string = "";
  publish() {
    this.service.broadcast(this.type, this.input);
  }
}
