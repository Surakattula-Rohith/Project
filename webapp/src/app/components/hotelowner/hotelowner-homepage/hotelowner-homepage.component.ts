import { CommonModule } from '@angular/common';
import { HttpClientModule } from '@angular/common/http';
import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { HotelService } from '../../../services/hotelowner/hotelowner.service';

@Component({
  selector: 'app-hotelowner-homepage',
  standalone: true,
  providers: [HotelService],
  imports: [CommonModule, FormsModule,HttpClientModule],
  templateUrl: './hotelowner-homepage.component.html',
  styleUrl: './hotelowner-homepage.component.css'
})
export class HotelownerHomepageComponent {
  ngOnInit(): void {}
  
}
