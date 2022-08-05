import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ExibirTurmaComponent } from './exibir-turma.component';

describe('ExibirTurmaComponent', () => {
  let component: ExibirTurmaComponent;
  let fixture: ComponentFixture<ExibirTurmaComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ExibirTurmaComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ExibirTurmaComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
