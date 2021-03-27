import { Component } from '@angular/core';
import {FormControl} from '@angular/forms';
import {HttpClient} from '@angular/common/http';
import {BehaviorSubject, Observable} from 'rxjs';
import {Food} from './models/food';
import {map, switchMap} from 'rxjs/operators';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'angular';

  foodSearchTextInput = new FormControl();

  searchFoods$ = new BehaviorSubject<string>('');

  foods$: Observable<string[]> = this.searchFoods$.pipe(
    switchMap(searchFoodsText => {
      return this.http
        .get<Food[]>('http://localhost:8080/food/list');
    }),
    map((foods: Food[]) => foods.map(food => food.name))
  );

  constructor(private http: HttpClient) {}

  doFoodSearch(): void {
    this.searchFoods$.next(this.foodSearchTextInput.value);
  }
}
