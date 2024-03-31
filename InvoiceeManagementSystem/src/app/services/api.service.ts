import { HttpClient, HttpParams } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Customer, Invoice } from '../app.component';
import { BehaviorSubject } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ApiService {

  constructor(private http : HttpClient) { }

  customerListRefrehed$:BehaviorSubject<boolean> = new BehaviorSubject(true);
  invoiceListRefrehed$:BehaviorSubject<boolean> = new BehaviorSubject(true);
  baseUrl = "http://localhost:8080"
  getCustomers(){
    return this.http.get(`${this.baseUrl}/customers`,{responseType:"json"})
  }
  saveCustomer(customer:Customer){
    return this.http.post(`${this.baseUrl}/customers`,customer,{responseType:"json"})
  }
  updateCustomer(customer:Customer,id :number){
    let params = new HttpParams();
    params = params.set("customerId",id)
    return this.http.put(`${this.baseUrl}/customers`,customer,{params,responseType:"json"})
  }

  deleteCustomer(id :number){
    let params = new HttpParams();
    params = params.set("customerId",id)
    return this.http.put(`${this.baseUrl}/customers`,{params,responseType:"json"})
  }

  getInvoices(){
    return this.http.get(`${this.baseUrl}/invoices`,{responseType:"json"})
  }

  saveInvoices(invoice:Invoice){
    return this.http.post(`${this.baseUrl}/invoices`,invoice,{responseType:"text" as "json"})
  }
  
  deleteInvoices(invoiceId:number){
    let params = new HttpParams();
    params = params.set("invoiceId",invoiceId)
    return this.http.delete(`${this.baseUrl}/invoices`,{responseType:"json"})
  }
}
