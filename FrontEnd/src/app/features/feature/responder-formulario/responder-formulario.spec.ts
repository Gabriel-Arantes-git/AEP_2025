import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ResponderFormulario } from './responder-formulario';

describe('ResponderFormulario', () => {
  let component: ResponderFormulario;
  let fixture: ComponentFixture<ResponderFormulario>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [ResponderFormulario]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ResponderFormulario);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
