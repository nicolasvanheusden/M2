import 'package:bike_rent/src/features/score/domain/score.dart';
import 'package:bike_rent/src/features/user/domain/user.dart';
import 'package:freezed_annotation/freezed_annotation.dart';

part 'bike.freezed.dart';

@freezed
class Bike with _$Bike {
  const Bike._();

  factory Bike({
    required final int id,
    required final String model,
    required final List<Score> scores,
    required final User owner,
    required final int? sellPrice,
    required final int? rentPrice,
  }) = _Bike;
}