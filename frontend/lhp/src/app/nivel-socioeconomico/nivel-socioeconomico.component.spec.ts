import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { NivelSocioeconomicoComponent } from './nivel-socioeconomico.component';

describe('NivelSocioeconomicoComponent', () => {
  let component: NivelSocioeconomicoComponent;
  let fixture: ComponentFixture<NivelSocioeconomicoComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ NivelSocioeconomicoComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(NivelSocioeconomicoComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should be created', () => {
    expect(component).toBeTruthy();
  });
});
