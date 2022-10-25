import 'package:bike_rent/src/features/bike/data/dtos/bike_dto.dart';
import 'package:http/http.dart' as http;


class BikeRemoteSource {

  BikeRemoteSource();

  Future<List<BikeDTO>> getBikes() async {
    // todo: find correct url
    final response = await http.get(Uri.parse('https://localhost:5001/api/bikes')); 
    if (response.statusCode == 200) {
      final map = response.body as Map<String, dynamic>;
      return map['body'].map<BikeDTO>((e) => BikeDTO.fromJson(e)).toList();
    } else {
      throw Exception('Failed to load bikes');
    }
  }

}

