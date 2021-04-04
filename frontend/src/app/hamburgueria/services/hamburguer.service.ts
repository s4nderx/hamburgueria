import { HttpClient } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { Observable } from "rxjs";
import { ServiceBase } from "src/app/services/base.service";
import { HamburguerModel, Ingredient } from "../models/Hamburguer.model";
import { catchError, map } from "rxjs/operators";
import { IngredientModel } from "../models/Ingredient.model";
import { NewHamburguerModel } from "../models/NewHamburguer.model";
@Injectable()
export class HamburguerService extends ServiceBase {

  constructor(private http: HttpClient) {
    super();
  }

  findAll(): Observable<HamburguerModel[]> {
    return this.http
    .get<HamburguerModel[]>(`${this._UrlService}/hamburguers`)
    .pipe(catchError(super._serviceError));
  }

  findIngredients(): Observable<IngredientModel[]> {
    return this.http
    .get<IngredientModel[]>(`${this._UrlService}/ingredients`)
    .pipe(catchError(super._serviceError));
  }

  createBurguer(newHamburguer: NewHamburguerModel): Observable<HamburguerModel> {
    console.log('###### [BURGAO] :>>>', newHamburguer)
    return this.http.post(`${this._UrlService}/hamburguers`, newHamburguer)
    .pipe(
      map(super._extractData),
      catchError(super._serviceError)
    );
  }

}
