import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';


@Injectable({
  providedIn: 'root'
})
export class ProductService {

  private baseUrl = "http://localhost:8080/monitor"

  constructor(private httpClient:HttpClient) {​​ }​​

  getAllMonitors(tempJson: any): Observable<any> {​​



    return this.httpClient.post(this.baseUrl+"/specs",tempJson);

  }​​

  getMonitorByName(name: any): Observable<any> {​​

    return this.httpClient.post(this.baseUrl+"/name",name);
  }

  getEveryMonitors(): Observable<any> {
    return this.httpClient.get(this.baseUrl);
  }

}

