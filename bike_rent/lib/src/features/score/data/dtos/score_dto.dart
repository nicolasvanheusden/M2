import 'package:bike_rent/src/features/score/domain/return_status_type.dart';
import 'package:bike_rent/src/features/score/domain/score.dart';
import 'package:freezed_annotation/freezed_annotation.dart';

part 'score_dto.freezed.dart';
part 'score_dto.g.dart';

@freezed
class ScoreDTO with _$ScoreDTO {
  const ScoreDTO._();
  factory ScoreDTO({
    required final int score,
    required final String status
  }) = _ScoreDTO;

  factory ScoreDTO.fromJson(Map<String, dynamic> json) => _$ScoreDTOFromJson(json);

  Score toDomain() => Score(
    score: score,
    status: ReturnStatusType.values.firstWhere((e) => e.toString() == 'ReturnStatusType.$status')
  );

  factory ScoreDTO.fromDomain(Score score) => ScoreDTO(
    score: score.score,
    status: score.status.toString().split('.').last
  );
}
