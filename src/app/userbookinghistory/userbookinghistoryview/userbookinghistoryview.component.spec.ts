import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { UserbookinghistoryviewComponent } from './userbookinghistoryview.component';

describe('UserbookinghistoryviewComponent', () => {
  let component: UserbookinghistoryviewComponent;
  let fixture: ComponentFixture<UserbookinghistoryviewComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ UserbookinghistoryviewComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(UserbookinghistoryviewComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
