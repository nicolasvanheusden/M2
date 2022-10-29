import 'package:bike_rent/src/features/bike/domain/bike.dart';
import 'package:flutter_bloc/flutter_bloc.dart';
import 'package:freezed_annotation/freezed_annotation.dart';

part 'shop_cart_event.dart';
part 'shop_cart_state.dart';
part 'shop_cart_bloc.freezed.dart';

class ShopCartBloc extends Bloc<ShopCartEvent, ShopCartState> {
  ShopCartBloc() : super(ShopCartState.initial()) {
    on<_AddBike>((event, emit) {
      emit(
        state.copyWith(
          bikesToBuy: [...state.bikesToBuy, event.bike]
        )
      );
    });

    on<_RemoveBike>((event, emit) {
      emit(
        state.copyWith(
          bikesToBuy: [...state.bikesToBuy.where((element) => element != event.bike)]
        )
      );
    });
  }
}
