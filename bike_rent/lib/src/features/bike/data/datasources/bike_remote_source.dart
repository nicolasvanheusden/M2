

import 'dart:convert';

import 'package:bike_rent/src/features/bike/data/dtos/bike_dto.dart';
import 'package:bike_rent/src/features/user/domain/user.dart';
import 'package:http/http.dart' as http;


class BikeRemoteSource {

  BikeRemoteSource();

  Future<List<BikeDTO>> getBikes() async {
    var request = http.Request(
      'GET',
      Uri.parse('http://localhost:8081/bike'),      
    );
    request.headers.addAll( {
      'Access-Control-Allow-Origin': '*',
      'Content-Type': 'application/json',
      'Accept': '*/*'
    });
    var response = await request.send();

    if (response.statusCode == 200) {
      var input = await response.stream.bytesToString();
      if (input.isEmpty) return [];
      var body = jsonDecode(input) as List<dynamic>;
      return body.map((e) => BikeDTO.fromJson(e)).toList();
    }
    
    print(response.reasonPhrase);
    
    return [];
  }

  Future<bool> addABikeToSell(String name, User owner, int price) async {
    var request = http.Request(
      'PUT',
      Uri.parse('http://localhost:8081/sellBike?model=$name&price=$price'),      
    );
    request.headers.addAll( {
      'Access-Control-Allow-Origin': '*',
      'Content-Type': 'application/json',
      'Accept': '*/*'
    });
    var response = await request.send();

    if (response.statusCode == 200) {
      return true;
    }
    print(response.reasonPhrase);
    return false;
  }

}


//   final document = XmlDocument.parse(input);
//   var xml2Json= Xml2Json();
//   xml2Json.parse(input);

//   var jsonText = xml2Json.toParker();

//   var json = jsonDecode(jsonText);

//   var bikesReturn = json['soapenv:Envelope']['soapenv:Body']['getBikesResponse'] as Map<String, dynamic>;


//   var res = List<BikeDTO>.empty(growable: true);
//   bikesReturn.map((key, value) => MapEntry(key, value.map((key, value) => MapEntry(key.substring(4), value))))
//   .forEach((key, value) {
//     var map = <String, dynamic>{};
//     value.forEach((key, value) {
//       map[key.toString()] = int.tryParse(value) ?? value;
//     });
//     res.add(BikeDTO.fromJson(map));
// });

// return res;
