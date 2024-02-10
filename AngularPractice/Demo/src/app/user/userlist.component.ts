import { Component, OnInit } from '@angular/core';
import { HttpServiceService } from '../http-service.service';

@Component({
  selector: 'app-userlist',
  templateUrl: './userlist.component.html'
})
export class UserlistComponent implements OnInit {

  constructor(private httpService: HttpServiceService) { }

  ngOnInit(): void {
    this.search();
    this.preload();
  }

  form: any = {
    list:[],
    searchParam: {},
    preload:[]
  }

  preload() {
    var self = this;
    this.httpService.get('http://localhost:8080/User/preload', function (res:any) {
      console.log(res.result);
      self.form.preload = res.result;
    });
  }

  search() {
    var self = this;
    this.httpService.post('http://localhost:8080/User/search', this.form.searchParam, function (res: any) {
      console.log(self.form.list);
    self.form.list = res.result.data;
    });
  }

}
