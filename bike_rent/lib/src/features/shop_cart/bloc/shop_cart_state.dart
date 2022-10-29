part of 'shop_cart_bloc.dart';

@freezed
class ShopCartState with _$ShopCartState {
  const factory ShopCartState({
    required final List<Bike> bikesToBuy,
  }) = _ShopCartState;

  factory ShopCartState.initial() => _ShopCartState(
    bikesToBuy: List.empty()
  );
}
