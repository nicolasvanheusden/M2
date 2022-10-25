// coverage:ignore-file
// GENERATED CODE - DO NOT MODIFY BY HAND
// ignore_for_file: type=lint
// ignore_for_file: unused_element, deprecated_member_use, deprecated_member_use_from_same_package, use_function_type_syntax_for_parameters, unnecessary_const, avoid_init_to_null, invalid_override_different_default_values_named, prefer_expression_function_bodies, annotate_overrides, invalid_annotation_target

part of 'bike_dto.dart';

// **************************************************************************
// FreezedGenerator
// **************************************************************************

T _$identity<T>(T value) => value;

final _privateConstructorUsedError = UnsupportedError(
    'It seems like you constructed your class using `MyClass._()`. This constructor is only meant to be used by freezed and you are not supposed to need it nor use it.\nPlease check the documentation here for more information: https://github.com/rrousselGit/freezed#custom-getters-and-methods');

BikeDTO _$BikeDTOFromJson(Map<String, dynamic> json) {
  return _BikeDTO.fromJson(json);
}

/// @nodoc
mixin _$BikeDTO {
  int get id => throw _privateConstructorUsedError;
  String get model => throw _privateConstructorUsedError;
  List<ScoreDTO> get scores => throw _privateConstructorUsedError;
  UserDTO get owner => throw _privateConstructorUsedError;
  int? get sellPrice => throw _privateConstructorUsedError;
  int? get rentPrice => throw _privateConstructorUsedError;

  Map<String, dynamic> toJson() => throw _privateConstructorUsedError;
  @JsonKey(ignore: true)
  $BikeDTOCopyWith<BikeDTO> get copyWith => throw _privateConstructorUsedError;
}

/// @nodoc
abstract class $BikeDTOCopyWith<$Res> {
  factory $BikeDTOCopyWith(BikeDTO value, $Res Function(BikeDTO) then) =
      _$BikeDTOCopyWithImpl<$Res, BikeDTO>;
  @useResult
  $Res call(
      {int id,
      String model,
      List<ScoreDTO> scores,
      UserDTO owner,
      int? sellPrice,
      int? rentPrice});

  $UserDTOCopyWith<$Res> get owner;
}

/// @nodoc
class _$BikeDTOCopyWithImpl<$Res, $Val extends BikeDTO>
    implements $BikeDTOCopyWith<$Res> {
  _$BikeDTOCopyWithImpl(this._value, this._then);

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
              as List<ScoreDTO>,
      owner: null == owner
          ? _value.owner
          : owner // ignore: cast_nullable_to_non_nullable
              as UserDTO,
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
  $UserDTOCopyWith<$Res> get owner {
    return $UserDTOCopyWith<$Res>(_value.owner, (value) {
      return _then(_value.copyWith(owner: value) as $Val);
    });
  }
}

/// @nodoc
abstract class _$$_BikeDTOCopyWith<$Res> implements $BikeDTOCopyWith<$Res> {
  factory _$$_BikeDTOCopyWith(
          _$_BikeDTO value, $Res Function(_$_BikeDTO) then) =
      __$$_BikeDTOCopyWithImpl<$Res>;
  @override
  @useResult
  $Res call(
      {int id,
      String model,
      List<ScoreDTO> scores,
      UserDTO owner,
      int? sellPrice,
      int? rentPrice});

  @override
  $UserDTOCopyWith<$Res> get owner;
}

/// @nodoc
class __$$_BikeDTOCopyWithImpl<$Res>
    extends _$BikeDTOCopyWithImpl<$Res, _$_BikeDTO>
    implements _$$_BikeDTOCopyWith<$Res> {
  __$$_BikeDTOCopyWithImpl(_$_BikeDTO _value, $Res Function(_$_BikeDTO) _then)
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
    return _then(_$_BikeDTO(
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
              as List<ScoreDTO>,
      owner: null == owner
          ? _value.owner
          : owner // ignore: cast_nullable_to_non_nullable
              as UserDTO,
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
@JsonSerializable()
class _$_BikeDTO extends _BikeDTO {
  _$_BikeDTO(
      {required this.id,
      required this.model,
      required final List<ScoreDTO> scores,
      required this.owner,
      required this.sellPrice,
      required this.rentPrice})
      : _scores = scores,
        super._();

  factory _$_BikeDTO.fromJson(Map<String, dynamic> json) =>
      _$$_BikeDTOFromJson(json);

  @override
  final int id;
  @override
  final String model;
  final List<ScoreDTO> _scores;
  @override
  List<ScoreDTO> get scores {
    // ignore: implicit_dynamic_type
    return EqualUnmodifiableListView(_scores);
  }

  @override
  final UserDTO owner;
  @override
  final int? sellPrice;
  @override
  final int? rentPrice;

  @override
  String toString() {
    return 'BikeDTO(id: $id, model: $model, scores: $scores, owner: $owner, sellPrice: $sellPrice, rentPrice: $rentPrice)';
  }

  @override
  bool operator ==(dynamic other) {
    return identical(this, other) ||
        (other.runtimeType == runtimeType &&
            other is _$_BikeDTO &&
            (identical(other.id, id) || other.id == id) &&
            (identical(other.model, model) || other.model == model) &&
            const DeepCollectionEquality().equals(other._scores, _scores) &&
            (identical(other.owner, owner) || other.owner == owner) &&
            (identical(other.sellPrice, sellPrice) ||
                other.sellPrice == sellPrice) &&
            (identical(other.rentPrice, rentPrice) ||
                other.rentPrice == rentPrice));
  }

  @JsonKey(ignore: true)
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
  _$$_BikeDTOCopyWith<_$_BikeDTO> get copyWith =>
      __$$_BikeDTOCopyWithImpl<_$_BikeDTO>(this, _$identity);

  @override
  Map<String, dynamic> toJson() {
    return _$$_BikeDTOToJson(
      this,
    );
  }
}

abstract class _BikeDTO extends BikeDTO {
  factory _BikeDTO(
      {required final int id,
      required final String model,
      required final List<ScoreDTO> scores,
      required final UserDTO owner,
      required final int? sellPrice,
      required final int? rentPrice}) = _$_BikeDTO;
  _BikeDTO._() : super._();

  factory _BikeDTO.fromJson(Map<String, dynamic> json) = _$_BikeDTO.fromJson;

  @override
  int get id;
  @override
  String get model;
  @override
  List<ScoreDTO> get scores;
  @override
  UserDTO get owner;
  @override
  int? get sellPrice;
  @override
  int? get rentPrice;
  @override
  @JsonKey(ignore: true)
  _$$_BikeDTOCopyWith<_$_BikeDTO> get copyWith =>
      throw _privateConstructorUsedError;
}
