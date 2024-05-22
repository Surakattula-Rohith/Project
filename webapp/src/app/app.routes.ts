import { Routes } from '@angular/router';
import { CustomerFooterComponent } from './components/customer-footer/customer-footer.component';
import { CustomerHeaderComponent } from './components/customer-header/customer-header.component';
import { CustomerHomepageComponent } from './components/customer-homepage/customer-homepage.component';
import { CustomerContentComponent } from './components/customer-content/customer-content.component';
import { LandingPageComponent } from './components/landing-page/landing-page.component';
import { LoginComponent } from './components/login/login.component';
import { RegisterComponent } from './components/register/register.component';


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
        children: [
            { path: '', redirectTo: 'customer-homepage', pathMatch: 'full' },
            { path: 'customer-header', component: CustomerHeaderComponent },
            { path: 'customer-footer', component: CustomerFooterComponent },
            { path: 'customer-homepage', component: CustomerHomepageComponent }
        ]
    }


];

