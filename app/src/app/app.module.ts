import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { CommonModule } from "@angular/common";
import { AppRoutingModule } from './app-routing.module';
import { FormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';

import { AppComponent } from './app.component';
import { LoginComponent } from './_components/login/login.component';
import { RegisterComponent } from './_components/register/register.component';
import { HomeComponent } from './_components/home/home.component';
import { BoardAdminComponent } from './_components/board-admin/board-admin.component';
import { BoardUserComponent } from './_components/board-user/board-user.component';
import { BoardModeratorComponent } from './_components/board-moderator/board-moderator.component';
import { ProfileComponent } from './_components/profile/profile.component';
import { AngularMaterialModule } from './angular-material/angular-material.module';

import { authInterceptorProviders } from './_helpers/auth.interceptor';
import { MyCoworkersComponent } from './_components/my-coworkers/my-coworkers.component';
import { PorcelainInventoryComponent } from './_components/porcelain-inventory/porcelain-inventory.component';
import { MyOrdersComponent } from './_components/my-orders/my-orders.component';
import { MonthlyReportsComponent } from './_components/monthly-reports/monthly-reports.component';

@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    RegisterComponent,
    HomeComponent,
    BoardAdminComponent,
    BoardUserComponent,
    BoardModeratorComponent,
    ProfileComponent,
    MyCoworkersComponent,
    PorcelainInventoryComponent,
    MyOrdersComponent,
    MonthlyReportsComponent
  ],
  imports: [
    BrowserModule,
    CommonModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule,
    AngularMaterialModule
  ],
  entryComponents:[
    MyOrdersComponent,
    MyCoworkersComponent,
    PorcelainInventoryComponent,
    MonthlyReportsComponent
  ],
  providers: [authInterceptorProviders],
  bootstrap: [AppComponent]
})
export class AppModule { }
