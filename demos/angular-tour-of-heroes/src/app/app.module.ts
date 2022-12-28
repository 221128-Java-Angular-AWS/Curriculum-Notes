import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { FormsModule } from '@angular/forms';

import { AppComponent } from './app.component';
import { TestComponent } from './test/test.component';
import { Test2Component } from './test2/test2.component';
import { TextComponent } from './text/text.component';
import { DirectiveDirective } from './directive.directive';
import { LeftComponent } from './left/left.component';
import { RightComponent } from './right/right.component';

@NgModule({
  declarations: [
    AppComponent,
    TestComponent,
    Test2Component,
    TextComponent,
    DirectiveDirective,
    LeftComponent,
    RightComponent
  ],
  imports: [
    BrowserModule,
    FormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
