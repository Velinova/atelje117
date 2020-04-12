import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { CommonModule } from "@angular/common";
import { AppRoutingModule } from './app-routing.module';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';

import { AppComponent } from './app.component';
import { LoginComponent } from './_components/login/login.component';
import { RegisterComponent } from './_components/register/register.component';
import { HomeComponent } from './_components/home/home.component';
import { ProfileComponent } from './_components/profile/profile.component';
import { AngularMaterialModule } from './angular-material/angular-material.module';
import {MatDatepickerModule} from '@angular/material/datepicker';
import {MatNativeDateModule} from '@angular/material/core';
import {MatInputModule} from '@angular/material/input';

import { authInterceptorProviders } from './_helpers/auth.interceptor';
import { MyCoworkersComponent } from './_components/my-coworkers/my-coworkers.component';
import { PorcelainInventoryComponent } from './_components/porcelain-inventory/porcelain-inventory.component';
import { MyOrdersComponent } from './_components/my-orders/my-orders.component';
import { MonthlyReportsComponent } from './_components/monthly-reports/monthly-reports.component';
import { MyCoworkersService } from './_components/my-coworkers/my-coworkers.service';
import { ManageCoworkerDialogComponent } from './_components/my-coworkers/dialog/manage-coworker-dialog.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatSelectModule } from '@angular/material/select';
import { MatTooltipModule } from '@angular/material/tooltip';
import { GraniteOrdersComponent } from './_components/granite-orders/granite-orders.component';
import { PorcelainOrdersComponent } from './_components/porcelain-orders/porcelain-orders.component';
import { ManageGraniteOrderComponent } from './_components/granite-orders/dialog/manage-granite-order/manage-granite-order.component';
import { MyArtistsComponent } from './_components/my-artists/my-artists.component';

@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    RegisterComponent,
    HomeComponent,
    ProfileComponent,
    MyCoworkersComponent,
    PorcelainInventoryComponent,
    MyOrdersComponent,
    MonthlyReportsComponent,
    ManageCoworkerDialogComponent,
    GraniteOrdersComponent,
    PorcelainOrdersComponent,
    ManageGraniteOrderComponent,
    MyArtistsComponent
  ],
  imports: [
    BrowserModule,
    CommonModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule,
    ReactiveFormsModule,
    BrowserAnimationsModule,
    AngularMaterialModule,
    MatSelectModule,
    MatFormFieldModule,
    MatTooltipModule,
    MatDatepickerModule,
    MatNativeDateModule,
    MatInputModule
  ],
  entryComponents:[
    MyOrdersComponent,
    MyCoworkersComponent,
    MyArtistsComponent,
    PorcelainInventoryComponent,
    MonthlyReportsComponent,
    ManageCoworkerDialogComponent,
    GraniteOrdersComponent,
    PorcelainOrdersComponent,
    ManageGraniteOrderComponent
  ],
  providers: [authInterceptorProviders,
    MyCoworkersService],
  bootstrap: [AppComponent],
  exports: [ReactiveFormsModule]
})
export class AppModule { }
