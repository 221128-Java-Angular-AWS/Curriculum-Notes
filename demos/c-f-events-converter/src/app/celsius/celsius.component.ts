import { Component, EventEmitter, Input, Output } from '@angular/core';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-celsius',
  templateUrl: './celsius.component.html',
  styleUrls: ['./celsius.component.css']
})
export class CelsiusComponent {
  @Input() celIn: number = 0;
  @Output() newCel: EventEmitter<number> = new EventEmitter<number>();

  input() {
    this.newCel.emit(this.celIn);
  }


}
