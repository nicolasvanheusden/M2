// coverage:ignore-file
// GENERATED CODE - DO NOT MODIFY BY HAND
// ignore_for_file: type=lint
// ignore_for_file: unused_element, deprecated_member_use, deprecated_member_use_from_same_package, use_function_type_syntax_for_parameters, unnecessary_const, avoid_init_to_null, invalid_override_different_default_values_named, prefer_expression_function_bodies, annotate_overrides, invalid_annotation_target

part of 'rent_bike_bloc.dart';

// **************************************************************************
// FreezedGenerator
// **************************************************************************

T _$identity<T>(T value) => value;

final _privateConstructorUsedError = UnsupportedError(
    'It seems like you constructed your class using `MyClass._()`. This constructor is only meant to be used by freezed and you are not supposed to need it nor use it.\nPlease check the documentation here for more information: https://github.com/rrousselGit/freezed#custom-getters-and-methods');

/// @nodoc
mixin _$RentBikeEvent {
  @optionalTypeArgs
  TResult when<TResult extends Object?>({
    required TResult Function() fetchRentBikes,
    required TResult Function(String name, User owner, int price) rentInBike,
    required TResult Function(int id) rentOutBike,
  }) =>
      throw _privateConstructorUsedError;
  @optionalTypeArgs
  TResult? whenOrNull<TResult extends Object?>({
    TResult? Function()? fetchRentBikes,
    TResult? Function(String name, User owner, int price)? rentInBike,
    TResult? Function(int id)? rentOutBike,
  }) =>
      throw _privateConstructorUsedError;
  @optionalTypeArgs
  TResult maybeWhen<TResult extends Object?>({
    TResult Function()? fetchRentBikes,
    TResult Function(String name, User owner, int price)? rentInBike,
    TResult Function(int id)? rentOutBike,
    required TResult orElse(),
  }) =>
      throw _privateConstructorUsedError;
  @optionalTypeArgs
  TResult map<TResult extends Object?>({
    required TResult Function(_FetchRentBikes value) fetchRentBikes,
    required TResult Function(_RentInBike value) rentInBike,
    required TResult Function(_RentOutBike value) rentOutBike,
  }) =>
      throw _privateConstructorUsedError;
  @optionalTypeArgs
  TResult? mapOrNull<TResult extends Object?>({
    TResult? Function(_FetchRentBikes value)? fetchRentBikes,
    TResult? Function(_RentInBike value)? rentInBike,
    TResult? Function(_RentOutBike value)? rentOutBike,
  }) =>
      throw _privateConstructorUsedError;
  @optionalTypeArgs
  TResult maybeMap<TResult extends Object?>({
    TResult Function(_FetchRentBikes value)? fetchRentBikes,
    TResult Function(_RentInBike value)? rentInBike,
    TResult Function(_RentOutBike value)? rentOutBike,
    required TResult orElse(),
  }) =>
      throw _privateConstructorUsedError;
}

/// @nodoc
abstract class $RentBikeEventCopyWith<$Res> {
  factory $RentBikeEventCopyWith(
          RentBikeEvent value, $Res Function(RentBikeEvent) then) =
      _$RentBikeEventCopyWithImpl<$Res, RentBikeEvent>;
}

/// @nodoc
class _$RentBikeEventCopyWithImpl<$Res, $Val extends RentBikeEvent>
    implements $RentBikeEventCopyWith<$Res> {
  _$RentBikeEventCopyWithImpl(this._value, this._then);

  // ignore: unused_field
  final $Val _value;
  // ignore: unused_field
  final $Res Function($Val) _then;
}

/// @nodoc
abstract class _$$_FetchRentBikesCopyWith<$Res> {
  factory _$$_FetchRentBikesCopyWith(
          _$_FetchRentBikes value, $Res Function(_$_FetchRentBikes) then) =
      __$$_FetchRentBikesCopyWithImpl<$Res>;
}

/// @nodoc
class __$$_FetchRentBikesCopyWithImpl<$Res>
    extends _$RentBikeEventCopyWithImpl<$Res, _$_FetchRentBikes>
    implements _$$_FetchRentBikesCopyWith<$Res> {
  __$$_FetchRentBikesCopyWithImpl(
      _$_FetchRentBikes _value, $Res Function(_$_FetchRentBikes) _then)
      : super(_value, _then);
}

/// @nodoc

class _$_FetchRentBikes implements _FetchRentBikes {
  const _$_FetchRentBikes();

  @override
  String toString() {
    return 'RentBikeEvent.fetchRentBikes()';
  }

  @override
  bool operator ==(dynamic other) {
    return identical(this, other) ||
        (other.runtimeType == runtimeType && other is _$_FetchRentBikes);
  }

  @override
  int get hashCode => runtimeType.hashCode;

  @override
  @optionalTypeArgs
  TResult when<TResult extends Object?>({
    required TResult Function() fetchRentBikes,
    required TResult Function(String name, User owner, int price) rentInBike,
    required TResult Function(int id) rentOutBike,
  }) {
    return fetchRentBikes();
  }

  @override
  @optionalTypeArgs
  TResult? whenOrNull<TResult extends Object?>({
    TResult? Function()? fetchRentBikes,
    TResult? Function(String name, User owner, int price)? rentInBike,
    TResult? Function(int id)? rentOutBike,
  }) {
    return fetchRentBikes?.call();
  }

  @override
  @optionalTypeArgs
  TResult maybeWhen<TResult extends Object?>({
    TResult Function()? fetchRentBikes,
    TResult Function(String name, User owner, int price)? rentInBike,
    TResult Function(int id)? rentOutBike,
    required TResult orElse(),
  }) {
    if (fetchRentBikes != null) {
      return fetchRentBikes();
    }
    return orElse();
  }

  @override
  @optionalTypeArgs
  TResult map<TResult extends Object?>({
    required TResult Function(_FetchRentBikes value) fetchRentBikes,
    required TResult Function(_RentInBike value) rentInBike,
    required TResult Function(_RentOutBike value) rentOutBike,
  }) {
    return fetchRentBikes(this);
  }

  @override
  @optionalTypeArgs
  TResult? mapOrNull<TResult extends Object?>({
    TResult? Function(_FetchRentBikes value)? fetchRentBikes,
    TResult? Function(_RentInBike value)? rentInBike,
    TResult? Function(_RentOutBike value)? rentOutBike,
  }) {
    return fetchRentBikes?.call(this);
  }

  @override
  @optionalTypeArgs
  TResult maybeMap<TResult extends Object?>({
    TResult Function(_FetchRentBikes value)? fetchRentBikes,
    TResult Function(_RentInBike value)? rentInBike,
    TResult Function(_RentOutBike value)? rentOutBike,
    required TResult orElse(),
  }) {
    if (fetchRentBikes != null) {
      return fetchRentBikes(this);
    }
    return orElse();
  }
}

abstract class _FetchRentBikes implements RentBikeEvent {
  const factory _FetchRentBikes() = _$_FetchRentBikes;
}

/// @nodoc
abstract class _$$_RentInBikeCopyWith<$Res> {
  factory _$$_RentInBikeCopyWith(
          _$_RentInBike value, $Res Function(_$_RentInBike) then) =
      __$$_RentInBikeCopyWithImpl<$Res>;
  @useResult
  $Res call({String name, User owner, int price});

  $UserCopyWith<$Res> get owner;
}

/// @nodoc
class __$$_RentInBikeCopyWithImpl<$Res>
    extends _$RentBikeEventCopyWithImpl<$Res, _$_RentInBike>
    implements _$$_RentInBikeCopyWith<$Res> {
  __$$_RentInBikeCopyWithImpl(
      _$_RentInBike _value, $Res Function(_$_RentInBike) _then)
      : super(_value, _then);

  @pragma('vm:prefer-inline')
  @override
  $Res call({
    Object? name = null,
    Object? owner = null,
    Object? price = null,
  }) {
    return _then(_$_RentInBike(
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

class _$_RentInBike implements _RentInBike {
  const _$_RentInBike(this.name, this.owner, this.price);

  @override
  final String name;
  @override
  final User owner;
  @override
  final int price;

  @override
  String toString() {
    return 'RentBikeEvent.rentInBike(name: $name, owner: $owner, price: $price)';
  }

  @override
  bool operator ==(dynamic other) {
    return identical(this, other) ||
        (other.runtimeType == runtimeType &&
            other is _$_RentInBike &&
            (identical(other.name, name) || other.name == name) &&
            (identical(other.owner, owner) || other.owner == owner) &&
            (identical(other.price, price) || other.price == price));
  }

  @override
  int get hashCode => Object.hash(runtimeType, name, owner, price);

  @JsonKey(ignore: true)
  @override
  @pragma('vm:prefer-inline')
  _$$_RentInBikeCopyWith<_$_RentInBike> get copyWith =>
      __$$_RentInBikeCopyWithImpl<_$_RentInBike>(this, _$identity);

  @override
  @optionalTypeArgs
  TResult when<TResult extends Object?>({
    required TResult Function() fetchRentBikes,
    required TResult Function(String name, User owner, int price) rentInBike,
    required TResult Function(int id) rentOutBike,
  }) {
    return rentInBike(name, owner, price);
  }

  @override
  @optionalTypeArgs
  TResult? whenOrNull<TResult extends Object?>({
    TResult? Function()? fetchRentBikes,
    TResult? Function(String name, User owner, int price)? rentInBike,
    TResult? Function(int id)? rentOutBike,
  }) {
    return rentInBike?.call(name, owner, price);
  }

  @override
  @optionalTypeArgs
  TResult maybeWhen<TResult extends Object?>({
    TResult Function()? fetchRentBikes,
    TResult Function(String name, User owner, int price)? rentInBike,
    TResult Function(int id)? rentOutBike,
    required TResult orElse(),
  }) {
    if (rentInBike != null) {
      return rentInBike(name, owner, price);
    }
    return orElse();
  }

  @override
  @optionalTypeArgs
  TResult map<TResult extends Object?>({
    required TResult Function(_FetchRentBikes value) fetchRentBikes,
    required TResult Function(_RentInBike value) rentInBike,
    required TResult Function(_RentOutBike value) rentOutBike,
  }) {
    return rentInBike(this);
  }

  @override
  @optionalTypeArgs
  TResult? mapOrNull<TResult extends Object?>({
    TResult? Function(_FetchRentBikes value)? fetchRentBikes,
    TResult? Function(_RentInBike value)? rentInBike,
    TResult? Function(_RentOutBike value)? rentOutBike,
  }) {
    return rentInBike?.call(this);
  }

  @override
  @optionalTypeArgs
  TResult maybeMap<TResult extends Object?>({
    TResult Function(_FetchRentBikes value)? fetchRentBikes,
    TResult Function(_RentInBike value)? rentInBike,
    TResult Function(_RentOutBike value)? rentOutBike,
    required TResult orElse(),
  }) {
    if (rentInBike != null) {
      return rentInBike(this);
    }
    return orElse();
  }
}

abstract class _RentInBike implements RentBikeEvent {
  const factory _RentInBike(
      final String name, final User owner, final int price) = _$_RentInBike;

  String get name;
  User get owner;
  int get price;
  @JsonKey(ignore: true)
  _$$_RentInBikeCopyWith<_$_RentInBike> get copyWith =>
      throw _privateConstructorUsedError;
}

/// @nodoc
abstract class _$$_RentOutBikeCopyWith<$Res> {
  factory _$$_RentOutBikeCopyWith(
          _$_RentOutBike value, $Res Function(_$_RentOutBike) then) =
      __$$_RentOutBikeCopyWithImpl<$Res>;
  @useResult
  $Res call({int id});
}

/// @nodoc
class __$$_RentOutBikeCopyWithImpl<$Res>
    extends _$RentBikeEventCopyWithImpl<$Res, _$_RentOutBike>
    implements _$$_RentOutBikeCopyWith<$Res> {
  __$$_RentOutBikeCopyWithImpl(
      _$_RentOutBike _value, $Res Function(_$_RentOutBike) _then)
      : super(_value, _then);

  @pragma('vm:prefer-inline')
  @override
  $Res call({
    Object? id = null,
  }) {
    return _then(_$_RentOutBike(
      null == id
          ? _value.id
          : id // ignore: cast_nullable_to_non_nullable
              as int,
    ));
  }
}

/// @nodoc

class _$_RentOutBike implements _RentOutBike {
  const _$_RentOutBike(this.id);

  @override
  final int id;

  @override
  String toString() {
    return 'RentBikeEvent.rentOutBike(id: $id)';
  }

  @override
  bool operator ==(dynamic other) {
    return identical(this, other) ||
        (other.runtimeType == runtimeType &&
            other is _$_RentOutBike &&
            (identical(other.id, id) || other.id == id));
  }

  @override
  int get hashCode => Object.hash(runtimeType, id);

  @JsonKey(ignore: true)
  @override
  @pragma('vm:prefer-inline')
  _$$_RentOutBikeCopyWith<_$_RentOutBike> get copyWith =>
      __$$_RentOutBikeCopyWithImpl<_$_RentOutBike>(this, _$identity);

  @override
  @optionalTypeArgs
  TResult when<TResult extends Object?>({
    required TResult Function() fetchRentBikes,
    required TResult Function(String name, User owner, int price) rentInBike,
    required TResult Function(int id) rentOutBike,
  }) {
    return rentOutBike(id);
  }

  @override
  @optionalTypeArgs
  TResult? whenOrNull<TResult extends Object?>({
    TResult? Function()? fetchRentBikes,
    TResult? Function(String name, User owner, int price)? rentInBike,
    TResult? Function(int id)? rentOutBike,
  }) {
    return rentOutBike?.call(id);
  }

  @override
  @optionalTypeArgs
  TResult maybeWhen<TResult extends Object?>({
    TResult Function()? fetchRentBikes,
    TResult Function(String name, User owner, int price)? rentInBike,
    TResult Function(int id)? rentOutBike,
    required TResult orElse(),
  }) {
    if (rentOutBike != null) {
      return rentOutBike(id);
    }
    return orElse();
  }

  @override
  @optionalTypeArgs
  TResult map<TResult extends Object?>({
    required TResult Function(_FetchRentBikes value) fetchRentBikes,
    required TResult Function(_RentInBike value) rentInBike,
    required TResult Function(_RentOutBike value) rentOutBike,
  }) {
    return rentOutBike(this);
  }

  @override
  @optionalTypeArgs
  TResult? mapOrNull<TResult extends Object?>({
    TResult? Function(_FetchRentBikes value)? fetchRentBikes,
    TResult? Function(_RentInBike value)? rentInBike,
    TResult? Function(_RentOutBike value)? rentOutBike,
  }) {
    return rentOutBike?.call(this);
  }

  @override
  @optionalTypeArgs
  TResult maybeMap<TResult extends Object?>({
    TResult Function(_FetchRentBikes value)? fetchRentBikes,
    TResult Function(_RentInBike value)? rentInBike,
    TResult Function(_RentOutBike value)? rentOutBike,
    required TResult orElse(),
  }) {
    if (rentOutBike != null) {
      return rentOutBike(this);
    }
    return orElse();
  }
}

abstract class _RentOutBike implements RentBikeEvent {
  const factory _RentOutBike(final int id) = _$_RentOutBike;

  int get id;
  @JsonKey(ignore: true)
  _$$_RentOutBikeCopyWith<_$_RentOutBike> get copyWith =>
      throw _privateConstructorUsedError;
}

/// @nodoc
mixin _$RentBikeState {
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
abstract class $RentBikeStateCopyWith<$Res> {
  factory $RentBikeStateCopyWith(
          RentBikeState value, $Res Function(RentBikeState) then) =
      _$RentBikeStateCopyWithImpl<$Res, RentBikeState>;
}

/// @nodoc
class _$RentBikeStateCopyWithImpl<$Res, $Val extends RentBikeState>
    implements $RentBikeStateCopyWith<$Res> {
  _$RentBikeStateCopyWithImpl(this._value, this._then);

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
    extends _$RentBikeStateCopyWithImpl<$Res, _$_Initial>
    implements _$$_InitialCopyWith<$Res> {
  __$$_InitialCopyWithImpl(_$_Initial _value, $Res Function(_$_Initial) _then)
      : super(_value, _then);
}

/// @nodoc

class _$_Initial implements _Initial {
  const _$_Initial();

  @override
  String toString() {
    return 'RentBikeState.initial()';
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

abstract class _Initial implements RentBikeState {
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
    extends _$RentBikeStateCopyWithImpl<$Res, _$_Loading>
    implements _$$_LoadingCopyWith<$Res> {
  __$$_LoadingCopyWithImpl(_$_Loading _value, $Res Function(_$_Loading) _then)
      : super(_value, _then);
}

/// @nodoc

class _$_Loading implements _Loading {
  const _$_Loading();

  @override
  String toString() {
    return 'RentBikeState.loading()';
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

abstract class _Loading implements RentBikeState {
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
    extends _$RentBikeStateCopyWithImpl<$Res, _$Success>
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
    return 'RentBikeState.success(bikes: $bikes)';
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

abstract class Success implements RentBikeState {
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
    extends _$RentBikeStateCopyWithImpl<$Res, _$Failure>
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
    return 'RentBikeState.failure(message: $message)';
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

abstract class Failure implements RentBikeState {
  const factory Failure(final String message) = _$Failure;

  String get message;
  @JsonKey(ignore: true)
  _$$FailureCopyWith<_$Failure> get copyWith =>
      throw _privateConstructorUsedError;
}
