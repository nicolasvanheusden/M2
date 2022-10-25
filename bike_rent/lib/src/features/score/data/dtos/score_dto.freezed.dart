// coverage:ignore-file
// GENERATED CODE - DO NOT MODIFY BY HAND
// ignore_for_file: type=lint
// ignore_for_file: unused_element, deprecated_member_use, deprecated_member_use_from_same_package, use_function_type_syntax_for_parameters, unnecessary_const, avoid_init_to_null, invalid_override_different_default_values_named, prefer_expression_function_bodies, annotate_overrides, invalid_annotation_target

part of 'score_dto.dart';

// **************************************************************************
// FreezedGenerator
// **************************************************************************

T _$identity<T>(T value) => value;

final _privateConstructorUsedError = UnsupportedError(
    'It seems like you constructed your class using `MyClass._()`. This constructor is only meant to be used by freezed and you are not supposed to need it nor use it.\nPlease check the documentation here for more information: https://github.com/rrousselGit/freezed#custom-getters-and-methods');

ScoreDTO _$ScoreDTOFromJson(Map<String, dynamic> json) {
  return _ScoreDTO.fromJson(json);
}

/// @nodoc
mixin _$ScoreDTO {
  int get score => throw _privateConstructorUsedError;
  String get status => throw _privateConstructorUsedError;

  Map<String, dynamic> toJson() => throw _privateConstructorUsedError;
  @JsonKey(ignore: true)
  $ScoreDTOCopyWith<ScoreDTO> get copyWith =>
      throw _privateConstructorUsedError;
}

/// @nodoc
abstract class $ScoreDTOCopyWith<$Res> {
  factory $ScoreDTOCopyWith(ScoreDTO value, $Res Function(ScoreDTO) then) =
      _$ScoreDTOCopyWithImpl<$Res, ScoreDTO>;
  @useResult
  $Res call({int score, String status});
}

/// @nodoc
class _$ScoreDTOCopyWithImpl<$Res, $Val extends ScoreDTO>
    implements $ScoreDTOCopyWith<$Res> {
  _$ScoreDTOCopyWithImpl(this._value, this._then);

  // ignore: unused_field
  final $Val _value;
  // ignore: unused_field
  final $Res Function($Val) _then;

  @pragma('vm:prefer-inline')
  @override
  $Res call({
    Object? score = null,
    Object? status = null,
  }) {
    return _then(_value.copyWith(
      score: null == score
          ? _value.score
          : score // ignore: cast_nullable_to_non_nullable
              as int,
      status: null == status
          ? _value.status
          : status // ignore: cast_nullable_to_non_nullable
              as String,
    ) as $Val);
  }
}

/// @nodoc
abstract class _$$_ScoreDTOCopyWith<$Res> implements $ScoreDTOCopyWith<$Res> {
  factory _$$_ScoreDTOCopyWith(
          _$_ScoreDTO value, $Res Function(_$_ScoreDTO) then) =
      __$$_ScoreDTOCopyWithImpl<$Res>;
  @override
  @useResult
  $Res call({int score, String status});
}

/// @nodoc
class __$$_ScoreDTOCopyWithImpl<$Res>
    extends _$ScoreDTOCopyWithImpl<$Res, _$_ScoreDTO>
    implements _$$_ScoreDTOCopyWith<$Res> {
  __$$_ScoreDTOCopyWithImpl(
      _$_ScoreDTO _value, $Res Function(_$_ScoreDTO) _then)
      : super(_value, _then);

  @pragma('vm:prefer-inline')
  @override
  $Res call({
    Object? score = null,
    Object? status = null,
  }) {
    return _then(_$_ScoreDTO(
      score: null == score
          ? _value.score
          : score // ignore: cast_nullable_to_non_nullable
              as int,
      status: null == status
          ? _value.status
          : status // ignore: cast_nullable_to_non_nullable
              as String,
    ));
  }
}

/// @nodoc
@JsonSerializable()
class _$_ScoreDTO extends _ScoreDTO {
  _$_ScoreDTO({required this.score, required this.status}) : super._();

  factory _$_ScoreDTO.fromJson(Map<String, dynamic> json) =>
      _$$_ScoreDTOFromJson(json);

  @override
  final int score;
  @override
  final String status;

  @override
  String toString() {
    return 'ScoreDTO(score: $score, status: $status)';
  }

  @override
  bool operator ==(dynamic other) {
    return identical(this, other) ||
        (other.runtimeType == runtimeType &&
            other is _$_ScoreDTO &&
            (identical(other.score, score) || other.score == score) &&
            (identical(other.status, status) || other.status == status));
  }

  @JsonKey(ignore: true)
  @override
  int get hashCode => Object.hash(runtimeType, score, status);

  @JsonKey(ignore: true)
  @override
  @pragma('vm:prefer-inline')
  _$$_ScoreDTOCopyWith<_$_ScoreDTO> get copyWith =>
      __$$_ScoreDTOCopyWithImpl<_$_ScoreDTO>(this, _$identity);

  @override
  Map<String, dynamic> toJson() {
    return _$$_ScoreDTOToJson(
      this,
    );
  }
}

abstract class _ScoreDTO extends ScoreDTO {
  factory _ScoreDTO({required final int score, required final String status}) =
      _$_ScoreDTO;
  _ScoreDTO._() : super._();

  factory _ScoreDTO.fromJson(Map<String, dynamic> json) = _$_ScoreDTO.fromJson;

  @override
  int get score;
  @override
  String get status;
  @override
  @JsonKey(ignore: true)
  _$$_ScoreDTOCopyWith<_$_ScoreDTO> get copyWith =>
      throw _privateConstructorUsedError;
}
