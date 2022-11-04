

import 'dart:convert';

import 'package:bike_rent/src/features/bike/data/dtos/bike_dto.dart';
import 'package:flutter/services.dart';

class BikeLocalSource {

  BikeLocalSource();


  Future<List<BikeDTO>> getBikes() async {
    // todo: find correct url
    final jsonText = await rootBundle.loadString("assets/temp_bikes_data.json");
    final data = jsonDecode(jsonText) as Map<String, dynamic>;
    return data['bikes'].map<BikeDTO>((e) => BikeDTO.fromJson(e)).toList();
  }
}