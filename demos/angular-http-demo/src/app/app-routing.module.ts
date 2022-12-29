import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterModule, Routes } from '@angular/router';
import { NewTaskFormComponent } from './new-task-form/new-task-form.component';
import { TasksViewComponent } from './tasks-view/tasks-view.component';

const routes: Routes = [
  { path: "new-task", component: NewTaskFormComponent},
  { path: "tasks-view", component: TasksViewComponent}

];

@NgModule({
  declarations: [],
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
