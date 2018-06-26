import { TestBed, inject } from '@angular/core/testing';

import { VideoprojecteurRestService } from './videoprojecteur-rest.service';

describe('VideoprojecteurRestService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [VideoprojecteurRestService]
    });
  });

  it('should be created', inject([VideoprojecteurRestService], (service: VideoprojecteurRestService) => {
    expect(service).toBeTruthy();
  }));
});
