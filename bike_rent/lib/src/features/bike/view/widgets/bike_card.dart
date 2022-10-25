import 'package:bike_rent/src/features/bike/domain/bike.dart';
import 'package:flutter/material.dart';

class BikeCard extends StatelessWidget {
  const BikeCard({super.key, required this.bike, required this.isRenting});

  final Bike bike;
  final bool isRenting;

  @override
  Widget build(BuildContext context) {
    return LayoutBuilder(
      builder: (context, constraints) {
        return SizedBox(
          width: constraints.maxWidth / 6,
          height: 200,
          child: Card(
            child: Column(
              children: [
                Text(bike.model),
                Text(bike.owner.name),
                Text(isRenting ? bike.rentPrice.toString() : bike.sellPrice.toString()),
                Text(bike.scores.map((score) => score.score).reduce((value, element) => value + element).toString()),
              ],
            ),
          ),
        );
      },
    );
  }
}