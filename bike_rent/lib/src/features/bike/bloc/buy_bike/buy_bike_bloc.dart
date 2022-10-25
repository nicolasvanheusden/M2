import 'package:bike_rent/src/features/bike/domain/bike.dart';
import 'package:bike_rent/src/features/user/domain/user.dart';
import 'package:flutter_bloc/flutter_bloc.dart';
import 'package:freezed_annotation/freezed_annotation.dart';

part 'buy_bike_event.dart';
part 'buy_bike_state.dart';
part 'buy_bike_bloc.freezed.dart';

class BuyBikeBloc extends Bloc<BuyBikeEvent, BuyBikeState> {
  BuyBikeBloc() : super(const _Initial()) {
    on<BuyBikeEvent>((event, emit) {
      // TODO: implement event handler
    });
  }
}
