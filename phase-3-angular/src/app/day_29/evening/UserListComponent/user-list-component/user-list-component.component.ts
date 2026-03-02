import { Component } from '@angular/core';

@Component({
  selector: 'app-user-list-component',
  standalone: true,
  imports: [],
  templateUrl: './user-list-component.component.html',
  styleUrl: './user-list-component.component.css'
})
export class UserListComponentComponent {

  users = [
    {name: 'Brunda', age : 25},
    {name: 'Sowmya', age : 24},
    {name: 'Gigi', age : 26}
  ]

}
