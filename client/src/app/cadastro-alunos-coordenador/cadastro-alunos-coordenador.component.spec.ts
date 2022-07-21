import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CadastroTurmasCoordenadorComponent } from './cadastro-turmas-coordenador.component';

describe('CadastroTurmasCoordenadorComponent', () => {
  let component: CadastroTurmasCoordenadorComponent;
  let fixture: ComponentFixture<CadastroTurmasCoordenadorComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ CadastroTurmasCoordenadorComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(CadastroTurmasCoordenadorComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
