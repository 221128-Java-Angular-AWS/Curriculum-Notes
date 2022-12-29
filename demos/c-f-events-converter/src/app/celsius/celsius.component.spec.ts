import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CelsiusComponent } from './celsius.component';

describe('CelsiusComponent', () => {
  let component: CelsiusComponent;
  let fixture: ComponentFixture<CelsiusComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ CelsiusComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(CelsiusComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
