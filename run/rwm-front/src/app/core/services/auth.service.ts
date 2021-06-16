import { Injectable, Inject } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { map } from 'rxjs/operators';
import * as jwt_decode from 'jwt-decode';
import * as moment from 'moment';
import 'rxjs/add/operator/delay';

import { environment } from '../../../environments/environment';
import { of, EMPTY } from 'rxjs';
import { connectableObservableDescriptor } from 'rxjs/internal/observable/ConnectableObservable';

@Injectable({
    providedIn: 'root'
})
export class AuthenticationService {

    private headers = new HttpHeaders({'Content-Type': 'application/json'});

    constructor(private http: HttpClient,
        @Inject('LOCALSTORAGE') private localStorage: Storage) {
    }

    login(email: string, password: string) {
        return this.http.post(`${environment.baseUrl}/${environment.login}`, {username: email, password: password}, {headers: this.headers, responseType: 'json'})
            .pipe(map((response) => {
                console.log("bio na bekyu");
                // set token property
                console.log(response);
                const decodedToken = jwt_decode(response['accessToken']);

                // store email and jwt token in local storage to keep user logged in between page refreshes
                this.localStorage.setItem('currentUser', JSON.stringify({
                    token: decodedToken,
                    isAdmin: false,
                    email: decodedToken['sub'],
                    // id: '12312323232',
                    alias: decodedToken['sub'].split('@')[0],
                    expiration: moment().add(1, 'days').toDate(),
                    // fullName: 'John Doe'
                }));

                return true;
            }));
    }

    logout(): void {
        // clear token remove user from local storage to log user out
        this.localStorage.removeItem('currentUser');
    }

    getCurrentUser(): any {
        // TODO: Enable after implementation
        return JSON.parse(this.localStorage.getItem('currentUser'));
        // return {
        //     token: 'aisdnaksjdn,axmnczm',
        //     isAdmin: true,
        //     email: 'john.doe@gmail.com',
        //     id: '12312323232',
        //     alias: 'john.doe@gmail.com'.split('@')[0],
        //     expiration: moment().add(1, 'days').toDate(),
        //     fullName: 'John Doe'
        // };
    }

    passwordResetRequest(email: string) {
        return of(true).delay(1000);
    }

    changePassword(email: string, currentPwd: string, newPwd: string) {
        return of(true).delay(1000);
    }

    passwordReset(email: string, token: string, password: string, confirmPassword: string): any {
        return of(true).delay(1000);
    }
}
