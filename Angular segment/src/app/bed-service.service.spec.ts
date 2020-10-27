import { TestBed } from '@angular/core/testing';

import { BedServiceService } from './bed-service.service';

describe('BedServiceService', () => {
  let service: BedServiceService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(BedServiceService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
