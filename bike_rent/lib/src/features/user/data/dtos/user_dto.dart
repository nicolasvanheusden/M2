import 'package:bike_rent/src/features/user/domain/user.dart';
import 'package:bike_rent/src/features/user/domain/user_type.dart';
import 'package:freezed_annotation/freezed_annotation.dart';

part 'user_dto.freezed.dart';
part 'user_dto.g.dart';

@freezed
class UserDTO with _$UserDTO {
  const UserDTO._();
  factory UserDTO({
    required final int id,
    required final String name,
    required final String type,
  }) = _UserDTO;


  factory UserDTO.fromJson(Map<String, dynamic> json) => _$UserDTOFromJson(json);

  User toDomain() => User(
    id: id,
    name: name,
    type: UserType.values.firstWhere((e) => e.toString() == 'UserType.$type')
  );

  factory UserDTO.fromDomain(User user) => UserDTO(
    id: user.id,
    name: user.name,
    type: user.type.toString().split('.').last
  );
}