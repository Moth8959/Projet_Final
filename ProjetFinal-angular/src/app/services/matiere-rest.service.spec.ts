import { TestBed, inject } from '@angular/core/testing';

import { MatiereRestService } from './matiere-rest.service';

describe('MatiereRestService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [MatiereRestService]
    });
  });

  it('should be created', inject([MatiereRestService], (service: MatiereRestService) => {
    expect(service).toBeTruthy();
  }));
});
