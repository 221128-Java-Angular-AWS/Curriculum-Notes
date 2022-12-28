import { TestBed } from '@angular/core/testing';

import { TestServService } from './test-serv.service';

describe('TestServService', () => {
  let service: TestServService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(TestServService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
