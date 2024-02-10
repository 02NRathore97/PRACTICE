import { Component, OnInit } from '@angular/core';
import { HttpServiceService } from '../http-service.service';

@Component({
  selector: 'app-user',
  templateUrl: './user.component.html',
  styleUrls: ['./user.component.css']
})
export class UserComponent implements OnInit {

  constructor(private httpService: HttpServiceService) { }

  ngOnInit(): void {
  }

  title = "Add User";

  form:any={
    id: null,
    firstName: "",
    lastName: "",
    loginId: "",
    password: "",
    dob: ""
  }
  message:any="";

  inputerror:any={}

  save(){
    var self = this;
    this.httpService.post('http://localhost:8080/User/save', this.form,function(res:any){
      if(res.result){
        self.message = res.result.message;
      }
      if(res.result){
        self.inputerror = res.result.inputerror;
      }     
      
    });
  }
}
