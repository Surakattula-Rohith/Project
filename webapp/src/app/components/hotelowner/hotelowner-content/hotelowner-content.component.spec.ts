import { ComponentFixture, TestBed } from '@angular/core/testing';

import { HotelownerContentComponent } from './hotelowner-content.component';

describe('HotelownerContentComponent', () => {
  let component: HotelownerContentComponent;
  let fixture: ComponentFixture<HotelownerContentComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [HotelownerContentComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(HotelownerContentComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
