import { CommonModule } from '@angular/common';
import { Component } from '@angular/core';
import { RouterOutlet, RouterLink, RouterLinkActive } from '@angular/router';
import { LoginComponent } from '../login/login.component';
import { RegisterComponent } from '../register/register.component';
import { CustomerHomepageComponent } from '../customer/customer-homepage/customer-homepage.component';

@Component({
  selector: 'app-landing-page',
  standalone: true,
  imports: [RouterOutlet, RouterLink, RouterLinkActive, CommonModule,CustomerHomepageComponent,LoginComponent,RegisterComponent],
  templateUrl: './landing-page.component.html',
  styleUrl: './landing-page.component.css'
})
export class LandingPageComponent {

}
