import { Component } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-hotelowner-header',
  standalone: true,
  imports: [],
  templateUrl: './hotelowner-header.component.html',
  styleUrl: './hotelowner-header.component.css'
})
export class HotelownerHeaderComponent {
  constructor(private router: Router) { }

  navigateToHome() {
    this.router.navigate(['hotelowner-content/']);
  }

  navigateToAddHotel() {
    this.router.navigate(['hotelowner-content/add-hotel']);
  }

}
