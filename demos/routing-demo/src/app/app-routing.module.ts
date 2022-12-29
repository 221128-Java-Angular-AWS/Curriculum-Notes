import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { FirstComponent } from './first/first.component';
import { SecondComponent } from './second/second.component';
import { AuthGuard } from './auth.guard';

const routes: Routes = [
  {path: "first", component: FirstComponent, canActivate: [AuthGuard]},
  {path: "second", component: SecondComponent, canActivate: [AuthGuard]}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
