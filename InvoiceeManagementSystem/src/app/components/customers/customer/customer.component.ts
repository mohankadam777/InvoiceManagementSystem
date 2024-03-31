import { Component, Input } from '@angular/core';
import { MatDialog } from '@angular/material/dialog';
import { Customer } from 'src/app/app.component';
import { CustomerDialogComponent } from '../customer-dialog/customer-dialog.component';

@Component({
  selector: 'app-customer',
  templateUrl: './customer.component.html',
  styleUrls: ['./customer.component.css']
})
export class CustomerComponent {
  constructor(private dialog : MatDialog){
  }

  @Input() customer : Customer

  updateCustomer(){
    let dialogRef = this.dialog.open(CustomerDialogComponent, {
      data: { action: 'Edit',id:this.customer.customerId,customer:this.customer },
      width: '700px',
    });
  }

  deleteCustomer(){
    let dialogRef = this.dialog.open(CustomerDialogComponent, {
      data: { action: 'Delete',id:this.customer.customerId  },
      width: '700px',
    });
  }

}
