import {BrowserModule} from '@angular/platform-browser';
import {NgModule} from '@angular/core';

import {AppComponent} from './app.component';
import {NavigationComponent} from './parts/navigation/navigation.component';
import {PaginationComponent} from './parts/pagination/pagination.component';
import {AppRoutingModule} from './app-routing.module';
import {LoginComponent} from './pages/login/login.component';
import {SignupComponent} from './pages/signup/signup.component';
import {DetailComponent} from './pages/product-detail/detail.component';
import {FormsModule, ReactiveFormsModule} from '@angular/forms';
import {HTTP_INTERCEPTORS, HttpClientModule} from '@angular/common/http';
import {CookieService} from 'ngx-cookie-service';
import {ErrorInterceptor} from './_interceptors/error-interceptor.service';
import {JwtInterceptor} from './_interceptors/jwt-interceptor.service';
import {UserDetailComponent} from './pages/user-edit/user-detail.component';
import {FindComponent} from './pages/find/find.component';

@NgModule({
    declarations: [
        AppComponent,
        NavigationComponent,
        FindComponent,
        PaginationComponent,
        LoginComponent,
        SignupComponent,
        DetailComponent,
        UserDetailComponent,
    ],
    imports: [
        BrowserModule,
        AppRoutingModule,
        FormsModule,
        HttpClientModule,
        ReactiveFormsModule,

    ],
    providers: [CookieService,
        {provide: HTTP_INTERCEPTORS, useClass: JwtInterceptor, multi: true},
        {provide: HTTP_INTERCEPTORS, useClass: ErrorInterceptor, multi: true}],
    bootstrap: [AppComponent]
})
export class AppModule {
}
