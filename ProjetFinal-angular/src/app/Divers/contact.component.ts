import { Component, OnInit } from '@angular/core';


@Component({
  selector: 'app-contact',
  templateUrl: './contact.component.html',
  styleUrls: ['./contact.component.css']
})
export class ContactComponent implements OnInit {
  public data: any = [];

  constructor() { }

  save(name, email, subject, message): void {
    console.log('save() entered');
    this.data['name'] = name;
    this.data['email'] = email;
    this.data['subject'] = subject;
    this.data['message'] = message;
    console.log(this.data);
  }

  ngOnInit() {
  }

}
