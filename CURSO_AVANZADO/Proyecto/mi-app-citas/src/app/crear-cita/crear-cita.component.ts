import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup } from '@angular/forms';
import { CitaService, Cita } from '../servicios/cita.service';
import { UsuarioService, Paciente } from '../servicios/usuario.service';
import { MedicoService, Medico } from '../servicios/medico.service';
import { LUGARES_EJEMPLO, Lugar } from '../modelos/data';
import { ESPECIALIDADES, Especialidad } from '../modelos/data';
import { CitaMedica } from '../modelos/data';
import { Router } from '@angular/router';


@Component({
  selector: 'app-crear-cita',
  templateUrl: './crear-cita.component.html',
  styleUrls: ['./crear-cita.component.css']
})
export class CrearCitaComponent implements OnInit {

  formularioCita!: FormGroup;
  pacientes: Paciente[] = [];
  especialidades: any[] = [];
  medicosFiltrados: any[] = [];
  todosLosMedicos: Medico[] = [];
  especialidadSeleccionada: string | null = null;

  lugares: Lugar[] = [];
  tiposLugar: string[] = [];
  nombresFiltrados: Lugar[] = [];

  tipoSeleccionado: string | null = null;
  nombreSeleccionado: Lugar | null = null;
  direccion: string = '';

  constructor(
    private fb: FormBuilder,
    private usuarioService: UsuarioService,
    private medicoService: MedicoService,
    private citaService: CitaService,
    private router: Router
  ) { }

  ngOnInit(): void {

    this.lugares = LUGARES_EJEMPLO;
    // Extrae tipos únicos para el primer dropdown
    this.tiposLugar = [...new Set(this.lugares.map(l => l.tipo))];

    this.formularioCita = this.fb.group({
      paciente: [''],
      medico: [null],
      especialidad: [null],
      fecha: [''],
      hora: [''],
      motivo: [''],
      tipoLugar: [''],
      nombreLugar: [''],
      direccion: [''],
    });

    this.especialidades = ESPECIALIDADES;

    this.cargarPacientes();
    this.cargarMedicos();
    this.filtrarLugaresPorTipo();
    this.mostrarDireccionSeleccionada();

  }

  cargarPacientes() {

    this.usuarioService.obtenerPacientes().subscribe(data => {
      this.pacientes = data.map(p => ({
        ...p,
        dniNombre: `${p.dni}-${p.nombre}`
      }));
    });

  }

  cargarMedicos() {

    this.medicoService.obtenerTodosMedicos().subscribe(data => {
      this.todosLosMedicos = data;
    });


    this.formularioCita.get('especialidad')?.valueChanges.subscribe((especialidad: any) => {
      this.especialidadSeleccionada = especialidad.codigo;
      if (especialidad && especialidad.codigo) {
        this.medicosFiltrados = this.todosLosMedicos.filter(
          m => m.especialidad == especialidad.codigo
        );
      } else {
        this.medicosFiltrados = [];
      }
      console.log(this.medicosFiltrados);

      // Opcional: resetear selección previa
      this.formularioCita.get('medico')?.reset();
    });
  }

guardarCita(): void {
  if (this.formularioCita.valid) {
    const raw = this.formularioCita.value;

    const cita: CitaMedica = {
      dniPaciente: raw.paciente,
      dniMedico: raw.medico.dni,
      fechaHoraCita: this.combinarFechaHora(raw.fecha, raw.hora),
      motivo: raw.motivo,
      lugar: {
        tipo: raw.tipoLugar,
        nombre: raw.nombreLugar,
        direccion: raw.direccion
      }
    };

    // ✅ Enviar al servicio
    this.citaService.guardarCita(cita).subscribe({
      next: (respuesta) => {
        console.log('Cita registrada correctamente', respuesta);
        // Puedes mostrar un toast, limpiar el formulario, etc.
        alert('Cita registrada correctamente');
        this.router.navigate(['/citas']); 
      },
      error: (err) => {
        console.error('Error al guardar la cita', err);
        // Mostrar error visual si deseas
      }
    });
  }
}


  cancelar() {
    this.formularioCita.reset();
    // Si prefieres redirigir al listado de citas o al menú principal:
    // this.router.navigate(['/citas']);
  }


  filtrarLugaresPorTipo(): void {

    // 🔁 Suscribirse al cambio de tipo de lugar
    this.formularioCita.get('tipoLugar')?.valueChanges.subscribe((valorSeleccionado: string) => {
      console.log('Tipo de lugar seleccionado:', valorSeleccionado);
      // Aquí puedes actualizar otras variables si quieres reaccionar
      this.tipoSeleccionado = valorSeleccionado;

      this.nombresFiltrados = this.lugares.filter(l => l.tipo === this.tipoSeleccionado);
      //console.log(this.nombresFiltrados);
      this.nombreSeleccionado = null;
      this.direccion = '';


    });

  }

  mostrarDireccionSeleccionada(): void {
  this.formularioCita.get('nombreLugar')?.valueChanges.subscribe((valor: any) => {
    const lugar = this.nombresFiltrados.find(l => l.nombre === valor);
    const direccion = lugar?.direccion || '';

    // ✅ Actualiza el form control directamente
    this.formularioCita.patchValue({
      direccion: direccion
    });
  });
}


  private combinarFechaHora(fecha: string, hora: string): string {
    return `${fecha} ${hora}:00`; // formato simple si ya vienen como strings
  }


}
