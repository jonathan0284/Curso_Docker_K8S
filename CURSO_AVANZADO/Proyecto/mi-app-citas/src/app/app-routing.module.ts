import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { CitasComponent } from './citas/citas.component';
import { CrearCitaComponent } from './crear-cita/crear-cita.component';

const routes: Routes = [
  { path: 'citas', component: CitasComponent },
  { path: 'crear-cita', component: CrearCitaComponent },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
