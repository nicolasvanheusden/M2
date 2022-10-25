


import 'package:bike_rent/src/features/bike/domain/bike.dart';

abstract class IBikeRepository {

  Future<List<Bike>> getRentBikes();
  Future<List<Bike>> getSellBikes();
}