export class NewHamburguerModel {

  name: string | undefined;
  ingredients: HamburguerIngredient[]  | undefined;

  constructor(name?: string, ingredients?: HamburguerIngredient[] | undefined){
    this.name = name;
    this.ingredients = ingredients;
  }
}

export interface HamburguerIngredient {

  id: number;
  quantity: number;

}
