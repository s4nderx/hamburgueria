/* Angular modules */
import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterModule } from '@angular/router';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import {HttpClientModule} from '@angular/common/http'

/* My Components */

import { HamburgueriaAppComponent } from './hamburgueria.app.component';
import { RegisterComponent } from './register/register.component';
import { ListComponent } from './list/list.component';

/* My Modules */
import { HamburgueriaRouterModule } from './hamburgueria.route';
import { HamburguerService } from './services/hamburguer.service';



@NgModule({
  declarations: [
    RegisterComponent,
    ListComponent,
    HamburgueriaAppComponent
  ],
  imports: [
    CommonModule,
    RouterModule,
    HamburgueriaRouterModule,
    FormsModule,
    ReactiveFormsModule,
    HttpClientModule,
  ],
  providers: [
    HamburguerService
  ]
})
export class HamburgueriaModule { }
