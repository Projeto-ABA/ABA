import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CadastraAtividadeComponent } from './cadastra-atividade.component';

describe('CadastraAtividadeComponent', () => {
  let component: CadastraAtividadeComponent;
  let fixture: ComponentFixture<CadastraAtividadeComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ CadastraAtividadeComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(CadastraAtividadeComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
