import 'package:bike_rent/src/features/bike/data/repositories/bike_localhost_repository.dart';
import 'package:bike_rent/src/features/bike/domain/bike.dart';
import 'package:bike_rent/src/features/user/domain/user.dart';
import 'package:flutter_bloc/flutter_bloc.dart';
import 'package:freezed_annotation/freezed_annotation.dart';

part 'buy_bike_event.dart';
part 'buy_bike_state.dart';
part 'buy_bike_bloc.freezed.dart';

class BuyBikeBloc extends Bloc<BuyBikeEvent, BuyBikeState> {

  final BikeLocalhostRepository _repository;

  BuyBikeBloc(this._repository) : super(const _Initial()) {
    on<_FetchBuyBikes>((event, emit) async {
      emit(const BuyBikeState.loading());
      final bikes = await _repository.getSellBikes();
      emit(BuyBikeState.success(bikes));
    });
  }
}
