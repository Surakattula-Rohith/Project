import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { HotelOwner } from '../../model/HotelOwner';

@Injectable({
  providedIn: 'root'
})
export class HotelService {

  private baseUrl = 'http://localhost:8081/hotel';

  constructor(private http: HttpClient) { }

  addHotel(hotel: HotelOwner): Observable<HotelOwner> {
    return this.http.post<HotelOwner>(`${this.baseUrl}/addHotel`, hotel);
  }

  updateHotel(hotelId: number, hotel: HotelOwner): Observable<HotelOwner> {
    return this.http.put<HotelOwner>(`${this.baseUrl}/update/${hotelId}`, hotel);
  }

  deleteHotel(hotelId: number): Observable<String> {
    return this.http.delete<String>(`${this.baseUrl}/delete/${hotelId}`);
  }

  findByOwnerName(ownerName: string): Observable<HotelOwner[]> {
    return this.http.get<HotelOwner[]>(`${this.baseUrl}/owner/${ownerName}`);
  }
}
