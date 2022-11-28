


import 'package:bike_rent/src/features/bike/domain/bike.dart';
import 'package:bike_rent/src/features/user/domain/user.dart';

abstract class IBikeRepository {

  Future<List<Bike>> getRentBikes();
  Future<List<Bike>> getSellBikes();
  Future<bool> sellABike(String name, User owner, int price);
}