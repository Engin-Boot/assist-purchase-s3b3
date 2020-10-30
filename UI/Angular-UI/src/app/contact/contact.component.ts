import { Component, OnInit } from '@angular/core';
import { ContactService } from '../contact.service';
import {FormBuilder} from '@angular/forms';

@Component({
  selector: 'app-contact',
  templateUrl: './contact.component.html',
  styleUrls: ['./contact.component.css']
})
export class ContactComponent implements OnInit {

  
  abcd: any;
  tempJson: any={
    "name": "",
    "email": "",
    "mobile": "",
    "monitorDevice": "",
    "message": ""
}

  constructor(private contactservice: ContactService ) { }

  ngOnInit(): void {
  
  }
  
  onSubmits(formdata){
    this.tempJson.name = formdata.value.Name;
    this.tempJson.email = formdata.value.Sender;
    this.tempJson.mobile = formdata.value.Mobile;
    this.tempJson.monitorDevice = formdata.value.Device;
    this.tempJson.message = formdata.value.Message;
    this.sendMailToSalesTeam();
  }

  sendMailToSalesTeam()
  {
    console.log(this.tempJson);
    this.contactservice.sendMailToSalesTeam(this.tempJson).subscribe(response => {​​

    this.abcd = response;
    console.log(this.abcd);
}​​)

  }
}
