import { CommonModule } from '@angular/common';
import { Component } from '@angular/core';
import { RouterOutlet, RouterLink, RouterLinkActive } from '@angular/router';
import { AdminHeaderComponent } from '../admin-header/admin-header.component';
import { AdminHomepageComponent } from '../admin-homepage/admin-homepage.component';
import { AdminFooterComponent } from '../admin-footer/admin-footer.component';

@Component({
  selector: 'app-admin-content',
  standalone: true,
  imports: [RouterOutlet, RouterLink, RouterLinkActive, CommonModule,AdminHeaderComponent,AdminHomepageComponent,AdminFooterComponent],
  templateUrl: './admin-content.component.html',
  styleUrl: './admin-content.component.css'
})
export class AdminContentComponent {

}
