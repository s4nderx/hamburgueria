import { Component, OnInit } from '@angular/core';
import { HamburguerModel } from '../models/Hamburguer.model';
import { HamburguerService } from '../services/hamburguer.service';

@Component({
  selector: 'app-list',
  templateUrl: './list.component.html',
  styleUrls: ['./list.component.css']
})
export class ListComponent implements OnInit {

  hamburguers: HamburguerModel[] = [];
  constructor(private service: HamburguerService) { }

  ngOnInit(): void {
    this.findAll();
  }

  findAll(page?: number): void {
    this.service.findAll(page).subscribe(response => {
      this.hamburguers = response;
    })
  }

}
