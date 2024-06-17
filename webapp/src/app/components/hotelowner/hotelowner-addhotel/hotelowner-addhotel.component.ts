import { Component } from '@angular/core';
import { HotelOwner } from '../../../model/HotelOwner';
import { FormsModule, NgForm } from '@angular/forms';
import { RouterOutlet, RouterLink, RouterLinkActive } from '@angular/router';
import { CommonModule } from '@angular/common';
import { BrowserModule } from '@angular/platform-browser';

@Component({
  selector: 'app-hotelowner-addhotel',
  standalone: true,
  imports: [CommonModule, FormsModule],
  templateUrl: './hotelowner-addhotel.component.html',
  styleUrl: './hotelowner-addhotel.component.css'
})
export class HotelownerAddhotelComponent {

  hotelOwner: HotelOwner = {}; 

  onSubmit(form: NgForm) {
    if (form.valid) {
      console.log('Form submitted!', this.hotelOwner);
    } else {
      console.log('Form is invalid!');
    }
  }
}
