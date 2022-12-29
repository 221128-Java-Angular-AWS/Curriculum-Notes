import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { FormsModule } from '@angular/forms';
import { AppComponent } from './app.component';
import { FahrenheitComponent } from './fahrenheit/fahrenheit.component';
import { CelsiusComponent } from './celsius/celsius.component';

@NgModule({
  declarations: [
    AppComponent,
    FahrenheitComponent,
    CelsiusComponent
  ],
  imports: [
    BrowserModule,
    FormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
