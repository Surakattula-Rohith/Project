import { Component } from '@angular/core';
import { HotelOwner } from '../../../model/HotelOwner';
import { FormsModule, NgForm } from '@angular/forms';
import { RouterOutlet, RouterLink, RouterLinkActive } from '@angular/router';
import { CommonModule } from '@angular/common';
import { BrowserModule } from '@angular/platform-browser';
import { HotelService } from '../../../services/hotelowner/hotelowner.service';
import { HttpClientModule } from '@angular/common/http';

@Component({
  selector: 'app-hotelowner-addhotel',
  standalone: true,
  providers: [HotelService],
  imports: [CommonModule, FormsModule,HttpClientModule],
  templateUrl: './hotelowner-addhotel.component.html',
  styleUrl: './hotelowner-addhotel.component.css'
})
export class HotelownerAddhotelComponent { 
  
  ngOnInit(): void {}

  constructor(private hotelService : HotelService){
    this.hotelOwner = new HotelOwner() ;
  }

  hotelOwner: HotelOwner = {
    hotelName: '',
    state: '',
    city: '',
    address: '',
    gstNumber: '',
    ownerName: '',
    description: '',
    ac: false,
    wifi: false,
    maintainance: false,
    singleRooms: 0,
    doubleRooms: 0,
    tripleRooms: 0,
    adminAccess: false
  };

  onSubmit(myForm: NgForm) {
    
    this.hotelOwner = {
      hotelName: myForm.value.hotelName,
      state: myForm.value.state,
      city: myForm.value.city,
      address: myForm.value.address,
      gstNumber: myForm.value.gstNumber,
      ownerName: myForm.value.ownerName,
      description: myForm.value.description,
      ac: myForm.value.ac || false,
      wifi: myForm.value.wifi || false,
      maintainance: myForm.value.maintainance || false,
      singleRooms: myForm.value.singleRooms || 0,
      doubleRooms: myForm.value.doubleRooms || 0,
      tripleRooms: myForm.value.tripleRooms || 0,
      adminAccess: myForm.value.adminAccess || false
    };

    this.hotelService.addHotel(this.hotelOwner).subscribe(
      (response: any) => {
        this.hotelOwner = new HotelOwner() ;
        alert('Owner Added Successfully');
      },
      (error) => {
        alert('Add valid details');
      }
    );
  }
}
