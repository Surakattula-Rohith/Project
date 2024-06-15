import { ComponentFixture, TestBed } from '@angular/core/testing';

import { HotelownerHomepageComponent } from './hotelowner-homepage.component';

describe('HotelownerHomepageComponent', () => {
  let component: HotelownerHomepageComponent;
  let fixture: ComponentFixture<HotelownerHomepageComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [HotelownerHomepageComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(HotelownerHomepageComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
