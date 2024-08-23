import { ComponentFixture, TestBed } from '@angular/core/testing';

import { VieAllComponent } from './vie-all.component';

describe('VieAllComponent', () => {
  let component: VieAllComponent;
  let fixture: ComponentFixture<VieAllComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ VieAllComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(VieAllComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
