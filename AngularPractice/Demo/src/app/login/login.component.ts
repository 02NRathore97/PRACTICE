import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { HttpServiceService } from '../http-service.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  constructor(private router: Router, private httpService: HttpServiceService) { }

  ngOnInit(): void {
  }

  title = 'Login Form';
  form = {
    loginId: '',
    password: '',
    message: ''
  }

  inputerror: any = {};


  signIn() {
    var self = this;

    //  if(this.form.loginId == 'admin' && this.form.password == 'password'){
    //   this.router.navigateByUrl('/welcome');
    //  }else{
    //   this.form.message = 'Invalid loginId and Password';
    //  }

    this.httpService.post('http://localhost:8080/Auth/login', this.form, function (res: any) {
      // console.log("Data -> ", res);

      if (res.result.inputerror) {
        self.inputerror = res.result.inputerror;
      } else if (res.result.data) {
        localStorage.setItem("fname", res.result.data.firstName);
        localStorage.setItem("lname", res.result.data.lastName);
        self.router.navigateByUrl("/welcome");
      }
      if (res.result.message) {
        self.form.message = res.result.message;
      }

      console.log(self.inputerror.loginId);

    })
  }
}
