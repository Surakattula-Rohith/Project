import { CommonModule } from '@angular/common';
import { Component } from '@angular/core';
import { RouterOutlet, RouterLink, RouterLinkActive } from '@angular/router';
import { HotelownerHeaderComponent } from '../hotelowner-header/hotelowner-header.component';
import { HotelownerHomepageComponent } from '../hotelowner-homepage/hotelowner-homepage.component';
import { HotelownerFooterComponent } from '../hotelowner-footer/hotelowner-footer.component';

@Component({
  selector: 'app-hotelowner-content',
  standalone: true,
  imports: [RouterOutlet, RouterLink, RouterLinkActive, CommonModule,HotelownerHeaderComponent,HotelownerHomepageComponent,HotelownerFooterComponent],
  templateUrl: './hotelowner-content.component.html',
  styleUrl: './hotelowner-content.component.css'
})
export class HotelownerContentComponent {

}
