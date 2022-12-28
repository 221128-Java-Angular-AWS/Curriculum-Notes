import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class TestServService {

  constructor() { }

  subscribers: Function[] = [];

  subscribe(callback: Function) {

    this.subscribers.push(callback);


  }


  something = [1, 2, 3];

  publish(info: string): any {
    for (let i = 0; i < this.subscribers.length; i++) {
      let callback: Function = this.subscribers[i];
      callback(info);
    }
  }




}
