import {Component, OnDestroy, OnInit} from '@angular/core';
import {UserService} from '../../services/user.service';
import {Observable, Subscription} from 'rxjs';
import {JwtResponse} from '../../response/JwtResponse';
import {Router} from '@angular/router';
import {Role} from '../../enum/Role';
import {ProductService} from '../../services/product.service';
import {FormBuilder} from '@angular/forms';
import {tap} from 'rxjs/operators';

@Component({
    selector: 'app-navigation',
    templateUrl: './navigation.component.html',
    styleUrls: ['./navigation.component.css']
})
export class NavigationComponent implements OnInit, OnDestroy {
    currentUserSubscription: Subscription;
    categoriesSubscription: Subscription;
    name$;
    name: string;
    selectedCategory: string;
    currentUser: JwtResponse;
    categories: {};
    root = '/';
    Role = Role;
    searchForm;

    constructor(private userService: UserService,
                private productService: ProductService,
                private formBuilder: FormBuilder,
                private router: Router,
    ) {
        this.selectedCategory = 'Any';
        this.searchForm = this.formBuilder.group({
            category: 0,
            search: ''
        });
    }


    ngOnInit() {
        this.name$ = this.userService.name$.subscribe(aName => this.name = aName);
        this.currentUserSubscription = this.userService.currentUser.subscribe(user => {
            this.currentUser = user;
        });

        this.categoriesSubscription = this.productService.getCategories().pipe(
        ).subscribe(categories => this.categories = categories);
    }

    ngOnDestroy(): void {
        this.currentUserSubscription.unsubscribe();
        this.categoriesSubscription.unsubscribe();
    }

    logout() {
        this.userService.logout();
    }

    selectCategory($event) {
        this.selectedCategory = $event.target.selectedOptions[0].text;
    }

    onSearch(searchData) {
        this.router.navigate(['/find'], {queryParams: {search: searchData.search, category: searchData.category}});
        console.log(searchData);
    }
}
