import { Component, OnInit } from '@angular/core';
import {FormBuilder, FormGroup, Validators} from '@angular/forms';
import {ProductService} from '../product.service';

@Component({
  selector: 'app-product',
  templateUrl: './product.component.html',
  styleUrls: ['./product.component.css']
})
export class ProductComponent implements OnInit {
  firstFormGroup: FormGroup;
  secondFormGroup: FormGroup;
  thirdFormGroup: FormGroup;
  fourthFormGroup: FormGroup;
  choices: string[] = ['Yes','No'];
  test1: string;
  test2: string;
  test3: string;
  test4: string;
  // inptest: string;
  lister: boolean[] = []
  monitorname: any;
  monitorfromstepper: any;
  monitors: any;
 showstepper = false;
 showsearch = false;

  tempJs: any={
    "isTouchscreen": true,
    "isWireless": true,
    "isInteroperable": true,
    "connectivitywithemr": true

}

  constructor(private _formBuilder: FormBuilder, private prodservice: ProductService) { }

  ngOnInit() {
    this.firstFormGroup = this._formBuilder.group({
      firstCtrl: ['', Validators.required]
    });
    this.secondFormGroup = this._formBuilder.group({
      secondCtrl: ['', Validators.required]
    });
    this.thirdFormGroup = this._formBuilder.group({
      thirdCtrl: ['', Validators.required]
    });
    this.fourthFormGroup = this._formBuilder.group({
      fourthCtrl: ['', Validators.required]
    });
    this.getEveryMonitors();
  }

  onSubmits(formdata){
    console.log("success");
    this.getMonitorByName(formdata.value.label);
    this.showstepper = false;
    this.showsearch = true;
    
    // this.getMonitors();
  }

  onSubmit1() {
    console.log( this.test1 ) ;
    
    if(this.test1=='Yes'){
      this.lister.push(true);
    }
    else{
      this.lister.push(false);
    }
  }

  onSubmit2() {
    console.log( this.test2 ) ;

    if(this.test2=='Yes'){
      this.lister.push(true);
    }
    else{
      this.lister.push(false);
    }
  }

  onSubmit3() {
    console.log( this.test3 ) ;

    if(this.test3=='Yes'){
      this.lister.push(true);
    }
    else{
      this.lister.push(false);
    }

  }

  onSubmit4() {
    console.log( this.test4 ) ;

    if(this.test4=='Yes'){
      this.lister.push(true);
    }
    else{
      this.lister.push(false);
    }
  }

  onSubmit5() {
    // console.log(this.lister);
    this.tempJs.isTouchscreen=this.lister[0];
    this.tempJs.isWireless=this.lister[1];
    this.tempJs.isInteroperable=this.lister[2];
    this.tempJs.connectivitywithemr=this.lister[3];
    this.showsearch = false;
    this.showstepper = true;
    this.getMonitors();
  }

  // onreset() {
  //   this.showstepper=false;
  // }

  getMonitors() {​​
    // this.tempJs1= <JSON>this.tempJs;
    console.log(this.tempJs);
    this.prodservice.getAllMonitors(this.tempJs).subscribe(response => {​​

      this.monitorfromstepper = response;
      console.log(this.monitorfromstepper);
    }​​);
  }

  getMonitorByName(name) {

    console.log(name);
    this.prodservice.getMonitorByName(name).subscribe(response => {​​

      this.monitorname = response;
      console.log(this.monitorname.name);
    }​​);
  }

  getEveryMonitors() {

    this.prodservice.getEveryMonitors().subscribe(response => {
      this.monitors = response;
      console.log(this.monitors);

    });
  }

}
