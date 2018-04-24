import {Component, ContentChildren, EventEmitter, Input, OnInit, Output, QueryList} from "@angular/core";
import {TopNavEntryComponent} from "./top_nav_entry";
import {ActivatedRoute, Router} from "@angular/router";

@Component({
  selector: 'top-nav',
  template: `
    <nav class="navbar navbar-toggleable-md navbar-light bg-faded">
      <button class="navbar-toggler navbar-toggler-right" type="button" data-toggle="collapse" data-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle Navigation">
        <span class="navbar-toggler-icon"></span>
      </button>
      <a class="v1x1-color navbar-brand" href="#" (click)="entriesOn('brand')[0].navigate();">v1x1</a>
      <div class="collapse navbar-collapse" id="navbarNav">
        <ul class="navbar-nav">
          <li *ngFor="let item of entriesOn('left'); let i = index" class="nav-item" [class.active]="item.isActive()">
            <a class="nav-link" href="#" (click)="item.navigate();">{{item.title}}</a>
          </li>
        </ul>
        <ul class="navbar-nav ml-auto">
          <li *ngFor="let item of entriesOn('right'); let i = index;" class="nav-item" [class.active]="item.isActive()">
            <a class="nav-link" href="#" (click)="item.navigate();">{{item.title}}</a>
          </li>
          <tenant-dropdown-nav-component *ngIf="loggedIn" (activeTenantChange)="activeTenantChange.emit($event)"></tenant-dropdown-nav-component>
          <user-dropdown-nav-component *ngIf="loggedIn" [activeTenantUrl]="activeTenantUrl"></user-dropdown-nav-component>
        </ul>
      </div>
    </nav>
  `
})
export class TopNavComponent implements OnInit {
  @Input() loggedIn: boolean;
  @Input() activeTenantUrl: string;
  @ContentChildren(TopNavEntryComponent) entries: QueryList<TopNavEntryComponent>;
  @Output() public activeTenantChange = new EventEmitter();

  constructor(private route: ActivatedRoute, private router: Router) {}

  ngOnInit() {}

  entriesOn(side: string) {
    return this.entries.filter((x, i, a) => x.justify === side);
  }
}
