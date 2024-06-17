import { ComponentFixture, TestBed } from '@angular/core/testing';

import { HotelownerAddhotelComponent } from './hotelowner-addhotel.component';

describe('HotelownerAddhotelComponent', () => {
  let component: HotelownerAddhotelComponent;
  let fixture: ComponentFixture<HotelownerAddhotelComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [HotelownerAddhotelComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(HotelownerAddhotelComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
