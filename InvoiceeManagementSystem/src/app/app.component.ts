import { Component, OnInit } from '@angular/core';
import { MatDialog } from '@angular/material/dialog';
import { CustomerDialogComponent } from './components/customers/customer-dialog/customer-dialog.component';
import { InvoiceDialogComponent } from './components/invoices/invoice-dialog/invoice-dialog.component';
import { ApiService } from './services/api.service';

export interface Invoice{
  invoiceNumber?:number ,
  date?:Date,
  amount:number,
  customerId:number,
  productDetails?:ProductDetails[]
  customer?:Customer
}

export interface Customer{
  customerId?:number,
  custName :string;
  email:string;
  contactNumber:number;
  address:string; 
}

export interface ProductDetails{
  "name":string,
  "price":number,
  "quantity":number
}
@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit {
  title = 'Invoice Management System';
  showInvoice :boolean =true
  constructor(private dialog : MatDialog,
    private apiServices : ApiService){
  }
  ngOnInit(): void {
    this.apiServices.customerListRefrehed$.subscribe((bool)=>{
      if(bool){
        this.getCustomers();
      }
    })
    this.apiServices.invoiceListRefrehed$.subscribe((bool)=>{
      if(bool){
        this.getInvoices();
      }
    })
  }
  invoiceList:Invoice[]=[]
  getCustomers(){
    this.apiServices.getCustomers().subscribe((data:any)=>{
      this.customerList= data
      this.apiServices.customerListRefrehed$.next(false)

    })
  }
  getInvoices(){
    this.apiServices.getInvoices().subscribe((data:any)=>{
      this.invoiceList=data
      this.apiServices.invoiceListRefrehed$.next(false);
    })
  }
  customerList:Customer[];
  filter(showInvoice : boolean){
    this.showInvoice=showInvoice;
  }

  addInvoice(){
    let dialogRef = this.dialog.open(InvoiceDialogComponent, {
      data: { action: 'Add' },
      width: '700px',
    });
  }

  addCustomer(){
    let dialogRef = this.dialog.open(CustomerDialogComponent, {
      data: { action: 'Add' },
      width: '700px',
    });
  }
  
}
