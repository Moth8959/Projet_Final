import { Component, OnInit, AfterViewInit } from '@angular/core';
/*declare var $ : any ;*/


@Component({
  selector: 'app-calendar',
  templateUrl: './calendar.component.html',
  styleUrls: ['./calendar.component.css']
})
export class CalendarComponent implements OnInit {

  constructor() { }

  ngOnInit() {

  }
  /*ngAfterViewInit(){
    $(document).ready(function(){
      $("p").click(function(){
        $(this).hide();
      });
    });
  }*/

}
