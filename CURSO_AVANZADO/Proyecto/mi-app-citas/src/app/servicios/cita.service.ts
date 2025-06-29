import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { CitaMedica } from '../modelos/data';
import { environment } from 'src/environments/environment';

export interface Cita {
  id: string;
  codigoCita: string;
  fechaHoraCita: string;
  paciente: {
    dni: string;
    nombre: string;
    direccion: string;
  };
   medico: {
    dni: string;
    nombre: string;
    especialidad: string;
    celular: string;
  };
  lugar: {
    tipo: string;
    nombre: string;
    direccion: string;
  };
  motivo: string;
  estado: string;
  // Agrega los campos que devuelve tu API
}

@Injectable({
  providedIn: 'root'
})
export class CitaService {
  
  private apiUrl = environment.apiBaseUrl + '/citas';
  

  constructor(private http: HttpClient) {}

  obtenerCitas(): Observable<Cita[]> {
   return this.http.get<Cita[]>(this.apiUrl);    
  }

  guardarCita(cita: CitaMedica): Observable<any> {
    return this.http.post<any>(this.apiUrl, cita);
  }
  
}
