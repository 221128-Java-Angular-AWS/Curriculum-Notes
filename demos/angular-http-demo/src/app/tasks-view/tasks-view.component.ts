import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { RemoteService, Task } from '../remote.service';

@Component({
  selector: 'app-tasks-view',
  templateUrl: './tasks-view.component.html',
  styleUrls: ['./tasks-view.component.css']
})
export class TasksViewComponent {

  remote: RemoteService;

  constructor(remote: RemoteService) {
    this.remote = remote;
  }

  userId: number = 0;
  tasks: Task[] = [];

  doGetRequest() {
    this.remote.getAllTasksForUserId(this.userId).subscribe({
      next: (value) => { 
        console.log("value: ", value);
        this.tasks = value; 
      },
      error: (error) => {/*do something*/ },
      complete: () => {/*do something*/ }
    })
  }
}
