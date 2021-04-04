import { HamburgueriaAppComponent } from './hamburgueria.app.component';
import { NgModule } from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
import { RegisterComponent } from './register/register.component';
import { ListComponent } from './list/list.component';

const contaRouterConfig: Routes = [
  {
    path: '', component: HamburgueriaAppComponent,
    children: [
      {path: 'register', component: RegisterComponent},
      {path: 'list', component: ListComponent}
    ]
  }
]

@NgModule({
  imports: [
    RouterModule.forChild(contaRouterConfig),
  ],
  exports: [RouterModule]
})
export class HamburgueriaRouterModule {}
