import { TestBed } from '@angular/core/testing';

import { userservice } from './userservice.service';

describe('UserserviceService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: userservice = TestBed.get(userservice);
    expect(service).toBeTruthy();
  });
});
