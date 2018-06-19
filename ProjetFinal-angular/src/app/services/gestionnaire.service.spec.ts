import { TestBed, inject } from '@angular/core/testing';

import { FormateurRestService } from './formateur.rest.service';

describe('FormateurRestService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [FormateurRestService]
    });
  });

  it('should be created', inject([FormateurRestService], (service: FormateurRestService) => {
    expect(service).toBeTruthy();
  }));
});
