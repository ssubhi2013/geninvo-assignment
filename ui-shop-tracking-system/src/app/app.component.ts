import { Component } from '@angular/core';
import { HttpClient } from '@angular/common/http';


@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  data: any;
  searchText: string;

  shopName: string;
  shopCategory: string;
  shopAddress: string;
  ownerName: string;

  constructor(private http: HttpClient) {
    this.searchText = "";

  }
  ngOnInit() {
    this.fetchShops();
  }
  search() {
    console.log('called');
    this.fetchShops();
  }
  fetchShops() {
    let obs = this.http.get('http://localhost:8080/geninvo/shop?search=' + this.searchText);
    obs.subscribe((res) => {
      this.data = res;
    });
  }
  addNewShop() {
    var body = {
      shopName: this.shopName,
      ownerName: this.ownerName,
      shopCategory: this.shopCategory,
      shopAddress: this.shopAddress,
      longitude: '0',
      latitude: '0'
    };

    let obs = this.http.post('http://localhost:8080/geninvo/shop', body);
    obs.subscribe((res) => {
      this.fetchShops();
    });
  }
}
