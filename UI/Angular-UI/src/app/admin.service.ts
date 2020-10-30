import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class AdminService {

  private baseUrl = "http://localhost:8080/monitor";
  constructor(private httpClient:HttpClient) { }

  getAllMonitors(): Observable<any> {
    return this.httpClient.get(this.baseUrl);
  }

  getProdCount(): Observable<any> {
    return this.httpClient.get(this.baseUrl+"/count");
  }

  addProduct(string:any): Observable<any> {
    return this.httpClient.post(this.baseUrl, string);
  }
}
