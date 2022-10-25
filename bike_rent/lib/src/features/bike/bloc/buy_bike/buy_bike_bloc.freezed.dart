// coverage:ignore-file
// GENERATED CODE - DO NOT MODIFY BY HAND
// ignore_for_file: type=lint
// ignore_for_file: unused_element, deprecated_member_use, deprecated_member_use_from_same_package, use_function_type_syntax_for_parameters, unnecessary_const, avoid_init_to_null, invalid_override_different_default_values_named, prefer_expression_function_bodies, annotate_overrides, invalid_annotation_target

part of 'buy_bike_bloc.dart';

// **************************************************************************
// FreezedGenerator
// **************************************************************************

T _$identity<T>(T value) => value;

final _privateConstructorUsedError = UnsupportedError(
    'It seems like you constructed your class using `MyClass._()`. This constructor is only meant to be used by freezed and you are not supposed to need it nor use it.\nPlease check the documentation here for more information: https://github.com/rrousselGit/freezed#custom-getters-and-methods');

/// @nodoc
mixin _$BuyBikeEvent {
  @optionalTypeArgs
  TResult when<TResult extends Object?>({
    required TResult Function() fetchBuyBikes,
    required TResult Function(String name, User owner, int price) sellABike,
    required TResult Function(int id) buyABike,
  }) =>
      throw _privateConstructorUsedError;
  @optionalTypeArgs
  TResult? whenOrNull<TResult extends Object?>({
    TResult? Function()? fetchBuyBikes,
    TResult? Function(String name, User owner, int price)? sellABike,
    TResult? Function(int id)? buyABike,
  }) =>
      throw _privateConstructorUsedError;
  @optionalTypeArgs
  TResult maybeWhen<TResult extends Object?>({
    TResult Function()? fetchBuyBikes,
    TResult Function(String name, User owner, int price)? sellABike,
    TResult Function(int id)? buyABike,
    required TResult orElse(),
  }) =>
      throw _privateConstructorUsedError;
  @optionalTypeArgs
  TResult map<TResult extends Object?>({
    required TResult Function(_FetchBuyBikes value) fetchBuyBikes,
    required TResult Function(_SellABike value) sellABike,
    required TResult Function(_BuyABike value) buyABike,
  }) =>
      throw _privateConstructorUsedError;
  @optionalTypeArgs
  TResult? mapOrNull<TResult extends Object?>({
    TResult? Function(_FetchBuyBikes value)? fetchBuyBikes,
    TResult? Function(_SellABike value)? sellABike,
    TResult? Function(_BuyABike value)? buyABike,
  }) =>
      throw _privateConstructorUsedError;
  @optionalTypeArgs
  TResult maybeMap<TResult extends Object?>({
    TResult Function(_FetchBuyBikes value)? fetchBuyBikes,
    TResult Function(_SellABike value)? sellABike,
    TResult Function(_BuyABike value)? buyABike,
    required TResult orElse(),
  }) =>
      throw _privateConstructorUsedError;
}

/// @nodoc
abstract class $BuyBikeEventCopyWith<$Res> {
  factory $BuyBikeEventCopyWith(
          BuyBikeEvent value, $Res Function(BuyBikeEvent) then) =
      _$BuyBikeEventCopyWithImpl<$Res, BuyBikeEvent>;
}

/// @nodoc
class _$BuyBikeEventCopyWithImpl<$Res, $Val extends BuyBikeEvent>
    implements $BuyBikeEventCopyWith<$Res> {
  _$BuyBikeEventCopyWithImpl(this._value, this._then);

  // ignore: unused_field
  final $Val _value;
  // ignore: unused_field
  final $Res Function($Val) _then;
}

/// @nodoc
abstract class _$$_FetchBuyBikesCopyWith<$Res> {
  factory _$$_FetchBuyBikesCopyWith(
          _$_FetchBuyBikes value, $Res Function(_$_FetchBuyBikes) then) =
      __$$_FetchBuyBikesCopyWithImpl<$Res>;
}

/// @nodoc
class __$$_FetchBuyBikesCopyWithImpl<$Res>
    extends _$BuyBikeEventCopyWithImpl<$Res, _$_FetchBuyBikes>
    implements _$$_FetchBuyBikesCopyWith<$Res> {
  __$$_FetchBuyBikesCopyWithImpl(
      _$_FetchBuyBikes _value, $Res Function(_$_FetchBuyBikes) _then)
      : super(_value, _then);
}

/// @nodoc

class _$_FetchBuyBikes implements _FetchBuyBikes {
  const _$_FetchBuyBikes();

  @override
  String toString() {
    return 'BuyBikeEvent.fetchBuyBikes()';
  }

  @override
  bool operator ==(dynamic other) {
    return identical(this, other) ||
        (other.runtimeType == runtimeType && other is _$_FetchBuyBikes);
  }

  @override
  int get hashCode => runtimeType.hashCode;

  @override
  @optionalTypeArgs
  TResult when<TResult extends Object?>({
    required TResult Function() fetchBuyBikes,
    required TResult Function(String name, User owner, int price) sellABike,
    required TResult Function(int id) buyABike,
  }) {
    return fetchBuyBikes();
  }

  @override
  @optionalTypeArgs
  TResult? whenOrNull<TResult extends Object?>({
    TResult? Function()? fetchBuyBikes,
    TResult? Function(String name, User owner, int price)? sellABike,
    TResult? Function(int id)? buyABike,
  }) {
    return fetchBuyBikes?.call();
  }

  @override
  @optionalTypeArgs
  TResult maybeWhen<TResult extends Object?>({
    TResult Function()? fetchBuyBikes,
    TResult Function(String name, User owner, int price)? sellABike,
    TResult Function(int id)? buyABike,
    required TResult orElse(),
  }) {
    if (fetchBuyBikes != null) {
      return fetchBuyBikes();
    }
    return orElse();
  }

  @override
  @optionalTypeArgs
  TResult map<TResult extends Object?>({
    required TResult Function(_FetchBuyBikes value) fetchBuyBikes,
    required TResult Function(_SellABike value) sellABike,
    required TResult Function(_BuyABike value) buyABike,
  }) {
    return fetchBuyBikes(this);
  }

  @override
  @optionalTypeArgs
  TResult? mapOrNull<TResult extends Object?>({
    TResult? Function(_FetchBuyBikes value)? fetchBuyBikes,
    TResult? Function(_SellABike value)? sellABike,
    TResult? Function(_BuyABike value)? buyABike,
  }) {
    return fetchBuyBikes?.call(this);
  }

  @override
  @optionalTypeArgs
  TResult maybeMap<TResult extends Object?>({
    TResult Function(_FetchBuyBikes value)? fetchBuyBikes,
    TResult Function(_SellABike value)? sellABike,
    TResult Function(_BuyABike value)? buyABike,
    required TResult orElse(),
  }) {
    if (fetchBuyBikes != null) {
      return fetchBuyBikes(this);
    }
    return orElse();
  }
}

abstract class _FetchBuyBikes implements BuyBikeEvent {
  const factory _FetchBuyBikes() = _$_FetchBuyBikes;
}

/// @nodoc
abstract class _$$_SellABikeCopyWith<$Res> {
  factory _$$_SellABikeCopyWith(
          _$_SellABike value, $Res Function(_$_SellABike) then) =
      __$$_SellABikeCopyWithImpl<$Res>;
  @useResult
  $Res call({String name, User owner, int price});

  $UserCopyWith<$Res> get owner;
}

/// @nodoc
class __$$_SellABikeCopyWithImpl<$Res>
    extends _$BuyBikeEventCopyWithImpl<$Res, _$_SellABike>
    implements _$$_SellABikeCopyWith<$Res> {
  __$$_SellABikeCopyWithImpl(
      _$_SellABike _value, $Res Function(_$_SellABike) _then)
      : super(_value, _then);

  @pragma('vm:prefer-inline')
  @override
  $Res call({
    Object? name = null,
    Object? owner = null,
    Object? price = null,
  }) {
    return _then(_$_SellABike(
      null == name
          ? _value.name
          : name // ignore: cast_nullable_to_non_nullable
              as String,
      null == owner
          ? _value.owner
          : owner // ignore: cast_nullable_to_non_nullable
              as User,
      null == price
          ? _value.price
          : price // ignore: cast_nullable_to_non_nullable
              as int,
    ));
  }

  @override
  @pragma('vm:prefer-inline')
  $UserCopyWith<$Res> get owner {
    return $UserCopyWith<$Res>(_value.owner, (value) {
      return _then(_value.copyWith(owner: value));
    });
  }
}

/// @nodoc

class _$_SellABike implements _SellABike {
  const _$_SellABike(this.name, this.owner, this.price);

  @override
  final String name;
  @override
  final User owner;
  @override
  final int price;

  @override
  String toString() {
    return 'BuyBikeEvent.sellABike(name: $name, owner: $owner, price: $price)';
  }

  @override
  bool operator ==(dynamic other) {
    return identical(this, other) ||
        (other.runtimeType == runtimeType &&
            other is _$_SellABike &&
            (identical(other.name, name) || other.name == name) &&
            (identical(other.owner, owner) || other.owner == owner) &&
            (identical(other.price, price) || other.price == price));
  }

  @override
  int get hashCode => Object.hash(runtimeType, name, owner, price);

  @JsonKey(ignore: true)
  @override
  @pragma('vm:prefer-inline')
  _$$_SellABikeCopyWith<_$_SellABike> get copyWith =>
      __$$_SellABikeCopyWithImpl<_$_SellABike>(this, _$identity);

  @override
  @optionalTypeArgs
  TResult when<TResult extends Object?>({
    required TResult Function() fetchBuyBikes,
    required TResult Function(String name, User owner, int price) sellABike,
    required TResult Function(int id) buyABike,
  }) {
    return sellABike(name, owner, price);
  }

  @override
  @optionalTypeArgs
  TResult? whenOrNull<TResult extends Object?>({
    TResult? Function()? fetchBuyBikes,
    TResult? Function(String name, User owner, int price)? sellABike,
    TResult? Function(int id)? buyABike,
  }) {
    return sellABike?.call(name, owner, price);
  }

  @override
  @optionalTypeArgs
  TResult maybeWhen<TResult extends Object?>({
    TResult Function()? fetchBuyBikes,
    TResult Function(String name, User owner, int price)? sellABike,
    TResult Function(int id)? buyABike,
    required TResult orElse(),
  }) {
    if (sellABike != null) {
      return sellABike(name, owner, price);
    }
    return orElse();
  }

  @override
  @optionalTypeArgs
  TResult map<TResult extends Object?>({
    required TResult Function(_FetchBuyBikes value) fetchBuyBikes,
    required TResult Function(_SellABike value) sellABike,
    required TResult Function(_BuyABike value) buyABike,
  }) {
    return sellABike(this);
  }

  @override
  @optionalTypeArgs
  TResult? mapOrNull<TResult extends Object?>({
    TResult? Function(_FetchBuyBikes value)? fetchBuyBikes,
    TResult? Function(_SellABike value)? sellABike,
    TResult? Function(_BuyABike value)? buyABike,
  }) {
    return sellABike?.call(this);
  }

  @override
  @optionalTypeArgs
  TResult maybeMap<TResult extends Object?>({
    TResult Function(_FetchBuyBikes value)? fetchBuyBikes,
    TResult Function(_SellABike value)? sellABike,
    TResult Function(_BuyABike value)? buyABike,
    required TResult orElse(),
  }) {
    if (sellABike != null) {
      return sellABike(this);
    }
    return orElse();
  }
}

abstract class _SellABike implements BuyBikeEvent {
  const factory _SellABike(
      final String name, final User owner, final int price) = _$_SellABike;

  String get name;
  User get owner;
  int get price;
  @JsonKey(ignore: true)
  _$$_SellABikeCopyWith<_$_SellABike> get copyWith =>
      throw _privateConstructorUsedError;
}

/// @nodoc
abstract class _$$_BuyABikeCopyWith<$Res> {
  factory _$$_BuyABikeCopyWith(
          _$_BuyABike value, $Res Function(_$_BuyABike) then) =
      __$$_BuyABikeCopyWithImpl<$Res>;
  @useResult
  $Res call({int id});
}

/// @nodoc
class __$$_BuyABikeCopyWithImpl<$Res>
    extends _$BuyBikeEventCopyWithImpl<$Res, _$_BuyABike>
    implements _$$_BuyABikeCopyWith<$Res> {
  __$$_BuyABikeCopyWithImpl(
      _$_BuyABike _value, $Res Function(_$_BuyABike) _then)
      : super(_value, _then);

  @pragma('vm:prefer-inline')
  @override
  $Res call({
    Object? id = null,
  }) {
    return _then(_$_BuyABike(
      null == id
          ? _value.id
          : id // ignore: cast_nullable_to_non_nullable
              as int,
    ));
  }
}

/// @nodoc

class _$_BuyABike implements _BuyABike {
  const _$_BuyABike(this.id);

  @override
  final int id;

  @override
  String toString() {
    return 'BuyBikeEvent.buyABike(id: $id)';
  }

  @override
  bool operator ==(dynamic other) {
    return identical(this, other) ||
        (other.runtimeType == runtimeType &&
            other is _$_BuyABike &&
            (identical(other.id, id) || other.id == id));
  }

  @override
  int get hashCode => Object.hash(runtimeType, id);

  @JsonKey(ignore: true)
  @override
  @pragma('vm:prefer-inline')
  _$$_BuyABikeCopyWith<_$_BuyABike> get copyWith =>
      __$$_BuyABikeCopyWithImpl<_$_BuyABike>(this, _$identity);

  @override
  @optionalTypeArgs
  TResult when<TResult extends Object?>({
    required TResult Function() fetchBuyBikes,
    required TResult Function(String name, User owner, int price) sellABike,
    required TResult Function(int id) buyABike,
  }) {
    return buyABike(id);
  }

  @override
  @optionalTypeArgs
  TResult? whenOrNull<TResult extends Object?>({
    TResult? Function()? fetchBuyBikes,
    TResult? Function(String name, User owner, int price)? sellABike,
    TResult? Function(int id)? buyABike,
  }) {
    return buyABike?.call(id);
  }

  @override
  @optionalTypeArgs
  TResult maybeWhen<TResult extends Object?>({
    TResult Function()? fetchBuyBikes,
    TResult Function(String name, User owner, int price)? sellABike,
    TResult Function(int id)? buyABike,
    required TResult orElse(),
  }) {
    if (buyABike != null) {
      return buyABike(id);
    }
    return orElse();
  }

  @override
  @optionalTypeArgs
  TResult map<TResult extends Object?>({
    required TResult Function(_FetchBuyBikes value) fetchBuyBikes,
    required TResult Function(_SellABike value) sellABike,
    required TResult Function(_BuyABike value) buyABike,
  }) {
    return buyABike(this);
  }

  @override
  @optionalTypeArgs
  TResult? mapOrNull<TResult extends Object?>({
    TResult? Function(_FetchBuyBikes value)? fetchBuyBikes,
    TResult? Function(_SellABike value)? sellABike,
    TResult? Function(_BuyABike value)? buyABike,
  }) {
    return buyABike?.call(this);
  }

  @override
  @optionalTypeArgs
  TResult maybeMap<TResult extends Object?>({
    TResult Function(_FetchBuyBikes value)? fetchBuyBikes,
    TResult Function(_SellABike value)? sellABike,
    TResult Function(_BuyABike value)? buyABike,
    required TResult orElse(),
  }) {
    if (buyABike != null) {
      return buyABike(this);
    }
    return orElse();
  }
}

abstract class _BuyABike implements BuyBikeEvent {
  const factory _BuyABike(final int id) = _$_BuyABike;

  int get id;
  @JsonKey(ignore: true)
  _$$_BuyABikeCopyWith<_$_BuyABike> get copyWith =>
      throw _privateConstructorUsedError;
}

/// @nodoc
mixin _$BuyBikeState {
  @optionalTypeArgs
  TResult when<TResult extends Object?>({
    required TResult Function() initial,
    required TResult Function() loading,
    required TResult Function(List<Bike> bikes) success,
    required TResult Function(String message) failure,
  }) =>
      throw _privateConstructorUsedError;
  @optionalTypeArgs
  TResult? whenOrNull<TResult extends Object?>({
    TResult? Function()? initial,
    TResult? Function()? loading,
    TResult? Function(List<Bike> bikes)? success,
    TResult? Function(String message)? failure,
  }) =>
      throw _privateConstructorUsedError;
  @optionalTypeArgs
  TResult maybeWhen<TResult extends Object?>({
    TResult Function()? initial,
    TResult Function()? loading,
    TResult Function(List<Bike> bikes)? success,
    TResult Function(String message)? failure,
    required TResult orElse(),
  }) =>
      throw _privateConstructorUsedError;
  @optionalTypeArgs
  TResult map<TResult extends Object?>({
    required TResult Function(_Initial value) initial,
    required TResult Function(_Loading value) loading,
    required TResult Function(Success value) success,
    required TResult Function(Failure value) failure,
  }) =>
      throw _privateConstructorUsedError;
  @optionalTypeArgs
  TResult? mapOrNull<TResult extends Object?>({
    TResult? Function(_Initial value)? initial,
    TResult? Function(_Loading value)? loading,
    TResult? Function(Success value)? success,
    TResult? Function(Failure value)? failure,
  }) =>
      throw _privateConstructorUsedError;
  @optionalTypeArgs
  TResult maybeMap<TResult extends Object?>({
    TResult Function(_Initial value)? initial,
    TResult Function(_Loading value)? loading,
    TResult Function(Success value)? success,
    TResult Function(Failure value)? failure,
    required TResult orElse(),
  }) =>
      throw _privateConstructorUsedError;
}

/// @nodoc
abstract class $BuyBikeStateCopyWith<$Res> {
  factory $BuyBikeStateCopyWith(
          BuyBikeState value, $Res Function(BuyBikeState) then) =
      _$BuyBikeStateCopyWithImpl<$Res, BuyBikeState>;
}

/// @nodoc
class _$BuyBikeStateCopyWithImpl<$Res, $Val extends BuyBikeState>
    implements $BuyBikeStateCopyWith<$Res> {
  _$BuyBikeStateCopyWithImpl(this._value, this._then);

  // ignore: unused_field
  final $Val _value;
  // ignore: unused_field
  final $Res Function($Val) _then;
}

/// @nodoc
abstract class _$$_InitialCopyWith<$Res> {
  factory _$$_InitialCopyWith(
          _$_Initial value, $Res Function(_$_Initial) then) =
      __$$_InitialCopyWithImpl<$Res>;
}

/// @nodoc
class __$$_InitialCopyWithImpl<$Res>
    extends _$BuyBikeStateCopyWithImpl<$Res, _$_Initial>
    implements _$$_InitialCopyWith<$Res> {
  __$$_InitialCopyWithImpl(_$_Initial _value, $Res Function(_$_Initial) _then)
      : super(_value, _then);
}

/// @nodoc

class _$_Initial implements _Initial {
  const _$_Initial();

  @override
  String toString() {
    return 'BuyBikeState.initial()';
  }

  @override
  bool operator ==(dynamic other) {
    return identical(this, other) ||
        (other.runtimeType == runtimeType && other is _$_Initial);
  }

  @override
  int get hashCode => runtimeType.hashCode;

  @override
  @optionalTypeArgs
  TResult when<TResult extends Object?>({
    required TResult Function() initial,
    required TResult Function() loading,
    required TResult Function(List<Bike> bikes) success,
    required TResult Function(String message) failure,
  }) {
    return initial();
  }

  @override
  @optionalTypeArgs
  TResult? whenOrNull<TResult extends Object?>({
    TResult? Function()? initial,
    TResult? Function()? loading,
    TResult? Function(List<Bike> bikes)? success,
    TResult? Function(String message)? failure,
  }) {
    return initial?.call();
  }

  @override
  @optionalTypeArgs
  TResult maybeWhen<TResult extends Object?>({
    TResult Function()? initial,
    TResult Function()? loading,
    TResult Function(List<Bike> bikes)? success,
    TResult Function(String message)? failure,
    required TResult orElse(),
  }) {
    if (initial != null) {
      return initial();
    }
    return orElse();
  }

  @override
  @optionalTypeArgs
  TResult map<TResult extends Object?>({
    required TResult Function(_Initial value) initial,
    required TResult Function(_Loading value) loading,
    required TResult Function(Success value) success,
    required TResult Function(Failure value) failure,
  }) {
    return initial(this);
  }

  @override
  @optionalTypeArgs
  TResult? mapOrNull<TResult extends Object?>({
    TResult? Function(_Initial value)? initial,
    TResult? Function(_Loading value)? loading,
    TResult? Function(Success value)? success,
    TResult? Function(Failure value)? failure,
  }) {
    return initial?.call(this);
  }

  @override
  @optionalTypeArgs
  TResult maybeMap<TResult extends Object?>({
    TResult Function(_Initial value)? initial,
    TResult Function(_Loading value)? loading,
    TResult Function(Success value)? success,
    TResult Function(Failure value)? failure,
    required TResult orElse(),
  }) {
    if (initial != null) {
      return initial(this);
    }
    return orElse();
  }
}

abstract class _Initial implements BuyBikeState {
  const factory _Initial() = _$_Initial;
}

/// @nodoc
abstract class _$$_LoadingCopyWith<$Res> {
  factory _$$_LoadingCopyWith(
          _$_Loading value, $Res Function(_$_Loading) then) =
      __$$_LoadingCopyWithImpl<$Res>;
}

/// @nodoc
class __$$_LoadingCopyWithImpl<$Res>
    extends _$BuyBikeStateCopyWithImpl<$Res, _$_Loading>
    implements _$$_LoadingCopyWith<$Res> {
  __$$_LoadingCopyWithImpl(_$_Loading _value, $Res Function(_$_Loading) _then)
      : super(_value, _then);
}

/// @nodoc

class _$_Loading implements _Loading {
  const _$_Loading();

  @override
  String toString() {
    return 'BuyBikeState.loading()';
  }

  @override
  bool operator ==(dynamic other) {
    return identical(this, other) ||
        (other.runtimeType == runtimeType && other is _$_Loading);
  }

  @override
  int get hashCode => runtimeType.hashCode;

  @override
  @optionalTypeArgs
  TResult when<TResult extends Object?>({
    required TResult Function() initial,
    required TResult Function() loading,
    required TResult Function(List<Bike> bikes) success,
    required TResult Function(String message) failure,
  }) {
    return loading();
  }

  @override
  @optionalTypeArgs
  TResult? whenOrNull<TResult extends Object?>({
    TResult? Function()? initial,
    TResult? Function()? loading,
    TResult? Function(List<Bike> bikes)? success,
    TResult? Function(String message)? failure,
  }) {
    return loading?.call();
  }

  @override
  @optionalTypeArgs
  TResult maybeWhen<TResult extends Object?>({
    TResult Function()? initial,
    TResult Function()? loading,
    TResult Function(List<Bike> bikes)? success,
    TResult Function(String message)? failure,
    required TResult orElse(),
  }) {
    if (loading != null) {
      return loading();
    }
    return orElse();
  }

  @override
  @optionalTypeArgs
  TResult map<TResult extends Object?>({
    required TResult Function(_Initial value) initial,
    required TResult Function(_Loading value) loading,
    required TResult Function(Success value) success,
    required TResult Function(Failure value) failure,
  }) {
    return loading(this);
  }

  @override
  @optionalTypeArgs
  TResult? mapOrNull<TResult extends Object?>({
    TResult? Function(_Initial value)? initial,
    TResult? Function(_Loading value)? loading,
    TResult? Function(Success value)? success,
    TResult? Function(Failure value)? failure,
  }) {
    return loading?.call(this);
  }

  @override
  @optionalTypeArgs
  TResult maybeMap<TResult extends Object?>({
    TResult Function(_Initial value)? initial,
    TResult Function(_Loading value)? loading,
    TResult Function(Success value)? success,
    TResult Function(Failure value)? failure,
    required TResult orElse(),
  }) {
    if (loading != null) {
      return loading(this);
    }
    return orElse();
  }
}

abstract class _Loading implements BuyBikeState {
  const factory _Loading() = _$_Loading;
}

/// @nodoc
abstract class _$$SuccessCopyWith<$Res> {
  factory _$$SuccessCopyWith(_$Success value, $Res Function(_$Success) then) =
      __$$SuccessCopyWithImpl<$Res>;
  @useResult
  $Res call({List<Bike> bikes});
}

/// @nodoc
class __$$SuccessCopyWithImpl<$Res>
    extends _$BuyBikeStateCopyWithImpl<$Res, _$Success>
    implements _$$SuccessCopyWith<$Res> {
  __$$SuccessCopyWithImpl(_$Success _value, $Res Function(_$Success) _then)
      : super(_value, _then);

  @pragma('vm:prefer-inline')
  @override
  $Res call({
    Object? bikes = null,
  }) {
    return _then(_$Success(
      null == bikes
          ? _value._bikes
          : bikes // ignore: cast_nullable_to_non_nullable
              as List<Bike>,
    ));
  }
}

/// @nodoc

class _$Success implements Success {
  const _$Success(final List<Bike> bikes) : _bikes = bikes;

  final List<Bike> _bikes;
  @override
  List<Bike> get bikes {
    // ignore: implicit_dynamic_type
    return EqualUnmodifiableListView(_bikes);
  }

  @override
  String toString() {
    return 'BuyBikeState.success(bikes: $bikes)';
  }

  @override
  bool operator ==(dynamic other) {
    return identical(this, other) ||
        (other.runtimeType == runtimeType &&
            other is _$Success &&
            const DeepCollectionEquality().equals(other._bikes, _bikes));
  }

  @override
  int get hashCode =>
      Object.hash(runtimeType, const DeepCollectionEquality().hash(_bikes));

  @JsonKey(ignore: true)
  @override
  @pragma('vm:prefer-inline')
  _$$SuccessCopyWith<_$Success> get copyWith =>
      __$$SuccessCopyWithImpl<_$Success>(this, _$identity);

  @override
  @optionalTypeArgs
  TResult when<TResult extends Object?>({
    required TResult Function() initial,
    required TResult Function() loading,
    required TResult Function(List<Bike> bikes) success,
    required TResult Function(String message) failure,
  }) {
    return success(bikes);
  }

  @override
  @optionalTypeArgs
  TResult? whenOrNull<TResult extends Object?>({
    TResult? Function()? initial,
    TResult? Function()? loading,
    TResult? Function(List<Bike> bikes)? success,
    TResult? Function(String message)? failure,
  }) {
    return success?.call(bikes);
  }

  @override
  @optionalTypeArgs
  TResult maybeWhen<TResult extends Object?>({
    TResult Function()? initial,
    TResult Function()? loading,
    TResult Function(List<Bike> bikes)? success,
    TResult Function(String message)? failure,
    required TResult orElse(),
  }) {
    if (success != null) {
      return success(bikes);
    }
    return orElse();
  }

  @override
  @optionalTypeArgs
  TResult map<TResult extends Object?>({
    required TResult Function(_Initial value) initial,
    required TResult Function(_Loading value) loading,
    required TResult Function(Success value) success,
    required TResult Function(Failure value) failure,
  }) {
    return success(this);
  }

  @override
  @optionalTypeArgs
  TResult? mapOrNull<TResult extends Object?>({
    TResult? Function(_Initial value)? initial,
    TResult? Function(_Loading value)? loading,
    TResult? Function(Success value)? success,
    TResult? Function(Failure value)? failure,
  }) {
    return success?.call(this);
  }

  @override
  @optionalTypeArgs
  TResult maybeMap<TResult extends Object?>({
    TResult Function(_Initial value)? initial,
    TResult Function(_Loading value)? loading,
    TResult Function(Success value)? success,
    TResult Function(Failure value)? failure,
    required TResult orElse(),
  }) {
    if (success != null) {
      return success(this);
    }
    return orElse();
  }
}

abstract class Success implements BuyBikeState {
  const factory Success(final List<Bike> bikes) = _$Success;

  List<Bike> get bikes;
  @JsonKey(ignore: true)
  _$$SuccessCopyWith<_$Success> get copyWith =>
      throw _privateConstructorUsedError;
}

/// @nodoc
abstract class _$$FailureCopyWith<$Res> {
  factory _$$FailureCopyWith(_$Failure value, $Res Function(_$Failure) then) =
      __$$FailureCopyWithImpl<$Res>;
  @useResult
  $Res call({String message});
}

/// @nodoc
class __$$FailureCopyWithImpl<$Res>
    extends _$BuyBikeStateCopyWithImpl<$Res, _$Failure>
    implements _$$FailureCopyWith<$Res> {
  __$$FailureCopyWithImpl(_$Failure _value, $Res Function(_$Failure) _then)
      : super(_value, _then);

  @pragma('vm:prefer-inline')
  @override
  $Res call({
    Object? message = null,
  }) {
    return _then(_$Failure(
      null == message
          ? _value.message
          : message // ignore: cast_nullable_to_non_nullable
              as String,
    ));
  }
}

/// @nodoc

class _$Failure implements Failure {
  const _$Failure(this.message);

  @override
  final String message;

  @override
  String toString() {
    return 'BuyBikeState.failure(message: $message)';
  }

  @override
  bool operator ==(dynamic other) {
    return identical(this, other) ||
        (other.runtimeType == runtimeType &&
            other is _$Failure &&
            (identical(other.message, message) || other.message == message));
  }

  @override
  int get hashCode => Object.hash(runtimeType, message);

  @JsonKey(ignore: true)
  @override
  @pragma('vm:prefer-inline')
  _$$FailureCopyWith<_$Failure> get copyWith =>
      __$$FailureCopyWithImpl<_$Failure>(this, _$identity);

  @override
  @optionalTypeArgs
  TResult when<TResult extends Object?>({
    required TResult Function() initial,
    required TResult Function() loading,
    required TResult Function(List<Bike> bikes) success,
    required TResult Function(String message) failure,
  }) {
    return failure(message);
  }

  @override
  @optionalTypeArgs
  TResult? whenOrNull<TResult extends Object?>({
    TResult? Function()? initial,
    TResult? Function()? loading,
    TResult? Function(List<Bike> bikes)? success,
    TResult? Function(String message)? failure,
  }) {
    return failure?.call(message);
  }

  @override
  @optionalTypeArgs
  TResult maybeWhen<TResult extends Object?>({
    TResult Function()? initial,
    TResult Function()? loading,
    TResult Function(List<Bike> bikes)? success,
    TResult Function(String message)? failure,
    required TResult orElse(),
  }) {
    if (failure != null) {
      return failure(message);
    }
    return orElse();
  }

  @override
  @optionalTypeArgs
  TResult map<TResult extends Object?>({
    required TResult Function(_Initial value) initial,
    required TResult Function(_Loading value) loading,
    required TResult Function(Success value) success,
    required TResult Function(Failure value) failure,
  }) {
    return failure(this);
  }

  @override
  @optionalTypeArgs
  TResult? mapOrNull<TResult extends Object?>({
    TResult? Function(_Initial value)? initial,
    TResult? Function(_Loading value)? loading,
    TResult? Function(Success value)? success,
    TResult? Function(Failure value)? failure,
  }) {
    return failure?.call(this);
  }

  @override
  @optionalTypeArgs
  TResult maybeMap<TResult extends Object?>({
    TResult Function(_Initial value)? initial,
    TResult Function(_Loading value)? loading,
    TResult Function(Success value)? success,
    TResult Function(Failure value)? failure,
    required TResult orElse(),
  }) {
    if (failure != null) {
      return failure(this);
    }
    return orElse();
  }
}

abstract class Failure implements BuyBikeState {
  const factory Failure(final String message) = _$Failure;

  String get message;
  @JsonKey(ignore: true)
  _$$FailureCopyWith<_$Failure> get copyWith =>
      throw _privateConstructorUsedError;
}
