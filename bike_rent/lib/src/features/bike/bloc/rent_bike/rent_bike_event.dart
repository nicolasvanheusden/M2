part of 'rent_bike_bloc.dart';

@freezed
class RentBikeEvent with _$RentBikeEvent {
  const factory RentBikeEvent.fetchRentBikes() = _FetchRentBikes;
  const factory RentBikeEvent.rentInBike(String name, User owner, int price) = _RentInBike;
  const factory RentBikeEvent.rentOutBike(int id) = _RentOutBike;

}