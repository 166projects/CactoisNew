import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { UserhelpdeskviewcomplaintComponent } from './userhelpdeskviewcomplaint.component';

describe('UserhelpdeskviewcomplaintComponent', () => {
  let component: UserhelpdeskviewcomplaintComponent;
  let fixture: ComponentFixture<UserhelpdeskviewcomplaintComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ UserhelpdeskviewcomplaintComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(UserhelpdeskviewcomplaintComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
