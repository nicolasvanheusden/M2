import 'package:bike_rent/src/features/bike/data/repositories/bike_localhost_repository.dart';
import 'package:bike_rent/src/features/bike/domain/bike.dart';
import 'package:bike_rent/src/features/user/domain/user.dart';
import 'package:flutter_bloc/flutter_bloc.dart';
import 'package:freezed_annotation/freezed_annotation.dart';

part 'rent_bike_event.dart';
part 'rent_bike_state.dart';
part 'rent_bike_bloc.freezed.dart';

class RentBikeBloc extends Bloc<RentBikeEvent, RentBikeState> {

  final BikeLocalhostRepository _repository;

  RentBikeBloc(this._repository) : super(const _Initial()) {
    on<_FetchRentBikes>((event, emit) async {
      emit(const RentBikeState.loading());
      final bikes = await _repository.getRentBikes();
      emit(RentBikeState.success(bikes));
    });
  }
}
