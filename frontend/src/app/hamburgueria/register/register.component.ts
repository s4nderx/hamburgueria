import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { ToastrService } from 'ngx-toastr';
import { NewHamburguerModel } from '../models/NewHamburguer.model';
import { HamburguerService } from '../services/hamburguer.service';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {

  ingredients: any[] = [];
  newHamburguer: NewHamburguerModel = new NewHamburguerModel();
  errors: any[] = [];
  constructor(private service: HamburguerService,
    private toastr: ToastrService,
    private router: Router,) { }


  ngOnInit(): void {
    this.getIngredients();
  }

  public getIngredients() : any {
    this.service.findIngredients().subscribe(data => {
      this.ingredients = data.map(x => {return {quantity: 0, name: x.name, price: x.price, id: x.id}});
    });
  }

  enviar() {
    this.newHamburguer.ingredients = this.ingredients
    .map(x => { return {id: x.id, quantity: x.quantity}})
    .filter(x => x.quantity !== 0);

    this.service.createBurguer(this.newHamburguer).subscribe(
      data => {
      this.sucessInsert(data);
      },
      failure => {
        this.failureInsert(failure);
      }
    )
  }

  sucessInsert(res: any){
    this.newHamburguer = new NewHamburguerModel();
    this.getIngredients();
    this.toastr.success('Hamburguer cadastrado com sucesso!', 'Sucesso!');
    this.router.navigate(['/hamburgueria/list']);
  }

  failureInsert(failure: any) {

    this.errors = failure.error?.errors || [];
    console.log(this.errors );
    this.toastr.error('Ocorreu um erro!', 'Opa :(');
  };

  inputnumber = 0;

  plus(item: any){
    item.quantity = item.quantity+1;
  }

  minus(item: any){
    if(item.quantity != 0){
      item.quantity = item.quantity-1;
    }

  }

  verifyValidAndTouched(field: any, form: any) {
    return (!field.valid && field.touched) || (form.submitted && !field.valid);
  }

  applyCssError(field: any, form: any) {
    return {
        "is-invalid": this.verifyValidAndTouched(field, form),
    };

  }
}
