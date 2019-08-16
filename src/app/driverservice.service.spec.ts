import { TestBed } from '@angular/core/testing';

import { DriverserviceService } from './driverservice.service';

describe('DriverserviceService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: DriverserviceService = TestBed.get(DriverserviceService);
    expect(service).toBeTruthy();
  });
});
