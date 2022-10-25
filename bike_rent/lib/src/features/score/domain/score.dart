


import 'package:bike_rent/src/features/score/domain/return_status_type.dart';
import 'package:freezed_annotation/freezed_annotation.dart';

part 'score.freezed.dart';

@freezed
class Score with _$Score {
  const Score._();

  factory Score({
    required final int score,
    required final ReturnStatusType status
  }) = _Score;

}