import { ComponentFixture, TestBed } from '@angular/core/testing';

import { MinhasTurmas } from './minhas-turmas';

describe('MinhasTurmas', () => {
  let component: MinhasTurmas;
  let fixture: ComponentFixture<MinhasTurmas>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [MinhasTurmas]
    })
    .compileComponents();

    fixture = TestBed.createComponent(MinhasTurmas);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
