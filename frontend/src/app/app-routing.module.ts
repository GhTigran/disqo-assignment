import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
import {LoginComponent} from './pages/login/login.component';
import {SignupComponent} from './pages/signup/signup.component';
import {DetailComponent} from './pages/product-detail/detail.component';
import {AuthGuard} from './_guards/auth.guard';
import {UserDetailComponent} from './pages/user-edit/user-detail.component';
import {FindComponent} from './pages/find/find.component';

const routes: Routes = [
    {path: '', redirectTo: '/find', pathMatch: 'full'},
    {path: 'product/:id', component: DetailComponent},
    {path: 'find', component: FindComponent},
    {path: 'login', component: LoginComponent},
    {path: 'logout', component: LoginComponent},
    {path: 'register', component: SignupComponent},
    {path: 'success', component: SignupComponent},
    {
        path: 'profile',
        component: UserDetailComponent,
        canActivate: [AuthGuard]
    },

];

@NgModule({
    declarations: [],
    imports: [
        RouterModule.forRoot(routes)
    ],
    exports: [RouterModule]
})
export class AppRoutingModule {
}
