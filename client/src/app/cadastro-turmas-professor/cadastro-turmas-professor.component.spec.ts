import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CadastroTurmasProfessorComponent } from './cadastro-turmas-professor.component';

describe('CadastroTurmasProfessorComponent', () => {
  let component: CadastroTurmasProfessorComponent;
  let fixture: ComponentFixture<CadastroTurmasProfessorComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ CadastroTurmasProfessorComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(CadastroTurmasProfessorComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
