export interface HamburguerModel {
  id: number;
  name: string;
  discount: number;
  price: number;
  finalPrice: number;
  ingredients: Ingredient[];
}

export interface Ingredient{
  name: string;
  quantity: number;
  price: number;
}
