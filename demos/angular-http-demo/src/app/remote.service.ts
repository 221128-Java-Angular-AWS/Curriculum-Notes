import { Injectable } from '@angular/core';
import { Observable, throwError } from 'rxjs';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { catchError, retry } from 'rxjs/operators';

@Injectable({
  providedIn: 'root'
})
export class RemoteService {

  http: HttpClient;

  constructor(http: HttpClient) {
    this.http = http;
  }

  baseUrl: string = 'http://localhost:8080';

  postNewTask(newTask: Task) {

    let options = {
      headers: new HttpHeaders({
        'Content-Type': 'application/json'
      })
    }

    return this.http.post<Task>(this.baseUrl + '/task', JSON.stringify(newTask), options)
      .pipe(
        retry(1),
        catchError(this.errorHandl)
      );
  }

  getAllTasksForUserId(id: number): Observable<Task[]> {
    return this.http.get<Task[]>(this.baseUrl + '/user/' + id + '/tasks')
    .pipe(
      retry(1),
      catchError(this.errorHandl)
    )
  }


    // Error handling
    errorHandl(error: any) {
      let errorMessage = '';
      if(error.error instanceof ErrorEvent) {
        // Get client-side error
        errorMessage = error.error.message;
      } else {
        // Get server-side error
        errorMessage = `Error Code: ${error.status}\nMessage: ${error.message}`;
      }
      console.log(errorMessage);
      return throwError(errorMessage);
    }

}

export class Task {
  constructor(userId: number, title: string, description: string, completed: boolean, taskId?: number) {
    this.userId = userId;
    this.title = title;
    this.description = description;
    this.completed = completed;
    this.taskId = taskId;
  }


  userId: number;
  title: string;
  description: string;
  completed: boolean;
  taskId?: number;

}
