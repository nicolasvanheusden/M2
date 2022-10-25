import 'package:bike_rent/src/features/bike/domain/bike.dart';
import 'package:bike_rent/src/features/user/domain/user.dart';
import 'package:flutter_bloc/flutter_bloc.dart';
import 'package:freezed_annotation/freezed_annotation.dart';

part 'rent_bike_event.dart';
part 'rent_bike_state.dart';
part 'rent_bike_bloc.freezed.dart';

class RentBikeBloc extends Bloc<RentBikeEvent, RentBikeState> {
  RentBikeBloc() : super(const _Initial()) {
    on<RentBikeEvent>((event, emit) {
    });
  }
}
