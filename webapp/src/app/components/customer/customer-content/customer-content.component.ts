import { CommonModule } from '@angular/common';
import { Component } from '@angular/core';
import { RouterOutlet, RouterLink, RouterLinkActive } from '@angular/router';
import { CustomerHeaderComponent } from "../customer-header/customer-header.component";
import { CustomerFooterComponent } from '../customer-footer/customer-footer.component';
import { CustomerHomepageComponent } from '../customer-homepage/customer-homepage.component';

@Component({
    selector: 'app-customer-content',
    standalone: true,
    templateUrl: './customer-content.component.html',
    styleUrl: './customer-content.component.css',
    imports: [RouterOutlet, RouterLink, RouterLinkActive, CommonModule, CustomerHeaderComponent,CustomerFooterComponent,CustomerHomepageComponent]
})
export class CustomerContentComponent {

}
