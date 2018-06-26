import { TestBed, inject } from '@angular/core/testing';

import { ModuleRestService } from './module-rest.service';

describe('ModuleRestService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [ModuleRestService]
    });
  });

  it('should be created', inject([ModuleRestService], (service: ModuleRestService) => {
    expect(service).toBeTruthy();
  }));
});
