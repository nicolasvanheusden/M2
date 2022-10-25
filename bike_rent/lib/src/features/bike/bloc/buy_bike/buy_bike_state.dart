part of 'buy_bike_bloc.dart';

@freezed
class BuyBikeState with _$BuyBikeState {
  const factory BuyBikeState.initial() = _Initial;
  const factory BuyBikeState.loading() = _Loading;
  const factory BuyBikeState.success(List<Bike> bikes) = Success;
  const factory BuyBikeState.failure(String message) = Failure;
}
