import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { Stagiaire.DetailComponent } from './stagiaire.detail.component';

describe('Stagiaire.DetailComponent', () => {
  let component: Stagiaire.DetailComponent;
  let fixture: ComponentFixture<Stagiaire.DetailComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ Stagiaire.DetailComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(Stagiaire.DetailComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
