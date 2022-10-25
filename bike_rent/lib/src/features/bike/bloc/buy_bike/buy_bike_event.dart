part of 'buy_bike_bloc.dart';

@freezed
class BuyBikeEvent with _$BuyBikeEvent {
  const factory BuyBikeEvent.fetchBuyBikes() = _FetchBuyBikes;
  const factory BuyBikeEvent.sellABike(String name, User owner, int price) = _SellABike;
  const factory BuyBikeEvent.buyABike(int id) = _BuyABike;
  
  
}