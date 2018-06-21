import {Component, OnInit, ViewChild} from '@angular/core';
import { CalendarComponent } from 'ng-fullcalendar';
import { Options } from 'fullcalendar';
import { EventService } from '../services/event.service';
import * as html2canvas from 'html2canvas';

@Component({
  selector: 'app-calendrier',
  templateUrl: './calendrier.component.html',
  styleUrls: ['./calendrier.component.css']
})
export class CalendrierComponent implements OnInit {
  calendarOptions: Options;
  displayEvent: any;
  events = null;
  isWeekend = true;
  @ViewChild(CalendarComponent) ucCalendar: CalendarComponent;
  constructor(protected eventService: EventService) {




  }

  ngOnInit() {
    this.calendarOptions = {
      locale: 'fr',
      editable: true,
      eventLimit: false,
      weekends: this.isWeekend,
      businessHours: true,
      header: {
        left: 'prev,next today',
        center: 'title',
        right: 'month,agendaWeek,agendaDay,listMonth'
      },
      events: [{
        title: 'Angular 4',
        start: '2018-06-11',
        end: '2018-06-15',
        color: 'red',
      },
        {
        title: 'Projet Final',
        start: '2018-06-15',
        end: '2018-06-22',
        color: 'yellow',
      },
        {
          start: '2018-06-25',
          end: '2018-06-25',
          overlap: false,
          rendering: 'background',
          color: '#ff9f89'
        }]
    };
  }
  loadevents() {
    this.eventService.getEvents().subscribe(data => {
      this.calendarOptions.events = data;
    });
    console.log('méthode loadevents() entrée');
/*    console.log(this.eventService.getEvents().value);*/
    this.events = {
      title: 'Projet de groupe',
      start: '2018-06-15',
      end: '2018-06-21',
      };

  }
  clickButton(model: any) {
    this.displayEvent = model;
  }
  dayClick(model: any) {
    console.log(model);
  }
  eventClick(model: any) {
    model = {
      event: {
        id: model.event.id,
        start: model.event.start,
        end: model.event.end,
        title: model.event.title,
        allDay: model.event.allDay
        // other params
      },
      duration: {}
    }
    this.displayEvent = model;
  }
  updateEvent(model: any) {
    model = {
      event: {
        id: model.event.id,
        start: model.event.start,
        end: model.event.end,
        title: model.event.title
        // other params
      },
      duration: {
        _data: model.duration._data
      }
    }
    this.displayEvent = model;
  }
  chgWeekend(isWeekend: boolean) {
    if (isWeekend) {
      isWeekend = false;
      console.log(isWeekend);
    } else {
      isWeekend = true;
    }

  }

  pdfDownload() {
    console.log('pdfDownload() entered');
    html2canvas(document.body).then((canvas) => {
      window.open().document.write('<img src="' + canvas.toDataURL() + '" />');
    });
  }
}
