import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ContactService {

  private baseUrl = "http://localhost:8080/sendmail";

  constructor(private httpClient:HttpClient) { }

sendMailToSalesTeam(tempJson: any):Observable<any> {​​

  return this.httpClient.post(this.baseUrl,tempJson);
}

}
