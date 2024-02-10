import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { LoginComponent } from './login/login.component';
import { SignupComponent } from './login/signup.component';
import { WelcomeComponent } from './welcome/welcome.component';
import { UserComponent } from './user/user.component';
import { UserlistComponent } from './user/userlist.component';


const routes: Routes = [
  {
    path : '',
    pathMatch: 'full',
    redirectTo: 'login'
  },
  {
    path: 'login',
    component: LoginComponent
  },
  {
    path: 'welcome',
    component : WelcomeComponent
  },
  {
    path: 'signup',
    component : SignupComponent
  },
  {
    path: 'user',
    component : UserComponent

  },
  {
    path: 'userlist',
    component : UserlistComponent
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
