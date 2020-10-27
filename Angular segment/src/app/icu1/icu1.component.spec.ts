import { ComponentFixture, TestBed } from '@angular/core/testing';

import { Icu1Component } from './icu1.component';

describe('Icu1Component', () => {
  let component: Icu1Component;
  let fixture: ComponentFixture<Icu1Component>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ Icu1Component ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(Icu1Component);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
