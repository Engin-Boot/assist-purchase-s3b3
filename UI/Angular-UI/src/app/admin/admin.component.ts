import { Component, OnInit } from '@angular/core';
import {AdminService} from '../admin.service';
@Component({
  selector: 'app-admin',
  templateUrl: './admin.component.html',
  styleUrls: ['./admin.component.css']
})
export class AdminComponent implements OnInit {

  monitorCount: any;
  product : any;

  alert = true;
  constructor( private _service : AdminService) { }

  monitors : any[];

  features = "";
  sectiontype = 'viewproduct';

  ngOnInit(){

    this.getMonitors();
    this.getMonitorCount();
    //this.addProduct();
    console.log(this.product);
  }
  getMonitorCount() {

    this._service.getProdCount().subscribe(response => {
      this.monitorCount = response;
      this.monitorCount = this.monitorCount+1;
      console.log(this.monitorCount);
    });

  }

  customtab(type) {
    this.sectiontype = type;
  }

  getMonitors() {
    this._service.getAllMonitors().subscribe(response => {
      this.monitors = response;
      console.log(this.monitors);
    });
  }

  addProduct(){
    this._service.addProduct(this.product).subscribe(response => {
      console.log(response);
    });

    this.alert = false;
  }
  public showMyMessage = false;

  showMessageSoon() {
    setTimeout(() => {
      this.showMyMessage = true
    }, 1000)
  }
  save(name:any,price :any,Description:any,wireless:any,emr:any,touchscreen:any,interoperable:any){
    this.showMessageSoon();
    console.log(name,price, Description, wireless, emr , touchscreen, interoperable);

    this.product = {
      "name":name,
      "price":price,
      "wireless":wireless,
      "touchscreen":touchscreen,
      "connectivitywithemr":emr,
      "interoperable":interoperable,
      "description":Description,
      "image":"image"
    }

    console.log(this.product);
    this.addProduct();

  }



}
