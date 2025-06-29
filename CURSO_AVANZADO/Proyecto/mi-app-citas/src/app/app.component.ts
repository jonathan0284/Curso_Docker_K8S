import { Component } from '@angular/core';
import { MenuItem } from 'primeng/api';


@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'mi-app-citas';
  menuItems: MenuItem[] = [{}];


  ngOnInit() {
    this.menuItems = [
      {
        label: 'Inicio',
        icon: 'pi pi-home',
        routerLink: ['/']
      },
      {
        label: 'Citas',
        icon: 'pi pi-calendar',
        items: [
          {
            label: 'Crear cita',
            icon: 'pi pi-plus-circle',
            routerLink: ['/crear-cita'] // o (click)="abrirModal()" si es con diálogo
          },
          {
            label: 'Ver citas',
            icon: 'pi pi-list',
            routerLink: ['/citas']
          }
        ]
      },
      {
        label: 'Perfil',
        icon: 'pi pi-user',
        routerLink: ['/perfil']
      }
    ];
  }
}
