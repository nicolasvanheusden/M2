// GENERATED CODE - DO NOT MODIFY BY HAND

part of 'bike_dto.dart';

// **************************************************************************
// JsonSerializableGenerator
// **************************************************************************

_$_BikeDTO _$$_BikeDTOFromJson(Map<String, dynamic> json) => _$_BikeDTO(
      id: json['id'] as int,
      model: json['model'] as String,
      scores: (json['scores'] as List<dynamic>?)
          ?.map((e) => ScoreDTO.fromJson(e as Map<String, dynamic>))
          .toList(),
      owner: json['owner'] == null
          ? null
          : UserDTO.fromJson(json['owner'] as Map<String, dynamic>),
      sellPrice: json['sellPrice'] as int?,
      rentPrice: json['rentPrice'] as int?,
    );

Map<String, dynamic> _$$_BikeDTOToJson(_$_BikeDTO instance) =>
    <String, dynamic>{
      'id': instance.id,
      'model': instance.model,
      'scores': instance.scores,
      'owner': instance.owner,
      'sellPrice': instance.sellPrice,
      'rentPrice': instance.rentPrice,
    };
