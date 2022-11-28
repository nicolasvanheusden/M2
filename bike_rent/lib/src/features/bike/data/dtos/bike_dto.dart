

import 'package:bike_rent/src/features/bike/domain/bike.dart';
import 'package:bike_rent/src/features/score/data/dtos/score_dto.dart';
import 'package:bike_rent/src/features/user/data/dtos/user_dto.dart';
import 'package:bike_rent/src/features/user/domain/user.dart';
import 'package:bike_rent/src/features/user/domain/user_type.dart';
import 'package:freezed_annotation/freezed_annotation.dart';

part 'bike_dto.freezed.dart';
part 'bike_dto.g.dart';

@freezed
class BikeDTO with _$BikeDTO {
  const BikeDTO._();
  factory BikeDTO({
    required final int id,
    required final String model,
    required final List<ScoreDTO>? scores,
    required final UserDTO? owner,
    required final int? sellPrice,
    required final int? rentPrice,
  }) = _BikeDTO;
  

  factory BikeDTO.fromJson(Map<String, dynamic> json) => _$BikeDTOFromJson(json);

  Bike toDomain() => Bike(
    id: id,
    model: model,
    scores: scores?.map((e) => e.toDomain()).toList() ?? [],
    owner: owner?.toDomain() ?? User(id: 0, name: "Marco", type: UserType.ownerParticular),
    sellPrice: sellPrice,
    rentPrice: rentPrice,
  );

  factory BikeDTO.fromDomain(Bike bike) => BikeDTO(
    id: bike.id,
    model: bike.model,
    scores: bike.scores.map((e) => ScoreDTO.fromDomain(e)).toList(),
    owner: UserDTO.fromDomain(bike.owner),
    sellPrice: bike.sellPrice,
    rentPrice: bike.rentPrice,
  );

}