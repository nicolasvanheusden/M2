part of 'shop_cart_bloc.dart';

@freezed
class ShopCartEvent with _$ShopCartEvent {
  const factory ShopCartEvent.addBike(Bike bike) = _AddBike;
  const factory ShopCartEvent.removeBike(Bike bike) = _RemoveBike;
  const factory ShopCartEvent.fetchBike() = _FetchBike;
  
}
  
  