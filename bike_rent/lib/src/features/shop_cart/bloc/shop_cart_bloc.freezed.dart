// coverage:ignore-file
// GENERATED CODE - DO NOT MODIFY BY HAND
// ignore_for_file: type=lint
// ignore_for_file: unused_element, deprecated_member_use, deprecated_member_use_from_same_package, use_function_type_syntax_for_parameters, unnecessary_const, avoid_init_to_null, invalid_override_different_default_values_named, prefer_expression_function_bodies, annotate_overrides, invalid_annotation_target

part of 'shop_cart_bloc.dart';

// **************************************************************************
// FreezedGenerator
// **************************************************************************

T _$identity<T>(T value) => value;

final _privateConstructorUsedError = UnsupportedError(
    'It seems like you constructed your class using `MyClass._()`. This constructor is only meant to be used by freezed and you are not supposed to need it nor use it.\nPlease check the documentation here for more information: https://github.com/rrousselGit/freezed#custom-getters-and-methods');

/// @nodoc
mixin _$ShopCartEvent {
  Bike get bike => throw _privateConstructorUsedError;
  @optionalTypeArgs
  TResult when<TResult extends Object?>({
    required TResult Function(Bike bike) addBike,
    required TResult Function(Bike bike) removeBike,
  }) =>
      throw _privateConstructorUsedError;
  @optionalTypeArgs
  TResult? whenOrNull<TResult extends Object?>({
    TResult? Function(Bike bike)? addBike,
    TResult? Function(Bike bike)? removeBike,
  }) =>
      throw _privateConstructorUsedError;
  @optionalTypeArgs
  TResult maybeWhen<TResult extends Object?>({
    TResult Function(Bike bike)? addBike,
    TResult Function(Bike bike)? removeBike,
    required TResult orElse(),
  }) =>
      throw _privateConstructorUsedError;
  @optionalTypeArgs
  TResult map<TResult extends Object?>({
    required TResult Function(_AddBike value) addBike,
    required TResult Function(_RemoveBike value) removeBike,
  }) =>
      throw _privateConstructorUsedError;
  @optionalTypeArgs
  TResult? mapOrNull<TResult extends Object?>({
    TResult? Function(_AddBike value)? addBike,
    TResult? Function(_RemoveBike value)? removeBike,
  }) =>
      throw _privateConstructorUsedError;
  @optionalTypeArgs
  TResult maybeMap<TResult extends Object?>({
    TResult Function(_AddBike value)? addBike,
    TResult Function(_RemoveBike value)? removeBike,
    required TResult orElse(),
  }) =>
      throw _privateConstructorUsedError;

  @JsonKey(ignore: true)
  $ShopCartEventCopyWith<ShopCartEvent> get copyWith =>
      throw _privateConstructorUsedError;
}

/// @nodoc
abstract class $ShopCartEventCopyWith<$Res> {
  factory $ShopCartEventCopyWith(
          ShopCartEvent value, $Res Function(ShopCartEvent) then) =
      _$ShopCartEventCopyWithImpl<$Res, ShopCartEvent>;
  @useResult
  $Res call({Bike bike});

  $BikeCopyWith<$Res> get bike;
}

/// @nodoc
class _$ShopCartEventCopyWithImpl<$Res, $Val extends ShopCartEvent>
    implements $ShopCartEventCopyWith<$Res> {
  _$ShopCartEventCopyWithImpl(this._value, this._then);

  // ignore: unused_field
  final $Val _value;
  // ignore: unused_field
  final $Res Function($Val) _then;

  @pragma('vm:prefer-inline')
  @override
  $Res call({
    Object? bike = null,
  }) {
    return _then(_value.copyWith(
      bike: null == bike
          ? _value.bike
          : bike // ignore: cast_nullable_to_non_nullable
              as Bike,
    ) as $Val);
  }

  @override
  @pragma('vm:prefer-inline')
  $BikeCopyWith<$Res> get bike {
    return $BikeCopyWith<$Res>(_value.bike, (value) {
      return _then(_value.copyWith(bike: value) as $Val);
    });
  }
}

/// @nodoc
abstract class _$$_AddBikeCopyWith<$Res>
    implements $ShopCartEventCopyWith<$Res> {
  factory _$$_AddBikeCopyWith(
          _$_AddBike value, $Res Function(_$_AddBike) then) =
      __$$_AddBikeCopyWithImpl<$Res>;
  @override
  @useResult
  $Res call({Bike bike});

  @override
  $BikeCopyWith<$Res> get bike;
}

/// @nodoc
class __$$_AddBikeCopyWithImpl<$Res>
    extends _$ShopCartEventCopyWithImpl<$Res, _$_AddBike>
    implements _$$_AddBikeCopyWith<$Res> {
  __$$_AddBikeCopyWithImpl(_$_AddBike _value, $Res Function(_$_AddBike) _then)
      : super(_value, _then);

  @pragma('vm:prefer-inline')
  @override
  $Res call({
    Object? bike = null,
  }) {
    return _then(_$_AddBike(
      null == bike
          ? _value.bike
          : bike // ignore: cast_nullable_to_non_nullable
              as Bike,
    ));
  }
}

/// @nodoc

class _$_AddBike implements _AddBike {
  const _$_AddBike(this.bike);

  @override
  final Bike bike;

  @override
  String toString() {
    return 'ShopCartEvent.addBike(bike: $bike)';
  }

  @override
  bool operator ==(dynamic other) {
    return identical(this, other) ||
        (other.runtimeType == runtimeType &&
            other is _$_AddBike &&
            (identical(other.bike, bike) || other.bike == bike));
  }

  @override
  int get hashCode => Object.hash(runtimeType, bike);

  @JsonKey(ignore: true)
  @override
  @pragma('vm:prefer-inline')
  _$$_AddBikeCopyWith<_$_AddBike> get copyWith =>
      __$$_AddBikeCopyWithImpl<_$_AddBike>(this, _$identity);

  @override
  @optionalTypeArgs
  TResult when<TResult extends Object?>({
    required TResult Function(Bike bike) addBike,
    required TResult Function(Bike bike) removeBike,
  }) {
    return addBike(bike);
  }

  @override
  @optionalTypeArgs
  TResult? whenOrNull<TResult extends Object?>({
    TResult? Function(Bike bike)? addBike,
    TResult? Function(Bike bike)? removeBike,
  }) {
    return addBike?.call(bike);
  }

  @override
  @optionalTypeArgs
  TResult maybeWhen<TResult extends Object?>({
    TResult Function(Bike bike)? addBike,
    TResult Function(Bike bike)? removeBike,
    required TResult orElse(),
  }) {
    if (addBike != null) {
      return addBike(bike);
    }
    return orElse();
  }

  @override
  @optionalTypeArgs
  TResult map<TResult extends Object?>({
    required TResult Function(_AddBike value) addBike,
    required TResult Function(_RemoveBike value) removeBike,
  }) {
    return addBike(this);
  }

  @override
  @optionalTypeArgs
  TResult? mapOrNull<TResult extends Object?>({
    TResult? Function(_AddBike value)? addBike,
    TResult? Function(_RemoveBike value)? removeBike,
  }) {
    return addBike?.call(this);
  }

  @override
  @optionalTypeArgs
  TResult maybeMap<TResult extends Object?>({
    TResult Function(_AddBike value)? addBike,
    TResult Function(_RemoveBike value)? removeBike,
    required TResult orElse(),
  }) {
    if (addBike != null) {
      return addBike(this);
    }
    return orElse();
  }
}

abstract class _AddBike implements ShopCartEvent {
  const factory _AddBike(final Bike bike) = _$_AddBike;

  @override
  Bike get bike;
  @override
  @JsonKey(ignore: true)
  _$$_AddBikeCopyWith<_$_AddBike> get copyWith =>
      throw _privateConstructorUsedError;
}

/// @nodoc
abstract class _$$_RemoveBikeCopyWith<$Res>
    implements $ShopCartEventCopyWith<$Res> {
  factory _$$_RemoveBikeCopyWith(
          _$_RemoveBike value, $Res Function(_$_RemoveBike) then) =
      __$$_RemoveBikeCopyWithImpl<$Res>;
  @override
  @useResult
  $Res call({Bike bike});

  @override
  $BikeCopyWith<$Res> get bike;
}

/// @nodoc
class __$$_RemoveBikeCopyWithImpl<$Res>
    extends _$ShopCartEventCopyWithImpl<$Res, _$_RemoveBike>
    implements _$$_RemoveBikeCopyWith<$Res> {
  __$$_RemoveBikeCopyWithImpl(
      _$_RemoveBike _value, $Res Function(_$_RemoveBike) _then)
      : super(_value, _then);

  @pragma('vm:prefer-inline')
  @override
  $Res call({
    Object? bike = null,
  }) {
    return _then(_$_RemoveBike(
      null == bike
          ? _value.bike
          : bike // ignore: cast_nullable_to_non_nullable
              as Bike,
    ));
  }
}

/// @nodoc

class _$_RemoveBike implements _RemoveBike {
  const _$_RemoveBike(this.bike);

  @override
  final Bike bike;

  @override
  String toString() {
    return 'ShopCartEvent.removeBike(bike: $bike)';
  }

  @override
  bool operator ==(dynamic other) {
    return identical(this, other) ||
        (other.runtimeType == runtimeType &&
            other is _$_RemoveBike &&
            (identical(other.bike, bike) || other.bike == bike));
  }

  @override
  int get hashCode => Object.hash(runtimeType, bike);

  @JsonKey(ignore: true)
  @override
  @pragma('vm:prefer-inline')
  _$$_RemoveBikeCopyWith<_$_RemoveBike> get copyWith =>
      __$$_RemoveBikeCopyWithImpl<_$_RemoveBike>(this, _$identity);

  @override
  @optionalTypeArgs
  TResult when<TResult extends Object?>({
    required TResult Function(Bike bike) addBike,
    required TResult Function(Bike bike) removeBike,
  }) {
    return removeBike(bike);
  }

  @override
  @optionalTypeArgs
  TResult? whenOrNull<TResult extends Object?>({
    TResult? Function(Bike bike)? addBike,
    TResult? Function(Bike bike)? removeBike,
  }) {
    return removeBike?.call(bike);
  }

  @override
  @optionalTypeArgs
  TResult maybeWhen<TResult extends Object?>({
    TResult Function(Bike bike)? addBike,
    TResult Function(Bike bike)? removeBike,
    required TResult orElse(),
  }) {
    if (removeBike != null) {
      return removeBike(bike);
    }
    return orElse();
  }

  @override
  @optionalTypeArgs
  TResult map<TResult extends Object?>({
    required TResult Function(_AddBike value) addBike,
    required TResult Function(_RemoveBike value) removeBike,
  }) {
    return removeBike(this);
  }

  @override
  @optionalTypeArgs
  TResult? mapOrNull<TResult extends Object?>({
    TResult? Function(_AddBike value)? addBike,
    TResult? Function(_RemoveBike value)? removeBike,
  }) {
    return removeBike?.call(this);
  }

  @override
  @optionalTypeArgs
  TResult maybeMap<TResult extends Object?>({
    TResult Function(_AddBike value)? addBike,
    TResult Function(_RemoveBike value)? removeBike,
    required TResult orElse(),
  }) {
    if (removeBike != null) {
      return removeBike(this);
    }
    return orElse();
  }
}

abstract class _RemoveBike implements ShopCartEvent {
  const factory _RemoveBike(final Bike bike) = _$_RemoveBike;

  @override
  Bike get bike;
  @override
  @JsonKey(ignore: true)
  _$$_RemoveBikeCopyWith<_$_RemoveBike> get copyWith =>
      throw _privateConstructorUsedError;
}

/// @nodoc
mixin _$ShopCartState {
  List<Bike> get bikesToBuy => throw _privateConstructorUsedError;

  @JsonKey(ignore: true)
  $ShopCartStateCopyWith<ShopCartState> get copyWith =>
      throw _privateConstructorUsedError;
}

/// @nodoc
abstract class $ShopCartStateCopyWith<$Res> {
  factory $ShopCartStateCopyWith(
          ShopCartState value, $Res Function(ShopCartState) then) =
      _$ShopCartStateCopyWithImpl<$Res, ShopCartState>;
  @useResult
  $Res call({List<Bike> bikesToBuy});
}

/// @nodoc
class _$ShopCartStateCopyWithImpl<$Res, $Val extends ShopCartState>
    implements $ShopCartStateCopyWith<$Res> {
  _$ShopCartStateCopyWithImpl(this._value, this._then);

  // ignore: unused_field
  final $Val _value;
  // ignore: unused_field
  final $Res Function($Val) _then;

  @pragma('vm:prefer-inline')
  @override
  $Res call({
    Object? bikesToBuy = null,
  }) {
    return _then(_value.copyWith(
      bikesToBuy: null == bikesToBuy
          ? _value.bikesToBuy
          : bikesToBuy // ignore: cast_nullable_to_non_nullable
              as List<Bike>,
    ) as $Val);
  }
}

/// @nodoc
abstract class _$$_ShopCartStateCopyWith<$Res>
    implements $ShopCartStateCopyWith<$Res> {
  factory _$$_ShopCartStateCopyWith(
          _$_ShopCartState value, $Res Function(_$_ShopCartState) then) =
      __$$_ShopCartStateCopyWithImpl<$Res>;
  @override
  @useResult
  $Res call({List<Bike> bikesToBuy});
}

/// @nodoc
class __$$_ShopCartStateCopyWithImpl<$Res>
    extends _$ShopCartStateCopyWithImpl<$Res, _$_ShopCartState>
    implements _$$_ShopCartStateCopyWith<$Res> {
  __$$_ShopCartStateCopyWithImpl(
      _$_ShopCartState _value, $Res Function(_$_ShopCartState) _then)
      : super(_value, _then);

  @pragma('vm:prefer-inline')
  @override
  $Res call({
    Object? bikesToBuy = null,
  }) {
    return _then(_$_ShopCartState(
      bikesToBuy: null == bikesToBuy
          ? _value._bikesToBuy
          : bikesToBuy // ignore: cast_nullable_to_non_nullable
              as List<Bike>,
    ));
  }
}

/// @nodoc

class _$_ShopCartState implements _ShopCartState {
  const _$_ShopCartState({required final List<Bike> bikesToBuy})
      : _bikesToBuy = bikesToBuy;

  final List<Bike> _bikesToBuy;
  @override
  List<Bike> get bikesToBuy {
    // ignore: implicit_dynamic_type
    return EqualUnmodifiableListView(_bikesToBuy);
  }

  @override
  String toString() {
    return 'ShopCartState(bikesToBuy: $bikesToBuy)';
  }

  @override
  bool operator ==(dynamic other) {
    return identical(this, other) ||
        (other.runtimeType == runtimeType &&
            other is _$_ShopCartState &&
            const DeepCollectionEquality()
                .equals(other._bikesToBuy, _bikesToBuy));
  }

  @override
  int get hashCode => Object.hash(
      runtimeType, const DeepCollectionEquality().hash(_bikesToBuy));

  @JsonKey(ignore: true)
  @override
  @pragma('vm:prefer-inline')
  _$$_ShopCartStateCopyWith<_$_ShopCartState> get copyWith =>
      __$$_ShopCartStateCopyWithImpl<_$_ShopCartState>(this, _$identity);
}

abstract class _ShopCartState implements ShopCartState {
  const factory _ShopCartState({required final List<Bike> bikesToBuy}) =
      _$_ShopCartState;

  @override
  List<Bike> get bikesToBuy;
  @override
  @JsonKey(ignore: true)
  _$$_ShopCartStateCopyWith<_$_ShopCartState> get copyWith =>
      throw _privateConstructorUsedError;
}
