import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { HotelOwner } from '../../model/HotelOwner';

@Injectable({
  providedIn: 'root'
})
export class HotelownerService {

  constructor(private http: HttpClient) { }

  addHotelOwner(hotelOwner: HotelOwner) {
    return this.http.post('http://localhost:8081/hotel/addHotel', hotelOwner);
  }
  
}
