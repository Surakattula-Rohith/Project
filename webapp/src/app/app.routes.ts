import { Routes } from '@angular/router';
import { LandingPageComponent } from './components/landing-page/landing-page.component';
import { LoginComponent } from './components/login/login.component';
import { RegisterComponent } from './components/register/register.component';
import { CustomerContentComponent } from './components/customer/customer-content/customer-content.component';
import { CustomerFooterComponent } from './components/customer/customer-footer/customer-footer.component';
import { CustomerHeaderComponent } from './components/customer/customer-header/customer-header.component';
import { CustomerHomepageComponent } from './components/customer/customer-homepage/customer-homepage.component';
import { AdminContentComponent } from './components/admin/admin-content/admin-content.component';
import { HotelownerContentComponent } from './components/hotelowner/hotelowner-content/hotelowner-content.component';


export const routes: Routes = [

    { path: '', redirectTo: 'landing-page', pathMatch: 'full' },
    {
        path: 'landing-page', component: LandingPageComponent,
        children: [
            { path: '', redirectTo: 'login', pathMatch: 'full' },
            { path: 'login', component: LoginComponent },
            { path: 'register', component: RegisterComponent }
        ]
    },
    {
        path: 'customer-content', component: CustomerContentComponent,
        // children: [
        //     { path: '', redirectTo: 'customer-homepage', pathMatch: 'full' },
        //     { path: 'customer-header', component: CustomerHeaderComponent },
        //     { path: 'customer-footer', component: CustomerFooterComponent },
        //     { path: 'customer-homepage', component: CustomerHomepageComponent }
        // ]
    },
    {
        path: 'admin-content', component: AdminContentComponent,
        // children: [
        //     { path: '', redirectTo: 'customer-homepage', pathMatch: 'full' },
        //     { path: 'customer-header', component: CustomerHeaderComponent },
        //     { path: 'customer-footer', component: CustomerFooterComponent },
        //     { path: 'customer-homepage', component: CustomerHomepageComponent }
        // ]
    },
    {
        path: 'hotelowner-content', component: HotelownerContentComponent,
        // children: [
        //     { path: '', redirectTo: 'customer-homepage', pathMatch: 'full' },
        //     { path: 'customer-header', component: CustomerHeaderComponent },
        //     { path: 'customer-footer', component: CustomerFooterComponent },
        //     { path: 'customer-homepage', component: CustomerHomepageComponent }
        // ]
    }


];

