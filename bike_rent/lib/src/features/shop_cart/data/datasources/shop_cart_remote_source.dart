import 'dart:convert';

import 'package:bike_rent/src/features/bike/data/dtos/bike_dto.dart';
import 'package:http/http.dart' as http;


class ShopCartRemoteSource {

  Future<bool> addToCart(int id) async {
    var request = http.Request(
      'PUT',
      Uri.parse('http://localhost:8081/cart?id=$id'),      
    );
    request.headers.addAll( {
        "Access-Control-Allow-Origin": "*",
        'Content-Type': 'application/json',
        'Accept': '*/*'
      });
    var response = await request.send();

    if (response.statusCode == 200) {
      return true;
    }
    else {
      print(response.reasonPhrase);
    }
    return false;
  }

  Future<List<BikeDTO>> getBikesInCart() async {
    var request = http.Request(
      'GET',
      Uri.parse('http://localhost:8081/cart'),      
    );
    request.headers.addAll( {
        "Access-Control-Allow-Origin": "*",
        'Content-Type': 'application/json',
        'Accept': '*/*'
      });
    var response = await request.send();

    if (response.statusCode == 200) {
      var input = await response.stream.bytesToString();
      if (input.isEmpty) {
        return [];
      }
      var body = jsonDecode(input) as List<dynamic>;
      return body.map((e) => BikeDTO.fromJson(e)).toList();
    }
    else {
      print(response.reasonPhrase);
    }
    return [];
  }


  Future<bool> removeFromCart(int id) async {
    var request = http.Request(
      'DELETE',
      Uri.parse('http://localhost:8081/cart?id=$id'),      
    );
    request.headers.addAll( {
        "Access-Control-Allow-Origin": "*",
        'Content-Type': 'application/json',
        'Accept': '*/*'
      });
    var response = await request.send();

    if (response.statusCode == 200) {
      return true;
    }
    else {
      print(response.reasonPhrase);
    }
    return false;
  }
}