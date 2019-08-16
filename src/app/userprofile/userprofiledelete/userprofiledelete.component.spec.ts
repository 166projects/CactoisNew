import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { UserprofiledeleteComponent } from './userprofiledelete.component';

describe('UserprofiledeleteComponent', () => {
  let component: UserprofiledeleteComponent;
  let fixture: ComponentFixture<UserprofiledeleteComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ UserprofiledeleteComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(UserprofiledeleteComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
