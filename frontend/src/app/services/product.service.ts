import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable, of} from 'rxjs';
import {catchError} from 'rxjs/operators';
import {ProductInfo} from '../models/productInfo';
import {apiUrl} from '../../environments/environment';

@Injectable({
    providedIn: 'root'
})
export class ProductService {

    private productsUrl = `${apiUrl}/products/`;
    private categoriesUrl = `${apiUrl}/categories`;

    constructor(private http: HttpClient) {
    }

    find(search: String, category: number, page: number, size: number): Observable<any> {
        const url = `${this.productsUrl}?search=${search}&category=${category}&page=${page}&size=${size}`;
        return this.http.get(url);
    }

    getCategories(): Observable<any> {
        const url = `${this.categoriesUrl}/`;
        return this.http.get(url);
    }

    getDetail(id: String): Observable<ProductInfo> {
        const url = `${this.productsUrl}${id}`;
        return this.http.get<ProductInfo>(url).pipe(
            catchError(_ => {
                return of(new ProductInfo());
            })
        );
    }
}
