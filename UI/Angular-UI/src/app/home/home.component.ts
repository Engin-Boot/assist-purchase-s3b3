import { Component, OnInit } from '@angular/core';
import { OwlOptions } from 'ngx-owl-carousel-o';
@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {

  customOptions: OwlOptions = {
    loop: true,
    margin: 0,
    nav: true,
    autoplay: true,
    autoplayTimeout: 4000,
    autoplaySpeed: 1000,
    autoplayHoverPause: false,
    responsive: {
        0: {
            items: 1,
            nav: true
        },
        480: {
            items: 1,
            nav: true
        },
        667: {
            items: 1,
            nav: true
        },
        1000: {
            items: 1,
            nav: true
        }
    }
  }

  constructor() { }

  ngOnInit(): void {
  }

}
