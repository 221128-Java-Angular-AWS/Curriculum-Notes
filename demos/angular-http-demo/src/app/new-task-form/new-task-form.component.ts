import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { RemoteService, Task } from '../remote.service';

@Component({
  selector: 'app-new-task-form',
  templateUrl: './new-task-form.component.html',
  styleUrls: ['./new-task-form.component.css']
})
export class NewTaskFormComponent {

  remote: RemoteService;

  constructor(remote: RemoteService) {
    this.remote = remote;
  }



  userId: number = 0;
  title: string = "";
  description: string = "";
  completed: boolean = false;

  post() {
    console.log(this.userId, this.title, this.description, this.completed);
    this.remote.postNewTask(new Task(this.userId, this.title, this.description, this.completed)).subscribe()
  }

}
