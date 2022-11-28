import 'package:bike_rent/src/features/bike/domain/bike.dart';
import 'package:bike_rent/src/features/shop_cart/data/repositories/shop_cart_localhost_repository.dart';
import 'package:flutter_bloc/flutter_bloc.dart';
import 'package:freezed_annotation/freezed_annotation.dart';

part 'shop_cart_event.dart';
part 'shop_cart_state.dart';
part 'shop_cart_bloc.freezed.dart';

class ShopCartBloc extends Bloc<ShopCartEvent, ShopCartState> {

  final ShopCartLocalhostRepository _repository;

  ShopCartBloc(this._repository) : super(ShopCartState.initial()) {
    on<_AddBike>((event, emit) async {
      if (await _repository.addToCart(event.bike.id)) {
        add(const _FetchBike());
      }
    });

    on<_RemoveBike>((event, emit) async {

      if (await _repository.removeFromCart(event.bike.id)) {
        add(const _FetchBike());
      }
    });

    on<_FetchBike>((event, emit) async {
      var bikes = await _repository.getBikesInCart();
      emit(
        state.copyWith(
          bikesToBuy: [...bikes]
        )
      );
    });
  }
}
