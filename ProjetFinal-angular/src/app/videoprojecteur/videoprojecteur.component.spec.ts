import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { VideoprojecteurComponent } from './videoprojecteur.component';

describe('VideoprojecteurComponent', () => {
  let component: VideoprojecteurComponent;
  let fixture: ComponentFixture<VideoprojecteurComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ VideoprojecteurComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(VideoprojecteurComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
