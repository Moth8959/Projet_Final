import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { FormateurCompetencesComponent } from './formateur-competences.component';

describe('FormateurCompetencesComponent', () => {
  let component: FormateurCompetencesComponent;
  let fixture: ComponentFixture<FormateurCompetencesComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ FormateurCompetencesComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(FormateurCompetencesComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
