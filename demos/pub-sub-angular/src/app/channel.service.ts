import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class ChannelService {

  constructor() { }

  sequence: number = 0;
  channel: Array<Subscription> = [];

  subscribe(subscription: Subscription): Function {
    let id: number = this.sequence++;
    subscription.id = id;
    this.channel.push(subscription);

    return () => {
      let subscriber: Subscription = subscription;

      for (let i = 0; i < this.channel.length; i++) {
        if (subscriber.id === this.channel[i].id) {
          this.channel.splice(i, 1);
        }
      }
    }
  }


  broadcast(type: string, message: string) {
    for (let subscription of this.channel) {
      if (subscription.type === type)
        subscription.callback(message);
    }
  }


}

export class Subscription {
  constructor(type: string, callback: Function) {
    this.type = type;
    this.callback = callback;
  }

  id?: number;
  type: string;
  callback: Function;
}
