import { Component, OnInit, AfterViewInit } from '@angular/core';
/*declare var $ : any ;*/


@Component({
  selector: 'app-calendar',
  templateUrl: './calendrier.component.html',
  styleUrls: ['./calendrier.component.css']
})
export class CalendrierComponent implements OnInit {

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
