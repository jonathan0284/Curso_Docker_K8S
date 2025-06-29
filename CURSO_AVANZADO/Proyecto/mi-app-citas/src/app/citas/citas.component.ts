import { Component, OnInit } from '@angular/core';
import { CitaService, Cita } from '../servicios/cita.service';

@Component({
  selector: 'app-citas',
  templateUrl: './citas.component.html',
  styleUrls: ['./citas.component.css']
})
export class CitasComponent implements OnInit {

  constructor(
    private citaService: CitaService
  ) { }

  citas: any[] = [];

  ngOnInit(): void {

    this.citaService.obtenerCitas().subscribe(data => {
      this.citas = data;
    });
   

  }

}
