import { Component, OnInit } from '@angular/core';
import { HttpServiceService } from '../http-service.service';

@Component({
  selector: 'app-signup',
  templateUrl: './signup.component.html'
})
export class SignupComponent implements OnInit {

  constructor(private httpservice:HttpServiceService) { }

  ngOnInit(): void {
  }

  title = 'SignUp';

  form :any = {
    loginId : '',
    password : '',
    firstName : '',
    lastName : '',
    dob : '' 
  }
  message:any = "";
  inputerror:any = {};


  signUp(){
    var self = this;
   this.httpservice.post("http://localhost:8080/User/save", this.form, function(res:any){

   if(res.result.inputerror){
    self.inputerror = res.result.inputerror;
   }
   if(res.result.message){
    self.message = res.result.message;
   }
    
   });
  }
}