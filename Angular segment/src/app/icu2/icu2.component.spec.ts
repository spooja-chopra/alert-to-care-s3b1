import { ComponentFixture, TestBed } from '@angular/core/testing';

import { Icu2Component } from './icu2.component';

describe('Icu2Component', () => {
  let component: Icu2Component;
  let fixture: ComponentFixture<Icu2Component>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ Icu2Component ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(Icu2Component);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
