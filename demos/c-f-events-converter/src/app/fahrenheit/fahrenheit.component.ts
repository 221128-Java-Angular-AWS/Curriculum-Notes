import { Component, EventEmitter, Input, Output } from '@angular/core';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-fahrenheit',
  templateUrl: './fahrenheit.component.html',
  styleUrls: ['./fahrenheit.component.css']
})
export class FahrenheitComponent {

  @Input() fahIn: number = 0;
  @Output() newFah: EventEmitter<number> = new EventEmitter<number>();

  input() {
    this.newFah.emit(this.fahIn);
  }
}
