import {Component, OnInit} from '@angular/core';
import {ProductService} from '../../services/product.service';
import {ActivatedRoute, Router} from '@angular/router';
import {CookieService} from 'ngx-cookie-service';
import {ProductInfo} from '../../models/productInfo';

@Component({
    selector: 'app-detail',
    templateUrl: './detail.component.html',
    styleUrls: ['./detail.component.css']
})
export class DetailComponent implements OnInit {
    title: string;
    count: number;
    productInfo: ProductInfo;

    constructor(
        private productService: ProductService,
        private cookieService: CookieService,
        private route: ActivatedRoute,
        private router: Router
    ) {
    }

    ngOnInit() {
        this.getProduct();
        this.title = 'Product Detail';
        this.count = 1;
    }

    getProduct(): void {
        const id = this.route.snapshot.paramMap.get('id');
        this.productService.getDetail(id).subscribe(
            prod => {
                this.productInfo = prod;
            },
            _ => console.log('Get Cart Failed')
        );
    }

    validateCount() {
        const max = this.productInfo.stock;
        if (this.count > max) {
            this.count = max;
        } else if (this.count < 1) {
            this.count = 1;
        }
    }
}
