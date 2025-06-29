import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';

export interface Paciente {
  dni: string;  
  nombre:string;
  dniNombre: string;
}

@Injectable({
  providedIn: 'root'
})
export class UsuarioService {

  private apiUrl = environment.apiBaseUrl + '/pacientes';

  constructor(private http: HttpClient) { }

  obtenerPacientes(): Observable<Paciente[]> {
    return this.http.get<Paciente[]>(this.apiUrl);
  }
}
