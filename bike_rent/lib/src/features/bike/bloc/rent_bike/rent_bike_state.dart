part of 'rent_bike_bloc.dart';

@freezed
class RentBikeState with _$RentBikeState {
  const factory RentBikeState.initial() = _Initial;
  const factory RentBikeState.loading() = _Loading;
  const factory RentBikeState.success(List<Bike> bikes) = Success;
  const factory RentBikeState.failure(String message) = Failure;
  
  
}
