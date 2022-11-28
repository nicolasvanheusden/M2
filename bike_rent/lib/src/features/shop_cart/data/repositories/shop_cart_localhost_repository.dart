

import 'package:bike_rent/src/features/bike/domain/bike.dart';
import 'package:bike_rent/src/features/shop_cart/data/datasources/shop_cart_remote_source.dart';



class ShopCartLocalhostRepository {

  final ShopCartRemoteSource _shopCartRemoteSource;

  ShopCartLocalhostRepository(this._shopCartRemoteSource);


  Future<bool> addToCart(int id) async{
    return _shopCartRemoteSource.addToCart(id);
  }


  Future<List<Bike>> getBikesInCart() async{
    return _shopCartRemoteSource.getBikesInCart().then((value) => 
        value
          .map((e) => e.toDomain())
          .toList()
      );
  }


  Future<bool> removeFromCart(int id) async{
    return _shopCartRemoteSource.removeFromCart(id);
  }


}