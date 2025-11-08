import { ComponentFixture, TestBed } from '@angular/core/testing';

import { FormulariosAluno } from './formularios-aluno';

describe('FormulariosAluno', () => {
  let component: FormulariosAluno;
  let fixture: ComponentFixture<FormulariosAluno>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [FormulariosAluno]
    })
    .compileComponents();

    fixture = TestBed.createComponent(FormulariosAluno);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
