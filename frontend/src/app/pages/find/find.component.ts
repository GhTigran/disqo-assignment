import {Component, OnDestroy, OnInit} from '@angular/core';
import {ProductService} from '../../services/product.service';
import {ActivatedRoute} from '@angular/router';
import {Subscription} from 'rxjs';

@Component({
    selector: 'app-card',
    templateUrl: './find.component.html',
    styleUrls: ['./find.component.css']
})
export class FindComponent implements OnInit, OnDestroy {


    title: string;
    page: any;
    private paramSub: Subscription;
    private querySub: Subscription;


    constructor(private productService: ProductService,
                private route: ActivatedRoute) {

    }


    ngOnInit() {
        this.querySub = this.route.queryParams.subscribe(() => {
            this.update();
        });
        this.paramSub = this.route.params.subscribe(() => {
            this.update();
        });

    }

    ngOnDestroy(): void {
        this.querySub.unsubscribe();
        this.paramSub.unsubscribe();
    }

    update() {
        let search = this.route.snapshot.queryParamMap.get('search')
        const category = +this.route.snapshot.queryParamMap.get('category')
        const currentPage = +this.route.snapshot.queryParamMap.get('page');
        const size = +this.route.snapshot.queryParamMap.get('size');

        if (!search) {
            search = '';
        }

        if (currentPage) {
            this.getProds(search, category, currentPage, size);
        } else {
            this.getProds(search, category);
        }
    }

    getProds(search: String = '', category: number = 0, page: number = 1, size: number = 10) {
        this.productService.find(search, category, page, size)
            .subscribe(page => {
                this.page = page;
                this.title = 'Looking for ' + (search ? search : 'everything');
            });

    }


}
