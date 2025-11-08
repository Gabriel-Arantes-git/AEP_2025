import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CriarFormulario } from './criar-formulario';

describe('CriarFormulario', () => {
  let component: CriarFormulario;
  let fixture: ComponentFixture<CriarFormulario>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [CriarFormulario]
    })
    .compileComponents();

    fixture = TestBed.createComponent(CriarFormulario);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
