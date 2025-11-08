import { ComponentFixture, TestBed } from '@angular/core/testing';

import { VisaoDadosTurma } from './visao-dados-turma';

describe('VisaoDadosTurma', () => {
  let component: VisaoDadosTurma;
  let fixture: ComponentFixture<VisaoDadosTurma>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [VisaoDadosTurma]
    })
    .compileComponents();

    fixture = TestBed.createComponent(VisaoDadosTurma);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
