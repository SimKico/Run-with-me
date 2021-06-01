/* tslint:disable:no-unused-variable */

import { TestBed, async, inject } from '@angular/core/testing';
import { InjuryService } from './injury.service';

describe('Service: Injury', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [InjuryService]
    });
  });

  it('should ...', inject([InjuryService], (service: InjuryService) => {
    expect(service).toBeTruthy();
  }));
});
