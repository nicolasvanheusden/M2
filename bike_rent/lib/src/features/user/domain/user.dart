
import 'package:bike_rent/src/features/user/domain/user_type.dart';
import 'package:freezed_annotation/freezed_annotation.dart';

part 'user.freezed.dart';

@freezed
class User with _$User {
  const User._();

  factory User({
    required final int id,
    required final String name,
    required final UserType type,      
  }) = _User;

}