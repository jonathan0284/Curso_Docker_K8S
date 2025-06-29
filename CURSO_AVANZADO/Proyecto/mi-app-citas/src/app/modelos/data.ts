export interface CitaMedica {
  dniPaciente: string,
  dniMedico: string,
  fechaHoraCita: string,
  motivo: string,
  lugar: {
    tipo: string,
    nombre: string,
    direccion: string
  }
}

export interface Lugar {
  tipo: string;
  nombre: string;
  direccion: string;
}

export interface Especialidad {
  nombre: string;
  codigo: string;
}


export const LUGARES_EJEMPLO: Lugar[] = [
  {
    tipo: 'Consultorio',
    nombre: 'Consultorio Neurológico',
    direccion: 'Av Principal 120, Lima'
  },
  {
    tipo: 'Hospital',
    nombre: 'Hospital Nacional Edgardo Rebagliati',
    direccion: 'Av Salaverry 2255, Jesús María'
  },
  {
    tipo: 'Clinica',
    nombre: 'Clínica Internacional - Sede Lima',
    direccion: 'Av. Garcilaso de la Vega 1420, Cercado de Lima'
  },
  {
    tipo: 'Consultorio',
    nombre: 'Consultorio Dermatológico Miraflores',
    direccion: 'Calle Los Pinos 134, Miraflores'
  },
  {
    tipo: 'Centro Medico',
    nombre: 'Centro Médico San Borja Salud',
    direccion: 'Jr. Crespín 145, San Borja'
  },
  {
    tipo: 'Clinica',
    nombre: 'Clínica San Gabriel',
    direccion: 'Av. La Marina 2955, San Miguel'
  }
];

export const ESPECIALIDADES: Especialidad[] = [
  { nombre: 'Cardiologia', codigo: 'Cardiologia' },
  { nombre: 'Dermatologia', codigo: 'Dermatologia' },
  { nombre: 'Neurologia', codigo: 'Neurologia' },
  { nombre: 'Pediatria', codigo: 'Pediatria' },
];
