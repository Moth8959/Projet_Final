import { TestBed, inject } from '@angular/core/testing';

import { OrdinateurRestService } from './ordinateur-rest.service';

describe('OrdinateurRestService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [OrdinateurRestService]
    });
  });

  it('should be created', inject([OrdinateurRestService], (service: OrdinateurRestService) => {
    expect(service).toBeTruthy();
  }));
});
