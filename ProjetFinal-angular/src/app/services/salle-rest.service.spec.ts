import { TestBed, inject } from '@angular/core/testing';

import { SalleRestService } from './salle-rest.service';

describe('SalleRestService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [SalleRestService]
    });
  });

  it('should be created', inject([SalleRestService], (service: SalleRestService) => {
    expect(service).toBeTruthy();
  }));
});
