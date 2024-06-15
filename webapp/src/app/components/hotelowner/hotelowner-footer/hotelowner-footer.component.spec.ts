import { ComponentFixture, TestBed } from '@angular/core/testing';

import { HotelownerFooterComponent } from './hotelowner-footer.component';

describe('HotelownerFooterComponent', () => {
  let component: HotelownerFooterComponent;
  let fixture: ComponentFixture<HotelownerFooterComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [HotelownerFooterComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(HotelownerFooterComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
