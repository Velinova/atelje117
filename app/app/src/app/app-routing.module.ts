import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

import { RegisterComponent } from './_components/register/register.component';
import { LoginComponent } from './_components/login/login.component';
import { HomeComponent } from './_components/home/home.component';
import { ProfileComponent } from './_components/profile/profile.component';
import {MyCoworkersComponent} from "./_components/my-coworkers/my-coworkers.component";
import {PorcelainInventoryComponent} from "./_components/porcelain-inventory/porcelain-inventory.component";
import {MyOrdersComponent} from "./_components/my-orders/my-orders.component";
import {MonthlyReportsComponent} from "./_components/monthly-reports/monthly-reports.component";
import {GraniteOrdersComponent} from "./_components/granite-orders/granite-orders.component";
import {PorcelainOrdersComponent} from "./_components/porcelain-orders/porcelain-orders.component";
import {MyArtistsComponent} from "./_components/my-artists/my-artists.component";

const routes: Routes = [
  { path: 'home', component: HomeComponent },
  { path: 'login', component: LoginComponent },
  { path: 'mycoworkers', component: MyCoworkersComponent},
  { path: 'myartists', component: MyArtistsComponent},
  { path: 'porcelaininvetory', component: PorcelainInventoryComponent},
  { path: 'myorders', component: MyOrdersComponent},
  { path: 'monthlyreports', component: MonthlyReportsComponent},
  { path: 'graniteOrders', component: GraniteOrdersComponent},
  { path: 'porcelainOrders', component: PorcelainOrdersComponent},
  { path: 'register', component: RegisterComponent },
  { path: 'profile', component: ProfileComponent },
  { path: '', redirectTo: 'home', pathMatch: 'full' },
  { path: 'insufficient-permissions', component: HomeComponent},
  { path: "**", component: HomeComponent }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
