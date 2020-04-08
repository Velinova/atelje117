import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

import { RegisterComponent } from './_components/register/register.component';
import { LoginComponent } from './_components/login/login.component';
import { HomeComponent } from './_components/home/home.component';
import { ProfileComponent } from './_components/profile/profile.component';
import { BoardUserComponent } from './_components/board-user/board-user.component';
import { BoardModeratorComponent } from './_components/board-moderator/board-moderator.component';
import { BoardAdminComponent } from './_components/board-admin/board-admin.component';
import {MyCoworkersComponent} from "./_components/my-coworkers/my-coworkers.component";
import {PorcelainInventoryComponent} from "./_components/porcelain-inventory/porcelain-inventory.component";
import {MyOrdersComponent} from "./_components/my-orders/my-orders.component";
import {MonthlyReportsComponent} from "./_components/monthly-reports/monthly-reports.component";

const routes: Routes = [
  { path: 'home', component: HomeComponent },
  { path: 'login', component: LoginComponent },
  { path: 'mycoworkers', component: MyCoworkersComponent},
  { path: 'porcelaininvetory', component: PorcelainInventoryComponent},
  { path: 'myorders', component: MyOrdersComponent},
  { path: 'monthlyreports', component: MonthlyReportsComponent},
  { path: 'register', component: RegisterComponent },
  { path: 'profile', component: ProfileComponent },
  { path: 'user', component: BoardUserComponent },
  { path: 'mod', component: BoardModeratorComponent },
  { path: 'admin', component: BoardAdminComponent },
  { path: '', redirectTo: 'home', pathMatch: 'full' },
  { path: 'insufficient-permissions', component: HomeComponent},
  { path: "**", component: HomeComponent }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
