// coverage:ignore-file
// GENERATED CODE - DO NOT MODIFY BY HAND
// ignore_for_file: type=lint
// ignore_for_file: unused_element, deprecated_member_use, deprecated_member_use_from_same_package, use_function_type_syntax_for_parameters, unnecessary_const, avoid_init_to_null, invalid_override_different_default_values_named, prefer_expression_function_bodies, annotate_overrides, invalid_annotation_target

part of 'bike.dart';

// **************************************************************************
// FreezedGenerator
// **************************************************************************

T _$identity<T>(T value) => value;

final _privateConstructorUsedError = UnsupportedError(
    'It seems like you constructed your class using `MyClass._()`. This constructor is only meant to be used by freezed and you are not supposed to need it nor use it.\nPlease check the documentation here for more information: https://github.com/rrousselGit/freezed#custom-getters-and-methods');

/// @nodoc
mixin _$Bike {
  int get id => throw _privateConstructorUsedError;
  String get model => throw _privateConstructorUsedError;
  List<Score> get scores => throw _privateConstructorUsedError;
  User get owner => throw _privateConstructorUsedError;
  int? get sellPrice => throw _privateConstructorUsedError;
  int? get rentPrice => throw _privateConstructorUsedError;

  @JsonKey(ignore: true)
  $BikeCopyWith<Bike> get copyWith => throw _privateConstructorUsedError;
}

/// @nodoc
abstract class $BikeCopyWith<$Res> {
  factory $BikeCopyWith(Bike value, $Res Function(Bike) then) =
      _$BikeCopyWithImpl<$Res, Bike>;
  @useResult
  $Res call(
      {int id,
      String model,
      List<Score> scores,
      User owner,
      int? sellPrice,
      int? rentPrice});

  $UserCopyWith<$Res> get owner;
}

/// @nodoc
class _$BikeCopyWithImpl<$Res, $Val extends Bike>
    implements $BikeCopyWith<$Res> {
  _$BikeCopyWithImpl(this._value, this._then);

  // ignore: unused_field
  final $Val _value;
  // ignore: unused_field
  final $Res Function($Val) _then;

  @pragma('vm:prefer-inline')
  @override
  $Res call({
    Object? id = null,
    Object? model = null,
    Object? scores = null,
    Object? owner = null,
    Object? sellPrice = freezed,
    Object? rentPrice = freezed,
  }) {
    return _then(_value.copyWith(
      id: null == id
          ? _value.id
          : id // ignore: cast_nullable_to_non_nullable
              as int,
      model: null == model
          ? _value.model
          : model // ignore: cast_nullable_to_non_nullable
              as String,
      scores: null == scores
          ? _value.scores
          : scores // ignore: cast_nullable_to_non_nullable
              as List<Score>,
      owner: null == owner
          ? _value.owner
          : owner // ignore: cast_nullable_to_non_nullable
              as User,
      sellPrice: freezed == sellPrice
          ? _value.sellPrice
          : sellPrice // ignore: cast_nullable_to_non_nullable
              as int?,
      rentPrice: freezed == rentPrice
          ? _value.rentPrice
          : rentPrice // ignore: cast_nullable_to_non_nullable
              as int?,
    ) as $Val);
  }

  @override
  @pragma('vm:prefer-inline')
  $UserCopyWith<$Res> get owner {
    return $UserCopyWith<$Res>(_value.owner, (value) {
      return _then(_value.copyWith(owner: value) as $Val);
    });
  }
}

/// @nodoc
abstract class _$$_BikeCopyWith<$Res> implements $BikeCopyWith<$Res> {
  factory _$$_BikeCopyWith(_$_Bike value, $Res Function(_$_Bike) then) =
      __$$_BikeCopyWithImpl<$Res>;
  @override
  @useResult
  $Res call(
      {int id,
      String model,
      List<Score> scores,
      User owner,
      int? sellPrice,
      int? rentPrice});

  @override
  $UserCopyWith<$Res> get owner;
}

/// @nodoc
class __$$_BikeCopyWithImpl<$Res> extends _$BikeCopyWithImpl<$Res, _$_Bike>
    implements _$$_BikeCopyWith<$Res> {
  __$$_BikeCopyWithImpl(_$_Bike _value, $Res Function(_$_Bike) _then)
      : super(_value, _then);

  @pragma('vm:prefer-inline')
  @override
  $Res call({
    Object? id = null,
    Object? model = null,
    Object? scores = null,
    Object? owner = null,
    Object? sellPrice = freezed,
    Object? rentPrice = freezed,
  }) {
    return _then(_$_Bike(
      id: null == id
          ? _value.id
          : id // ignore: cast_nullable_to_non_nullable
              as int,
      model: null == model
          ? _value.model
          : model // ignore: cast_nullable_to_non_nullable
              as String,
      scores: null == scores
          ? _value._scores
          : scores // ignore: cast_nullable_to_non_nullable
              as List<Score>,
      owner: null == owner
          ? _value.owner
          : owner // ignore: cast_nullable_to_non_nullable
              as User,
      sellPrice: freezed == sellPrice
          ? _value.sellPrice
          : sellPrice // ignore: cast_nullable_to_non_nullable
              as int?,
      rentPrice: freezed == rentPrice
          ? _value.rentPrice
          : rentPrice // ignore: cast_nullable_to_non_nullable
              as int?,
    ));
  }
}

/// @nodoc

class _$_Bike extends _Bike {
  _$_Bike(
      {required this.id,
      required this.model,
      required final List<Score> scores,
      required this.owner,
      required this.sellPrice,
      required this.rentPrice})
      : _scores = scores,
        super._();

  @override
  final int id;
  @override
  final String model;
  final List<Score> _scores;
  @override
  List<Score> get scores {
    // ignore: implicit_dynamic_type
    return EqualUnmodifiableListView(_scores);
  }

  @override
  final User owner;
  @override
  final int? sellPrice;
  @override
  final int? rentPrice;

  @override
  String toString() {
    return 'Bike(id: $id, model: $model, scores: $scores, owner: $owner, sellPrice: $sellPrice, rentPrice: $rentPrice)';
  }

  @override
  bool operator ==(dynamic other) {
    return identical(this, other) ||
        (other.runtimeType == runtimeType &&
            other is _$_Bike &&
            (identical(other.id, id) || other.id == id) &&
            (identical(other.model, model) || other.model == model) &&
            const DeepCollectionEquality().equals(other._scores, _scores) &&
            (identical(other.owner, owner) || other.owner == owner) &&
            (identical(other.sellPrice, sellPrice) ||
                other.sellPrice == sellPrice) &&
            (identical(other.rentPrice, rentPrice) ||
                other.rentPrice == rentPrice));
  }

  @override
  int get hashCode => Object.hash(
      runtimeType,
      id,
      model,
      const DeepCollectionEquality().hash(_scores),
      owner,
      sellPrice,
      rentPrice);

  @JsonKey(ignore: true)
  @override
  @pragma('vm:prefer-inline')
  _$$_BikeCopyWith<_$_Bike> get copyWith =>
      __$$_BikeCopyWithImpl<_$_Bike>(this, _$identity);
}

abstract class _Bike extends Bike {
  factory _Bike(
      {required final int id,
      required final String model,
      required final List<Score> scores,
      required final User owner,
      required final int? sellPrice,
      required final int? rentPrice}) = _$_Bike;
  _Bike._() : super._();

  @override
  int get id;
  @override
  String get model;
  @override
  List<Score> get scores;
  @override
  User get owner;
  @override
  int? get sellPrice;
  @override
  int? get rentPrice;
  @override
  @JsonKey(ignore: true)
  _$$_BikeCopyWith<_$_Bike> get copyWith => throw _privateConstructorUsedError;
}
