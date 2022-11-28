

import 'package:bike_rent/src/features/bike/data/datasources/bike_remote_source.dart';
import 'package:bike_rent/src/features/bike/data/repositories/i_bike_repository.dart';
import 'package:bike_rent/src/features/bike/domain/bike.dart';

class BikeLocalhostRepository extends IBikeRepository {

  final BikeRemoteSource _bikeRemoteSource;
  // final BikeLocalSource _bikeLocalSource;

  BikeLocalhostRepository( this._bikeRemoteSource);

  @override
  Future<List<Bike>> getRentBikes() async {
    return await _bikeRemoteSource
      .getBikes()
      .then((value) => 
        value
          .map((e) => e.toDomain())
          // .where((element) => element.rentPrice != null)
          .toList()
      );  
  }

  @override
  Future<List<Bike>> getSellBikes() async {
    return await _bikeRemoteSource
      .getBikes()
      .then((value) => 
        value
          .map((e) => e.toDomain())
          // .where((element) => element.sellPrice != null)
          .toList()
      );  
  }

}