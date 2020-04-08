import { Component, OnInit } from '@angular/core';
import {any} from "codelyzer/util/function";

@Component({
  selector: 'app-my-coworkers',
  templateUrl: './my-coworkers.component.html',
  styleUrls: ['./my-coworkers.component.scss']
})
export class MyCoworkersComponent implements OnInit {
  //variables
  data: any[] = [
    {name: 'Coworker1', surname: 'Surname1', city: 'city1', phone: '078395088', totalOrders: '35', graniteOrders:'30', porcelainOrders: '5'},
    {name: 'Coworker1', surname: 'Surname1', city: 'city1', phone: '078395088', totalOrders: '35', graniteOrders:'30', porcelainOrders: '5'},
    {name: 'Coworker1', surname: 'Surname1', city: 'city1', phone: '078395088', totalOrders: '35', graniteOrders:'30', porcelainOrders: '5'},
  ];
  displayedColumns: string[] = ['name', 'surname', 'city', 'phone', 'totalOrders', 'graniteOrders', 'porcelainOrders', 'buttons'];
  //constructor
  constructor() { }

  //metoda koja se izvrsuva na load
  ngOnInit(): void {
  }

}
