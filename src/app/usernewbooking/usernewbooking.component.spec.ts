import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { UsernewbookingComponent } from './usernewbooking.component';

describe('UsernewbookingComponent', () => {
  let component: UsernewbookingComponent;
  let fixture: ComponentFixture<UsernewbookingComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ UsernewbookingComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(UsernewbookingComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
