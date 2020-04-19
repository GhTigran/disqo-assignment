export class ProductInfo {
    id: string;
    name: string;
    price: number;
    stock: number;
    description: string;
    image: string;
    status: number;
    categoryId: number;
    createTime: string;
    updateTime: string;


    constructor() {
        this.id = '';
        this.name = '';
        this.price = 20;
        this.stock = 100;
        this.description = '';
        this.image = '';
        this.categoryId = 0;
        this.status = 0;
    }
}

