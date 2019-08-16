import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { UserhelpdeskComponent } from './userhelpdesk.component';

describe('UserhelpdeskComponent', () => {
  let component: UserhelpdeskComponent;
  let fixture: ComponentFixture<UserhelpdeskComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ UserhelpdeskComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(UserhelpdeskComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
