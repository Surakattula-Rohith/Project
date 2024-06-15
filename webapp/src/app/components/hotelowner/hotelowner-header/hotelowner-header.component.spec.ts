import { ComponentFixture, TestBed } from '@angular/core/testing';

import { HotelownerHeaderComponent } from './hotelowner-header.component';

describe('HotelownerHeaderComponent', () => {
  let component: HotelownerHeaderComponent;
  let fixture: ComponentFixture<HotelownerHeaderComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [HotelownerHeaderComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(HotelownerHeaderComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
