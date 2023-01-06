import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppComponent } from './app.component';
import { NewTaskFormComponent } from './new-task-form/new-task-form.component';
import { TasksViewComponent } from './tasks-view/tasks-view.component';
import { HttpClientModule  } from '@angular/common/http';
import { FormsModule } from '@angular/forms';
import { NavbarComponent } from './navbar/navbar.component';
import { AppRoutingModule } from './app-routing.module';
import { RemoteService } from './remote.service';


@NgModule({
  declarations: [
    AppComponent,
    NewTaskFormComponent,
    TasksViewComponent,
    NavbarComponent
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    FormsModule,
    AppRoutingModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
