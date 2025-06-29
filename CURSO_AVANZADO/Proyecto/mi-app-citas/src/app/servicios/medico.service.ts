import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';

export interface Medico {
  dni: string;
  nombre: string;  
  especialidad:string;
 }

@Injectable({
  providedIn: 'root'
})
export class MedicoService {
    
  private apiUrlMedicos = environment.apiBaseUrl + '/medicos';

  constructor(private http: HttpClient) {}

    obtenerTodosMedicos(): Observable<Medico[]> {
     return this.http.get<Medico[]>(this.apiUrlMedicos);    
    }
}
