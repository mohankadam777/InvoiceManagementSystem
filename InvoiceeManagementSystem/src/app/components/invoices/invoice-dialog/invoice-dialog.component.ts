import { Component, Inject, OnInit, ViewChild } from '@angular/core';
import { NgForm } from '@angular/forms';
import { MAT_DIALOG_DATA, MatDialogRef } from '@angular/material/dialog';
import { Customer, ProductDetails } from 'src/app/app.component';
import { ApiService } from 'src/app/services/api.service';

@Component({
  selector: 'app-invoice-dialog',
  templateUrl: './invoice-dialog.component.html',
  styleUrls: ['./invoice-dialog.component.css']
})
export class InvoiceDialogComponent implements OnInit{

  @ViewChild("invoiceForm") invoiceForm : NgForm
  constructor(
    private dialogref: MatDialogRef<InvoiceDialogComponent>,
    @Inject(MAT_DIALOG_DATA) public data: any,
    private apiservices:ApiService
  ){
  }
  customerList:Customer[]=[];
  productList:ProductDetails[]=[]
  totalAmount:number =0;
  ngOnInit(): void {
    this.apiservices.getCustomers().subscribe((resp:any)=>{
      this.customerList=resp;
    })

  }

  addProductDetails(){
    this.productList.push({
      "name" : this.invoiceForm.value["name"],
      "price":this.invoiceForm.value["price"],
      "quantity":this.invoiceForm.value["qty"]
    })
    this.totalAmount += (this.invoiceForm.value["price"] * this.invoiceForm.value["qty"])    ; 
    this.invoiceForm.controls["name"]?.reset();
    this.invoiceForm.controls["price"]?.reset();
    this.invoiceForm.controls["qty"]?.reset();
  }
  setActiveCustomer(data:any){

  }
  handleSubmit(){
    if(this.data.action=="Add"){
      let requestBody = {
        "customerId" :this.invoiceForm.value["customerId"],
        "productDetails" :this.productList,
        "amount":this.totalAmount,
        // "customerName":this.
      }
      this.apiservices.saveInvoices(requestBody).subscribe({
        next : (resp)=>{
          this.dialogref.close()
      },
      error:(err)=>{
        console.log(err);
        this.dialogref.close()
      }
    })
    }
    if(this.data.action=="Delete"){
      this.apiservices.deleteInvoices(this.data.id).subscribe({
        next:(resp)=>{
          this.dialogref.close();
        },
        error:(err)=>{
          console.log(err);
          this.dialogref.close();
        }
      })
    }
  }

}
