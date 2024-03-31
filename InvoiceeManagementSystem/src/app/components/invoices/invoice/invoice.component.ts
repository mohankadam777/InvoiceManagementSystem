import { Component, Input } from '@angular/core';
import { Invoice } from 'src/app/app.component';

@Component({
  selector: 'app-invoice',
  templateUrl: './invoice.component.html',
  styleUrls: ['./invoice.component.css']
})
export class InvoiceComponent {
  @Input()invoice : Invoice

}
