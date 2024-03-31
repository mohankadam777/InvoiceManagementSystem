import { Component, Inject, OnInit, ViewChild } from '@angular/core';
import { NgForm } from '@angular/forms';
import { MAT_DIALOG_DATA, MatDialogRef } from '@angular/material/dialog';
import { ApiService } from 'src/app/services/api.service';

@Component({
  selector: 'app-customer-dialog',
  templateUrl: './customer-dialog.component.html',
  styleUrls: ['./customer-dialog.component.css']
})
export class CustomerDialogComponent implements OnInit{
  constructor(
    private dialogref: MatDialogRef<CustomerDialogComponent>,
    @Inject(MAT_DIALOG_DATA) public data: any,
    private apiServices:ApiService
  ){
  }
  ngOnInit(): void {
  }
  handleSubmit(value:any){
   if(this.data.action=="Add"){
    this.apiServices.saveCustomer(value).subscribe({
      next: (resp)=>{
        console.log(resp);
        this.dialogref.close();
        this.apiServices.customerListRefrehed$.next(true);
      },
      error :(err)=>{
        this.dialogref.close();
        console.log(err);
        
      }
    })
   }

   if(this.data.action=="Edit"){
    this.apiServices.updateCustomer(value,this.data?.id).subscribe({
      next: (resp)=>{
        this.dialogref.close();
        this.apiServices.customerListRefrehed$.next(true);
      },
      error :(err)=>{
        this.dialogref.close();
        console.log(err);
        
      }
    })
   }

   if(this.data.action=="Delete"){
    this.apiServices.deleteCustomer(this.data?.id).subscribe({
      next: (resp)=>{
        console.log(resp);
        this.dialogref.close();
        this.apiServices.customerListRefrehed$.next(true);
      },
      error :(err)=>{
        this.dialogref.close();
        console.log(err);
        
      }
    })
   }
   

  }

}
