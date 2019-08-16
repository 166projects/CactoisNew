import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { UserhelpdeskaddcomplaintComponent } from './userhelpdeskaddcomplaint.component';

describe('UserhelpdeskaddcomplaintComponent', () => {
  let component: UserhelpdeskaddcomplaintComponent;
  let fixture: ComponentFixture<UserhelpdeskaddcomplaintComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ UserhelpdeskaddcomplaintComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(UserhelpdeskaddcomplaintComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
