import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AntropometriaComponent } from './antropometria.component';

describe('AntropometriaComponent', () => {
  let component: AntropometriaComponent;
  let fixture: ComponentFixture<AntropometriaComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AntropometriaComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AntropometriaComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should be created', () => {
    expect(component).toBeTruthy();
  });
});
