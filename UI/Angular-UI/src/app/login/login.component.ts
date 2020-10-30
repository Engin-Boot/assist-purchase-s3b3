import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  constructor(private router: Router) { }

  ngOnInit(): void {
  }

   result = "";
  onSubmit(Username, Password){

    if(Username == "admin" && Password == "admin")
    {
      this.router.navigate(['./admin']);
    }
    else{
      this.result = "Invalid credentials";
    }

  }
}
