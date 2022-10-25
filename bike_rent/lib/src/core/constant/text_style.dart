


import 'package:bike_rent/src/core/constant/colors.dart';
import 'package:flutter/material.dart';

TextStyle myTextStyle({
  required final double fontSize,
  final FontWeight? fontWeight,
  final TextOverflow? overflow
}) {
  return TextStyle(
    color: textColor,
    fontSize: fontSize,
    fontWeight: fontWeight,
    overflow: overflow,

  );
}