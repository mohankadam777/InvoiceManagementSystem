import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { MaterialModule } from './shared/material/material.module';
import { InvoiceComponent } from './components/invoices/invoice/invoice.component';
import { InvoiceDialogComponent } from './components/invoices/invoice-dialog/invoice-dialog.component';
import { CustomerDialogComponent } from './components/customers/customer-dialog/customer-dialog.component';
import { FormsModule } from '@angular/forms';
import { CustomerComponent } from './components/customers/customer/customer.component';
import { HttpClientModule } from '@angular/common/http';

@NgModule({
  declarations: [
    AppComponent,
    InvoiceComponent,
    InvoiceDialogComponent,
    CustomerDialogComponent,
    CustomerComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    BrowserAnimationsModule,MaterialModule,
    FormsModule,
    HttpClientModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
